package com.lee7s.routerfunction.router;

import com.lee7s.routerfunction.handler.StudentHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author somg
 * @date 2023/8/16 14:33
 * @do 学生路由器
 */
@Configuration // javaConfig类
public class FunctionRouter {

    // 用于将请求路由到指定的处理器

    @Bean
    public RouterFunction<ServerResponse> studentRouter(StudentHandler studentHandler){

        return RouterFunctions.nest(RequestPredicates.path("student"), RouterFunctions.route(RequestPredicates.GET("all"), studentHandler::findAllHandler)
                .andRoute(RequestPredicates.POST("add").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), studentHandler::addStudent)
                .andRoute(RequestPredicates.PUT("update/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), studentHandler::updateStudent)
                .andRoute(RequestPredicates.DELETE("del/{id}"), studentHandler::deleteStudent)
        );

    }

}
