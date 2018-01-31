package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.FormSubmission;

@Repository("formRepository")
public interface FormRepository extends JpaRepository<FormSubmission, Long> {
    FormSubmission findByEmail(String email);
}
