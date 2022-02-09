package pro.sky.java.course2.questiongenerator.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.questiongenerator.data.Question;
import pro.sky.java.course2.questiongenerator.exceptions.BadRequestException;
import pro.sky.java.course2.questiongenerator.exceptions.QuestionAlreadyExistException;
import pro.sky.java.course2.questiongenerator.exceptions.QuestionNotExistException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;


@Service
public class QuestionServiceImpl implements QuestionService{
    List<Question> questions = new ArrayList<>();

    @Override
    public Question add(String question, String answer) {
        if (invalidInput(question,answer))
            throw new BadRequestException();
        Question newQuestion = new Question(question, answer);
        if (questions.contains(newQuestion)) {
            throw new QuestionAlreadyExistException();
        }
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)){
            throw new QuestionNotExistException();
        }
            questions.remove(question);
            return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int randomValue = questions.size();
        int index = random.nextInt(randomValue);
        Question randomQuestion = questions.get(index);
        return randomQuestion;
    }

    private boolean invalidInput(String question, String answer) {
        return StringUtils.isEmpty(question) || StringUtils.isEmpty(answer);
    }

}
