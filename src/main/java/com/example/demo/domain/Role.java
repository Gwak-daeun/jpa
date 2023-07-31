package com.example.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "role")
@NoArgsConstructor
@Setter
@Getter
//@ToString // 엔티티 관계를 표현할 때는 되도록 사용하지 않는게 좋다. 재귀적인 문제가 생길 수 있다.
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(length = 20)
    private String name;

    //엔티티에서는 되도록 @ToString 어노테이션을 사용하기 보단 직접 메소드를 오버라이딩해서 쓰는 것이 좋다.
    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                '}';
    }
}
