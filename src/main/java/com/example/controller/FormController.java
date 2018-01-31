package com.example.controller;

import javax.validation.Valid;

import com.example.model.FormSubmission;
import com.example.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;
import com.example.service.UserService;

@Controller
public class FormController {

    @Autowired
    private UserService userService;

    @Autowired
    private FormService formService;

    @RequestMapping(value="/confluenceForm", method = RequestMethod.POST)
    public ModelAndView submitForm(@RequestParam("comment-email") String commentEmail, @RequestParam("comment-input") String commentInput){
        ModelAndView modelAndView = new ModelAndView();

        FormSubmission formSubmission = new FormSubmission();

        formSubmission.setEmail(commentEmail);
        formSubmission.setComment(commentInput);

        formService.saveFormSubmission(formSubmission);

        modelAndView.addObject("formSubmission", formSubmission);
        modelAndView.addObject("email", commentEmail);
        modelAndView.addObject("comment", commentInput);
        modelAndView.setViewName("data_handler_page");
        return modelAndView;
    }

    @RequestMapping(value="/formSubmissions", method = RequestMethod.GET)
    public ModelAndView getFormSubmissions(){
        ModelAndView modelAndView = new ModelAndView();

        FormSubmission formSubmission = new FormSubmission();

        formService.saveFormSubmission(formSubmission);

        modelAndView.addObject("formSubmission", formSubmission);

        modelAndView.setViewName("data_handler_page");
        return modelAndView;
    }

}