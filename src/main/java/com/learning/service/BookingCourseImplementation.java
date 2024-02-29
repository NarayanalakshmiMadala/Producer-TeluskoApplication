package com.learning.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.dao.ICoursesRepo;
import com.learning.entity.Courses;
import com.learning.exception.CourseNotFoundException;

@Service
public class BookingCourseImplementation implements IBookingCourse
{

	@Autowired
	ICoursesRepo repo;
	@Override
	public String saveCourseDetails(Courses course){
		Courses result= repo.save(course);
		return "Course Details Added Successfully with Id : "+result.getId();
	}

	@Override
	public Courses getCourseInfoById(Integer id) {
		Courses course=repo.findById(id).orElseThrow(()->new CourseNotFoundException("Course Not Found With Given Id :"+id));
		return course;
	}

	@Override
	public List<Courses> fetchAll() {
		return repo.findAll();
	}

	@Override
	public String deleteCourseById(Integer id) {
		Courses course=repo.findById(id).orElse(null);
		if(course!=null)
		{
			repo.deleteById(id);
			return "Course with Id -> "+id+" Deleted Successfully"; 
		}
		else
		{
			throw new CourseNotFoundException("There is no Specific Course with ID "+id+" to Delete");
		}
	}

	@Override
	public String updateCourseById(Integer id, Courses course) {
		Courses courseFound=repo.findById(id).orElseThrow(()->new CourseNotFoundException("Course Not Found With Id : "+id+" to Update"));
		if(course!=null)
		{
			courseFound.setName(course.getName());
			courseFound.setDetails(course.getDetails());
			courseFound.setDuration(course.getDuration());
			courseFound.setPrice(course.getPrice());
			repo.save(courseFound);
			
			return "Course Details Updated Successfully";		
		}
		else
			throw new CourseNotFoundException("There is No Course Available with Id :"+id+" to Update");
	}

}
