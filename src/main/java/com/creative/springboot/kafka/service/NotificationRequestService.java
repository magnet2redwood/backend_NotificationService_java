package com.creative.springboot.kafka.service;

import com.creative.springboot.payload.NotificationRequest;

public interface NotificationRequestService {

	void save(NotificationRequest request);
}
