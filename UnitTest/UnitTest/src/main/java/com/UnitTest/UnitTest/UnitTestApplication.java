package com.UnitTest.UnitTest;

import com.UnitTest.UnitTest.models.CollageStudent;
import com.UnitTest.UnitTest.tdd.FizzBuzz;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class UnitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestApplication.class, args);
	}

	@Bean(name="collegeStudent")
	@Scope(value="prototyoe")
	CollageStudent getCollegeStudent(){
		return new CollageStudent();
	}

	public int add(int a, int b){
		return a + b;
	}

	public String checkNull(String ss){
		return ss;
	}

	public String sameRefOrNot(){
		return new String("TEST");
	}


	public boolean isNegative(int a) throws Exception {
		if(a < 0)
			throw new Exception("Number can not be negative");

		return true;
	}

	public void isSleep() throws InterruptedException {
		System.out.println("I will go sleep just for 4 seconds");
		Thread.sleep(500);
		System.out.println("I have wake up :) ");
	}

}
