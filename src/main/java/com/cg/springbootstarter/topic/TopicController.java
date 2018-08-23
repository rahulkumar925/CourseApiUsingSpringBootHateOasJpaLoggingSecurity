package com.cg.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics/{start}/{count}")
	public Resources getTopicByPage(@PathVariable("start") int start, @PathVariable("count") int count) {
		List<Topic> tempTopics = topicService.getAllTopics();
		List<Topic> topics = new ArrayList<Topic>();
		
		for (int i=start; i<start+count; i++) {
			topics.add(tempTopics.get(i-1));
		}
		
       Link nextLink = ControllerLinkBuilder.linkTo(methodOn(this.getClass()).getTopicByPage(start+count, count)).withRel("nextLink");

       Link previousLink = ControllerLinkBuilder.linkTo(methodOn(this.getClass()).getTopicByPage(start-count>=0?start-count:1, count)).withRel("previousLink");

       Resources resources = new Resources (topics, nextLink, previousLink);

       return resources;
	}
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Resource getTopic(@PathVariable("id")  int id) {
List<Topic> topics = topicService.getAllTopics();
		
		Link viewAll =linkTo(methodOn(this.getClass()).getTopicByPage(1, topics.size())).withRel("viewAll");
		
		Resource resource = new Resource(topicService.getTopic(id), viewAll);
		
		return resource;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable("id") int id) {
		topicService.updateTopic(id,topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/topics/{id}")
	public void deleteTopic(@PathVariable("id")  int id) {
		topicService.deleteTopic(id);
	}
}
