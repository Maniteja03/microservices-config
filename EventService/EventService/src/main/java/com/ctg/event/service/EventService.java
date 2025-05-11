package com.ctg.event.service;

import com.ctg.event.entity.Event;
import java.util.*;

public interface EventService {

	Event create(Event event);

	List<Event> getAll();

	Event get(String id);
}
