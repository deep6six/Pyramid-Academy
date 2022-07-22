package com.genspark.SpringBootDemo.Service;

import com.genspark.SpringBootDemo.Entity.Course;

import java.util.List;


public interface CourseService
{
    List<Course> getAllCourse();
    Course getCourseById(int courseID);
    Course addCourse(Course course);
    Course updateCourse(Course course);
    String deleteCourseById(int courseID);
}
