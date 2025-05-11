package com.ctg.rating.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctg.rating.entity.Rating;
import com.ctg.rating.repository.RatingRepository;
import com.ctg.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepository;
	@Override
	public Rating create(Rating rate) {
		// TODO Auto-generated method stub
		String randomRatingId = UUID.randomUUID().toString(); 
		rate.setRatingId(randomRatingId);
		return ratingRepository.save(rate);
	}

	@Override
	public List<Rating> getAllRating() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getByUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllByEventId(String eventId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByEventId(eventId);
	}

}
