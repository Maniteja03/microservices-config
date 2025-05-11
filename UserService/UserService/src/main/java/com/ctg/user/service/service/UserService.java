package com.ctg.user.service.service;

import com.ctg.user.service.entity.User;
import java.util.*;

public interface UserService {
	User save(User user);

	List<User> getAllUser();

	User getUser(String UnserId);

}
