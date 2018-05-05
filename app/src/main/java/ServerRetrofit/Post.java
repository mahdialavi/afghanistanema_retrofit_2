package ServerRetrofit;

import android.util.Log;

import java.util.ArrayList;

import StructPerson.StructPerson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Post {
    public void getPosts(final AnswerPosts answerPosts) {
        serverRootes service = ServiceGenerator.getClient().create(serverRootes.class);
        Call<ArrayList<StructPerson>> call = service.getPosts();
        call.enqueue(new Callback<ArrayList<StructPerson>>() {
            @Override
            public void onResponse(Call<ArrayList<StructPerson>> call, Response<ArrayList<StructPerson>> response) {
                ArrayList<StructPerson> res = response.body();
                answerPosts.AnswerBase(res);
            }
            @Override
            public void onFailure(Call<ArrayList<StructPerson>> call, Throwable t) {
                answerPosts.SendError(t);
                Log.e("getPosts:", t.getMessage());
            }
        });
    }
    public void getPost(String id ,final AnswerPost answerPost) {
        serverRootes service = ServiceGenerator.getClient().create(serverRootes.class);
        Call<PostModel> call = service.getPost(id);
        call.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                PostModel res = response.body();
                answerPost.AnswerBase(res);
            }
            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                answerPost.SendError(t);
                Log.e("getPost:", t.getMessage());
            }
        });
    }
    public void getPostCat(String cat ,final AnswerPosts answerPosts) {
        serverRootes service = ServiceGenerator.getClient().create(serverRootes.class);
        Call<ArrayList<StructPerson>> call = service.getPostsCat(cat);
        call.enqueue(new Callback<ArrayList<StructPerson>>() {
            @Override
            public void onResponse(Call<ArrayList<StructPerson>> call, Response<ArrayList<StructPerson>> response) {
                ArrayList<StructPerson> res = response.body();
                answerPosts.AnswerBase(res);
            }

            @Override
            public void onFailure(Call<ArrayList<StructPerson>> call, Throwable t) {
                answerPosts.SendError(t);
                Log.e("getPosts:", t.getMessage());
            }
        });
    }
    public void getPostsSearch(String text,final AnswerPosts answerPosts) {
        serverRootes service = ServiceGenerator.getClient().create(serverRootes.class);
        Call<ArrayList<StructPerson>> call = service.getPostsSearch(text);
        call.enqueue(new Callback<ArrayList<StructPerson>>() {
            @Override
            public void onResponse(Call<ArrayList<StructPerson>> call, Response<ArrayList<StructPerson>> response) {
                ArrayList<StructPerson> res = response.body();
                answerPosts.AnswerBase(res);
            }
            @Override
            public void onFailure(Call<ArrayList<StructPerson>> call, Throwable t) {
                answerPosts.SendError(t);
                Log.e("getPosts:", t.getMessage());
            }
        });
    }
}
