package com.katas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.list;

public class BowlingGameTest {
    @Test
    public void should_have_score_0_when_all_gutter_balls() {
        BowlingGame game = new BowlingGame(list(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    public void should_have_as_score_the_sum_of_all_pins_when_no_strikes_or_spares() {
        BowlingGame game = new BowlingGame(list(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5));

        assertThat(game.score()).isEqualTo(60);
    }

    @Test
    public void should_have_score_150_when_a_spare_in_every_frame() {
        BowlingGame game = new BowlingGame(list(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5));

        assertThat(game.score()).isEqualTo(150);
    }

    @Test
    public void should_have_score_300_when_is_perfect_game_with_all_strikes() {
        BowlingGame game = new BowlingGame(list(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));

        assertThat(game.score()).isEqualTo(300);
    }
}
