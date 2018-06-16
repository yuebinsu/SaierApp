package com.outsource.saier.mvp.presenter;

import android.app.Application;
import android.util.Log;

import com.alibaba.idst.nls.internal.utils.L;
import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.RxLifecycleUtils;
import com.outsource.saier.mvp.contract.UserContract;
import com.outsource.saier.mvp.model.UserModel;
import com.outsource.saier.mvp.model.api.entity.BaseResponse;
import com.outsource.saier.mvp.model.api.entity.TestRequest;
import com.outsource.saier.mvp.model.api.entity.User;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;

/**
 * Created by：Administrator on 2018/6/10 0010 23:17
 * 619389279@qq.com
 */
@ActivityScope
public class UserPresenter extends BasePresenter<UserContract.Model, UserContract.View> {

    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    AppManager mAppManager;
    @Inject
    Application mApplication;
    @Inject
    List<User> mUsers;

    @Inject
    public UserPresenter(UserContract.Model model, UserContract.View rootView) {
        super(model, rootView);
    }

    public void requestUser() {
       /* mModel.getUsers(1, false)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使
                .subscribe(new ErrorHandleSubscriber<List<User>>(mErrorHandler) {
                    @Override
                    public void onNext(List<User> users) {
                        Log.d("ss", new Gson().toJson(users));
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d("000", t.getMessage());
                        super.onError(t);
                    }
                });*/
        TestRequest testRequest = new TestRequest();
        testRequest.setPass("6666666");
        testRequest.setUser("343434");
        mModel.getTest(testRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(new ErrorHandleSubscriber<BaseResponse>(mErrorHandler) {
                    @Override
                    public void onNext(BaseResponse baseResponse) {
                        Log.d("base",new Gson().toJson(baseResponse));
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                    }
                });
    }
}
