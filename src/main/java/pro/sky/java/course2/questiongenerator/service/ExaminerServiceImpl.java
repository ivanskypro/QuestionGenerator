package pro.sky.java.course2.questiongenerator.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.questiongenerator.data.Question;
import pro.sky.java.course2.questiongenerator.exceptions.BadRequestException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class ExaminerServiceImpl implements ExaminerService {


    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> randomQuestions = new ArrayList<>();
        int listSize = questionService.getAll().size();
        if (amount > listSize) {
            throw new BadRequestException();
        }
        for (int i = 0; i < amount; i++) {
            randomQuestions.add(questionService.getRandomQuestion());
        }
        return randomQuestions;
    }
}
