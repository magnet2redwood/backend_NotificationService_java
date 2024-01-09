package com.creative.springboot.kafka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.creative.springboot.entity.EmailNotification;
import com.creative.springboot.entity.NotificationStatus;
import com.creative.springboot.kafka.repo.EmailNotificationRepository;
import com.creative.springboot.payload.NotificationRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	@Autowired
	private EmailNotificationRepository emailRepository;
	@Autowired
	private EmailNotification emailNotification;

	@Autowired
	private NotificationStatus notificationStatus;

	@Autowired
	private NotificationStatusSeriveImpl notificationStatusSeriveImpl;

	public String sendSimpleMail(NotificationRequest notificationRequest) {

		// Try block to check for exceptions
		try {

			// Creating a simple mail message
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			// Setting up necessary details
			mailMessage.setFrom(sender);
			mailMessage.setTo(notificationRequest.getRecipient());
			mailMessage.setText(notificationRequest.getMsgBody());
			mailMessage.setSubject(notificationRequest.getSubject());

			log.info("Email notificationRequest are : " + notificationRequest.getRecipient());

			emailNotification.setEventId(notificationRequest.getEventId());
			emailNotification.setFirstName(notificationRequest.getFirstName());
			emailNotification.setLastName(notificationRequest.getLastName());
			emailNotification.setRecipient(notificationRequest.getRecipient());
			emailNotification.setSubject(notificationRequest.getSubject());
			saveEmailDetails(emailNotification);
			log.info("Eamil details are saved");
			// Sending the mail

			try {
				javaMailSender.send(mailMessage);
			} catch (Exception e) {
				e.printStackTrace();
			}
			notificationStatus.setFirstName(notificationRequest.getFirstName());
			notificationStatus.setLastName(notificationRequest.getLastName());
			notificationStatus.setChannelType(notificationRequest.getChannelType());
			notificationStatus.setEventId(notificationRequest.getEventId());
			notificationStatus.setRecipient(notificationRequest.getRecipient());
			notificationStatus.setNotificationStatus("Success");
			notificationStatusSeriveImpl.save(notificationStatus);
			return "Mail Sent Successfully...";
		}

		// Catch block to handle the exceptions
		catch (Exception e) {
			return "Error while Sending Mail";
		}
	}

	// Save operation
	@Override
	public EmailNotification saveEmailDetails(EmailNotification emailNotification) {
		log.info("Email Details saved in DB");
		return emailRepository.save(emailNotification);
	}

	// Read operation
	@Override
	public List<EmailNotification> fetchEmailDetailsList() {
		return (List<EmailNotification>) emailRepository.findAll();
	}

	// Delete operation
	@Override
	public void deleteEmailDetailsById(Long id) {
		emailRepository.deleteById(id);
	}

}
