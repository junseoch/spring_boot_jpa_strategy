package com.app.strategy.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "TBL_BOOK")
@DiscriminatorValue("D")
@PrimaryKeyJoinColumn(name = "BOOK_ID")
@ToString
public class Book extends Product{ // 구분 컬럼은 B

    // 저자
    private String bookAuthor;

    // 발행
    private String bookPublisher;


}
