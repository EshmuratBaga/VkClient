package project.baga.vk.com.vkclient.rest.model.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bagdat Eshmuratov on 17.08.2017.
 * email: eshmuratovbagdat@gmail.com.
 */

public class BaseItemResponse<T> {

    public Integer count;
    public List<T> items = new ArrayList<>();

    public Integer getCount() {
        return count;
    }

    public List<T> getItems() {
        return items;
    }
}
