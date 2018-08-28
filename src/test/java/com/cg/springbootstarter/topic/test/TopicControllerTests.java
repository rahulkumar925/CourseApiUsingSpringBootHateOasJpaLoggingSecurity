package com.cg.springbootstarter.topic.test;

import static org.assertj.core.api.Assertions.assertThat;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;




@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class TopicControllerTests {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void testGetEmployeeById() throws Exception{
		
		//arrange
		
		//act
		ResponseEntity<Resource> responseEntity =  testRestTemplate.getForEntity("/topics/1", Resource.class);
		
		//assert
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
