package com.app.strategy.domain;


import com.app.strategy.domain.base.Period;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TBL_USER")

@SequenceGenerator(
        name = "SEQ_USER_GENERATOR",
        sequenceName = "SEQ_USER",
        allocationSize = 1
)
@ToString(exclude = {"boardList"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class User extends Period {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_USER_GENERATOR")
    @Column(name = "USER_ID")
    private Long id;
    private String userLoginId;
    private String userPassword;
    private Integer userAge;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Board> boardList;

    {
        this.boardList = new ArrayList<>(); // 초기화 블럭을 이용한 초기값 넣어줌
    }


}
