package com.creative.springboot.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.creative.springboot.entity.NotificationStatus;
import com.creative.springboot.kafka.service.EmailServiceImpl;
import com.creative.springboot.kafka.service.NotificationRequestServiceImpl;
import com.creative.springboot.kafka.service.NotificationStatusSeriveImpl;
import com.creative.springboot.payload.NotificationRequest;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JsonKafkaConsumer {

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private EmailServiceImpl notificationServiceImpl;
	
	@Autowired
	private NotificationRequestServiceImpl notificationRequestServiceImpl;
	
	@Value("${spring.mail.username}")
	private String sender;

	@KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(NotificationRequest request) {
		log.info(String.format("Json message recieved -> %s", request.toString()));
		
		//Client Request details saving in DB 
		notificationRequestServiceImpl.save(request);

		if (request.getChannelType().equalsIgnoreCase("Email")) {
			log.info("Email channel type notification");
			
			notificationServiceImpl.sendSimpleMail(request);
		}

	}

}
