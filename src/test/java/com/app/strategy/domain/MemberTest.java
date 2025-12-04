package com.app.strategy.domain;

import com.app.strategy.domain.embedded.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
@Commit
@Transactional
class MemberTest {

    @PersistenceContext
    private EntityManager entityManager;

    // @Test 메서드가 실행될 때 반드시 먼저 실행시키는 어노테이션
    @BeforeEach
    public void setUp() {
        Address address = new Address();
        address.setMemberAddress("강남구");
        address.setMemberAddressDetail("101호");
        address.setMemberZipcode("12345");

        Member member = new Member();
        member.setMemberName("홍길동");
        member.setAddress(address);
        entityManager.persist(member);
//        entityManager.detach(member);  // 영속 -> 준영속으로 바꿔서 감지되지 않도록 함


        Member member2 = new Member();
        Address address2 = new Address(); // 이 방식으로 해야함

        member2.setMemberName("장보고");
        address2.setMemberAddress("겅기도 성남시");
        address2.setMemberAddressDetail("1200호");
        address2.setMemberZipcode("45678");
        member2.setAddress(address);

        entityManager.persist(member2);
    }

    @Test
    public void saveTest() {

    }

}