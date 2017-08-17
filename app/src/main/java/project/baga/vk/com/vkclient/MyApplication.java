package project.baga.vk.com.vkclient;

import android.app.Application;

import com.vk.sdk.VKSdk;

import project.baga.vk.com.vkclient.di.component.ApplicationComponent;
import project.baga.vk.com.vkclient.di.component.DaggerApplicationComponent;
import project.baga.vk.com.vkclient.di.module.ApplicationModule;

/**
 * Created by Bagdat Eshmuratov on 11.08.2017.
 * email: eshmuratovbagdat@gmail.com.
 */

public class MyApplication extends Application{

    private static ApplicationComponent component;

    @Override public void onCreate() {
        super.onCreate();
        initComponent();
        VKSdk.initialize(this);

    }

    private void initComponent(){
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getApplicationComponent(){
        return component;
    }
}
