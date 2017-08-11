package project.baga.vk.com.vkclient.ui.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import project.baga.vk.com.vkclient.CurrentUser;

/**
 * Created by Bagdat Eshmuratov on 11.08.2017.
 * email: eshmuratovbagdat@gmail.com.
 */
@InjectViewState
public class MainPresenter extends MvpPresenter<MainView>{

    public void checkAuth(){
        if (!CurrentUser.isAuthorized())
            getViewState().startSignIn();
        else
            getViewState().signedIn();
    }
}
