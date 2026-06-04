package com.devtalles.tu_cv_spring_boot.tuCV.controller;

import com.devtalles.tu_cv_spring_boot.tuCV.model.CvData;
import com.devtalles.tu_cv_spring_boot.tuCV.service.CvInitializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LandingController {

    private final CvInitializationService cvInitializationService;

    @GetMapping("/cv-form")
    public String showFormCV(Model model){
        CvData cvData = cvInitializationService.initializeCvData();
        model.addAttribute("cvData", cvData);
        return "cv-form";
    }
}
