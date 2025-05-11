package com.ctg.user.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.ctg.user.service.entity.User;
import com.ctg.user.service.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User u = userService.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(u);
	}
	int retryCount =1;
	@GetMapping("/{userId}")
	//@CircuitBreaker(name="ratingEventBreaker",fallbackMethod = "ratingEventFallback")
	//@Retry(name="ratingEventService",fallbackMethod = "ratingEventFallback")
	@RateLimiter(name="userRateLimiter",fallbackMethod = "ratingEventFallback")
	public ResponseEntity<User> getSingleUserId(@PathVariable String userId){
		LOGGER.info("Retry count: {}",retryCount);
        retryCount++;
		User u = userService.getUser(userId);
		return ResponseEntity.ok(u);
		
	}
	
	
	 public ResponseEntity<User> ratingEventFallback(String userId, Throwable throwable) {
	        LOGGER.error("Fallback triggered for userId: {} due to: {}", userId, throwable.getMessage());
	        
	        User dummyUser = User.builder()
	                .userId("0000")
	                .name("Dummy User")
	                .email("dummy@example.com")
	                .contactNumber("999999999999")
	                .build();

	        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(dummyUser);
	    }
	
	@GetMapping("all")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> u = userService.getAllUser();
		return ResponseEntity.ok(u);
	}

}
