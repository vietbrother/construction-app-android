package com.panaceasoft.psstore.viewmodel.collection;

import com.panaceasoft.psstore.Config;
import com.panaceasoft.psstore.repository.collection.ProductCollectionRepository;
import com.panaceasoft.psstore.utils.AbsentLiveData;
import com.panaceasoft.psstore.utils.Utils;
import com.panaceasoft.psstore.viewmodel.common.PSViewModel;
import com.panaceasoft.psstore.viewobject.ProductCollectionHeader;
import com.panaceasoft.psstore.viewobject.common.Resource;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

/**
 * Created by Panacea-Soft on 10/27/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


public class ProductCollectionViewModel extends PSViewModel {


    // for ProductCollectionHeader

    private final LiveData<Resource<List<ProductCollectionHeader>>> productCollectionHeaderListDataForHome;
    private MutableLiveData<TmpDataHolder> productCollectionHeaderListForHomeObj = new MutableLiveData<>();

    private final LiveData<Resource<List<ProductCollectionHeader>>> productCollectionHeaderListData;
    private MutableLiveData<TmpDataHolder> productCollectionHeaderListObj = new MutableLiveData<>();

    private final LiveData<Resource<Boolean>> nextPageLoadingStateData;
    private MutableLiveData<TmpDataHolder> nextPageLoadingStateObj = new MutableLiveData<>();

    //region Constructor

    @Inject
    ProductCollectionViewModel(ProductCollectionRepository repository) {
        Utils.psLog("Inside ProductViewModel");


        // Latest ProductCollectionHeader List
        productCollectionHeaderListData = Transformations.switchMap(productCollectionHeaderListObj, obj -> {
            if (obj == null) {
                return AbsentLiveData.create();
            }
            return repository.getProductionCollectionHeaderList(Config.API_KEY, obj.limit, obj.offset);
        });

        productCollectionHeaderListDataForHome = Transformations.switchMap(productCollectionHeaderListForHomeObj, obj -> {
            if (obj == null) {
                return AbsentLiveData.create();
            }
            return repository.getProductionCollectionHeaderListForHome(Config.API_KEY, obj.collectionLimit, obj.colProductLimit, obj.productLimit, obj.offset);
        });

        nextPageLoadingStateData = Transformations.switchMap(nextPageLoadingStateObj, obj -> {
            if (obj == null) {
                return AbsentLiveData.create();
            }

            return repository.getNextPageProductionCollectionHeaderList(obj.limit, obj.offset);
        });


    }

    //endregion


    //region ProductCollectionHeader

    // Get ProductCollectionHeader
    public void setProductCollectionHeaderListObj( String limit, String offset) {
        if (!isLoading) {
            TmpDataHolder tmpDataHolder = new TmpDataHolder();
            tmpDataHolder.limit = limit;
            tmpDataHolder.offset = offset;
            productCollectionHeaderListObj.setValue(tmpDataHolder);

            // start loading
            setLoadingState(true);
        }
    }

    public LiveData<Resource<List<ProductCollectionHeader>>> getProductCollectionHeaderListData() {
        return productCollectionHeaderListData;
    }

    public void setProductCollectionHeaderListForHomeObj(String collectionLimit, String colProductLimit, String productLimit, String offset) {
        if (!isLoading) {
            TmpDataHolder tmpDataHolder = new TmpDataHolder();
            tmpDataHolder.collectionLimit = collectionLimit;
            tmpDataHolder.colProductLimit = colProductLimit;
            tmpDataHolder.productLimit = productLimit;
            tmpDataHolder.offset = offset;
            productCollectionHeaderListForHomeObj.setValue(tmpDataHolder);

            // start loading
            setLoadingState(true);
        }
    }

    public LiveData<Resource<List<ProductCollectionHeader>>> getProductCollectionHeaderListDataForHome() {
        return productCollectionHeaderListDataForHome;
    }

    //Get Latest ProductCollectionHeader Next Page
    public void setNextPageLoadingStateObj(String limit, String offset) {

        if (!isLoading) {
            TmpDataHolder tmpDataHolder = new TmpDataHolder();
            tmpDataHolder.limit = limit;
            tmpDataHolder.offset = offset;
            nextPageLoadingStateObj.setValue(tmpDataHolder);

            // start loading
            setLoadingState(true);
        }
    }

    public LiveData<Resource<Boolean>> getNextPageLoadingStateData() {
        return nextPageLoadingStateData;
    }

    //endregion

    //region Holder

    class TmpDataHolder {
        public String productId = "";
        public String loginUserId = "";
        public String limit = "";
        public String collectionLimit = "";
        public String colProductLimit = "";
        public String productLimit = "";
        public String offset = "";
        public Boolean isConnected = false;
        public String shopId = "";

    }

    //endregion
}
