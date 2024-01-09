package com.creative.springboot.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creative.springboot.entity.NotificationStatus;
import com.creative.springboot.kafka.repo.NotificationStatusRepository;
@Service
public class NotificationStatusSeriveImpl implements NotificationStatusService {

	@Autowired
	private NotificationStatusRepository notificationStatusRepository;
	@Override
	public void save(NotificationStatus request) {
		 notificationStatusRepository.save(request);
	}
	

}
