package com.panaceasoft.psstore.di;


import com.panaceasoft.psstore.MainActivity;
import com.panaceasoft.psstore.ui.apploading.AppLoadingActivity;
import com.panaceasoft.psstore.ui.apploading.AppLoadingFragment;
import com.panaceasoft.psstore.ui.basket.BasketListActivity;
import com.panaceasoft.psstore.ui.basket.BasketListFragment;
import com.panaceasoft.psstore.ui.blog.detail.BlogDetailActivity;
import com.panaceasoft.psstore.ui.blog.detail.BlogDetailFragment;
import com.panaceasoft.psstore.ui.blog.list.BlogListActivity;
import com.panaceasoft.psstore.ui.blog.list.BlogListFragment;
import com.panaceasoft.psstore.ui.category.CategoryListActivity;
import com.panaceasoft.psstore.ui.category.CategoryListFragment;
import com.panaceasoft.psstore.ui.category.TrendingCategoryFragment;
import com.panaceasoft.psstore.ui.checkout.CheckoutActivity;
import com.panaceasoft.psstore.ui.checkout.CheckoutFragment1;
import com.panaceasoft.psstore.ui.checkout.CheckoutFragment2;
import com.panaceasoft.psstore.ui.checkout.CheckoutFragment3;
import com.panaceasoft.psstore.ui.checkout.CheckoutStatusFragment;
import com.panaceasoft.psstore.ui.collection.CollectionActivity;
import com.panaceasoft.psstore.ui.collection.CollectionFragment;
import com.panaceasoft.psstore.ui.collection.productCollectionHeader.ProductCollectionHeaderListFragment;
import com.panaceasoft.psstore.ui.comment.detail.CommentDetailActivity;
import com.panaceasoft.psstore.ui.comment.detail.CommentDetailFragment;
import com.panaceasoft.psstore.ui.comment.list.CommentListActivity;
import com.panaceasoft.psstore.ui.comment.list.CommentListFragment;
import com.panaceasoft.psstore.ui.contactus.ContactUsFragment;
import com.panaceasoft.psstore.ui.forceupdate.ForceUpdateActivity;
import com.panaceasoft.psstore.ui.forceupdate.ForceUpdateFragment;
import com.panaceasoft.psstore.ui.gallery.GalleryActivity;
import com.panaceasoft.psstore.ui.gallery.GalleryFragment;
import com.panaceasoft.psstore.ui.gallery.detail.GalleryDetailActivity;
import com.panaceasoft.psstore.ui.gallery.detail.GalleryDetailFragment;
import com.panaceasoft.psstore.ui.language.LanguageFragment;
import com.panaceasoft.psstore.ui.privacyandpolicy.PrivacyPolicyActivity;
import com.panaceasoft.psstore.ui.privacyandpolicy.PrivacyPolicyFragment;
import com.panaceasoft.psstore.ui.product.MainFragment;
import com.panaceasoft.psstore.ui.notification.detail.NotificationActivity;
import com.panaceasoft.psstore.ui.notification.detail.NotificationFragment;
import com.panaceasoft.psstore.ui.notification.list.NotificationListActivity;
import com.panaceasoft.psstore.ui.notification.list.NotificationListFragment;
import com.panaceasoft.psstore.ui.notification.setting.NotificationSettingFragment;
import com.panaceasoft.psstore.ui.product.detail.ProductActivity;
import com.panaceasoft.psstore.ui.product.detail.ProductDetailFragment;
import com.panaceasoft.psstore.ui.product.favourite.FavouriteListActivity;
import com.panaceasoft.psstore.ui.product.favourite.FavouriteListFragment;
import com.panaceasoft.psstore.ui.product.filtering.CategoryFilterFragment;
import com.panaceasoft.psstore.ui.product.filtering.FilterFragment;
import com.panaceasoft.psstore.ui.product.filtering.FilteringActivity;
import com.panaceasoft.psstore.ui.product.history.HistoryFragment;
import com.panaceasoft.psstore.ui.product.history.UserHistoryListActivity;
import com.panaceasoft.psstore.ui.product.list.ProductListActivity;
import com.panaceasoft.psstore.ui.product.list.ProductListFragment;
import com.panaceasoft.psstore.ui.product.productbycatId.ProductListByCatIdActivity;
import com.panaceasoft.psstore.ui.product.productbycatId.ProductListByCatIdFragment;
import com.panaceasoft.psstore.ui.product.search.SearchByCategoryActivity;
import com.panaceasoft.psstore.ui.product.search.SearchCategoryFragment;
import com.panaceasoft.psstore.ui.product.search.SearchCityListFragment;
import com.panaceasoft.psstore.ui.product.search.SearchCountryListFragment;
import com.panaceasoft.psstore.ui.product.search.SearchFragment;
import com.panaceasoft.psstore.ui.product.search.SearchSubCategoryFragment;
import com.panaceasoft.psstore.ui.rating.RatingListActivity;
import com.panaceasoft.psstore.ui.rating.RatingListFragment;
import com.panaceasoft.psstore.ui.setting.AppInfoActivity;
import com.panaceasoft.psstore.ui.setting.AppInfoFragment;
import com.panaceasoft.psstore.ui.setting.NotificationSettingActivity;
import com.panaceasoft.psstore.ui.setting.SettingActivity;
import com.panaceasoft.psstore.ui.setting.SettingFragment;
import com.panaceasoft.psstore.ui.shop.ShopProfileFragment;
import com.panaceasoft.psstore.ui.stripe.StripeActivity;
import com.panaceasoft.psstore.ui.stripe.StripeFragment;
import com.panaceasoft.psstore.ui.terms.TermsAndConditionsActivity;
import com.panaceasoft.psstore.ui.terms.TermsAndConditionsFragment;
import com.panaceasoft.psstore.ui.transaction.detail.TransactionActivity;
import com.panaceasoft.psstore.ui.transaction.detail.TransactionFragment;
import com.panaceasoft.psstore.ui.transaction.list.TransactionListActivity;
import com.panaceasoft.psstore.ui.transaction.list.TransactionListFragment;
import com.panaceasoft.psstore.ui.user.PasswordChangeActivity;
import com.panaceasoft.psstore.ui.user.PasswordChangeFragment;
import com.panaceasoft.psstore.ui.user.ProfileEditActivity;
import com.panaceasoft.psstore.ui.user.ProfileEditFragment;
import com.panaceasoft.psstore.ui.user.ProfileFragment;
import com.panaceasoft.psstore.ui.user.UserForgotPasswordActivity;
import com.panaceasoft.psstore.ui.user.UserForgotPasswordFragment;
import com.panaceasoft.psstore.ui.user.UserLoginActivity;
import com.panaceasoft.psstore.ui.user.UserLoginFragment;
import com.panaceasoft.psstore.ui.user.UserRegisterActivity;
import com.panaceasoft.psstore.ui.user.UserRegisterFragment;
import com.panaceasoft.psstore.ui.user.verifyemail.VerifyEmailActivity;
import com.panaceasoft.psstore.ui.user.verifyemail.VerifyEmailFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Panacea-Soft on 11/15/17.
 * Contact Email : teamps.is.cool@gmail.com
 */


