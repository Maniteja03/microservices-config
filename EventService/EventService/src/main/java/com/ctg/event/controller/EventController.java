package com.ctg.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ctg.event.entity.Event;
import com.ctg.event.service.EventService;


@RestController
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	
	@PostMapping("create")
	public ResponseEntity<Event> createEvent(@RequestBody Event event){
		return ResponseEntity.status(HttpStatus.CREATED).body(eventService.create(event));
	}
	
	
	@GetMapping("/{eventId}")
	public ResponseEntity<Event> getById(@PathVariable String eventId){
		return ResponseEntity.status(HttpStatus.OK).body(eventService.get(eventId));
	}
	
	@GetMapping("all")
	public ResponseEntity<List<Event>> getAllEvents(){
		return ResponseEntity.ok(eventService.getAll());
	}
	
	

}
