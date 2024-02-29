package com.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.Courses;

public interface ICoursesRepo extends JpaRepository<Courses, Integer>{

}
