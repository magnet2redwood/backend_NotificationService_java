package com.creative.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.creative.springboot.payload.NotificationRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class EmailNotification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String eventId;
	private String firstName;
	private String lastName;
	private String recipient;
	private String msgBody;
	private String subject;
	private String channelType;
	private String eventType;
	private String eventModule;
	private String clientId;
	
}
