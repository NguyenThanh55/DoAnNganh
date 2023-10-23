/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.myproject.service;

import com.myproject.pojo.Comment;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Thanh
 */
public interface CommentService {
    List<Comment> getComments(Map<String, String> params);
    List<Object> getComments();
    List<Object> getCommentByPost(int postId);
    Comment addOrUpdateComment(Comment comment);
    List<Object> getCommentByReply(int reply);
    boolean deleteComment(int id);
    Comment getCommentById(int cmtId);
    long countComment();
}
