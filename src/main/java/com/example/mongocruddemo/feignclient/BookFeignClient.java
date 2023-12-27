package com.example.mongocruddemo.feignclient;

import com.example.mongocruddemo.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(name="student-profile",url="http://localhost:2081")
public interface BookFeignClient {
    @GetMapping("/api/student/")
    List<Student> getAllStudents();

    @GetMapping("/api/student/title")
    List<Student>getByBooktitle(@RequestParam("bookTitle") String bookTitle);
}
