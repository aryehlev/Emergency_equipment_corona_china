package cn.lss.demo001;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.lss.demo001.dao")
public class Demo001Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo001Application.class, args);
    }

}
