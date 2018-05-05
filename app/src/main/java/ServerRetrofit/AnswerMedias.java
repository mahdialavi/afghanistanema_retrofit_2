package ServerRetrofit;

import java.util.ArrayList;

/**
 * Created by root on 5/6/17.
 */

public interface AnswerMedias {

    void AnswerBase(ArrayList<MediaList> answer);
    void SendError(Throwable t);
}
