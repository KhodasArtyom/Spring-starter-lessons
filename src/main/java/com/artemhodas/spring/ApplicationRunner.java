package com.artemhodas.spring;

import com.artemhodas.spring.database.pool.ConnectionPool;
import com.artemhodas.spring.database.repository.CompanyRepository;
import com.artemhodas.spring.database.repository.UserRepository;
import com.artemhodas.spring.ioc.Container;
import com.artemhodas.spring.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        String value = "hello";
        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
        CompanyRepository companyRepository;
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {
            ConnectionPool pool1 = context.getBean("pool1", ConnectionPool.class);
            System.out.println(pool1);
            companyRepository = context.getBean("companyRepository", CompanyRepository.class);
        }
        System.out.println(companyRepository);
    }
}
