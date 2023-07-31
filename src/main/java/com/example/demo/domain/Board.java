package com.example.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Board") // JPQL에서 from 절 뒤에 쓰이는 name. 생략하게 되면 클래스명이 엔티티명이 됨
@Table(name = "board")
@NoArgsConstructor
@Setter
@Getter
public class Board {
    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(length = 100)
    private String title;

    @Lob //text type과 매핑하기 위한 어노테이션. 대용량 텍스트로 인식함
    private String content; //text type

    private int viewCount;

    @CreationTimestamp // 현재시간이 저장될 때 자동으로 생성
    private LocalDateTime regdate;

    @ManyToOne(fetch = FetchType.LAZY) // 게시물 N ----- 사용자 1
    // fetch = FetchType.EAGER -> ManyToOne이 갖고 있는 기본 속성. 사용하지 않아도 무조건 데이터를 가지고 오라는 뜻
    //FetchType.LAZY -> 쿼리를 늦게 가져옴
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Board{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", viewCount=" + viewCount +
                ", regdate=" + regdate +
                ", user=" + user +
                '}';
    }
}
