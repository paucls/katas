package com.katas;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    @Test
    public void gives_score_of_gutter_game() {
        var rolls = List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        BowlingGame game = new BowlingGame(rolls);

        assertThat(game.score()).isZero();
    }

    @Test
    public void gives_score_when_one_pin_knocked_down_per_roll() {
        BowlingGame game = new BowlingGame(List.of(
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));

        assertThat(game.score()).isEqualTo(20);
    }
}
