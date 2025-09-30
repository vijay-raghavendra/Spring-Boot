package com.aim2code.demo.RestController;

import com.aim2code.demo.Entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> studentList;

    @PostConstruct
    public void loadData(){
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Vijay"));
        studentList.add(new Student(2, "Naveen"));
        studentList.add(new Student(3, "Sushanth"));
    }

    @GetMapping("/studentList")
    public List<Student> studentList(){

        return studentList;
    }

    @GetMapping("/studentList/{studentId}")
    public Student studentId(@PathVariable int studentId){

        if (studentId >= studentList.size()){
            throw new StudentNotFoundException("Student Id: "+studentId+" Not Present in the List");
        }
        else if (studentId < 0)
        {
            throw new StudentNotFoundException("Student Id cannot be less than 0");
        }
        else{
            return studentList.get(studentId);
        }
        //return studentList.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){

        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
