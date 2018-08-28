package com.cg.springbootstarter.topic.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.springbootstarter.topic.bean.Topic;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

}
