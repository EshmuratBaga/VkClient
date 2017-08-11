package project.baga.vk.com.vkclient.ui.main;

import com.arellomobile.mvp.MvpView;

/**
 * Created by Bagdat Eshmuratov on 11.08.2017.
 * email: eshmuratovbagdat@gmail.com.
 */

public interface MainView extends MvpView {
    void startSignIn();

    void signedIn();
}
