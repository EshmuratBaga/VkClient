package project.baga.vk.com.vkclient.model.view;

import android.view.View;

import project.baga.vk.com.vkclient.model.WallItem;
import project.baga.vk.com.vkclient.ui.holder.BaseViewHolder;
import project.baga.vk.com.vkclient.ui.holder.NewsItemBodyHolder;

/**
 * Created by Bagdat Eshmuratov on 05.09.2017.
 * email: eshmuratovbagdat@gmail.com.
 */

public class NewsFeedItemBodyViewModel extends BaseViewModel{
    private int mId;

    private String mText;

    public NewsFeedItemBodyViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mText = wallItem.getText();
    }


    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemBody;
    }

    @Override
    public NewsItemBodyHolder onCreateViewHolder(View view) {
        return new NewsItemBodyHolder(view);
    }


    public String getText() {
        return mText;
    }

    public int getId() {
        return mId;
    }
}
