package com.example.demo.repository;

//org.springframework.data.jpa : spring data jpa와 관련된 패키지
import com.example.demo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

  //where user_id betwwen ? and ?
  List<User> findByUserIdBetween(int startUserIId, int endUserId);

  Page<User> findBy(Pageable pageable);
  //findBy라고만 쓰면 전체 건수를 다 가져오는것.
  //Pageable 인터페이스가 들어가면 페이징처리에 대한 정보를 받아들인다.
  //Page<User>는 페이징 처리한 결과를 1페이지 혹은 2페이지와 같이 원하는 만큼 갖고 올 수 있다.

}
