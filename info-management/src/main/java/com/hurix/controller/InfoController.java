package com.hurix.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hurix.model.Info;
import com.hurix.repo.InfoRepository;

@RestController
@RequestMapping("/info")
public class InfoController {

	private InfoRepository repo;
	private Environment env;
	
	public InfoController(InfoRepository repo, Environment env) {
		super();
		this.repo = repo;
		this.env = env;
	}

	@GetMapping("/{id}")
	public HttpEntity<Info> getOne(@PathVariable  Long id ){
		System.out.println("==========>> request served from "+env.getProperty("server.port"));
		Info info = repo.getOne(id);
		if(info == null) {
			return new ResponseEntity<Info>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Info>(info, HttpStatus.OK);
	}
	
	@GetMapping
	public HttpEntity<List<Info>> getAll(){
		System.out.println("==========>> request served from "+env.getProperty("server.port"));
		List<Info> info = repo.findAll();
		return new ResponseEntity<List<Info>>(info, HttpStatus.OK);
	}
	
}
