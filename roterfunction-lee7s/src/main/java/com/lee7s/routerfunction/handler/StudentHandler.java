package com.lee7s.routerfunction.handler;

import com.lee7s.routerfunction.entity.Student;
import com.lee7s.routerfunction.service.StudentService;
import com.lee7s.routerfunction.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author somg
 * @date 2023/8/16 14:37
 * @do 学生处理器类
 */

@Component
public class StudentHandler {

    @Autowired
    private StudentService studentService;


    public Mono<ServerResponse> findAllHandler(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(studentService.findAll(), Student.class);

    }

    public Mono<ServerResponse> addStudent(ServerRequest request){
        Mono<Student> studentMono = request.bodyToMono(Student.class);

        Mono<Student> studentMono1 = studentMono.map(student -> {
            ValidateUtils.validateAge(student.getAge());
            ValidateUtils.validateId(student.getId());
            ValidateUtils.validateName(student.getName());
            return student;
        });


        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(studentService.insert(studentMono1), Student.class);
    }



    public Mono<ServerResponse> updateStudent(ServerRequest request){
        String id = request.pathVariable("id");
        Mono<Student> studentMono = request.bodyToMono(Student.class);

        Mono<Student> student2 = studentMono.map(student -> {
            student.setId(id);
            return student;
        });


        return studentService.findById(id).flatMap(student -> {
            Flux<Student> studentFlux = studentService.saveAll(student2);
            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(studentFlux, Student.class);
        }).switchIfEmpty(ServerResponse.notFound().build());
    }


    public Mono<ServerResponse> deleteStudent(ServerRequest request){
        String id = request.pathVariable("id");


        return studentService.findById(id).flatMap(student -> {
            Mono<Void> voidMono = studentService.deleteById(id);
            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(voidMono, Student.class);

        }).switchIfEmpty(ServerResponse.notFound().build());
    }




}