@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector(modules = TransactionModule.class)
    abstract TransactionListActivity contributeTransactionActivity();

    @ContributesAndroidInjector(modules = FavouriteListModule.class)
    abstract FavouriteListActivity contributeFavouriteListActivity();

    @ContributesAndroidInjector(modules = UserHistoryModule.class)
    abstract UserHistoryListActivity contributeUserHistoryListActivity();

    @ContributesAndroidInjector(modules = UserRegisterModule.class)
    abstract UserRegisterActivity contributeUserRegisterActivity();

    @ContributesAndroidInjector(modules = UserForgotPasswordModule.class)
    abstract UserForgotPasswordActivity contributeUserForgotPasswordActivity();

    @ContributesAndroidInjector(modules = UserLoginModule.class)
    abstract UserLoginActivity contributeUserLoginActivity();

    @ContributesAndroidInjector(modules = PasswordChangeModule.class)
    abstract PasswordChangeActivity contributePasswordChangeActivity();

    @ContributesAndroidInjector(modules = ProductListByCatIdModule.class)
    abstract ProductListByCatIdActivity productListByCatIdActivity();

    @ContributesAndroidInjector(modules = FilteringModule.class)
    abstract FilteringActivity filteringActivity();

    @ContributesAndroidInjector(modules = CommentDetailModule.class)
    abstract CommentDetailActivity commentDetailActivity();

    @ContributesAndroidInjector(modules = DiscountDetailModule.class)
    abstract ProductActivity discountDetailActivity();

    @ContributesAndroidInjector(modules = NotificationModule.class)
    abstract NotificationListActivity notificationActivity();

    @ContributesAndroidInjector(modules = HomeFilteringActivityModule.class)
    abstract ProductListActivity contributehomeFilteringActivity();

    @ContributesAndroidInjector(modules = NotificationDetailModule.class)
    abstract NotificationActivity notificationDetailActivity();

    @ContributesAndroidInjector(modules = TransactionDetailModule.class)
    abstract TransactionActivity transactionDetailActivity();

    @ContributesAndroidInjector(modules = CheckoutActivityModule.class)
    abstract CheckoutActivity checkoutActivity();

    @ContributesAndroidInjector(modules = CommentListActivityModule.class)
    abstract CommentListActivity commentListActivity();

    @ContributesAndroidInjector(modules = BasketlistActivityModule.class)
    abstract BasketListActivity basketListActivity();

    @ContributesAndroidInjector(modules = GalleryDetailActivityModule.class)
    abstract GalleryDetailActivity galleryDetailActivity();

    @ContributesAndroidInjector(modules = GalleryActivityModule.class)
    abstract GalleryActivity galleryActivity();

    @ContributesAndroidInjector(modules = SearchByCategoryActivityModule.class)
    abstract SearchByCategoryActivity searchByCategoryActivity();

    @ContributesAndroidInjector(modules = TermsAndConditionsModule.class)
    abstract TermsAndConditionsActivity termsAndConditionsActivity();

    @ContributesAndroidInjector(modules = EditSettingModule.class)
    abstract SettingActivity editSettingActivity();

    @ContributesAndroidInjector(modules = LanguageChangeModule.class)
    abstract NotificationSettingActivity languageChangeActivity();

    @ContributesAndroidInjector(modules = ProfileEditModule.class)
    abstract ProfileEditActivity contributeProfileEditActivity();

    @ContributesAndroidInjector(modules = AppInfoModule.class)
    abstract AppInfoActivity AppInfoActivity();

    @ContributesAndroidInjector(modules = CategoryListActivityAppInfoModule.class)
    abstract CategoryListActivity categoryListActivity();

    @ContributesAndroidInjector(modules = RatingListActivityModule.class)
    abstract RatingListActivity ratingListActivity();

    @ContributesAndroidInjector(modules = CollectionModule.class)
    abstract CollectionActivity collectionActivity();

    @ContributesAndroidInjector(modules = StripeModule.class)
    abstract StripeActivity stripeActivity();

    @ContributesAndroidInjector(modules = BlogListActivityModule.class)
    abstract BlogListActivity BlogListActivity();

    @ContributesAndroidInjector(modules = BlogDetailModule.class)
    abstract BlogDetailActivity blogDetailActivity();

    @ContributesAndroidInjector(modules = forceUpdateModule.class)
    abstract ForceUpdateActivity forceUpdateActivity();

    @ContributesAndroidInjector(modules = appLoadingModule.class)
    abstract AppLoadingActivity appLoadingActivity();

    @ContributesAndroidInjector(modules = VerifyEmailModule.class)
    abstract VerifyEmailActivity contributeVerifyEmailActivity();

    @ContributesAndroidInjector(modules = PrivacyPolicyActivityModule.class)
    abstract PrivacyPolicyActivity contributePrivacyPolicyActivity();
}

