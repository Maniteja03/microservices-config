package com.ctg.rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ctg.rating.entity.Rating;
import com.ctg.rating.service.RatingService;
import java.util.*;
@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;

	@PostMapping("create")
	public ResponseEntity<Rating> create(@RequestBody Rating rate){
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.create(rate));
	}
	
	@GetMapping("all")
	public ResponseEntity<List<Rating>> getRatings(){
		return ResponseEntity.ok(ratingService.getAllRating());
	}
	
	@GetMapping("user/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
		return ResponseEntity.ok(ratingService.getByUserId(userId));
	}
	
	@GetMapping("event/{eventId}")
	public ResponseEntity<List<Rating>> getRatingsByEventId(@PathVariable String eventId){
		return ResponseEntity.ok(ratingService.getAllByEventId(eventId));
	}
}
