package project.baga.vk.com.vkclient.ui.holder;

import android.view.View;
import android.widget.TextView;

import project.baga.vk.com.vkclient.R;
import project.baga.vk.com.vkclient.model.view.NewsFeedItemBodyViewModel;

/**
 * Created by Bagdat Eshmuratov on 05.09.2017.
 * email: eshmuratovbagdat@gmail.com.
 */

public class NewsItemBodyHolder extends BaseViewHolder<NewsFeedItemBodyViewModel> {

    public TextView tvText;


    public NewsItemBodyHolder(View itemView) {
        super(itemView);

        tvText = (TextView) itemView.findViewById(R.id.tv_text);
    }

    @Override
    public void bindViewHolder(NewsFeedItemBodyViewModel item) {
        tvText.setText(item.getText());
    }

    @Override
    public void unbindViewHolder() {
        tvText.setText(null);
    }
}
