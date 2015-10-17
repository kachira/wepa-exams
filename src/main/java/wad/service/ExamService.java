/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
@Service
public class ExamService {

    public static Logger log = Logger.getLogger("exService");
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ExamRepository examRepository;

    public List<Exam> getExams() {
        return examRepository.findAllByOrderByExamDateAsc();
    }

    public Exam getExam(Long id) {
        return examRepository.findOne(id);
    }

    public Exam save(Exam exam) {
        return examRepository.save(exam);
    }

    public void delete(Long id) {
        examRepository.delete(id);
    }

    public List<Exam> searchByCourseName(String search) {
        search = "%" + search + "%";
        return examRepository.findByCourse_NameLike(search);
    }

    public List<Exam> searchByDateRange(Date start, Date end) {
        return examRepository.findByExamDateBetween(start, end);
    }

}
