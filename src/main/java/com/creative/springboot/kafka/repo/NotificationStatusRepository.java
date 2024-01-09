package com.creative.springboot.kafka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creative.springboot.entity.NotificationStatus;
@Repository
public interface NotificationStatusRepository extends JpaRepository<NotificationStatus, Long> {

}
