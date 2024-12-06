package com.ss.jumpgame;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class JumpGameTest {

    @Test
    public void firstElementZero_canJump() {
        JumpGame game = new JumpGame();

        assertThat(game.canJump(new int[]{0}), is(true));
        assertThat(game.canJump(new int[]{1}), is(true));
        assertThat(game.canJump(new int[]{1, 0, 0}), is(false));
        assertThat(game.canJump(new int[]{2, 0, 0}), is(true));
        assertThat(game.canJump(new int[]{1, 1, 0}), is(true));
        assertThat(game.canJump(new int[]{1,2,0,1,0}), is(true));
        assertThat(game.canJump(new int[]{1,2,1,0,1}), is(false));
    }
}
