package com.creative.springboot.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creative.springboot.kafka.repo.NotificationRequestRepository;
import com.creative.springboot.payload.NotificationRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificationRequestServiceImpl implements NotificationRequestService {

	@Autowired
	private NotificationRequestRepository notificationRequestRepository;

	@Override
	public void save(NotificationRequest request) {
		log.info("save(-)");
		log.info("Event ID :"+request.getEventId());
		notificationRequestRepository.save(request);

	}

}
