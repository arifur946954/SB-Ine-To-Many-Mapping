package com.jpa.JpaCrud.dao;

import com.jpa.JpaCrud.entity.Instructor;
import com.jpa.JpaCrud.entity.InstructorDetails;

public interface AppDao {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
    InstructorDetails findInstructoDetailsById(int theId);
    void deleteInstructorDetails(int theId);
}
