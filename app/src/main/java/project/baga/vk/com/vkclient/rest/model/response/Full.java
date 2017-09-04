package project.baga.vk.com.vkclient.rest.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bagdat Eshmuratov on 17.08.2017.
 * email: eshmuratovbagdat@gmail.com.
 */

public class Full<T> {

    @SerializedName("response")
    @Expose
    public T response;
}
