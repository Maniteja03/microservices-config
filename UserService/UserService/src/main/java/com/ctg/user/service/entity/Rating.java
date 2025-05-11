package com.ctg.user.service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
	private String ratingId;
	private String userId;
	private String eventId;
	private int rating;
	private String feedback;
	private Event event;
}
