
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.service.impl;

import com.myproject.pojo.Comment;
import com.myproject.repository.CommentRepository;
import com.myproject.service.CommentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thanh
 */
@Service
public class CommentServiceImpl implements CommentService{
    
    @Autowired
    private CommentRepository commentRepo;
    
    @Override
    public List<Object> getComments() {
        return this.commentRepo.getComments();
    }

    @Override
    public List<Object> getCommentByPost(int postId) {
        return this.commentRepo.getCommentByPost(postId);
    }

    @Override
    public Comment addOrUpdateComment(Comment comment) {
        return this.commentRepo.addOrUpdateComment(comment);
    }

    @Override
    public List<Object> getCommentByReply(int reply) {
        return this.commentRepo.getCommentByReply(reply);
    }

    @Override
    public boolean deleteComment(int id) {
        return this.commentRepo.deleteComment(id);
    }

    @Override
    public Comment getCommentById(int cmtId) {
        return this.commentRepo.getCommentById(cmtId);
    }

    @Override
    public List<Comment> getComments(Map<String, String> params) {
        return this.commentRepo.getComments(params);
    }

    @Override
    public long countComment() {
        return this.commentRepo.countComment();
    }
    
}
