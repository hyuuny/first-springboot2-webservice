package com.setge.boot.springboot.web.domain.posts;

import com.setge.boot.springboot.web.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본 생성자 자동추가
@Entity
public class Posts extends BaseTimeEntity { // Entity값을 생성 및 변경할때마다 시간이 자동저장된다.

    /*
    * @Entity : 테이블과 링크될 클래스임을 나타낸다.
    * @Id : 해당 테이블의 PK필드를 뜻한다.
    * @GeneratedValue : PK의 생성규칙을 나타낸다. GenerationType.IDENTITY를 추가해야만 auto_increment된다.
    * @Column : 테이블의 칼럼을 나타내며, 굳이 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이 된다.
    *           사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
    *           문자열은 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶은 경우 등
    * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
