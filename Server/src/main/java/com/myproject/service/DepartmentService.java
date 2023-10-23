/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.myproject.service;

import com.myproject.pojo.Department;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Thanh
 */
public interface DepartmentService {
    List<Object> getDepartment();
    Object getDepartmentById(int id);
    Department getDepartmentById_admin(int id);
    List<Department> getDepartments(Map<String, String> params);
    int countDepartments();
    boolean addOrUpdateDepartment(Department d);
    boolean deleteDepartment(int id);
}
