package com.cg.springbootstarter.topic.seervice;

import java.util.List;

import com.cg.springbootstarter.topic.bean.Topic;

public interface TopicServiceInterface {

	List<Topic> getAllTopics();

	Topic getTopic(int id);

	void addTopic(Topic topic);

	void updateTopic(int id, Topic topic);

	void deleteTopic(int id);

}