package com.genspark.SpringBootDemo.Service;

import com.genspark.SpringBootDemo.Entity.Course;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService
{
    List<Course> list;

    public CourseServiceImpl()
    {
        list = new ArrayList<>();
        list.add(new Course(101,"Spring Framework", "PD"));
        list.add(new Course(102,"Spring Boot", "SV"));
        list.add(new Course(103,"Web App", "AD"));
    }

    @Override
    public List<Course> getAllCourse()
    {
        return list;
    }

    @Override
    public Course getCourseById(int courseID)
    {
        Course c = null;
        for (Course course:list)
        {
            if (course.getCourseid() == courseID) { c = course; break; }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course)
    {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course)
    {
        String title = course.getTitle();
        String instructor = course.getInstructor();
        Course c = null;

        for (Course e:list)
        {
            if (e.getCourseid() == course.getCourseid())
            {
                e.setTitle(title);
                e.setInstructor(instructor);
                c = e;
                break;
            }
        }
        return c;
    }

    @Override
    public String deleteCourseById(int courseID)
    {
        for (Course course:list)
        {
            if (course.getCourseid() == courseID) { list.remove(course); break; }
        }
        return "Deleted Successfully";
    }
}
