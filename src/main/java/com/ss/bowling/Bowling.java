package com.ss.bowling;

public class Bowling {

    public static final int LAST_FRAME_BONUS = 11;

    public int score(String game) {
        int score = 0;
        String[] frames = game.split("\\|");
        for (int frameIndex = 0; frameIndex < 10; frameIndex++) {
            String frame = frames[frameIndex];
            if (isStrike(frame)) {
                score += 10 + strikeBonus(frameIndex + 1, frames);
            } else if (isSpare(frame)) {
                score += 10 + spareBonus(frameIndex + 1, frames);
            } else {
                score += frameScores(frame);
            }
        }
        return score;
    }

    private int spareBonus(int bonusFrame, String[] frames) {
        if (isLastFrame(bonusFrame)) {
            bonusFrame++;
        }
        return rollScore(frames[bonusFrame], 0);
    }

    private int strikeBonus(int bonusFrame, String[] frames) {
        if (isLastFrame(bonusFrame)) {
            return frameScores(frames[LAST_FRAME_BONUS]);
        } else if (isStrike(frames[bonusFrame])) {
            if (isLastFrame(bonusFrame + 1)) {
                bonusFrame++;
            }
            return 10 + rollScore(frames[bonusFrame + 1], 0);
        } else {
            return frameScores(frames[bonusFrame]);
        }
    }

    private static boolean isLastFrame(int frameIndex) {
        return frameIndex == 10;
    }

    private static boolean isSpare(String frame) {
        return frame.charAt(1) == '/';
    }

    private int frameScores(String frame) {
        if (frame.charAt(1) == '/') return 10;
        return rollScore(frame, 0) + rollScore(frame, 1);
    }

    private static boolean isStrike(String frame) {
        return frame.charAt(0) == 'X';
    }

    private int rollScore(String frame, int rollIndex) {
        if (frame.charAt(rollIndex) == 'X') return 10;
        if (frame.charAt(rollIndex) != '-') {
            return frame.charAt(rollIndex) - '0';
        }
        return 0;
    }

}
