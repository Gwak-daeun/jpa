package com.example.demo.repository;

//org.springframework.data.jpa : spring data jpa와 관련된 패키지
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//Spring Data JPA Rpository를 완성함. dao와 유사하다고 보면된다.
//엔티티의 crud를 담당하는 인터페이스이다.
//보통 인터페이스를 선언하면, 인터페이스를 구현하는 클래스를 작성해야한다고 생각한다.
//
public interface UserRepository extends JpaRepository<User, Integer> {
    //JpaRepository는 인터페이스이다. 제네릭의 첫번째 파라미터는 엔티티, 두번째는 엔티티의 Id에 해당하는 객체 타입을 넣는다.

  Optional<User> findByName(String name);

  //where name = ? and email = ?
  Optional<User> findByNameAndEmail(String name, String email);


  //where name = ? or email = ?
  List<User> findByNameOrEmail(String name, String email);
}
