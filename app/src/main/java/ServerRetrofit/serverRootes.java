package ServerRetrofit;

import java.util.ArrayList;

import StructPerson.StructPerson;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface serverRootes {
    @GET("index.php")
    Call<ArrayList<StructPerson>> getPosts();

    @FormUrlEncoded
    @POST("search.php")
    Call<ArrayList<StructPerson>> getPostsSearch(@Field("text") String text);

    @FormUrlEncoded
    @POST("getfulltxt.php")
    Call<PostModel> getPost(@Field("id") String id);

    @FormUrlEncoded
    @POST("cat.php")
    Call<ArrayList<StructPerson>> getPostsCat(@Field("cat") String cat);

    @FormUrlEncoded
    @POST("media.php")
    Call<ArrayList<MediaList>> getMedia(@Field("type") String type);
}
