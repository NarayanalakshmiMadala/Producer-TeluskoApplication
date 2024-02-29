package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Courses;
import com.learning.service.IBookingCourse;

@RestController
@RequestMapping("/courses")
public class CoursesController 
{
	@Autowired
	IBookingCourse service;
	
	@PostMapping("/addCourse")
	public ResponseEntity<String> addingNewCourse(@RequestBody Courses course)
	{
		String msg=service.saveCourseDetails(course);
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	 
	@GetMapping("/fetchCourses")
	public ResponseEntity<List<Courses>> displayCourses()
	{
		List<Courses> list=service.fetchAll();
		return new ResponseEntity<List<Courses>>(list,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/fetchCourse/{id}")
	public ResponseEntity<Courses> fetchCourseById(@PathVariable("id")Integer id)
	{
		Courses course=service.getCourseInfoById(id);
		return new ResponseEntity<Courses>(course,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCourse/{id}")
	public ResponseEntity<String> deleteCourseById(@PathVariable("id")Integer id)
	{
		String msg=service.deleteCourseById(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/updateCourse/{id}")
	public ResponseEntity<String> updateCourseById(@PathVariable("id") Integer id,@RequestBody Courses course)
	{
		String msg=service.updateCourseById(id,course);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
}
