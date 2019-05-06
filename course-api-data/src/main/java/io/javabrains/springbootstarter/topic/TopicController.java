package io.javabrains.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/getAllTopics")
	public List<Topic>  getAllTopics()
	{
		return topicService.getAllTopics();
		
	}
	
	@RequestMapping("/getTopic/{id}")
	public Topic getTopic(@PathVariable String id)
	{
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addTopic")
	public String addTopic(@RequestBody Topic topic)
	{
		topicService.addTopic(topic);
		return "Topic added Successfully";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/updateTopic/{id}")
	public String updateTopic(@RequestBody Topic topic,@PathVariable String id)
	{
		topicService.updateTopic(id, topic);
		return "Topic updated Successfully";
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void delete(@PathVariable String id)
	{
		topicService.deleteTopic(id);
	}
	

}