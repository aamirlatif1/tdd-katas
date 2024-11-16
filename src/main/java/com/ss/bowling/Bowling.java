package com.ss.bowling;

import java.util.ArrayList;
import java.util.List;

public class Bowling {
    private List<Integer> rolls;

    public Bowling(String card){
        rolls = new ArrayList<>();
        String[] frames = card.split("\\|");
        for (int i = 0; i < 10; i++) {
            String frame = frames[i];
            if(frame.equals("X")) {
                rolls.add(10);
            } else if(frame.charAt(1) == '/') {
                int firstRoll = getSlotValue(frame.charAt(0));
                rolls.add(firstRoll);
                rolls.add(10-firstRoll);
            } else {
                rolls.add(getSlotValue(frame.charAt(0)));
                rolls.add(getSlotValue(frame.charAt(1)));
            }
        }
        String lastBonus = card.substring(card.indexOf("||")+2);
        if(lastBonus.length() > 1) {
            rolls.add(getSlotValue(lastBonus.charAt(0)));
            rolls.add(getSlotValue(lastBonus.charAt(1)));
        } else if(lastBonus.length() == 1) {
            rolls.add(getSlotValue(lastBonus.charAt(0)));
            rolls.add(0);
        } else {
            rolls.add(0);
            rolls.add(0);
        }

    }

    private int getSlotValue(char frameSlot) {
        if (frameSlot == 'X') return 10;
        return frameSlot == '-' ? 0 : frameSlot - '0';
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else if(isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += frameScore(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private int frameScore(int slotIndex) {
        return rolls.get(slotIndex) + rolls.get(slotIndex + 1);
    }

    private Integer spareBonus(int slotIndex) {
        return rolls.get(slotIndex + 2);
    }

    private int strikeBonus(int slotIndex) {
        return rolls.get(slotIndex + 1) + rolls.get(slotIndex + 2);
    }

    private boolean isSpare(int slotIndex) {
        return rolls.get(slotIndex) + rolls.get(slotIndex + 1) == 10;
    }

    private boolean isStrike(int slotIndex) {
        return rolls.get(slotIndex) == 10;
    }
}
