package com.bitlabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitlabs.entity.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
        
    List<Course> findByFeeLessThan(double fee);
    List<Course> findByNameContaining(String name);
}

