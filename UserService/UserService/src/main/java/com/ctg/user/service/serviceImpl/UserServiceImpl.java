package com.ctg.user.service.serviceImpl;

import java.util.*;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ctg.user.service.entity.Event;
import com.ctg.user.service.entity.Rating;
import com.ctg.user.service.entity.User;
import com.ctg.user.service.exceptions.ResourceNotFoundException;
import com.ctg.user.service.external.EventService;
import com.ctg.user.service.repository.UserRepository;
import com.ctg.user.service.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EventService eventService;

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User With Given Id is Not Found On Server : " + userId));

		logger.info("Fetched user ID: {}", user.getUserId());
		String ratingServiceUrl = "http://RATINGSERVICE/ratings/user/" + user.getUserId();
		logger.info("Calling Rating Service URL: {}", ratingServiceUrl);

		Rating[] ratingOfUser = restTemplate.getForObject(ratingServiceUrl, Rating[].class);
		logger.info("Ratings received: {}", ratingOfUser);
		
		List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
		List<Rating> ratingList =ratings.stream().map(rating -> {
		//ResponseEntity<Event> forEntity	= restTemplate.getForEntity("http://EVENTSERVICE/event/" +rating.getEventId(), Event.class);
		Event event = eventService.getEvents(rating.getEventId());
		rating.setEvent(event);
		return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratingList);
		return user;
	}

}
