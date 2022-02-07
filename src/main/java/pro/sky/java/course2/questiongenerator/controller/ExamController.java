package pro.sky.java.course2.questiongenerator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.questiongenerator.data.Question;
import pro.sky.java.course2.questiongenerator.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java/question")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;

    }

    @GetMapping("/get")
    Collection<Question> getQuestions ( @RequestParam int amount){
        return examinerService.getQuestions(amount);
    }
}
