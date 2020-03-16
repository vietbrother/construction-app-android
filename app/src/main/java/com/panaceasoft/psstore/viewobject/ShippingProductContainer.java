package com.panaceasoft.psstore.viewobject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

public class ShippingProductContainer {

    @SerializedName("product_id")
    public final String productId;

    @SerializedName("qty")
    public final int qty;

    public ShippingProductContainer( String productId, int qty) {
        this.productId = productId;
        this.qty = qty;
    }
}
