package pro.sky.java.course2.questiongenerator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.questiongenerator.data.Question;
import pro.sky.java.course2.questiongenerator.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class Controller {

    private final QuestionService questionService;

    public Controller(QuestionService questionService) {
        this.questionService = questionService;
    }


    String addQuestion(@RequestParam String question, @RequestParam String answer) {
        return null;
    }

    Collection<Question> getQuestions(){
        return null;
    }

}
