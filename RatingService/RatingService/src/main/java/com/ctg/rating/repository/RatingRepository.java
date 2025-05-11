package com.ctg.rating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.ctg.rating.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {
	
	List<Rating> findByUserId(String userId);
	List<Rating> findByEventId(String eventId);

}
