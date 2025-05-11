package com.ctg.event.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctg.event.entity.Event;
import com.ctg.event.exception.ResourceNotFoundException;
import com.ctg.event.repository.EventRepository;
import com.ctg.event.service.EventService;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventRepository eventRepository;

	@Override
	public Event create(Event event) {
		// TODO Auto-generated method stub
		
		String eventId = UUID.randomUUID().toString();
		event.setEventId(eventId);
		return eventRepository.save(event);
	}

	@Override
	public List<Event> getAll() {
		// TODO Auto-generated method stub
		return eventRepository.findAll();
	}

	@Override
	public Event get(String id) {
		// TODO Auto-generated method stub
		return eventRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Event with Given Id was not found : "+id));
	}

}
