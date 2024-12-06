package com.ss.jumpgame;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int goal = 0;
        for (int i = nums.length-1; i > -1; i--) {
            if (i + nums[i] >= goal){
                goal = i;
            }
        }
        return goal == 0;
    }
}
