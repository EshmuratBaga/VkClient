package project.baga.vk.com.vkclient.rest.api;

import java.util.Map;

import project.baga.vk.com.vkclient.rest.model.response.BaseItemResponse;
import project.baga.vk.com.vkclient.rest.model.response.Full;
import project.baga.vk.com.vkclient.rest.model.response.WallGetResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Bagdat Eshmuratov on 17.08.2017.
 * email: eshmuratovbagdat@gmail.com.
 */

public interface WallApi {
    @GET(ApiMethods.WALL_GET)
    Call<WallGetResponse> get(@QueryMap Map<String, String> map);
}
