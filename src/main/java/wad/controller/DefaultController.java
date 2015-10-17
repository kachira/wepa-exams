/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wad.domain.Course;
import wad.domain.CourseType;
import wad.domain.Exam;
import wad.domain.ExamType;
import wad.repository.CourseRepository;
import wad.repository.ExamRepository;

/**
 *
 * @author sc
 */
@Controller
public class DefaultController {
    
    @RequestMapping("*")
    public String redirect() {
        return "redirect:/exams";
    }
    
     @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ExamRepository examRepository;

    @PostConstruct
    public void init() throws ParseException {
        String[] examiners = {
            "Arthur Dent",
            "Zaphod Beeblebrox",
            "Ford Prefect",
            "Slartibartfast",
            "Vogoni Jeltz",
            "Trillian",
            "Marvin",
            "Hotblack Desiato"
        };
        String[] first = {
            "Tietokoneen",
            "Perunanistutuksen",
            "Javascriptin",
            "Pilvipalveluiden",
            "Putkivahvistinten"
        };
        String[] adjective = {
            "syvällinen",
            "ihana",
            "käsittämätön",
            "nihkeä",
            "ärsyttävä"
        };
        String[] second = {
            "sielunelämä",
            "toiminta",
            "olemus",
            "käyttö",
            "hyödyttömyys"
        };
        String[] dates = {
            "12.10.2015 12:00",
            "12.10.2015 09:00",
            "01.06.2016 12:00",
            "05.10.2016 15:00",
            "01.02.2016 12:00",
            "01.02.2016 09:00",
            "06.06.2016 12:00",
            "06.06.2016 10:00",
            "10.10.2016 12:00"
        };
        Random rnd = new Random();
        ArrayList<String> coursenames = new ArrayList<>();
        ArrayList<Integer> coursecodes = new ArrayList<>();
        while (coursenames.size() < 30) {
            String name = first[rnd.nextInt(5)] + " " + adjective[rnd.nextInt(5)] + " " + second[rnd.nextInt(5)];
            if (!coursenames.contains(name)) {
                coursenames.add(name);
            }
        }
        while (coursecodes.size() < 30) {
            Integer i = rnd.nextInt(90) * rnd.nextInt(90);
            if (!coursecodes.contains(i)) {
                coursecodes.add(i);
            }
        }
        ArrayList<Course> courses = new ArrayList<>();
        for(int i = 0; i < 30; i++) {
            Course c = new Course();
            c.setCode(coursecodes.get(i));
            c.setName(coursenames.get(i));
            if(i < 10) c.setCourseType(CourseType.Basic);
            else if (i < 20) c.setCourseType(CourseType.Advanced);
            else c.setCourseType(CourseType.Subject);
            courses.add(c);
            courseRepository.save(c);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy HH:mm");

        for(int i = 0; i < courses.size(); i++) {
            Exam e = new Exam();
            e.setCourse(courses.get(i));
            e.setExaminer(examiners[rnd.nextInt(8)]);
            e.setExamDate(formatter.parse(dates[rnd.nextInt(9)]));
            int j = rnd.nextInt(300);
            j += 100;
            e.setLocation("A" + j);
            if(i < 10) {
                e.setExamType(ExamType.Normal);
            } else if(i < 20) {
                e.setExamType(ExamType.Retry);
            } else e.setExamType(ExamType.Separate);
            if(rnd.nextBoolean()) e.setRequiresAssignment(true);
            else e.setRequiresAssignment(false);
            examRepository.save(e);
            
        }

        
    }
}
