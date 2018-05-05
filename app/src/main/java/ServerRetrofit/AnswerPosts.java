package ServerRetrofit;

import java.util.ArrayList;

import StructPerson.StructPerson;

/**
 * Created by root on 5/6/17.
 */

public interface AnswerPosts  {

    void AnswerBase(ArrayList<StructPerson> answer);
    void SendError(Throwable t);
}
