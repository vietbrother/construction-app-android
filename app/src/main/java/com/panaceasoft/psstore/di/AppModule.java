package com.panaceasoft.psstore.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.panaceasoft.psstore.Config;
import com.panaceasoft.psstore.api.PSApiService;
import com.panaceasoft.psstore.db.AboutUsDao;
import com.panaceasoft.psstore.db.BasketDao;
import com.panaceasoft.psstore.db.BlogDao;
import com.panaceasoft.psstore.db.CategoryDao;
import com.panaceasoft.psstore.db.CategoryMapDao;
import com.panaceasoft.psstore.db.CityDao;
import com.panaceasoft.psstore.db.CommentDao;
import com.panaceasoft.psstore.db.CommentDetailDao;
import com.panaceasoft.psstore.db.CountryDao;
import com.panaceasoft.psstore.db.DeletedObjectDao;
import com.panaceasoft.psstore.db.HistoryDao;
import com.panaceasoft.psstore.db.ImageDao;
import com.panaceasoft.psstore.db.NotificationDao;
import com.panaceasoft.psstore.db.PSAppInfoDao;
import com.panaceasoft.psstore.db.PSAppVersionDao;
import com.panaceasoft.psstore.db.PSCoreDb;
import com.panaceasoft.psstore.db.ProductAttributeDetailDao;
import com.panaceasoft.psstore.db.ProductAttributeHeaderDao;
import com.panaceasoft.psstore.db.ProductCollectionDao;
import com.panaceasoft.psstore.db.ProductColorDao;
import com.panaceasoft.psstore.db.ProductDao;
import com.panaceasoft.psstore.db.ProductMapDao;
import com.panaceasoft.psstore.db.ProductSpecsDao;
import com.panaceasoft.psstore.db.RatingDao;
import com.panaceasoft.psstore.db.ShippingMethodDao;
import com.panaceasoft.psstore.db.ShopDao;
import com.panaceasoft.psstore.db.SubCategoryDao;
import com.panaceasoft.psstore.db.TransactionDao;
import com.panaceasoft.psstore.db.TransactionOrderDao;
import com.panaceasoft.psstore.db.UserDao;
import com.panaceasoft.psstore.utils.AppLanguage;
import com.panaceasoft.psstore.utils.Connectivity;
import com.panaceasoft.psstore.utils.LiveDataCallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Panacea-Soft on 11/15/17.
 * Contact Email : teamps.is.cool@gmail.com
 */

@Module(includes = ViewModelModule.class)
class AppModule {

    @Singleton
    @Provides
    PSApiService providePSApiService() {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .build();

        return new Retrofit.Builder()
                .baseUrl(Config.APP_API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build()
                .create(PSApiService.class);

    }

    @Singleton
    @Provides
    PSCoreDb provideDb(Application app) {
        return Room.databaseBuilder(app, PSCoreDb.class, "PSApp.db")
                //.addMigrations(MIGRATION_1_2)
                .fallbackToDestructiveMigration()
                .build();
    }

    @Singleton
    @Provides
    Connectivity provideConnectivity(Application app) {
        return new Connectivity(app);
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences(Application app) {
        return PreferenceManager.getDefaultSharedPreferences(app.getApplicationContext());
    }

    @Singleton
    @Provides
    UserDao provideUserDao(PSCoreDb db) {
        return db.userDao();
    }

    @Singleton
    @Provides
    AppLanguage provideCurrentLanguage(SharedPreferences sharedPreferences) {
        return new AppLanguage(sharedPreferences);
    }

    @Singleton
    @Provides
    AboutUsDao provideAboutUsDao(PSCoreDb db) {
        return db.aboutUsDao();
    }

    @Singleton
    @Provides
    ImageDao provideImageDao(PSCoreDb db) {
        return db.imageDao();
    }

    @Singleton
    @Provides
    ProductDao provideProductDao(PSCoreDb db) {
        return db.productDao();
    }

    @Singleton
    @Provides
    CountryDao provideCountryDao(PSCoreDb db) {
        return db.countryDao();
    }

    @Singleton
    @Provides
    CityDao provideCityDao(PSCoreDb db) {
        return db.cityDao();
    }

    @Singleton
    @Provides
    ProductColorDao provideProductColorDao(PSCoreDb db) {
        return db.productColorDao();
    }

    @Singleton
    @Provides
    ProductSpecsDao provideProductSpecsDao(PSCoreDb db) {
        return db.productSpecsDao();
    }

    @Singleton
    @Provides
    ProductAttributeHeaderDao provideProductAttributeHeaderDao(PSCoreDb db) {
        return db.productAttributeHeaderDao();
    }

    @Singleton
    @Provides
    ProductAttributeDetailDao provideProductAttributeDetailDao(PSCoreDb db) {
        return db.productAttributeDetailDao();
    }

    @Singleton
    @Provides
    BasketDao provideBasketDao(PSCoreDb db) {
        return db.basketDao();
    }

    @Singleton
    @Provides
    HistoryDao provideHistoryDao(PSCoreDb db) {
        return db.historyDao();
    }

    @Singleton
    @Provides
    CategoryDao provideCategoryDao(PSCoreDb db) {
        return db.categoryDao();
    }

    @Singleton
    @Provides
    RatingDao provideRatingDao(PSCoreDb db) {
        return db.ratingDao();
    }

    @Singleton
    @Provides
    SubCategoryDao provideSubCategoryDao(PSCoreDb db) {
        return db.subCategoryDao();
    }

    @Singleton
    @Provides
    CommentDao provideCommentDao(PSCoreDb db) {
        return db.commentDao();
    }

    @Singleton
    @Provides
    CommentDetailDao provideCommentDetailDao(PSCoreDb db) {
        return db.commentDetailDao();
    }

    @Singleton
    @Provides
    NotificationDao provideNotificationDao(PSCoreDb db){return db.notificationDao();}

    @Singleton
    @Provides
    ProductCollectionDao provideProductCollectionDao(PSCoreDb db){return db.productCollectionDao();}

    @Singleton
    @Provides
    TransactionDao provideTransactionDao(PSCoreDb db){return db.transactionDao();}

    @Singleton
    @Provides
    TransactionOrderDao provideTransactionOrderDao(PSCoreDb db){return db.transactionOrderDao();}

//    @Singleton
//    @Provides
//    TrendingCategoryDao provideTrendingCategoryDao(PSCoreDb db){return db.trendingCategoryDao();}

    @Singleton
    @Provides
    ShopDao provideShopDao(PSCoreDb db){return db.shopDao();}

    @Singleton
    @Provides
    BlogDao provideNewsFeedDao(PSCoreDb db){return db.blogDao();}

    @Singleton
    @Provides
    ShippingMethodDao provideShippingMethodDao(PSCoreDb db){return db.shippingMethodDao();}

    @Singleton
    @Provides
    ProductMapDao provideProductMapDao(PSCoreDb db){return db.productMapDao();}

    @Singleton
    @Provides
    CategoryMapDao provideCategoryMapDao(PSCoreDb db){return db.categoryMapDao();}

    @Singleton
    @Provides
    PSAppInfoDao providePSAppInfoDao(PSCoreDb db){return db.psAppInfoDao();}

    @Singleton
    @Provides
    PSAppVersionDao providePSAppVersionDao(PSCoreDb db){return db.psAppVersionDao();}

    @Singleton
    @Provides
    DeletedObjectDao provideDeletedObjectDao(PSCoreDb db){return db.deletedObjectDao();}
}
