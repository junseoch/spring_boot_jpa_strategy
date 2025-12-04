package com.app.strategy.domain;

import com.app.strategy.domain.embedded.Address;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TBL_MEMBER")
@SequenceGenerator(
        name = "SEQ_MEMBER_GENERATOR",
        sequenceName = "SEQ_MEMBER",
        allocationSize = 1
)

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MEMBER_GENERATOR")
    @EqualsAndHashCode.Include
    private Long id;
    private String memberName;

    // 임베디드 타입
    // 하나의 타입으로 묶어서 사용
    private Address address;

}
