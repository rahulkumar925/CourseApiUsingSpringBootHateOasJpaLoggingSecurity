package com.cg.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

@Autowired
private TopicRepository topicRepository;
	
/*private List<Topic> topics = new ArrayList<> (Arrays.asList(new Topic(1,"Core Java","Java in second"),
			
			new Topic(2,"Let us C","C descriptions"),
			
			new Topic(3,"Spring Framework","Spring Framework Description"),new Topic(4,"XML Framework","XML Framework Description"),
			new Topic(5,"JSON Framework","JSON Framework Description"),new Topic(6,"JEE Framework","JEE Framework Description"),
			new Topic(7,"Struts Framework","Struts Framework Description")));*/
	
	public List<Topic> getAllTopics(){
		//return topics;
		
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(int id) {
		/*for(Topic topic : topics) {
			if(topic.getId().equals(id)) {
				return topic;
			}
		}
		return null;*/
		
		//return topics.stream().filter(topic -> topic.getId()==id).findFirst().get();
		return topicRepository.findById(id).get();
	}

	public void addTopic(Topic topic) {
		
		//topics.add(topic);
		
		topicRepository.save(topic);
		
	}

	public void updateTopic(int id, Topic topic) {
		
		/*for(int i=0; i<topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId()==id) {
				topics.set(i, topic);
				return;
			}
		}*/
		
		topicRepository.save(topic);
	}

	public void deleteTopic(int id) {
		
		//topics.removeIf(topic -> topic.getId()==id);
		topicRepository.deleteById(id);
		
	}
	
	
}
