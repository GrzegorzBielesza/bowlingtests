import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BowlingGameTest {

    BowlingGame game = new BowlingGame();

    @Test
    public void score_returns0points_ifAllThrowsMissed() throws Exception {
        // When
        IntStream.range(0,20).forEach(roll->game.roll(0));
        int score = game.getScore();
        // Then
        assertThat(score).isEqualTo(0);
    }

    @Test
    public void score_returns20points_ifOnePointScoredTwentyTimes() throws Exception {
        // When
        IntStream.range(0,20).forEach(roll->game.roll(1));
        int score = game.getScore();
        // Then
        assertThat(score).isEqualTo(20);

    }

    @Test
    public void score_returns14points_ifTwoPointsScoredAfterSpare() {
        // When
        game.roll(5);
        game.roll(5);
        game.roll(2);
        IntStream.range(0,17).forEach(roll->game.roll(0));
        int score = game.getScore();
        // Then
        assertThat(score).isEqualTo(14);
    }

    @Test
    public void score_returns20points_ifFivePointsScoredAfterStrike(){
        // When
        game.roll(10);
        game.roll(5);
        IntStream.range(0,18).forEach(roll->game.roll(0));
        int score = game.getScore();
        // Then
        assertThat(score).isEqualTo(20);
    }

    @Test
    public void score_returns300points_ifPerfectGame() {
        // When
        IntStream.range(0,20).forEach(roll->game.roll(10));
        int score = game.getScore();
        // Then
        assertThat(score).isEqualTo(300);
    }

    @Test
    public void score_failed_ifNegativePointsScored(){

        // Expected
        assertThatThrownBy(() -> {
            game.roll(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void score_failed_ifTooManyPointsScored(){

        // Expected
        assertThatThrownBy(() -> {
            game.roll(11);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
