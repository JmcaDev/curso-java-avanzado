package com.devtalles.tu_cv_spring_boot.tuCV.service;

import com.devtalles.tu_cv_spring_boot.tuCV.model.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CvInitializationServiceImpl implements CvInitializationService {

    @Override
    public CvData initializeCvData() {
        CvData cvData = new CvData();

        //Datos personales
        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.setFirstName("Jose");
        personalDetails.setLastName("Castillo");
        personalDetails.setEmail("jose@jose.com");
        personalDetails.setProfessionalProfile("Backend Developer");
        cvData.setPersonalDetails(personalDetails);

        //Educacion
        Education education = new Education();
        education.setInstitution("UJAP");
        education.setDegree("Engineering");
        education.setPeriod("July 2023 - December 2026");
        education.setDescription("Computer Engineering");

        cvData.setEducations(Collections.singletonList(education));

        //Experiencia
        Experience  experience = new Experience();
        experience.setJobTitle("Jr Developer");
        experience.setCompany("Example company");
        experience.setPeriod("July 2026 - Present");

        cvData.setExperiences(List.of(experience));

        //Habilidades
        Skill skill1 = new Skill();
        skill1.setName("Java");
        skill1.setLevel("Advanced");

        Skill  skill2 = new Skill();
        skill2.setName("SpringBoot");
        skill2.setLevel("Basic");

        Skill  skill3 = new Skill();
        skill3.setName("NodeJS");
        skill3.setLevel("Advanced");

        cvData.setSkills(Arrays.asList(skill1, skill2, skill3));

        return cvData;
    }
}
