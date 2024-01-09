package com.creative.springboot.kafka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creative.springboot.payload.NotificationRequest;
@Repository
public interface NotificationRequestRepository extends JpaRepository<NotificationRequest, Long> {

}
