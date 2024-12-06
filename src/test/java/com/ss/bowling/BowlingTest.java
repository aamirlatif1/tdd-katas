package com.ss.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {


   private Bowling game;

   @BeforeEach
   void setUp() {
      game = new Bowling();
   }

   @Test
   public void gutterGame() throws Exception {
      int score = game.score("--|--|--|--|--|--|--|--|--|--||");

      assertEquals(0, score);
   }

   @Test
   public void rollAllOnes() throws Exception {
      int score = game.score("11|11|11|11|11|11|11|11|11|11||");

      assertEquals(20, score);
   }

   @Test
   public void rollAllTwos() throws Exception {
      int score = game.score("22|22|22|22|22|22|22|22|22|22||");

      assertEquals(40, score);
   }

   @Test
   public void rollOneSpare() throws Exception {
       int score = game.score("3/|2-|--|--|--|--|--|--|--|--||");

      assertEquals(14, score);
   }

   @Test
   public void rollStrike() throws Exception {
       int score = game.score("X|23|--|--|--|--|--|--|--|--||");

      assertEquals(20, score);
   }

   @Test
   public void rollStrikeAnd() throws Exception {
      int score = game.score("X|2/|1-|--|--|--|--|--|--|--||");

      assertEquals(32, score);
   }

   @Test
   public void spareAndStrike() throws Exception {
      int score = game.score("2/|X|1-|--|--|--|--|--|--|--||");

      assertEquals(32, score);
   }

   @Test
   public void doubleStrike() throws Exception {
      int score = game.score("X|X|11|--|--|--|--|--|--|--||");

      assertEquals(35, score);
   }

   @Test
   public void turkey() throws Exception {
      int score = game.score("X|X|X|11|--|--|--|--|--|--||");

      assertEquals(65, score);
   }
   @Test
   public void lastFrameSpare() throws Exception {
      int score = game.score("--|--|--|--|--|--|--|--|--|-/||1");

      assertEquals(11, score);
   }
   @Test
   public void lastFrameStrike() throws Exception {
      int score = game.score("--|--|--|--|--|--|--|--|--|X||11");

      assertEquals(12, score);
   }

   @Test
   public void perfectGame() throws Exception {
      int score = game.score("X|X|X|X|X|X|X|X|X|X||XX");

      assertEquals(300, score);
   }
   @Test
   public void normalGame() throws Exception {
      int score = game.score("X|7/|9-|X|-8|8/|-6|X|X|X||81");

      assertEquals(167, score);
   }
}