@Module
abstract class CheckoutActivityModule {

    @ContributesAndroidInjector
    abstract CheckoutFragment1 checkoutFragment1();

    @ContributesAndroidInjector
    abstract LanguageFragment languageFragment();

    @ContributesAndroidInjector
    abstract CheckoutFragment2 checkoutFragment2();

    @ContributesAndroidInjector
    abstract CheckoutFragment3 checkoutFragment3();

    @ContributesAndroidInjector
    abstract CheckoutStatusFragment checkoutStatusFragment();
}

@Module
abstract class MainModule {

    @ContributesAndroidInjector
    abstract ProductListFragment contributefeaturedProductFragment();

    @ContributesAndroidInjector
    abstract MainFragment contributeSelectedShopFragment();

    @ContributesAndroidInjector
    abstract CategoryListFragment contributeCategoryFragment();

    @ContributesAndroidInjector
    abstract CategoryFilterFragment contributeTypeFilterFragment();

    @ContributesAndroidInjector
    abstract ProductCollectionHeaderListFragment contributeProductCollectionHeaderListFragment();

    @ContributesAndroidInjector
    abstract ContactUsFragment contributeContactUsFragment();

    @ContributesAndroidInjector
    abstract UserLoginFragment contributeUserLoginFragment();

    @ContributesAndroidInjector
    abstract UserForgotPasswordFragment contributeUserForgotPasswordFragment();

