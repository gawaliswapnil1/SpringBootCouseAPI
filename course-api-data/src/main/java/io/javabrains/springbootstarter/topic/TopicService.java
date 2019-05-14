package io.javabrains.springbootstarter.topic;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	
	@Autowired
	private TopicRepository topicRepository;
	
	
	 private List<Topic> topics=new ArrayList<>(Arrays.asList( new Topic("string",
	  "Spring Framework","Spring framework descrption" ), new Topic("java",
	  "Core Java","Core Java descrption" ), new Topic("javascript",
	 "javascript","javascript descrption" ) ));
	 
	
	public List<Topic> getAllTopics()
	{
		List<Topic> topics=new ArrayList<Topic>();
		
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		return topicRepository.findOne(id);
		//return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic)
	{
		topicRepository.save(topic);
		//topics.add(topic);
	}
	
	public void updateTopic(String id,Topic topic)
	{
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicRepository.delete(id);
	}
}
