package pro.sky.java.course2.questiongenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.questiongenerator.data.Question;
import pro.sky.java.course2.questiongenerator.service.QuestionServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static pro.sky.java.course2.questiongenerator.ConstantsForTests.*;

public class QuestionServiceImplTest {

    ConstantsForTests constantsForTests;
    QuestionServiceImpl out = new QuestionServiceImpl();

    @Test
    public void addTest (){
        Question question1 = new Question(QUESTION_1, ANSWER_1);
        Assertions.assertEquals(question1,out.add(QUESTION_1,ANSWER_1));
        Question question2 = new Question(QUESTION_2, ANSWER_2);
        Assertions.assertEquals(question2,out.add(QUESTION_2,ANSWER_2));
        Question question3 = new Question(QUESTION_3, ANSWER_3);
        Assertions.assertEquals(question3,out.add(QUESTION_3,ANSWER_3));
    }

    @Test
    public void willExceptionBeThrownToAddMethod (){
        Question emptyQuestion = new Question(EMPTY_QUESTION, EMPTY_ANSWER);
        Assertions.assertThrows(RuntimeException.class, () -> out.add(EMPTY_QUESTION, EMPTY_ANSWER));
        List<Question> questions = new ArrayList<>();
        out.add(QUESTION_1, ANSWER_1);
        Assertions.assertThrows(RuntimeException.class, () -> out.add(QUESTION_1, ANSWER_1));
    }

    @Test
    public void removeTest(){
        Question question = new Question(QUESTION_1, ANSWER_1);
        out.add(QUESTION_1,ANSWER_1);
        Assertions.assertEquals(question,out.remove(question));
    }

    @Test
    public void willExceptionBeThrownToRemoveMethod (){
        Question question = new Question(QUESTION_1, ANSWER_1);
        out.add(QUESTION_2, ANSWER_2);
        Assertions.assertThrows(RuntimeException.class, () -> out.remove(question));
    }

    @Test
    public void getAllTest(){
        Question question1 = new Question(QUESTION_1, ANSWER_1);
        Question question2 = new Question(QUESTION_2, ANSWER_2);
        Question question3 = new Question(QUESTION_3, ANSWER_3);
        List<Question> questions = new ArrayList<>();

        questions.add(question1);
        questions.add(question2);
        questions.add(question3);

        out.add(question1);
        out.add(question2);
        out.add(question3);

        Assertions.assertEquals(questions,out.getAll());
    }





}
