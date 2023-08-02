package com.example.demo.repository;

import com.example.demo.domain.Board;
import com.example.demo.dto.BoardIf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    //JPQL을 사용할 수 있다.
    //JPQL은 SQL과 모양이 비슷하지만, SQL이 아니다.
    //JPQL은 객체지향 언어이다.
    //JPQL에서 from 뒤에 있는 것은 엔티티 이름(엔티티 어노테이션에 name 속성을 생략하면 클래스명이 이름이 됨
    //Board 엔티티들을 조회하라는 뜻. 엔티티는 결국 테이블과 관계
    @Query(value = "select b from Board b join fetch b.user")
    List<Board> getBoards();
    //join b.user=> board b와 user 엔티티를 조인하라는 뜻. 조인하고 sql이 실행됨
    // join fetch을 통해 1 + n 문제를 해결할 수 있게 됨. join fetch를 할 땐, 반드시 board 엔티티의 유저 속성으로
    //조인을 해야 1 + n문제가 해결된다. 일반적으로 조인하는 on 조건문이 뒤에 오면 해결되지 않는다.

    @Query(value = "select count(b) from Board b")
    Long getBoardCount();

    @Query(value = "select b.board_id, b.title, b.content, b.user_id, u.name, b.regdate, b.view_cnt from board b, user u where b.user_id = u.user_id",
    nativeQuery = true
    )
    List<BoardIf> getBoardsWithNativeQuery();
}
