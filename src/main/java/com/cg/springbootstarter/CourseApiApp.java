package com.cg.springbootstarter;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cg.springbootstarter.topic.Topic;
import com.cg.springbootstarter.topic.TopicService;

@SpringBootApplication
public class CourseApiApp {

	public static void main(String[] args) {
	
	SpringApplication.run(CourseApiApp.class, args);

	}
	
	@Bean
	public CommandLineRunner loadInitialData(TopicService service) {
		return (args) -> {
			service.addTopic(new Topic(1,"Core Java","Java in second"));
			service.addTopic(new Topic(2,"Let us C","C descriptions"));
			service.addTopic(new Topic(3,"Spring Framework","Spring Framework Description"));
			service.addTopic(new Topic(4,"XML Framework","XML Framework Description"));
			service.addTopic(new Topic(5,"JSON Framework","JSON Framework Description"));
			service.addTopic(new Topic(6,"JEE Framework","JEE Framework Description"));
			service.addTopic(new Topic(7,"Struts Framework","Struts Framework Description"));
			System.out.println("Sample data populated to database");
		};
	}

}
