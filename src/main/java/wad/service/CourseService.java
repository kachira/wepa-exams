/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.service;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.domain.Course;
import wad.repository.CourseRepository;

/**
 *
 * @author sc
 */
@Service
public class CourseService {
    public static Logger log = Logger.getLogger("courseService");
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
    
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
}
