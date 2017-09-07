package project.baga.vk.com.vkclient.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import project.baga.vk.com.vkclient.model.view.BaseViewModel;

/**
 * Created by Bagdat Eshmuratov on 05.09.2017.
 * email: eshmuratovbagdat@gmail.com.
 */

public abstract class BaseViewHolder<Item extends BaseViewModel> extends RecyclerView.ViewHolder{

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindViewHolder(Item item);

    public abstract void unbindViewHolder();
}
