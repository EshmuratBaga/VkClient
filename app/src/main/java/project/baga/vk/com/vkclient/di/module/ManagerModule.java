package project.baga.vk.com.vkclient.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import project.baga.vk.com.vkclient.common.manager.MyFragmentManager;

/**
 * Created by Bagdat Eshmuratov on 17.08.2017.
 * email: eshmuratovbagdat@gmail.com.
 */

@Module
public class ManagerModule {

    @Singleton
    @Provides
    public MyFragmentManager provideMyFragmentManager(){
        return new MyFragmentManager();
    }


}
