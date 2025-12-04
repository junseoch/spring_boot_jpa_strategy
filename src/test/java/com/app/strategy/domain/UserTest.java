package com.app.strategy.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
@Commit
class UserTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void insertTest() {
        User user = new User();
        user.setUserLoginId("test1234@gmail.com");

        Board board = new Board();
        board.setContent("게시글 내용");
        board.setTitle("게시글 제목");
        board.setUser(user);

        entityManager.persist(board);
        entityManager.persist(user);
    }

    @Test
    public void selectTest() {
        entityManager.find(User.class, 1);

    }

    @Test
    public void updateTest() {
        Board board = entityManager.find(Board.class, 1);

    }

}