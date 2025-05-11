package com.ctg.rating.service;

import com.ctg.rating.entity.Rating;
import java.util.*;
public interface RatingService {
	
	Rating create(Rating rate);
	
	List<Rating> getAllRating();
	
	List<Rating> getByUserId(String userId);
	
	List<Rating> getAllByEventId(String eventId);
	

}
