package pro.sky.java.course2.questiongenerator.controller;

import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping("/add")
    String addQuestion(@RequestParam String question, @RequestParam String answer) {
        questionService.add(question, answer);
        return "Вопрос: " + question + " Ответ: " + answer + ". успешно добавлены.";
    }


    @GetMapping("")
    Collection<Question> getQuestions(){
        return questionService.getAll();

    }
    @GetMapping("/remove")
    String removeQuestion(@RequestParam String question, @RequestParam String answer) {
        Question removingQuestion = new Question(question, answer);
        questionService.remove(removingQuestion);
        return "Вопрос " + removingQuestion + " успешно удалён!";
    }

}
