package com.cg.springbootstarter.topic.repository;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.repository.CrudRepository;

import com.cg.springbootstarter.topic.bean.Topic;

//public interface TopicRepository extends CrudRepository<Topic, Integer>
public interface TopicRepository extends MongoRepository<Topic,Integer>{

	Optional<Topic> findById(int id);

	
	
}
