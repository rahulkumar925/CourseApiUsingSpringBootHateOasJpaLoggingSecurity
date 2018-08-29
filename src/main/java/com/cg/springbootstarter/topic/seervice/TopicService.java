package com.cg.springbootstarter.topic.seervice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springbootstarter.topic.bean.Topic;
import com.cg.springbootstarter.topic.repository.TopicRepository;

@Service
public class TopicService implements TopicServiceInterface {

@Autowired
private TopicRepository topicRepository;
	
/*private List<Topic> topics = new ArrayList<> (Arrays.asList(new Topic(1,"Core Java","Java in second"),
			
			new Topic(2,"Let us C","C descriptions"),
			
			new Topic(3,"Spring Framework","Spring Framework Description"),new Topic(4,"XML Framework","XML Framework Description"),
			new Topic(5,"JSON Framework","JSON Framework Description"),new Topic(6,"JEE Framework","JEE Framework Description"),
			new Topic(7,"Struts Framework","Struts Framework Description")));*/
	
	/* (non-Javadoc)
	 * @see com.cg.springbootstarter.topic.seervice.TopicServiceInterface#getAllTopics()
	 */
	
	/* (non-Javadoc)
	 * @see com.cg.springbootstarter.topic.seervice.TopicServiceInterface#getAllTopics()
	 */
	@Override
	public List<Topic> getAllTopics(){
		//return topics;
		
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	/* (non-Javadoc)
	 * @see com.cg.springbootstarter.topic.seervice.TopicServiceInterface#getTopic(int)
	 */
	
	/* (non-Javadoc)
	 * @see com.cg.springbootstarter.topic.seervice.TopicServiceInterface#getTopic(int)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see com.cg.springbootstarter.topic.seervice.TopicServiceInterface#addTopic(com.cg.springbootstarter.topic.bean.Topic)
	 */

	/* (non-Javadoc)
	 * @see com.cg.springbootstarter.topic.seervice.TopicServiceInterface#addTopic(com.cg.springbootstarter.topic.bean.Topic)
	 */
	@Override
	public void addTopic(Topic topic) {
		
		//topics.add(topic);
		
		topicRepository.save(topic);
		
	}

	/* (non-Javadoc)
	 * @see com.cg.springbootstarter.topic.seervice.TopicServiceInterface#updateTopic(int, com.cg.springbootstarter.topic.bean.Topic)
	 */
	
	/* (non-Javadoc)
	 * @see com.cg.springbootstarter.topic.seervice.TopicServiceInterface#updateTopic(int, com.cg.springbootstarter.topic.bean.Topic)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see com.cg.springbootstarter.topic.seervice.TopicServiceInterface#deleteTopic(int)
	 */
	
	/* (non-Javadoc)
	 * @see com.cg.springbootstarter.topic.seervice.TopicServiceInterface#deleteTopic(int)
	 */
	@Override
	public void deleteTopic(int id) {
		
		//topics.removeIf(topic -> topic.getId()==id); //for manual collection
		topicRepository.deleteById(id); //for curd jpa
	
	}
	
	
}
