package com.panaceasoft.psstore.viewmodel.homelist;

import com.panaceasoft.psstore.repository.product.ProductRepository;
import com.panaceasoft.psstore.utils.AbsentLiveData;
import com.panaceasoft.psstore.utils.Utils;
import com.panaceasoft.psstore.viewmodel.common.PSViewModel;
import com.panaceasoft.psstore.viewobject.Product;
import com.panaceasoft.psstore.viewobject.common.Resource;
import com.panaceasoft.psstore.viewobject.holder.ProductParameterHolder;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

public class HomeFeaturedProductViewModel extends PSViewModel {


    private final LiveData<Resource<List<Product>>> getProductListByKeyData;
    private final MutableLiveData<HomeFeaturedProductViewModel.TmpDataHolder> getProductListByKeyObj = new MutableLiveData<>();

    private final LiveData<Resource<Boolean>> getNextPageProductListByKeyData;
    private final MutableLiveData<HomeFeaturedProductViewModel.TmpDataHolder> getNextPageProductListByKeyObj = new MutableLiveData<>();

    public ProductParameterHolder productParameterHolder = new ProductParameterHolder().getFeaturedParameterHolder();

    @Inject
    HomeFeaturedProductViewModel(ProductRepository repository) {
        Utils.psLog("Inside HomeFeaturedProductViewModel");

        getProductListByKeyData = Transformations.switchMap(getProductListByKeyObj, obj -> {
            if (obj == null) {
                return AbsentLiveData.create();
            }

            return repository.getProductListByKey(obj.productParameterHolder, obj.loginUserId, obj.limit, obj.offset);
        });

        getNextPageProductListByKeyData = Transformations.switchMap(getNextPageProductListByKeyObj, obj -> {
            if (obj == null) {
                return AbsentLiveData.create();
            }

            return repository.getNextPageProductListByKey(obj.productParameterHolder, obj.loginUserId, obj.limit, obj.offset);
        });
    }

    public void setGetProductListByKeyObj(ProductParameterHolder parameterHolder, String userId, String limit, String offset) {
        TmpDataHolder tmpDataHolder = new TmpDataHolder();
        tmpDataHolder.productParameterHolder = parameterHolder;
        tmpDataHolder.limit = limit;
        tmpDataHolder.offset = offset;
        tmpDataHolder.loginUserId = userId;

        this.getProductListByKeyObj.setValue(tmpDataHolder);
    }

    public LiveData<Resource<List<Product>>> getGetProductListByKeyData() {
        return getProductListByKeyData;
    }


    public LiveData<Resource<Boolean>> getGetNextPageProductListByKeyData() {
        return getNextPageProductListByKeyData;
    }

    class TmpDataHolder {
        public String productId = "";
        public String loginUserId = "";
        public String offset = "";
        public String catId = "";
        public String limit = "";
        public Boolean isConnected = false;
        public String apiKey = "";
        public String shopId = "";
        ProductParameterHolder productParameterHolder = new ProductParameterHolder();
    }
}
