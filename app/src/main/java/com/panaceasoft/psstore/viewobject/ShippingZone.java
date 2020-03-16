package com.panaceasoft.psstore.viewobject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

public class ShippingZone {

    @SerializedName("shipping_zone_package_name")
    public final String shippingZonePackageName;

    @SerializedName("shipping_cost")
    public final String shippingCost;

    public ShippingZone( String shippingZonePackageName, String shippingCost) {

        this.shippingZonePackageName = shippingZonePackageName;
        this.shippingCost = shippingCost;
    }
}
