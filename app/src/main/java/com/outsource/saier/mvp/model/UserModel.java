/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.outsource.saier.mvp.model;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Environment;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.outsource.saier.mvp.contract.UserContract;
import com.outsource.saier.mvp.model.api.entity.BaseResponse;
import com.outsource.saier.mvp.model.api.entity.TestRequest;
import com.outsource.saier.mvp.model.api.entity.User;
import com.outsource.saier.mvp.model.api.service.UserService;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import timber.log.Timber;

/**
 * ================================================
 * 展示 Model 的用法
 *
 * @see <a href="https://github.com/JessYanCoding/MVPArms/wiki#2.4.3">Model wiki 官方文档</a>
 * Created by JessYan on 09/04/2016 10:56
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
@ActivityScope
public class UserModel extends BaseModel implements UserContract.Model {
    public static final int USERS_PER_PAGE = 10;

    @Inject
    public UserModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<List<User>> getUsers(int lastIdQueried, boolean update) {
        //使用rxcache缓存,上拉刷新则不读取缓存,加载更多读取缓存
        return Observable.just(mRepositoryManager
                .obtainRetrofitService(UserService.class)
                .getUsers(lastIdQueried, USERS_PER_PAGE))
                .flatMap(new Function<Observable<List<User>>, ObservableSource<List<User>>>() {
                    @Override
                    public ObservableSource<List<User>> apply(@NonNull Observable<List<User>> listObservable) throws Exception {
                        return listObservable;
                    }
                });
    }

    @Override
    public Observable<BaseResponse> getTest(TestRequest request) {
  /*      return Observable.just(mRepositoryManager.obtainRetrofitService(UserService.class)
                .getTest(request))
                .flatMap(new Function<Observable<BaseResponse>, ObservableSource<BaseResponse>>() {
                    @Override
                    public ObservableSource<BaseResponse> apply(Observable<BaseResponse> baseResponseObservable) throws Exception {
                        return baseResponseObservable;
                    }
                });*/
        RequestBody time = RequestBody.create(MediaType.parse("text/plain"), "22");
        RequestBody address = RequestBody.create(MediaType.parse("text/plain"), "asdasdasdasda");
        RequestBody type = RequestBody.create(MediaType.parse("text/plain"), "类型");
        File imgFile = new File(Environment.getExternalStorageDirectory() + File.separator + "Download/aaa.png");
        Map<String, RequestBody> map = new HashMap<>();
        map.put("phone", time);
        map.put("userId", address);
        map.put("mac", address);
        map.put("token", type);
        RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), imgFile);
        map.put("file\"; filename=\"" + imgFile.getName() + "", fileBody);
        return Observable.just(mRepositoryManager.obtainRetrofitService(UserService.class)
                .getFileTest(map))
                .flatMap(new Function<Observable<BaseResponse>, ObservableSource<BaseResponse>>() {
                    @Override
                    public ObservableSource<BaseResponse> apply(Observable<BaseResponse> objectObservable) throws Exception {
                        return objectObservable;
                    }
                });

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause() {
        Timber.d("Release Resource");
    }

}
