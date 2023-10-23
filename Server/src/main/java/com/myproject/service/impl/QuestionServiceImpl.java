/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.service.impl;

import com.myproject.pojo.Question;
import com.myproject.repository.QuestionRepository;
import com.myproject.service.QuestionService;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thanh
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepo;

    @Override
    public Question addOrUpdateQuestion(Question q) {
        return this.questionRepo.addOrUpdateQuestion(q);
    }

    @Override
    public List<Object> getListQuestionsByLive(int liveId) {
        return this.questionRepo.getListQuestionsByLive(liveId);
    }

    @Override
    public List<Object> getQuestionByAnswer(int answer) {
        return this.questionRepo.getQuestionByAnswer(answer);
    }

    @Override
    public boolean deleteQuestion(int id) {
        return this.questionRepo.deleteQuestion(id);
    }

    @Override
    public Question getQuestionById(int id) {
        return this.questionRepo.getQuestionById(id);
    }

    @Override
    public List<Object> getListQuestionsForQuestion(Map<String, String> params) {
        return this.questionRepo.getListQuestionsForQuestion(params);
    }

    @Override
    public LocalDate getDate() {
        Question q = new Question();
        return q.getDate();
    }

    @Override
    public void setDate(String d) {
        Question q = new Question();
        LocalDate localDate = LocalDate.parse(d);
        q.setDate(localDate);
    }
    

    @Override
    public Long countQuetionsNotLive() {
        return this.questionRepo.countQuetionsNotLive();
    }

    @Override
    public List<Question> getQuestions(Map<String, String> params) {
        return this.questionRepo.getQuestions(params);
    }

    @Override
    public List<Object> getQuestionForLive(Map<String, String> params) {
        return this.questionRepo.getQuestionForLive(params);
    }


}
