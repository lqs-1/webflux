package com.lee7s.webflux.service;

import com.lee7s.webflux.entity.Student;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * @author somg
 * @date 2023/8/11 18:15
 * @do 学生服务层接口
 */
// ReactiveMongoRepository 第一个参数为实体类型 第二个参数为id类型
public interface StudentService extends ReactiveMongoRepository<Student, String> {

    Flux<Student> queryAllByAgeBetween(Integer le, Integer rl);

    @Query("{'age':{'$gt':?0, '$lt':?1}}")
    Flux<Student> queryByAge(Integer le, Integer rl);




}
