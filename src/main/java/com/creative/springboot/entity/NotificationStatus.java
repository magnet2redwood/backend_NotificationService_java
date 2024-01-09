package com.creative.springboot.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class NotificationStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long notificationId;
	private String notificationStatus;
	private Date date;
	private String eventId;
	private String firstName;
	private String lastName;
	private String recipient;
	private String msgBody;
	private String subject;
	private String channelType;
}
