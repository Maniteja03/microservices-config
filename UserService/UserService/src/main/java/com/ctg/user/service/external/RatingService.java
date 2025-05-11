package com.ctg.user.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.ctg.user.service.entity.Rating;

@FeignClient(name ="RATINGSERVICE")
public interface RatingService {
	
	@PostMapping("/ratings/create")
	public Rating createRatingd(Rating rate);
	
	public Rating updateRating();
	

}
