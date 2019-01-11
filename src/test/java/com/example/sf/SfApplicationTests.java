package com.example.sf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SfApplicationTests {

	@Autowired
	ODataApiService oDataApiService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testUserMeta(){
		System.out.println(oDataApiService.operation("User('1')"));
	}

}

