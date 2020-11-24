package com.videosharing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class VideoSharingGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoSharingGatewayServiceApplication.class, args);
	}

}
