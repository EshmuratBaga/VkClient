package project.baga.vk.com.vkclient.rest.api;

import project.baga.vk.com.vkclient.rest.model.response.BaseItemResponse;
import project.baga.vk.com.vkclient.rest.model.response.Full;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Bagdat Eshmuratov on 17.08.2017.
 * email: eshmuratovbagdat@gmail.com.
 */

public interface WallApi {
    @GET(ApiMethods.WALL_GET)
    Call<Full<BaseItemResponse>> get(@Query("owner_id") String ownerId,

                                     @Query("access_token") String accessToken,

                                     @Query("extended") Integer extended,

                                     @Query("v") String version);
}
