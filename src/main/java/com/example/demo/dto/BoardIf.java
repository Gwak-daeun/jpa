package com.example.demo.dto;

import java.time.LocalDateTime;

public interface BoardIf {
    //select 문의 칼럼 값을 읽어오는 getter메소드를 인터페이스에서 만들어준다.
    public Integer getBoardId();

    public String getTitle();

    public String getContent();

    public Integer getUserId();

    public String getName();

    public LocalDateTime getRegdate();

    public int getViewCnt();

}

//select문 : b.board_id, b.title, b.content, b.user_id, u.name, b.regdate, b.view_cnt