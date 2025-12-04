package com.app.strategy.domain;

import com.app.strategy.domain.base.Period;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TBL_BOARD")

@Getter
@Setter
@SequenceGenerator(
        name = "SEQ_BOARD_GENERATOR",
        sequenceName = "SEQ_BOARD",
        allocationSize = 1
)
@ToString(exclude = {"user"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Board extends Period {

    @Id @EqualsAndHashCode.Include
    @Column(name = "BOARD_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_BOARD_GENERATOR")
    private Long id;
    private String title;
    private String content;

    // user를 join으로 가져옴
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

}
