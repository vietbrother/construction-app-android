package com.panaceasoft.psstore.ui.blog.list;

import android.os.Bundle;

import com.panaceasoft.psstore.R;
import com.panaceasoft.psstore.databinding.ActivityBlogListBinding;
import com.panaceasoft.psstore.ui.common.PSAppCompactActivity;

import androidx.databinding.DataBindingUtil;

public class BlogListActivity extends PSAppCompactActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityBlogListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_blog_list);

        initUI(binding);

    }

    private void initUI(ActivityBlogListBinding binding) {

        // Toolbar
        initToolbar(binding.toolbar, getResources().getString(R.string.blog_list__title));

        // setup Fragment

        setupFragment(new BlogListFragment());

    }
}
