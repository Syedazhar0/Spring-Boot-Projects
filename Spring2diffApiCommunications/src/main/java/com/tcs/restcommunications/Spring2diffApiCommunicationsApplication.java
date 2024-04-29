package com.tcs.restcommunications;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
@SpringBootApplication
public class Spring2diffApiCommunicationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring2diffApiCommunicationsApplication.class, args);
	}
	
	
	
	
	@Component
	 class MyClass implements CommandLineRunner{
    Logger logger =org.slf4j.LoggerFactory.getLogger(MyClass.class);
		@Override
		//loggers are used to track the information of every operations ex: when application started where the error occured when application crashed
		public void run(String... args) throws Exception {
			logger.trace("this is a trace message logger");
			logger.debug("this is a dbug message logger");
			logger.info("this is a info message logger");
			logger.warn("this is a warn message logger");
			logger.error("this is a error message logger");
			
		}
		
	}

}

