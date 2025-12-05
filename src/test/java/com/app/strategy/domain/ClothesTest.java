package com.app.strategy.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Slf4j
@Transactional
@Commit

class ClothesTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testClothes() {
        Clothes clothes = new Clothes();
        clothes.setName("패딩");
        clothes.setPrice(20000);
        clothes.setClothesSize(100);
        clothes.setClothesColor("red");

        entityManager.persist(clothes);

    }

    @Test
    public void testBook() {
//        Book book = new Book();
//        book.setName("스물다섯 뭐시기");
//        book.setPrice(20000);
//        book.setBookAuthor("김길동");
//        book.setBookPublisher("출판사");
//        entityManager.persist(book);
        Book book = new Book();
        book.setName("명언집");
        book.setPrice(10000);
        book.setBookAuthor("홍길동");
        book.setBookPublisher("공공데이터 출판사");
        entityManager.persist(book);

    }

    @Test
    public void bookFindTest(){
        Book book = entityManager.find(Book.class, 52L);
        log.info("book :{}",book.getName());
        log.info("book :{}",book.getPrice());
        log.info("book :{}",book);

    }

    @Test
    public void bookUpdateTest(){
        Book book = entityManager.find(Book.class, 102L);
        book.setBookAuthor("장보고");
    }

    // 책 삭제
    @Test
    public void bookDeleteTest(){
        entityManager.remove(entityManager.find(Book.class, 2L));
    }

}