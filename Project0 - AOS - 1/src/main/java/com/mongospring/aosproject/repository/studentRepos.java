package com.mongospring.aosproject.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.mongospring.aosproject.model.Student;

public interface studentRepos extends MongoRepository<Student,String> {

}
