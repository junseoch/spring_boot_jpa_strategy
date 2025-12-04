package com.app.strategy.domain;

import com.app.strategy.domain.base.Period;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_PRODUCT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@SequenceGenerator(
        name = "SEQ_PRODUCT_GENERATOR",
        sequenceName = "SEQ_PRODUCT"
)
@ToString
public class Product extends Period {
    @Id
    @GeneratedValue(generator = "SEQ_PRODUCT_GENERATOR")
    @Column(name = "PRODUCT_ID")
    private Long id;
    private String name;
    private Integer price; // 자식, 부모 컬럼 비교를 위해

}
