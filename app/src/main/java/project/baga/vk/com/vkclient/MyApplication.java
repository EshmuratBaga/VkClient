package project.baga.vk.com.vkclient;

import android.app.Application;

import com.vk.sdk.VKSdk;

/**
 * Created by Bagdat Eshmuratov on 11.08.2017.
 * email: eshmuratovbagdat@gmail.com.
 */

public class MyApplication extends Application{

    @Override public void onCreate() {
        super.onCreate();

        VKSdk.initialize(this);

    }
}
