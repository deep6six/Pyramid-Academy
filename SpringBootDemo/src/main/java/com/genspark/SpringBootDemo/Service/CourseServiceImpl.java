package com.genspark.SpringBootDemo.Service;

import com.genspark.SpringBootDemo.Dao.CourseDao;
import com.genspark.SpringBootDemo.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService
{
//    List<Course> list;
//
//    public CourseServiceImpl()
//    {
//        list = new ArrayList<>();
//        list.add(new Course(101,"Spring Framework", "PD"));
//        list.add(new Course(102,"Spring Boot", "SV"));
//        list.add(new Course(103,"Web App", "AD"));
//    }

    @Autowired
    private CourseDao courseDao;


    @Override
    public List<Course> getAllCourse()
    {
        //return list;
        return this.courseDao.findAll();
    }

    @Override
    public Course getCourseById(int courseID)
    {
//        Course c = null;
//        for (Course course:list)
//        {
//            if (course.getCourseid() == courseID) { c = course; break; }
//        }
//        return c;
        Optional<Course> c = this.courseDao.findById(courseID);
        Course course = null;
        if(c.isPresent()) { course = c.get(); }
        else { throw new RuntimeException("Course not found for id :: " + courseID); }
        return course;
    }

    @Override
    public Course addCourse(Course course)
    {
//        list.add(course);
//        return course;
        return this.courseDao.save(course);
    }

    @Override
    public Course updateCourse(Course course)
    {
//        String title = course.getTitle();
//        String instructor = course.getInstructor();
//        Course c = null;
//
//        for (Course e:list)
//        {
//            if (e.getCourseid() == course.getCourseid())
//            {
//                e.setTitle(title);
//                e.setInstructor(instructor);
//                c = e;
//                break;
//            }
//        }
//        return c;
        return this.courseDao.save(course);
    }

    @Override
    public String deleteCourseById(int courseID)
    {
//        for (Course course:list)
//        {
//            if (course.getCourseid() == courseID) { list.remove(course); break; }
//        }
        this.deleteCourseById(courseID);
        return "Deleted Successfully";
    }
}
