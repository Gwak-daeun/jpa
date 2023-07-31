package com.example.demo;

import com.example.demo.domain.Board;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory; //javax.persistence로 시작하는 패키지들은 다 jpa api이다. jpa에서 정의된 것
import javax.persistence.EntityTransaction;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringdatajpaApplication implements CommandLineRunner { // 스프링에서 제공하는 bean을 사용하려면 CommandLineRunner를 구현해야 한다.

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BoardRepository boardRepository;

    @Override
    @Transactional // 메소드가 시작할 때 트랜잭션이 실행되고, 메소드가 종료될 때 트랜잭션이 commit된다.
    // 중간에 RuntimeException이 발생하면 트랜잭션이 rollback된다.
    public void run(String... args) throws Exception {

        List<Board> all = boardRepository.findAll(); // select * from user; 4rjs 1 + N 문제
        for (Board board : all) {
            System.out.println(board);

        }

    }
}
