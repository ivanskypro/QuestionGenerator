package pro.sky.java.course2.questiongenerator.service;

import pro.sky.java.course2.questiongenerator.data.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
