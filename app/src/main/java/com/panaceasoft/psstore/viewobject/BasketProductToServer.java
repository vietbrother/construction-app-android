package com.panaceasoft.psstore.viewobject;

import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;

@Entity
public class BasketProductToServer {

    @SerializedName("shop_id")
    public String shopId;

    @SerializedName("product_id")
    public String productId;

    @SerializedName("product_name")
    public String productName;

    @SerializedName("product_attribute_id")
    public String productAttributeId;

    @SerializedName("product_attribute_name")
    public String productAttributeName;

    @SerializedName("product_attribute_price")
    public String product_attribute_price;

    @SerializedName("product_color_id")
    public String product_color_id;

    @SerializedName("product_color_code")
    public String product_color_code;

    @SerializedName("product_unit")
    public String product_unit;

    @SerializedName("product_measurement")
    public String productMeasurement;

    @SerializedName("shipping_cost")
    public String shippingCost;

    @SerializedName("unit_price")
    public String price;

    @SerializedName("original_price")
    public String originalPrice;

    @SerializedName("discount_price")
    public String discount_price;

    @SerializedName("discount_amount")
    public String discountAmount;

    @SerializedName("qty")
    public String qty;

    @SerializedName("discount_value")
    public String discountValue;

    @SerializedName("discount_percent")
    public String discountPercent;

    @SerializedName("currency_short_form")
    public String currencyShortForm;

    @SerializedName("currency_symbol")
    public String currencySymbol;

    public BasketProductToServer(String shopId, String productId, String productName, String productAttributeId, String productAttributeName, String product_attribute_price, String product_color_id, String product_color_code, String product_unit, String productMeasurement, String shippingCost, String price, String originalPrice, String discount_price, String discountAmount, String qty, String discountValue, String discountPercent, String currencyShortForm, String currencySymbol) {
        this.shopId = shopId;
        this.productId = productId;
        this.productName = productName;
        this.productAttributeId = productAttributeId;
        this.productAttributeName = productAttributeName;
        this.product_attribute_price = product_attribute_price;
        this.product_color_id = product_color_id;
        this.product_color_code = product_color_code;
        this.product_unit = product_unit;
        this.productMeasurement = productMeasurement;
        this.shippingCost = shippingCost;
        this.price = price;
        this.originalPrice = originalPrice;
        this.discount_price = discount_price;
        this.discountAmount = discountAmount;
        this.qty = qty;
        this.discountValue = discountValue;
        this.discountPercent = discountPercent;
        this.currencyShortForm = currencyShortForm;
        this.currencySymbol = currencySymbol;
    }
}
