package com.panaceasoft.psstore.viewobject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ShippingCost {

    @SerializedName("shipping")
    public final ShippingZone shippingZone;

    public ShippingCost( ShippingZone shippingZone) {
        this.shippingZone = shippingZone;
    }
}
