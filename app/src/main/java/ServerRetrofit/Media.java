package ServerRetrofit;

import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Media {
    public void getMedia(String type,final AnswerMedias answerPosts) {
        serverRootes service = ServiceGenerator.getClient().create(serverRootes.class);
        Call<ArrayList<MediaList>> call = service.getMedia(type);
        call.enqueue(new Callback<ArrayList<MediaList>>() {
            @Override
            public void onResponse(Call<ArrayList<MediaList>> call, Response<ArrayList<MediaList>> response) {
                ArrayList<MediaList> res = response.body();
                answerPosts.AnswerBase(res);
            }
            @Override
            public void onFailure(Call<ArrayList<MediaList>> call, Throwable t) {
                answerPosts.SendError(t);
                Log.e("getPosts:", t.getMessage());
            }
        });
    }
}
