package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course>  getAllCourse(@PathVariable String topicId)
	{
		return courseService.getAllCourses(topicId);
		
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id)
	{
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses")
	public String addCourse(@RequestBody Course course,@PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
		return "Course added Successfully";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses/{id}")
	public String updateTopic(@RequestBody Course course,@PathVariable String topicId,@PathVariable String id)
	{
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(id, course);
		return "Course updated Successfully";
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/courses/{id}")
	public void delete(@PathVariable String id)
	{
		courseService.deleteCourse(id);
	}
	

}
