package com.hurix;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hurix.model.Info;
import com.hurix.repo.InfoRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.hurix.repo")
public class InfoManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoManagementApplication.class, args);
	}
	
	@Autowired
	private InfoRepository repo;
	
	@EventListener(classes = ApplicationReadyEvent.class)
	public void initData() {
		for(int i = 0; i < 10; i ++) {
			Info info = new Info( UUID.randomUUID().toString() , UUID.randomUUID()+"@yopmail.com", UUID.randomUUID().toString());
			repo.save(info);
		}
	}
}
