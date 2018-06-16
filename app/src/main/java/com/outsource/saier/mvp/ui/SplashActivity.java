package com.outsource.saier.mvp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.component.DaggerAppComponent;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.utils.ArmsUtils;
import com.outsource.saier.R;
import com.outsource.saier.app.ARoutePaths;
import com.outsource.saier.app.IBaseActivity;
import com.outsource.saier.di.component.DaggerUserComponent;
import com.outsource.saier.di.module.UserModule;
import com.outsource.saier.mvp.contract.UserContract;
import com.outsource.saier.mvp.model.api.entity.User;
import com.outsource.saier.mvp.model.api.service.UserService;
import com.outsource.saier.mvp.presenter.UserPresenter;
import com.outsource.saier.utils.RxBarTool;
import com.tbruyelle.rxpermissions2.RxPermissions;


import java.util.List;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;

@Route(path = ARoutePaths.HOME_SPLASH)
public class SplashActivity extends IBaseActivity<UserPresenter> implements UserContract.View {

    private final int ANIMATION_TIME = 3000;
    @BindView(R.id.rl_splash)
    RelativeLayout rl_splash;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerUserComponent
                .builder()
                .appComponent(appComponent)
                .userModule(new UserModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        // RxBarTool.FLAG_FULLSCREEN(this);
        return R.layout.activity_splash;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        //渐变时间
        alphaAnimation.setDuration(ANIMATION_TIME);

        //  rl_splash.startAnimation(alphaAnimation);
 /*       alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ARouter.getInstance().build(ARoutePaths.HOME_MAIN)
                        .navigation();
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });*/
      /*  IRepositoryManager iRepositoryManager = ArmsUtils.obtainAppComponentFromContext(this).repositoryManager();
        Observable<List<User>> listObservable = iRepositoryManager.obtainRetrofitService(UserService.class).getUsers(1,1);*/
        mPresenter.requestUser();
        rl_splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Observable.just(ArmsUtils.obtainAppComponentFromContext(SplashActivity.this).repositoryManager()
                        .obtainRetrofitService(UserService.class)
                        .getUsers(1, 10))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ErrorHandleSubscriber<Observable<List<User>>>(ArmsUtils.obtainAppComponentFromContext(SplashActivity.this).rxErrorHandler()) {
                            @Override
                            public void onNext(Observable<List<User>> listObservable) {
                                Log.d(TAG, new Gson().toJson(listObservable));
                            }

                            @Override
                            public void onError(Throwable t) {
                                Log.d(TAG, t.getMessage());
                                super.onError(t);
                            }
                        });*/
                mPresenter.requestUser();

               /* ArmsUtils.obtainAppComponentFromContext(SplashActivity.this).repositoryManager()
                        .obtainRetrofitService(UserService.class).getUsers(1,10);*/
            }
        });
    }

    @Override
    public void startLoadMore() {

    }

    @Override
    public void endLoadMore() {

    }

    @Override
    public Activity getActivity() {
        return null;
    }

    @Override
    public RxPermissions getRxPermissions() {
        return null;
    }

    @Override
    public void showMessage(@NonNull String message) {

    }
}
