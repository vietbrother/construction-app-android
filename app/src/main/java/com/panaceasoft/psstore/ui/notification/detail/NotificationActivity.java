package com.panaceasoft.psstore.ui.notification.detail;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.panaceasoft.psstore.Config;
import com.panaceasoft.psstore.R;
import com.panaceasoft.psstore.databinding.ActivityNotificationBinding;
import com.panaceasoft.psstore.ui.common.PSAppCompactActivity;
import com.panaceasoft.psstore.utils.Constants;
import com.panaceasoft.psstore.utils.MyContextWrapper;

import androidx.databinding.DataBindingUtil;

public class NotificationActivity extends PSAppCompactActivity {


    //region Override Methods

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityNotificationBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_notification);

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

    private void initUI(ActivityNotificationBinding binding) {

        // Toolbar
        initToolbar(binding.toolbar, getResources().getString(R.string.notification_detail__title));

        // setup Fragment
        setupFragment(new NotificationFragment());
    }
    //endregion

}
