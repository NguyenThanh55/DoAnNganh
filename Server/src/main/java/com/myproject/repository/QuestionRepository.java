/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.myproject.repository;

import com.myproject.pojo.Question;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Thanh
 */
public interface QuestionRepository {
    Question addOrUpdateQuestion(Question q);
    List<Object> getListQuestionsByLive(int liveId);
    List<Object> getQuestionByAnswer(int answer);
    boolean deleteQuestion(int id);
    Question getQuestionById(int questionId);
    List<Object> getListQuestionsForQuestion(Map<String, String> params);
//    List<Object> getListQuestionsForQuestionAndAnswer();
    Long countQuetionsNotLive();
    List<Question> getQuestions(Map<String, String> params);
    List<Object> getQuestionForLive(Map<String, String> params);
}
