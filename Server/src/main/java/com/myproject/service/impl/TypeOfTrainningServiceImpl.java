/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.service.impl;

import com.myproject.pojo.Typeoftrainning;
import com.myproject.repository.TypeOfTrainningRepository;
import com.myproject.service.TypeOfTrainningService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thanh
 */
@Service
public class TypeOfTrainningServiceImpl implements TypeOfTrainningService{
    @Autowired
    private TypeOfTrainningRepository typeRepo;
    
    @Override
    public List<Typeoftrainning> getTypeOfTrainning() {
        return this.typeRepo.getTypeOfTrainning();
    }

    @Override
    public Typeoftrainning getTOTNById(int id) {
        return this.typeRepo.getTOTNById(id);
    }

    @Override
    public boolean addOrUpdateTOTN(Typeoftrainning t) {
        return this.typeRepo.addOrUpdateTOTN(t);
    }

    @Override
    public boolean deleteTOTN(int id) {
        return this.typeRepo.deleteTOTN(id);
    }
    
}
