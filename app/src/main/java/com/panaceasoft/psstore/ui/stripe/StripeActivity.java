package com.panaceasoft.psstore.ui.stripe;

import android.os.Bundle;

import com.panaceasoft.psstore.R;
import com.panaceasoft.psstore.databinding.ActivityStripeBinding;
import com.panaceasoft.psstore.ui.common.PSAppCompactActivity;

import androidx.databinding.DataBindingUtil;

public class StripeActivity extends PSAppCompactActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityStripeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_stripe);

        initUI(binding);

    }

    private void initUI(ActivityStripeBinding binding) {

        // Toolbar
        initToolbar(binding.toolbar, getResources().getString(R.string.checkout__stripe));

        // setup Fragment
        setupFragment(new StripeFragment());

    }
}

