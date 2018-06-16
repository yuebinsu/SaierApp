package com.outsource.saier.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.outsource.saier.di.module.UserModule;
import com.outsource.saier.mvp.ui.SplashActivity;

import dagger.Component;

/**
 * Created by：Administrator on 2018/6/10 0010 23:26
 * 619389279@qq.com
 */
@ActivityScope
@Component(modules = UserModule.class, dependencies = AppComponent.class)
public interface UserComponent {
    void inject(SplashActivity activity);
}
