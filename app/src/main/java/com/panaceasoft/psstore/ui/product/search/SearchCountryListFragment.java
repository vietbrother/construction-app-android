package com.panaceasoft.psstore.ui.product.search;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.panaceasoft.psstore.Config;
import com.panaceasoft.psstore.R;
import com.panaceasoft.psstore.binding.FragmentDataBindingComponent;
import com.panaceasoft.psstore.databinding.FragmentSearchCountryListBinding;
import com.panaceasoft.psstore.databinding.FragmentSearchCountryListBinding;
import com.panaceasoft.psstore.databinding.TypeFilterBinding;
import com.panaceasoft.psstore.ui.common.DataBoundListAdapter;
import com.panaceasoft.psstore.ui.common.PSFragment;
import com.panaceasoft.psstore.ui.product.filtering.CategoryFilterFragment;
import com.panaceasoft.psstore.ui.product.filtering.adapter.CategoryAdapter;
import com.panaceasoft.psstore.ui.product.search.adapter.SearchCategoryAdapter;
import com.panaceasoft.psstore.ui.product.search.adapter.SearchCountryAdapter;
import com.panaceasoft.psstore.utils.AutoClearedValue;
import com.panaceasoft.psstore.utils.Constants;
import com.panaceasoft.psstore.utils.Utils;

import com.panaceasoft.psstore.viewmodel.country.CountryViewModel;

import com.panaceasoft.psstore.viewobject.Category;
import com.panaceasoft.psstore.viewobject.Country;
import com.panaceasoft.psstore.viewobject.SubCategory;
import com.panaceasoft.psstore.viewobject.common.Resource;
import com.panaceasoft.psstore.viewobject.common.Status;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchCountryListFragment extends PSFragment {

    private final androidx.databinding.DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);

    private CountryViewModel countryViewModel;
    public String countryId;

    @VisibleForTesting
    private AutoClearedValue<FragmentSearchCountryListBinding> binding;
    private AutoClearedValue<SearchCountryAdapter> adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentSearchCountryListBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_country_list, container, false, dataBindingComponent);

        binding = new AutoClearedValue<>(this, dataBinding);

        setHasOptionsMenu(true);

        if (getActivity() != null) {
            Intent intent = getActivity().getIntent();
            this.countryId = intent.getStringExtra(Constants.COUNTRY_ID);
        }
        return binding.get().getRoot();
    }

    @Override
    protected void initUIAndActions() {

        if (Config.SHOW_ADMOB && connectivity.isConnected()) {
            AdRequest adRequest = new AdRequest.Builder()
                    .build();
            binding.get().adView.loadAd(adRequest);
        } else {
            binding.get().adView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        inflater.inflate(R.menu.clear_button, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.clear) {
            this.countryId = "";

            initAdapters();

            initData();

            navigationController.navigateBackToSearchFragmentFromCountry(SearchCountryListFragment.this.getActivity(), this.countryId, "");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initViewModels() {

        countryViewModel = ViewModelProviders.of(this, viewModelFactory).get(CountryViewModel.class);
    }

    @Override
    protected void initAdapters() {

        SearchCountryAdapter nvadapter = new SearchCountryAdapter(dataBindingComponent,
                (country, id) -> {

                    navigationController.navigateBackToSearchFragmentFromCountry(SearchCountryListFragment.this.getActivity(), country.id, country.name);

                    if (getActivity() != null) {
                        SearchCountryListFragment.this.getActivity().finish();
                    }
                }, this.countryId);
        this.adapter = new AutoClearedValue<>(this, nvadapter);
        binding.get().searchCategoryRecyclerView.setAdapter(nvadapter);

    }

    @Override
    protected void initData() {

        loadCountry();
    }

    private void loadCountry() {

        // Load Country List

        countryViewModel.setCountryListObj(shopId, String.valueOf(Config.LIST_CATEGORY_COUNT), String.valueOf(countryViewModel.offset));

        LiveData<Resource<List<Country>>> news = countryViewModel.getCountryListData();

        if (news != null) {

            news.observe(this, listResource -> {
                if (listResource != null) {

                    Utils.psLog("Got Data" + listResource.message + listResource.toString());

                    switch (listResource.status) {
                        case LOADING:
                            // Loading State
                            // Data are from Local DB

                            if (listResource.data != null) {
                                //fadeIn Animation
                                fadeIn(binding.get().getRoot());

                                // Update the data
                                replaceData(listResource.data);

                            }

                            break;

                        case SUCCESS:
                            // Success State
                            // Data are from Server

                            if (listResource.data != null) {
                                // Update the data
                                replaceData(listResource.data);
                            }

                            countryViewModel.setLoadingState(false);

                            break;

                        case ERROR:
                            // Error State

                            countryViewModel.setLoadingState(false);

                            break;
                        default:
                            // Default

                            break;
                    }

                } else {

                    // Init Object or Empty Data
                    Utils.psLog("Empty Data");

                    if (countryViewModel.offset > 1) {
                        // No more data for this list
                        // So, Block all future loading
                        countryViewModel.forceEndLoading = true;
                    }

                }

            });
        }

        countryViewModel.getNextPageCountryListData().observe(this, state -> {
            if (state != null) {
                if (state.status == Status.ERROR) {
                    Utils.psLog("Next Page State : " + state.data);

                    countryViewModel.setLoadingState(false);
                    countryViewModel.forceEndLoading = true;
                }
            }
        });

    }

    private void replaceData(List<Country> countryList) {

        adapter.get().replace(countryList);
        binding.get().executePendingBindings();

    }
}
