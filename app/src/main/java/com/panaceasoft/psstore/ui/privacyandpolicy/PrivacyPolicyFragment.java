package com.panaceasoft.psstore.ui.privacyandpolicy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import com.panaceasoft.psstore.R;
import com.panaceasoft.psstore.binding.FragmentDataBindingComponent;
import com.panaceasoft.psstore.databinding.FragmentPrivacyPolicyBinding;
import com.panaceasoft.psstore.ui.common.PSFragment;
import com.panaceasoft.psstore.utils.AutoClearedValue;
import com.panaceasoft.psstore.utils.Utils;
import com.panaceasoft.psstore.viewmodel.aboutus.AboutUsViewModel;
import com.panaceasoft.psstore.viewobject.AboutUs;

public class PrivacyPolicyFragment extends PSFragment {

    //region Variables

    private final androidx.databinding.DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);

    private AboutUsViewModel aboutUsViewModel;

    @VisibleForTesting
    private AutoClearedValue<FragmentPrivacyPolicyBinding> binding;


    //endregion


    //region Override Methods

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        FragmentPrivacyPolicyBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_privacy_policy, container, false, dataBindingComponent);

        binding = new AutoClearedValue<>(this, dataBinding);

        return binding.get().getRoot();
    }

    @Override
    protected void initUIAndActions() {

//        if(getActivity() instanceof MainActivity)  {
//            ((MainActivity) this.getActivity()).binding.toolbar.setBackgroundColor(getResources().getColor(R.color.global__primary));
//            ((MainActivity)getActivity()).updateMenuIconWhite();
//        }
    }

    @Override
    protected void initViewModels() {
        aboutUsViewModel = ViewModelProviders.of(this, viewModelFactory).get(AboutUsViewModel.class);
    }

    @Override
    protected void initAdapters() {

    }

    @Override
    protected void initData() {

        aboutUsViewModel.setAboutUsObj("about us");
        aboutUsViewModel.getAboutUsData().observe(this, resource -> {

            if (resource != null) {

                switch (resource.status) {
                    case LOADING:
                        // Loading State
                        // Data are from Local DB

                        if (resource.data != null) {

                            fadeIn(binding.get().getRoot());

                        }
                        break;
                    case SUCCESS:
                        // Success State
                        // Data are from Server

                        if (resource.data != null) {

                            setAboutUsData(resource.data);
                        }

                        break;
                    case ERROR:
                        // Error State

                        break;
                    default:
                        // Default

                        break;
                }

            } else {

                // Init Object or Empty Data
                Utils.psLog("Empty Data");

            }


            // we don't need any null checks here for the adapter since LiveData guarantees that
            // it won't call us if fragment is stopped or not started.
            if (resource != null) {
                Utils.psLog("Got Data Of About Us.");


            } else {
                //noinspection Constant Conditions
                Utils.psLog("No Data of About Us.");
            }
        });
    }


    private void setAboutUsData(AboutUs aboutUs) {
        binding.get().setAboutUs(aboutUs);
        binding.get().termsAndConditionTextView.setText(aboutUs.privacyPolicy);
    }
    //endregion

}


