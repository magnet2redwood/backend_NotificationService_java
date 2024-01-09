package com.creative.springboot.kafka.service;

import java.util.List;

import com.creative.springboot.entity.EmailNotification;
import com.creative.springboot.payload.NotificationRequest;

public interface EmailService {

	// To send a simple email
	String sendSimpleMail(NotificationRequest request);

	// Save operation
	EmailNotification saveEmailDetails(EmailNotification request);

	// Read operation
	List<EmailNotification> fetchEmailDetailsList();

	// Update operation
//	EmailDetails updateEmailDetails(EmailDetails emailDetails, Long id);

	// Delete operation
	void deleteEmailDetailsById(Long id);

}
