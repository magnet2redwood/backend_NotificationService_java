package com.creative.springboot.kafka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.creative.springboot.entity.EmailNotification;
import com.creative.springboot.payload.NotificationRequest;

@Repository
public interface EmailNotificationRepository extends JpaRepository<EmailNotification, Long> {

}
