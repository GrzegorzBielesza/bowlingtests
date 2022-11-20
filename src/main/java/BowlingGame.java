public class BowlingGame {

    int[] rolls = new int[21];
    int roll = 0;

    int index = 0;

    int getScore() {
        int score = 0;
        for(int frame = 0; frame<10; frame++){
            if(isStrike()) {
                score += 10 + rolls[index+1] + rolls[index+2];
                index++;
            }
            else if(isSpare()){
                score += 10 + rolls[index+2];
                index+=2;
            } else{
                score+=rolls[index] + rolls[index+1];
                index+=2;
            }
        }
        return score;
    }

    private boolean isSpare() {
        return rolls[index] + rolls[index+1] == 10;
    }

    private boolean isStrike() {
        return rolls[index] == 10;
    }

    void roll(int pins) {
        if(pins>=0 && pins<=10) {
            rolls[roll++] = pins; }
        else { throw new IllegalArgumentException("Bowling pins cannot have a negative value");}
    }
}
