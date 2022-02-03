package pro.sky.java.course2.questiongenerator.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.questiongenerator.data.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class QuestionServiceImpl implements QuestionService{

    List<Question> questions = new ArrayList<>();

    @Override
    public Question add(String question, String answer) {
        return null;
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        Random randomNumber = new Random();
        randomNumber.nextInt(10);

        return null;
    }
}
