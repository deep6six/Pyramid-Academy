package com.genspark.SpringBootDemo.Controller;

import com.genspark.SpringBootDemo.Entity.Course;
import com.genspark.SpringBootDemo.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController
{
    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String home(@RequestParam(value = "name", defaultValue = "World") String name,
                       @RequestParam(value = "msg", defaultValue = "Good Morning") String msg)
    {
        return "Hello " + name + ". " + msg;
    }

    @GetMapping("/courses")
    public List<Course> getCourses()
    {
        return this.courseService.getAllCourse();
    }

    @GetMapping("/courses/{courseID}")
    public Course getCourse(@PathVariable String courseID)
    {
        return this.courseService.getCourseById(Integer.parseInt(courseID));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course)
    {
        return this.courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course)
    {
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseID}")
    public String deleteCourse(@PathVariable String courseID)
    {
        return this.courseService.deleteCourseById(Integer.parseInt(courseID));
    }
}
