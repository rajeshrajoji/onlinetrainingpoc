package com.optum.poc.onlinetraining;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.optum.poc.onlinetraining.dao.CourseRepository;
import com.optum.poc.onlinetraining.dao.UserRepository;
import com.optum.poc.onlinetraining.entities.Course;
import com.optum.poc.onlinetraining.entities.User;
/**
 * 
 * @author kamal berriga
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner{
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	CourseRepository courseRepo;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		User user = new User();
		user.setUsername("rajesh");
		user.setPassword("rajesh");	
		user.setRole("USER");
		repo.save(user);
		
		Course course = new Course();
		course.setId(new Long(1));
		course.setName("Java");
		
		Course course2 = new Course();
		course2.setId(new Long(2));
		course2.setName("Angular");
		
		List<Course> list = new ArrayList<>();
		list.add(course2);
		list.add(course);
		
		courseRepo.save(list);
	}
}
