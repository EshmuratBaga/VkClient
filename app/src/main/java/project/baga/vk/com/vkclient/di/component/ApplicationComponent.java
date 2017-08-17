package project.baga.vk.com.vkclient.di.component;

import javax.inject.Singleton;

import dagger.Component;
import project.baga.vk.com.vkclient.di.module.ApplicationModule;
import project.baga.vk.com.vkclient.di.module.ManagerModule;
import project.baga.vk.com.vkclient.di.module.RestModule;
import project.baga.vk.com.vkclient.ui.BaseActivity;
import project.baga.vk.com.vkclient.ui.main.MainActivity;
import project.baga.vk.com.vkclient.ui.news.NewsFeedFragment;

/**
 * Created by Bagdat Eshmuratov on 17.08.2017.
 * email: eshmuratovbagdat@gmail.com.
 */

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {

    void inject(BaseActivity __);
    void inject(MainActivity __);

    void inject(NewsFeedFragment __);
}
