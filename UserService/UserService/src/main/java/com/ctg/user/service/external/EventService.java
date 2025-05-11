package com.ctg.user.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.ctg.user.service.entity.Event;

@FeignClient(name= "EVENTSERVICE")
public interface EventService {
	
	@GetMapping("event/{eventId}")
	Event getEvents(@PathVariable String eventId);
	

}
