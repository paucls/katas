package com.katas;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BowlingGameTest {

    @Test
    public void should_have_score_zero_when_all_gutter_balls() {
        BowlingGame bowlingGame = new BowlingGame(new int[]{
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

        assertThat(bowlingGame.score()).isZero();
    }

    @Test
    public void should_have_score_the_sum_of_pins_when_no_spares_or_strikes() {
        BowlingGame bowlingGame = new BowlingGame(new int[]{
                1, 2, 3, 4, 5, 1, 2, 3, 4, 5,
                1, 2, 3, 4, 5, 1, 2, 3, 4, 5});

        assertThat(bowlingGame.score()).isEqualTo(60);
    }

    @Test
    public void should_calculate_score_considering_spares() {
        BowlingGame bowlingGame = new BowlingGame(new int[]{
                5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5});
        assertThat(bowlingGame.score()).isEqualTo(150);
    }

    @Test
    public void should_calculate_score_considering_strikes() {
        BowlingGame bowlingGame = new BowlingGame(new int[]{
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10});

        assertThat(bowlingGame.score()).isEqualTo(300);
    }
}
