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
class BoardTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void boardTest(){
        Board board = new Board();
        board.setId(1L);
        board.setTitle("책 제목");
        board.setContent("책 내용");

        entityManager.persist(board);

    }

    @Test
    public void findBoardTest(){
        Board board = entityManager.find(Board.class, 1L);
    }

}