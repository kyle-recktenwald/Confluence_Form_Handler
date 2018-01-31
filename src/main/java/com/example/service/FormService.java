package com.example.service;

import com.example.model.FormSubmission;
import com.example.model.User;

public interface FormService {
    public FormSubmission findFormSubmissionByEmail(String email);
    public void saveFormSubmission(FormSubmission formSubmission);
}
