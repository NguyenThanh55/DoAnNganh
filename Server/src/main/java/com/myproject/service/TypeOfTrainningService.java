/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.myproject.service;

import com.myproject.pojo.Typeoftrainning;
import java.util.List;

/**
 *
 * @author Thanh
 */
public interface TypeOfTrainningService {
    List<Typeoftrainning> getTypeOfTrainning();
    Typeoftrainning getTOTNById(int id);
    boolean addOrUpdateTOTN(Typeoftrainning t);
    boolean deleteTOTN(int id);
}
