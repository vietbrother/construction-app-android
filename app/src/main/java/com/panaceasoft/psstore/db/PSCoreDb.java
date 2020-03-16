package com.panaceasoft.psstore.db;

import com.panaceasoft.psstore.db.common.Converters;
import com.panaceasoft.psstore.viewobject.AboutUs;
import com.panaceasoft.psstore.viewobject.Basket;
import com.panaceasoft.psstore.viewobject.Blog;
import com.panaceasoft.psstore.viewobject.Category;
import com.panaceasoft.psstore.viewobject.CategoryMap;
import com.panaceasoft.psstore.viewobject.City;
import com.panaceasoft.psstore.viewobject.Comment;
import com.panaceasoft.psstore.viewobject.CommentDetail;
import com.panaceasoft.psstore.viewobject.Country;
import com.panaceasoft.psstore.viewobject.DeletedObject;
import com.panaceasoft.psstore.viewobject.DiscountProduct;
import com.panaceasoft.psstore.viewobject.FavouriteProduct;
import com.panaceasoft.psstore.viewobject.FeaturedProduct;
import com.panaceasoft.psstore.viewobject.HistoryProduct;
import com.panaceasoft.psstore.viewobject.Image;
import com.panaceasoft.psstore.viewobject.LatestProduct;
import com.panaceasoft.psstore.viewobject.LikedProduct;
import com.panaceasoft.psstore.viewobject.Noti;
import com.panaceasoft.psstore.viewobject.PSAppInfo;
import com.panaceasoft.psstore.viewobject.PSAppVersion;
import com.panaceasoft.psstore.viewobject.Product;
import com.panaceasoft.psstore.viewobject.ProductAttributeDetail;
import com.panaceasoft.psstore.viewobject.ProductAttributeHeader;
import com.panaceasoft.psstore.viewobject.ProductCollection;
import com.panaceasoft.psstore.viewobject.ProductCollectionHeader;
import com.panaceasoft.psstore.viewobject.ProductColor;
import com.panaceasoft.psstore.viewobject.ProductListByCatId;
import com.panaceasoft.psstore.viewobject.ProductMap;
import com.panaceasoft.psstore.viewobject.ProductSpecs;
import com.panaceasoft.psstore.viewobject.Rating;
import com.panaceasoft.psstore.viewobject.RelatedProduct;
import com.panaceasoft.psstore.viewobject.ShippingCost;
import com.panaceasoft.psstore.viewobject.ShippingMethod;
import com.panaceasoft.psstore.viewobject.ShippingProductContainer;
import com.panaceasoft.psstore.viewobject.ShippingCostContainer;
import com.panaceasoft.psstore.viewobject.ShippingZone;
import com.panaceasoft.psstore.viewobject.Shop;
import com.panaceasoft.psstore.viewobject.ShopByTagId;
import com.panaceasoft.psstore.viewobject.ShopMap;
import com.panaceasoft.psstore.viewobject.ShopTag;
import com.panaceasoft.psstore.viewobject.SubCategory;
import com.panaceasoft.psstore.viewobject.TransactionDetail;
import com.panaceasoft.psstore.viewobject.TransactionObject;
import com.panaceasoft.psstore.viewobject.User;
import com.panaceasoft.psstore.viewobject.UserLogin;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


/**
 * Created by Panacea-Soft on 11/20/17.
 * Contact Email : teamps.is.cool@gmail.com
 */

@Database(entities = {
        Image.class,
        Category.class,
        User.class,
        UserLogin.class,
        AboutUs.class,
        Product.class,
        LatestProduct.class,
        DiscountProduct.class,
        FeaturedProduct.class,
        SubCategory.class,
        ProductListByCatId.class,
        Comment.class,
        CommentDetail.class,
        ProductColor.class,
        ProductSpecs.class,
        RelatedProduct.class,
        FavouriteProduct.class,
        LikedProduct.class,
        ProductAttributeHeader.class,
        ProductAttributeDetail.class,
        Noti.class,
        TransactionObject.class,
        ProductCollectionHeader.class,
        ProductCollection.class,
        TransactionDetail.class,
        Basket.class,
        HistoryProduct.class,
        Shop.class,
        ShopTag.class,
        Blog.class,
        Rating.class,
        ShippingMethod.class,
        ShopByTagId.class,
        ProductMap.class,
        ShopMap.class,
        CategoryMap.class,
        PSAppInfo.class,
        PSAppVersion.class,
        DeletedObject.class,
        Country.class,
        City.class

}, version = 7, exportSchema = false)
//V2.0 = DBV 7
//V1.9 = DBV 7
//V1.8 = DBV 7
//V1.7 = DBV 6
//V1.6 = DBV 5
//V1.5 = DBV 4
//V1.4 = DBV 3
//V1.3 = DBV 2


@TypeConverters({Converters.class})

public abstract class PSCoreDb extends RoomDatabase {

    abstract public UserDao userDao();

    abstract public ProductColorDao productColorDao();

    abstract public ProductSpecsDao productSpecsDao();

    abstract public ProductAttributeHeaderDao productAttributeHeaderDao();

    abstract public ProductAttributeDetailDao productAttributeDetailDao();

    abstract public BasketDao basketDao();

    abstract public HistoryDao historyDao();

    abstract public AboutUsDao aboutUsDao();

    abstract public ImageDao imageDao();

    abstract public CountryDao countryDao();

    abstract public CityDao cityDao();

    abstract public RatingDao ratingDao();

    abstract public CommentDao commentDao();

    abstract public CommentDetailDao commentDetailDao();

    abstract public ProductDao productDao();

    abstract public CategoryDao categoryDao();

    abstract public SubCategoryDao subCategoryDao();

    abstract public NotificationDao notificationDao();

    abstract public ProductCollectionDao productCollectionDao();

    abstract public TransactionDao transactionDao();

    abstract public TransactionOrderDao transactionOrderDao();

    abstract public ShopDao shopDao();

    abstract public BlogDao blogDao();

    abstract public ShippingMethodDao shippingMethodDao();

    abstract public ProductMapDao productMapDao();

    abstract public CategoryMapDao categoryMapDao();

    abstract public PSAppInfoDao psAppInfoDao();

    abstract public PSAppVersionDao psAppVersionDao();

    abstract public DeletedObjectDao deletedObjectDao();


//    /**
//     * Migrate from:
//     * version 1 - using Room
//     * to
//     * version 2 - using Room where the {@link } has an extra field: addedDateStr
//     */
//    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            database.execSQL("ALTER TABLE news "
//                    + " ADD COLUMN addedDateStr INTEGER NOT NULL DEFAULT 0");
//        }
//    };

    /* More migration write here */
}