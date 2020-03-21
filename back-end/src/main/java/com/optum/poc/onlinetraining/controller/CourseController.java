package com.optum.poc.onlinetraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.optum.poc.onlinetraining.entities.Course;
import com.optum.poc.onlinetraining.entities.User;
import com.optum.poc.onlinetraining.entities.UserCourse;
import com.optum.poc.onlinetraining.services.CourseService;
import com.optum.poc.onlinetraining.services.UserService;

@RestController
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	

	@Autowired
	private UserService userService;

	@CrossOrigin
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public List<Course> getUserCourses() {
	     return courseService.findAllCourses();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/enroll", method = RequestMethod.POST)
	public Course enrollUser(@RequestBody UserCourse userCourse) {
	     return courseService.saveUserCourse(userCourse);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
	public User getUser(@PathVariable Long userId) {
		return userService.find(userId);
	}

}
