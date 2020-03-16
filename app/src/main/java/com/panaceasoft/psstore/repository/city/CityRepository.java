package com.panaceasoft.psstore.repository.city;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.panaceasoft.psstore.AppExecutors;
import com.panaceasoft.psstore.Config;
import com.panaceasoft.psstore.api.ApiResponse;
import com.panaceasoft.psstore.api.PSApiService;
import com.panaceasoft.psstore.db.CategoryDao;
import com.panaceasoft.psstore.db.CityDao;
import com.panaceasoft.psstore.db.PSCoreDb;
import com.panaceasoft.psstore.repository.common.NetworkBoundResource;
import com.panaceasoft.psstore.repository.common.PSRepository;
import com.panaceasoft.psstore.utils.Utils;
import com.panaceasoft.psstore.viewobject.City;
import com.panaceasoft.psstore.viewobject.City;
import com.panaceasoft.psstore.viewobject.SubCategory;
import com.panaceasoft.psstore.viewobject.common.Resource;

import java.util.List;

import javax.inject.Inject;

public class CityRepository extends PSRepository {


    //region Variables

    private final CityDao cityDao;

    //endregion


    //region Constructor

    @Inject
    CityRepository(PSApiService psApiService, AppExecutors appExecutors, PSCoreDb db, CityDao cityDao) {
        super(psApiService, appExecutors, db);

        Utils.psLog("Inside CategoryRepository");

        this.cityDao = cityDao;
    }
    //endregion

    //region Category Repository Functions for ViewModel

    public LiveData<Resource<List<City>>> getCityListWithShopId(String apiKey, String shopId, String countryId, String limit, String offset) {
        return new NetworkBoundResource<List<City>, List<City>>(appExecutors) {
            @Override
            protected void saveCallResult(@NonNull List<City> itemList) {

                Utils.psLog("SaveCallResult of getAllSubCategoryList.");

                try {
                    db.beginTransaction();

                    cityDao.deleteCity();

                    cityDao.insertAll(itemList);

                    db.setTransactionSuccessful();
                } catch (Exception e) {
                    Utils.psErrorLog("Error in doing transaction of getAllSubCategoryList.", e);
                } finally {
                    db.endTransaction();
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<City> data) {
                return connectivity.isConnected();
            }

            @NonNull
            @Override
            protected LiveData<List<City>> loadFromDb() {
                return cityDao.getAllCity();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<List<City>>> createCall() {
                return psApiService.getCityListWithCountryId(apiKey, shopId, countryId, limit, offset);
            }

            @Override
            protected void onFetchFailed(String message) {
                Utils.psLog("Fetch Failed of " + message);
            }

        }.asLiveData();
    }

    public LiveData<Resource<Boolean>> getNextPageCityListWithShopId(String shopId, String countryId, String limit, String offset) {
        final MediatorLiveData<Resource<Boolean>> statusLiveData = new MediatorLiveData<>();
        LiveData<ApiResponse<List<City>>> apiResponse = psApiService.getCityListWithCountryId(Config.API_KEY, shopId, countryId, limit, offset);

        statusLiveData.addSource(apiResponse, response -> {

            statusLiveData.removeSource(apiResponse);

            //noinspection Constant Conditions
            if (response.isSuccessful()) {

                appExecutors.diskIO().execute(() -> {


                    try {
                        db.beginTransaction();

                        if (response.body != null) {
                            for (City news : response.body) {
                                db.cityDao().insert(new City(news.id, news.name, news.countryId, news.status, news.addedDate, news.addedUserId, news.updatedDate, news.updatedUserId, news.updatedFlag, news.addedDateStr));
                            }

                            db.cityDao().insertAll(response.body);
                        }

                        db.setTransactionSuccessful();
                    } catch (NullPointerException ne) {
                        Utils.psErrorLog("Null Pointer Exception : ", ne);
                    } catch (Exception e) {
                        Utils.psErrorLog("Exception : ", e);
                    } finally {
                        db.endTransaction();
                    }

                    statusLiveData.postValue(Resource.success(true));
                });

            } else {
                statusLiveData.postValue(Resource.error(response.errorMessage, null));
            }

        });

        return statusLiveData;
    }


//endregion
}