    @ContributesAndroidInjector
    abstract UserRegisterFragment contributeUserRegisterFragment();

    @ContributesAndroidInjector
    abstract NotificationSettingFragment contributeNotificationSettingFragment();

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();

    @ContributesAndroidInjector
    abstract LanguageFragment contributeLanguageFragment();

    @ContributesAndroidInjector
    abstract FavouriteListFragment contributeFavouriteListFragment();

    @ContributesAndroidInjector
    abstract TransactionListFragment contributTransactionListFragment();

    @ContributesAndroidInjector
    abstract SettingFragment contributEditSettingFragment();

    @ContributesAndroidInjector
    abstract HistoryFragment historyFragment();

    @ContributesAndroidInjector
    abstract ShopProfileFragment contributeAboutUsFragmentFragment();

    @ContributesAndroidInjector
    abstract BasketListFragment basketFragment();

    @ContributesAndroidInjector
    abstract SearchFragment contributeSearchFragment();

    @ContributesAndroidInjector
    abstract NotificationListFragment contributeNotificationFragment();

    @ContributesAndroidInjector
    abstract AppInfoFragment contributeAppInfoFragment();

    @ContributesAndroidInjector
    abstract VerifyEmailFragment contributeVerifyEmailFragment();

    @ContributesAndroidInjector
    abstract PrivacyPolicyFragment contributePrivacyPolicyFragment();
}


@Module
abstract class ProfileEditModule {
    @ContributesAndroidInjector
    abstract ProfileEditFragment contributeProfileEditFragment();
}

@Module
abstract class TransactionModule {
    @ContributesAndroidInjector
    abstract TransactionListFragment contributeTransactionListFragment();
}


@Module
abstract class FavouriteListModule {
    @ContributesAndroidInjector
    abstract FavouriteListFragment contributeFavouriteFragment();
}

@Module
abstract class UserRegisterModule {
    @ContributesAndroidInjector
    abstract UserRegisterFragment contributeUserRegisterFragment();
}

@Module
abstract class UserForgotPasswordModule {
    @ContributesAndroidInjector
    abstract UserForgotPasswordFragment contributeUserForgotPasswordFragment();
}

@Module
abstract class UserLoginModule {
    @ContributesAndroidInjector
    abstract UserLoginFragment contributeUserLoginFragment();
}

@Module
abstract class PasswordChangeModule {
    @ContributesAndroidInjector
    abstract PasswordChangeFragment contributePasswordChangeFragment();
}

@Module
abstract class CommentDetailModule {
    @ContributesAndroidInjector
    abstract CommentDetailFragment commentDetailFragment();
}

@Module
abstract class DiscountDetailModule {
    @ContributesAndroidInjector
    abstract ProductDetailFragment discountDetailFragment();
}

@Module
abstract class NotificationModule {
    @ContributesAndroidInjector
    abstract NotificationListFragment notificationFragment();


}


@Module
abstract class NotificationDetailModule {
    @ContributesAndroidInjector
    abstract NotificationFragment notificationDetailFragment();
}

@Module
abstract class TransactionDetailModule {
    @ContributesAndroidInjector
    abstract TransactionFragment transactionDetailFragment();
}

@Module
abstract class UserHistoryModule {
    @ContributesAndroidInjector
    abstract HistoryFragment contributeHistoryFragment();
}

@Module
abstract class AppInfoModule {
    @ContributesAndroidInjector
    abstract AppInfoFragment contributeAppInfoFragment();
}

