/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.formatter;

import com.myproject.pojo.Post;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Thanh
 */
public class PostFormatter implements Formatter<Post>{

    @Override
    public String print(Post object, Locale locale) {
        return String.valueOf(object);
    }

    @Override
    public Post parse(String text, Locale locale) throws ParseException {
        return new Post(Integer.parseInt(text));
    }
    
    
}
