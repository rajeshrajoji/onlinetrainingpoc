package com.optum.poc.onlinetraining.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optum.poc.onlinetraining.dao.CourseRepository;
import com.optum.poc.onlinetraining.dao.UserRepository;
import com.optum.poc.onlinetraining.entities.Course;
import com.optum.poc.onlinetraining.entities.User;
/** 
 * @author kamal berriga
 *
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Transactional
	public User save(User user) {
		
	   System.out.println("**"+user.getCourses().size());
	   userRepository.saveAndFlush(user);
	   if(!user.getCourses().isEmpty()) {
		    Course c = new Course();
		
		   // c.setId(user.getCourses().iterator().next().getId());
		    Course cc = courseRepo.findOne((user.getCourses().iterator().next().getId()));
		    c.setName(cc.getName());
		    c.setId(cc.getId());
		    c.setUser(user);
	 		courseService.saveCourse(c);
	   }
	   return user;
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public User find(String userName) {
		return userRepository.findOneByUsername(userName);
	}

	public User find(Long id) {
		return userRepository.findOne(id);
	}
}
