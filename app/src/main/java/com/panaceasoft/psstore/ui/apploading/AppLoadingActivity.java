package com.panaceasoft.psstore.ui.apploading;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.databinding.DataBindingUtil;

import com.panaceasoft.psstore.Config;
import com.panaceasoft.psstore.R;
import com.panaceasoft.psstore.databinding.ActivityAppLoadingBinding;
import com.panaceasoft.psstore.ui.common.PSAppCompactActivity;
import com.panaceasoft.psstore.utils.Constants;
import com.panaceasoft.psstore.utils.MyContextWrapper;

public class AppLoadingActivity extends PSAppCompactActivity {

    //region Override Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityAppLoadingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_app_loading);
        // Init all UI
        initUI(binding);

    }

    @Override
    protected void attachBaseContext(Context newBase) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(newBase);
        String CURRENT_LANG_CODE = preferences.getString(Constants.LANGUAGE_CODE, Config.DEFAULT_LANGUAGE);
        String CURRENT_LANG_COUNTRY_CODE = preferences.getString(Constants.LANGUAGE_COUNTRY_CODE, Config.DEFAULT_LANGUAGE_COUNTRY_CODE);

        super.attachBaseContext(MyContextWrapper.wrap(newBase, CURRENT_LANG_CODE, CURRENT_LANG_COUNTRY_CODE, true));
    }
    //endregion


    //region Private Methods

    private void initUI(ActivityAppLoadingBinding binding) {

        // setup Fragment

        setupFragment(new AppLoadingFragment());
    }
}
//endregion


