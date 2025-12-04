package com.app.strategy.domain.base;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

// Period
// Period는 엔티티가 아니다. 상속을 사용하기 위한 공통 필드이다.
// 객체 지향언어의 상속을 구현할 때 사용되며, 테이블과 매핑하지 않고
// 필드를 상속하기 위해 사용하는 클래스이다.
// 즉, 자바에서는 상속관계이지만, RDB에서는 상속 구현과는 무관한 클래스임을 표시한다.
@MappedSuperclass
public abstract class Period { // new Period() : 하지말 것! (abstract)

    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    // .persist() 이전에 실행되는 메서드
    // 하이버네이트가 지원한다
    @PrePersist //  영속되기 직전에 실행
    public void onPrePersist() {
        createDate = LocalDateTime.now();
        modifyDate = LocalDateTime.now();
    }

    // 터티체크 시점에 발생한다
    @PreUpdate
    public void onPreUpdate() {
        this.modifyDate = LocalDateTime.now();
    }


}
