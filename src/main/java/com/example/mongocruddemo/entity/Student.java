package com.example.mongocruddemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="studentDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private String id;

    private String name;
    private String age;
    private String className;
    private String bookTitle;
}
