package com.panaceasoft.psstore.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.panaceasoft.psstore.viewmodel.aboutus.AboutUsViewModel;
import com.panaceasoft.psstore.viewmodel.blog.BlogViewModel;
import com.panaceasoft.psstore.viewmodel.category.CategoryViewModel;
import com.panaceasoft.psstore.viewmodel.city.CityViewModel;
import com.panaceasoft.psstore.viewmodel.clearalldata.ClearAllDataViewModel;
import com.panaceasoft.psstore.viewmodel.collection.ProductCollectionProductViewModel;
import com.panaceasoft.psstore.viewmodel.collection.ProductCollectionViewModel;
import com.panaceasoft.psstore.viewmodel.comment.CommentDetailListViewModel;
import com.panaceasoft.psstore.viewmodel.comment.CommentListViewModel;
import com.panaceasoft.psstore.viewmodel.common.NotificationViewModel;
import com.panaceasoft.psstore.viewmodel.common.PSNewsViewModelFactory;
import com.panaceasoft.psstore.viewmodel.contactus.ContactUsViewModel;
import com.panaceasoft.psstore.viewmodel.country.CountryViewModel;
import com.panaceasoft.psstore.viewmodel.coupondiscount.CouponDiscountViewModel;
import com.panaceasoft.psstore.viewmodel.homelist.HomeFeaturedProductViewModel;
import com.panaceasoft.psstore.viewmodel.homelist.HomeLatestProductViewModel;
import com.panaceasoft.psstore.viewmodel.homelist.HomeSearchProductViewModel;
import com.panaceasoft.psstore.viewmodel.homelist.HomeTrendingCategoryListViewModel;
import com.panaceasoft.psstore.viewmodel.homelist.HomeTrendingProductViewModel;
import com.panaceasoft.psstore.viewmodel.image.ImageViewModel;
import com.panaceasoft.psstore.viewmodel.notification.NotificationsViewModel;
import com.panaceasoft.psstore.viewmodel.paypal.PaypalViewModel;
import com.panaceasoft.psstore.viewmodel.product.BasketViewModel;
import com.panaceasoft.psstore.viewmodel.product.HistoryProductViewModel;
import com.panaceasoft.psstore.viewmodel.product.ProductAttributeDetailViewModel;
import com.panaceasoft.psstore.viewmodel.product.ProductAttributeHeaderViewModel;
import com.panaceasoft.psstore.viewmodel.product.ProductColorViewModel;
import com.panaceasoft.psstore.viewmodel.product.ProductDetailViewModel;
import com.panaceasoft.psstore.viewmodel.product.ProductFavouriteViewModel;
import com.panaceasoft.psstore.viewmodel.product.ProductListByCatIdViewModel;
import com.panaceasoft.psstore.viewmodel.product.ProductRelatedViewModel;
import com.panaceasoft.psstore.viewmodel.product.ProductSpecsViewModel;
import com.panaceasoft.psstore.viewmodel.product.TouchCountViewModel;
import com.panaceasoft.psstore.viewmodel.apploading.AppLoadingViewModel;
import com.panaceasoft.psstore.viewmodel.rating.RatingViewModel;
import com.panaceasoft.psstore.viewmodel.shippingmethod.ShippingMethodViewModel;
import com.panaceasoft.psstore.viewmodel.shop.ShopViewModel;
import com.panaceasoft.psstore.viewmodel.subcategory.SubCategoryViewModel;
import com.panaceasoft.psstore.viewmodel.transaction.TransactionListViewModel;
import com.panaceasoft.psstore.viewmodel.transaction.TransactionOrderViewModel;
import com.panaceasoft.psstore.viewmodel.user.UserViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Panacea-Soft on 11/16/17.
 * Contact Email : teamps.is.cool@gmail.com
 */

