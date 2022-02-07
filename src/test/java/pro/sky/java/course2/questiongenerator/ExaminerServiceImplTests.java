package pro.sky.java.course2.questiongenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.questiongenerator.data.Question;
import pro.sky.java.course2.questiongenerator.service.ExaminerServiceImpl;
import pro.sky.java.course2.questiongenerator.service.QuestionServiceImpl;

import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.when;
import static pro.sky.java.course2.questiongenerator.ConstantsForTests.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTests {


    @Mock
    private QuestionServiceImpl questionServiceImpl;

    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    public void setQuestions(){
        when(questionServiceImpl.getAll()).thenReturn(List.of(
                new Question(QUESTION_1, ANSWER_1),
                new Question(QUESTION_2, ANSWER_2),
                new Question(QUESTION_3, ANSWER_3)));
    }


    @Test
    public void willGetRandomQuestionsWork(){
       when(questionServiceImpl.getRandomQuestion()).thenReturn(
               new Question(QUESTION_1,ANSWER_1),
               new Question(QUESTION_2,ANSWER_2),
               new Question(QUESTION_3,ANSWER_3));
        Collection<Question> actual = out.getQuestions(3);
        Collection<Question> expected = List.of(
                new Question(QUESTION_1,ANSWER_1),
                new Question(QUESTION_2,ANSWER_2),
                new Question(QUESTION_3,ANSWER_3));
        Assertions.assertTrue(actual.equals(expected));
    }

    @Test
    public void willExceptionBeThrownToGetRandomQuestions() {
        Assertions.assertThrows(RuntimeException.class, () -> out.getQuestions(4));
    }
}
