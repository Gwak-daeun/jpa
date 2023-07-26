package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory; //javax.persistence로 시작하는 패키지들은 다 jpa api이다. jpa에서 정의된 것
import javax.persistence.EntityTransaction;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication
public class SpringdatajpaApplication implements CommandLineRunner { // 스프링에서 제공하는 bean을 사용하려면 CommandLineRunner를 구현해야 한다.

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    //스프링이 제공하는 빈을 주입받는다.
    @Autowired
    UserRepository userRepository; // UserRepository를 구현하고 있는 빈을 자동으로 주입한다.
    //이 UserRepository를 사용해서 해당 엔티티의 crud작업을 할 수 있다.

    @Override // CommandLineRunner가 갖고 있는 run()메소드를 오버라이딩. 이 메소드에서 스프링이 제공하는 빈을 쓸 수 있다.
    @Transactional // 메소드가 시작할 때 트랜잭션이 실행되고, 메소드가 종료될 때 트랜잭션이 commit된다.
    // 중간에 RuntimeException이 발생하면 트랜잭션이 rollback된다.
    public void run(String... args) throws Exception {
       Optional<User> user = userRepository.findByNameAndEmail("second", "second@gmail.com");
        System.out.println(user);
    }
}
