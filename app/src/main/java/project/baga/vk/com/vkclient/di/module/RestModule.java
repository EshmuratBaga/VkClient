package project.baga.vk.com.vkclient.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import project.baga.vk.com.vkclient.rest.RestClient;
import project.baga.vk.com.vkclient.rest.api.WallApi;

/**
 * Created by Bagdat Eshmuratov on 17.08.2017.
 * email: eshmuratovbagdat@gmail.com.
 */
@Module
public class RestModule {
    private RestClient mRestClient;


    public RestModule() {
        mRestClient = new RestClient();
    }


    @Provides
    @Singleton
    public RestClient provideRestClient() {
        return mRestClient;
    }

    @Singleton
    @Provides
    public WallApi provideWallApi(){
        return mRestClient.createService(WallApi.class);
    }
}
