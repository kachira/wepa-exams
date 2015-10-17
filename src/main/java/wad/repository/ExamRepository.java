/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Exam;

/**
 *
 * @author sc
 */
public interface ExamRepository extends JpaRepository<Exam, Long>{
    List<Exam> findAllByOrderByExamDateAsc();
    List<Exam> findByCourse_NameLike(String name);
    List<Exam> findByExamDateBetween(Date start, Date end);
}