@Module
abstract class CategoryListActivityAppInfoModule {
    @ContributesAndroidInjector
    abstract CategoryListFragment contributeCategoryFragment();

    @ContributesAndroidInjector
    abstract TrendingCategoryFragment contributeTrendingCategoryFragment();
}

@Module
abstract class RatingListActivityModule {
    @ContributesAndroidInjector
    abstract RatingListFragment contributeRatingListFragment();
}

@Module
abstract class TermsAndConditionsModule {
    @ContributesAndroidInjector
    abstract TermsAndConditionsFragment TermsAndConditionsFragment();
}

@Module
abstract class EditSettingModule {
    @ContributesAndroidInjector
    abstract SettingFragment EditSettingFragment();
}

@Module
abstract class LanguageChangeModule {
    @ContributesAndroidInjector
    abstract NotificationSettingFragment notificationSettingFragment();
}

@Module
abstract class EditProfileModule {
    @ContributesAndroidInjector
    abstract ProfileFragment ProfileFragment();
}

@Module
abstract class ProductListByCatIdModule {
    @ContributesAndroidInjector
    abstract ProductListByCatIdFragment contributeProductListByCatIdFragment();

}

@Module
abstract class FilteringModule {

    @ContributesAndroidInjector
    abstract CategoryFilterFragment contributeTypeFilterFragment();

    @ContributesAndroidInjector
    abstract FilterFragment contributeSpecialFilteringFragment();
}

@Module
abstract class HomeFilteringActivityModule {
    @ContributesAndroidInjector
    abstract ProductListFragment contributefeaturedProductFragment();

    @ContributesAndroidInjector
    abstract CategoryListFragment contributeCategoryFragment();

    @ContributesAndroidInjector
    abstract CategoryFilterFragment contributeTypeFilterFragment();

    @ContributesAndroidInjector
    abstract CollectionFragment contributeCollectionFragment();
}

@Module
abstract class CommentListActivityModule {
    @ContributesAndroidInjector
    abstract CommentListFragment contributeCommentListFragment();
}

@Module
abstract class BasketlistActivityModule {
    @ContributesAndroidInjector
    abstract BasketListFragment contributeBasketListFragment();
}

@Module
abstract class GalleryDetailActivityModule {
    @ContributesAndroidInjector
    abstract GalleryDetailFragment contributeGalleryDetailFragment();
}

@Module
abstract class GalleryActivityModule {
    @ContributesAndroidInjector
    abstract GalleryFragment contributeGalleryFragment();
}

@Module
abstract class SearchByCategoryActivityModule {

    @ContributesAndroidInjector
    abstract SearchCategoryFragment contributeSearchCategoryFragment();

    @ContributesAndroidInjector
    abstract SearchSubCategoryFragment contributeSearchSubCategoryFragment();

    @ContributesAndroidInjector
    abstract SearchCityListFragment contributeSearchCityListFragment();

    @ContributesAndroidInjector
    abstract SearchCountryListFragment contributeSearchCountryListFragment();

}

@Module
abstract class CollectionModule {

    @ContributesAndroidInjector
    abstract CollectionFragment contributeCollectionFragment();

}

@Module
abstract class StripeModule {

    @ContributesAndroidInjector
    abstract StripeFragment contributeStripeFragment();

}

@Module
abstract class BlogListActivityModule {

    @ContributesAndroidInjector
    abstract BlogListFragment contributeBlogListFragment();

}

@Module
abstract class BlogDetailModule {

    @ContributesAndroidInjector
    abstract BlogDetailFragment contributeBlogDetailFragment();
}

@Module
abstract class forceUpdateModule {

    @ContributesAndroidInjector
    abstract ForceUpdateFragment contributeForceUpdateFragment();
}

@Module
abstract class appLoadingModule {

    @ContributesAndroidInjector
    abstract AppLoadingFragment contributeAppLoadingFragment();
}

@Module
abstract class VerifyEmailModule {
    @ContributesAndroidInjector
    abstract VerifyEmailFragment contributeVerifyEmailFragment();
}

@Module
abstract class PrivacyPolicyActivityModule {
    @ContributesAndroidInjector
    abstract PrivacyPolicyFragment contributePrivacyPolicyFragment();
}