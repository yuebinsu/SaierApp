package com.outsource.saier;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.outsource.saier.app.ARoutePaths;

import butterknife.BindView;

@Route(path = ARoutePaths.HOME_MAIN)
public class MainActivity extends BaseActivity {

    @BindView(R.id.main_toolbar)
    Toolbar mainToolbar;
    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.mapView_main)
    MapView mapViewMain;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        mainToolbar.setNavigationIcon(R.drawable.ic_main_toolbar_user);
        searchView.setIconified(false);
        searchView.onActionViewExpanded();
        searchView.setSubmitButtonEnabled(true);
        mapViewMain.onCreate(savedInstanceState);
        AMap aMap = mapViewMain.getMap();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mapViewMain != null) {
            mapViewMain.onDestroy();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapViewMain.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapViewMain.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapViewMain.onSaveInstanceState(outState);
    }
    /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_search_view, menu);
        //找到searchView
        MenuItem searchItem = menu.findItem(R.id.main_menu_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setIconified(false);
        searchView.setIconifiedByDefault(false);//默认为true在框内，设置false则在框外
        return super.onCreateOptionsMenu(menu);
    }*/
}
