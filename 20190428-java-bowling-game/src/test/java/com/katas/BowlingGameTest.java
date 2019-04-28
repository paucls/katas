package com.katas;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    @Test
    public void gives_score_of_gutter_game() {
        var rolls = List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        BowlingGame game = new BowlingGame(rolls);

        int score = game.score();

        assertThat(score).isZero();
    }
}
