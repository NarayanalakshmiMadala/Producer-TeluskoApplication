package com.learning.service;

import java.util.List;

import com.learning.entity.Courses;

public interface IBookingCourse 
{
	public String saveCourseDetails(Courses course);
	public List<Courses> fetchAll();
	public Courses getCourseInfoById(Integer id);
	public String deleteCourseById(Integer id);
	public String updateCourseById(Integer id,Courses course);

}
