package com.app.strategy.domain.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable // 선언하는 쪽
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Address {
    // 임베디드 타입
    // 하나의 타입으로 묶어서 사용
    private String memberAddress;
    private String memberAddressDetail;
    private String memberZipcode;

    public String createFullAddress() {
        return memberAddress + " " + memberAddressDetail + " [" + memberZipcode + "]";
    }

}