@Module
abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(PSNewsViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    abstract ViewModel bindUserViewModel(UserViewModel userViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(AboutUsViewModel.class)
    abstract ViewModel bindAboutUsViewModel(AboutUsViewModel aboutUsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ImageViewModel.class)
    abstract ViewModel bindImageViewModel(ImageViewModel imageViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RatingViewModel.class)
    abstract ViewModel bindRatingViewModel(RatingViewModel ratingViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(NotificationViewModel.class)
    abstract ViewModel bindNotificationViewModel(NotificationViewModel notificationViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CountryViewModel.class)
    abstract ViewModel bindCountryViewModel(CountryViewModel countryViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CityViewModel.class)
    abstract ViewModel bindCityViewModel(CityViewModel cityViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ContactUsViewModel.class)
    abstract ViewModel bindContactUsViewModel(ContactUsViewModel contactUsViewModel);

  /*  @Binds
    @IntoMap
    @ViewModelKey(ProductViewModel.class)
    abstract ViewModel bindProductViewModel(ProductViewModel productViewModel);*/

    @Binds
    @IntoMap
    @ViewModelKey(CommentListViewModel.class)
    abstract ViewModel bindCommentViewModel(CommentListViewModel commentListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CommentDetailListViewModel.class)
    abstract ViewModel bindCommentDetailViewModel(CommentDetailListViewModel commentDetailListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProductDetailViewModel.class)
    abstract ViewModel bindProductDetailViewModel(ProductDetailViewModel productDetailViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TouchCountViewModel.class)
    abstract ViewModel bindTouchCountViewModel(TouchCountViewModel touchCountViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProductColorViewModel.class)
    abstract ViewModel bindProductColorViewModel(ProductColorViewModel productColorViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProductSpecsViewModel.class)
    abstract ViewModel bindProductSpecsViewModel(ProductSpecsViewModel productSpecsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(BasketViewModel.class)
    abstract ViewModel bindBasketViewModel(BasketViewModel basketViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(HistoryProductViewModel.class)
    abstract ViewModel bindHistoryProductViewModel(HistoryProductViewModel historyProductViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProductAttributeHeaderViewModel.class)
    abstract ViewModel bindProductAttributeHeaderViewModel(ProductAttributeHeaderViewModel productAttributeHeaderViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProductAttributeDetailViewModel.class)
    abstract ViewModel bindProductAttributeDetailViewModel(ProductAttributeDetailViewModel productAttributeDetailViewModel);
/*

    @Binds
    @IntoMap
    @ViewModelKey(DiscountProductViewModel.class)
    abstract ViewModel bindDiscountProductViewModel(DiscountProductViewModel discountProductViewModel);
*/

    @Binds
    @IntoMap
    @ViewModelKey(ProductRelatedViewModel.class)
    abstract ViewModel bindRelatedProductViewModel(ProductRelatedViewModel productRelatedViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProductFavouriteViewModel.class)
    abstract ViewModel bindProductFavouriteViewModel(ProductFavouriteViewModel productFavouriteViewModel);

//    @Binds
//    @IntoMap
//    @ViewModelKey(ProductLikedViewModel.class)
//    abstract ViewModel bindProductLikedViewModel(ProductLikedViewModel productLikedViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CategoryViewModel.class)
    abstract ViewModel bindCategoryViewModel(CategoryViewModel categoryViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(SubCategoryViewModel.class)
    abstract ViewModel bindSubCategoryViewModel(SubCategoryViewModel subCategoryViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProductListByCatIdViewModel.class)
    abstract ViewModel bindProductListByCatIdViewModel(ProductListByCatIdViewModel productListByCatIdViewModel);

//    @Binds
//    @IntoMap
//    @ViewModelKey(TrendingProductsViewModel.class)
//    abstract ViewModel bindTrendingProductsViewModel(TrendingProductsViewModel trendingProductsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(HomeLatestProductViewModel.class)
    abstract ViewModel bindHomeLatestProductViewModel(HomeLatestProductViewModel homeLatestProductViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(HomeSearchProductViewModel.class)
    abstract ViewModel bindHomeFeaturedProductViewModel(HomeSearchProductViewModel homeSearchProductViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(HomeTrendingProductViewModel.class)
    abstract ViewModel bindHomeTrendingProductViewModel(HomeTrendingProductViewModel homeTrendingProductViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(HomeFeaturedProductViewModel.class)
    abstract ViewModel bindHomeCategory1ProductViewModel(HomeFeaturedProductViewModel homeFeaturedProductViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProductCollectionViewModel.class)
    abstract ViewModel bindProductCollectionViewModel(ProductCollectionViewModel productCollectionViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(NotificationsViewModel.class)
    abstract ViewModel bindNotificationListViewModel(NotificationsViewModel notificationListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TransactionListViewModel.class)
    abstract ViewModel bindTransactionListViewModel(TransactionListViewModel transactionListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TransactionOrderViewModel.class)
    abstract ViewModel bindTransactionOrderViewModel(TransactionOrderViewModel transactionOrderViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(HomeTrendingCategoryListViewModel.class)
    abstract ViewModel bindHomeTrendingCategoryListViewModel(HomeTrendingCategoryListViewModel transactionListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProductCollectionProductViewModel.class)
    abstract ViewModel bindProductCollectionProductViewModel(ProductCollectionProductViewModel productCollectionProductViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ShopViewModel.class)
    abstract ViewModel bindShopViewModel(ShopViewModel shopViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(BlogViewModel.class)
    abstract ViewModel bindNewsFeedViewModel(BlogViewModel blogViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ShippingMethodViewModel.class)
    abstract ViewModel bindShippingMethodViewModel(ShippingMethodViewModel shippingMethodViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PaypalViewModel.class)
    abstract ViewModel bindPaypalViewModel(PaypalViewModel paypalViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CouponDiscountViewModel.class)
    abstract ViewModel bindCouponDiscountViewModel(CouponDiscountViewModel couponDiscountViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(AppLoadingViewModel.class)
    abstract ViewModel bindPSAppInfoViewModel(AppLoadingViewModel psAppInfoViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ClearAllDataViewModel.class)
    abstract ViewModel bindClearAllDataViewModel(ClearAllDataViewModel clearAllDataViewModel);
}


