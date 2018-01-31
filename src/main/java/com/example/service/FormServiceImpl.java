package com.example.service;

import java.util.Arrays;
import java.util.HashSet;

import com.example.model.FormSubmission;
import com.example.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.Role;
import com.example.model.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;

@Service("formService")
public class FormServiceImpl implements FormService {

    @Autowired
    private FormRepository formRepository;

    @Override
    public FormSubmission findFormSubmissionByEmail(String email) {
        return formRepository.findByEmail(email);
    }

    @Override
    public void saveFormSubmission(FormSubmission formSubmission) {

        formSubmission.setId(formSubmission.getId());
        formSubmission.setEmail(formSubmission.getEmail());
        formSubmission.setComment(formSubmission.getComment());
        formRepository.save(formSubmission);
    }

}
