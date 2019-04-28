package com.katas;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    @Test
    public void gives_score_of_gutter_game() {
        BowlingGame game = new BowlingGame(List.of(
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

        assertThat(game.score()).isZero();
    }

    @Test
    public void gives_score_when_one_pin_knocked_down_per_roll() {
        BowlingGame game = new BowlingGame(List.of(
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));

        assertThat(game.score()).isEqualTo(20);
    }

    @Test
    public void gives_score_when_spares_in_every_round() {
        BowlingGame game = new BowlingGame(List.of(
                5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5));

        assertThat(game.score()).isEqualTo(150);
    }
}
