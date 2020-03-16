package com.panaceasoft.psstore.repository.coupondiscount;

import com.panaceasoft.psstore.AppExecutors;
import com.panaceasoft.psstore.Config;
import com.panaceasoft.psstore.api.ApiResponse;
import com.panaceasoft.psstore.api.PSApiService;
import com.panaceasoft.psstore.db.PSCoreDb;
import com.panaceasoft.psstore.repository.common.PSRepository;
import com.panaceasoft.psstore.viewobject.CouponDiscount;
import com.panaceasoft.psstore.viewobject.common.Resource;

import java.io.IOException;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Response;

public class CouponDiscountRepository extends PSRepository {


    /**
     * Constructor of PSRepository
     *
     * @param psApiService Panacea-Soft API Service Instance
     * @param appExecutors Executors Instance
     * @param db           Panacea-Soft DB
     */

    @Inject
    CouponDiscountRepository(PSApiService psApiService, AppExecutors appExecutors, PSCoreDb db) {
        super(psApiService, appExecutors, db);
    }

    public LiveData<Resource<CouponDiscount>> getCouponDiscount(String code)
    {
        final MutableLiveData<Resource<CouponDiscount>> statusLiveData = new MutableLiveData<>();

        appExecutors.networkIO().execute(() -> {

            try {
                // Call the API Service
                Response<CouponDiscount> response;
                response = psApiService.checkCouponDiscount(Config.API_KEY, code).execute();

                // Wrap with APIResponse Class
                ApiResponse<CouponDiscount> apiResponse = new ApiResponse<>(response);

                // If response is successful
                if (apiResponse.isSuccessful()) {

                    statusLiveData.postValue(Resource.success(apiResponse.body));

                } else {
                    statusLiveData.postValue(Resource.error(String.valueOf(apiResponse.errorMessage), null));
                }

            } catch (IOException e) {
                statusLiveData.postValue(Resource.error(e.getMessage(), null));
            }
        });

        return statusLiveData;
    }
}
