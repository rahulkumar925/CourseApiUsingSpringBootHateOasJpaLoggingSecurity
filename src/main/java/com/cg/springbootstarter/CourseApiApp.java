package com.cg.springbootstarter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cg.springbootstarter.topic.bean.Topic;
import com.cg.springbootstarter.topic.seervice.TopicServiceInterface;


@SpringBootApplication
public class CourseApiApp {
   
	
	//Creating reference of Logger.
   private static Logger logger = LogManager.getLogger(CourseApiApp.class);
	
	public static void main(String[] args) {
	
	SpringApplication.run(CourseApiApp.class, args);

	}
	
	@Bean
	public CommandLineRunner loadInitialData(TopicServiceInterface service) {
		
		//Using logger
		logger.debug("This is debug message");
		logger.info("This is info message");
		logger.warn("This is warn message");
		logger.error("This is error message");
		logger.fatal("This is fatal message");
		
		return (args) -> {
			service.addTopic(new Topic("Core Java","Java in second"));
			service.addTopic(new Topic("Let us C","C descriptions"));
			service.addTopic(new Topic("Spring Framework","Spring Framework Description"));
			service.addTopic(new Topic("XML Framework","XML Framework Description"));
			service.addTopic(new Topic("JSON Framework","JSON Framework Description"));
			service.addTopic(new Topic("JEE Framework","JEE Framework Description"));
			service.addTopic(new Topic("Struts Framework","Struts Framework Description"));
			System.out.println("Sample data populated to database");
		};
	}

}
