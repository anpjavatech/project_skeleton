package com.anpjavatech.project_skelton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Created by Anoop.ks on 11-12-2017
 */
@SpringBootApplication
public class ProjectSkeltonApplication {

	public static void main(String[] args) {

		Class[] configurations = {ProjectSkeltonApplication.class};
		SpringApplication.run(configurations, args);
	}
}
