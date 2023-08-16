package com.lee7s.webflux.controller;

import com.lee7s.webflux.entity.Student;
import com.lee7s.webflux.service.StudentService;
import com.lee7s.webflux.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author somg
 * @date 2023/8/11 18:17
 * @do 学生控制器
 */
@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 查询全部学生 非sse
     * @return
     */
    @GetMapping("all")
    public Flux<Student> finAll(){
        return studentService.findAll();
    }

    /**
     * 查询全部学生 sse
     * @return
     */
    @GetMapping(value = "sse/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> finAllSSE(){
        return studentService.findAll();
    }



    @PostMapping(value = "add")
    public Mono add(@RequestBody Student student){
        ValidateUtils.validateAge(student.getAge());
        ValidateUtils.validateName(student.getName());
        ValidateUtils.validateId(student.getId());

        Mono<Student> insert = studentService.insert(student);
        System.out.println(insert);
        return insert;
    }

    @GetMapping(value = "query/{start}/{end}")
    public Flux<Student> query(@PathVariable Integer start, @PathVariable Integer end){
        return studentService.queryByAge(start, end);
        // return studentService.queryAllByAgeBetween(start, end);
    }

    @GetMapping(value = "query/sse/{start}/{end}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> querySSE(@PathVariable Integer start, @PathVariable Integer end){
        return studentService.queryByAge(start, end);
        // return studentService.queryAllByAgeBetween(start, end);
    }

    @GetMapping("/find/{id}")
    public Mono<ResponseEntity<Student>>findById(@PathVariable("id") String id) {
        return studentService.findById(id)
                .map(student -> new ResponseEntity<Student>(student, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<Student>(HttpStatus.NOT_FOUND));
    }

}
