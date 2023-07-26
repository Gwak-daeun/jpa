package com.example.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // 데이터베이스 테이블과 맵핑하는 객체
@Table(name = "user3") // 데이터베이스 테이블 이름이 user3와 User라는 객체가 맵핑된다. 생략하면 현재 위치의 클래스명과 같은 테이블명으로 맵핑됨
@NoArgsConstructor // 기본 생성자가 있어야 한다.
@Setter
@Getter
@ToString // ToString은 조심히 만들어야 한다.
public class User {
    @Id //유일한 키(해당 필드가 Table의 pk라는 의미.) @Entity는 꼭 @Id 속성을 가져야 한다.
    @Column(name = "user_id") // userId필드는 user_id컬럼과 관계있다는 뜻
    @GeneratedValue(strategy = GenerationType.IDENTITY) // userId는 자동으로 생성되도록 한다.(autoIncrement와 같은 역할)
    private Integer userId;

    @Column(length = 255)
    private String email; //@Column(name = "")이 없는 것은 해당 필드와 같은 이름의 컬럼을 만들라는 뜻

    @Column(length = 50)
    private String name;

    @Column(length = 500)
    private String password;

    @CreationTimestamp // 현재시간이 저장될 때 자동으로 생성
    private LocalDateTime regdate;

}
