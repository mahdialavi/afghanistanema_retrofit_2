package ServerRetrofit;

/**
 * Created by root on 5/6/17.
 */

public interface AnswerPost {

    void AnswerBase(PostModel answer);
    void SendError(Throwable t);
}
