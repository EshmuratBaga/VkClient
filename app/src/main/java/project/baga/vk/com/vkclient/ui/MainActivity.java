package project.baga.vk.com.vkclient.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;
import com.vk.sdk.util.VKUtil;

import java.util.Arrays;

import project.baga.vk.com.vkclient.CurrentUser;
import project.baga.vk.com.vkclient.R;
import project.baga.vk.com.vkclient.consts.ApiConstance;
import project.baga.vk.com.vkclient.ui.main.MainPresenter;
import project.baga.vk.com.vkclient.ui.main.MainView;

public class MainActivity extends MvpAppCompatActivity implements MainView{

    @InjectPresenter
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter.checkAuth();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
                    @Override
                    public void onResult(VKAccessToken res) {
                        presenter.checkAuth();
                    }

                    @Override
                    public void onError(VKError error) {
                        // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
                    }
                }
        )) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override public void startSignIn() {
        VKSdk.login(this, ApiConstance.DEFAULT_LOGIN_SCOPE);
    }

    @Override public void signedIn() {
        Toast.makeText(this, CurrentUser.getId(), Toast.LENGTH_SHORT).show();
    }
}
