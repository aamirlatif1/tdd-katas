package com.ss.bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {

   private static String spareGame() {
      return "3/|2-|--|--|--|--|--|--|--|--||";
   }

   private static String strikeGame() {
      return "X|23|--|--|--|--|--|--|--|--||";
   }

   @Test
   public void gutterGame() throws Exception {
       Bowling game = new Bowling("--|--|--|--|--|--|--|--|--|--||");

      int score = game.score();

      assertEquals(0, score);
   }

   @Test
   public void rollAllOnes() throws Exception {
      Bowling game = new Bowling("11|11|11|11|11|11|11|11|11|11||");

      int score = game.score();

      assertEquals(20, score);
   }

   @Test
   public void rollAllTwos() throws Exception {
      Bowling game = new Bowling("22|22|22|22|22|22|22|22|22|22||");

      int score = game.score();

      assertEquals(40, score);
   }

   @Test
   public void rollOneStrike() throws Exception {
      Bowling game = new Bowling(spareGame());

      int score = game.score();

      assertEquals(14, score);
   }

   @Test
   public void rollStrike() throws Exception {
      Bowling game = new Bowling(strikeGame());

      int score = game.score();

      assertEquals(20, score);
   }

   @Test
   public void perfectGame() throws Exception {
      Bowling game = new Bowling("X|X|X|X|X|X|X|X|X|X||XX");

      int score = game.score();

      assertEquals(300, score);
   }

   @Test
   public void normalGame() throws Exception {
      Bowling game = new Bowling("X|7/|9-|X|-8|8/|-6|X|X|X||81");

      int score = game.score();

      assertEquals(167, score);
   }
}
