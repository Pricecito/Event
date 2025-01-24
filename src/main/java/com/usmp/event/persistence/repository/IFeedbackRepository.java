package com.usmp.event.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usmp.event.persistence.models.Feedback;

@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, UUID> {

}
