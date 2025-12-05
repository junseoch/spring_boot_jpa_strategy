package com.app.strategy.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TBL_CLOTHES")
@DiscriminatorValue("C") // DTYPE -  C   구분점
@PrimaryKeyJoinColumn(name = "CLOTHES_ID")
public class Clothes extends Product {

    private Integer clothesSize;
    private String clothesColor;

}
