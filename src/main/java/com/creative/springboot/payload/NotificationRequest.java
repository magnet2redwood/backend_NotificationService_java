package com.creative.springboot.payload;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Annotations
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class NotificationRequest {
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
	


	@Override
	public String toString() {
		return "User{" + "eventId" + eventId + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", recipient='" + recipient + '\'' + ", msgBody='" + msgBody + '\'' + ", subject='" + subject + '\''
				+ ", channelType='" + channelType + '\'' + '}';
	}
}
