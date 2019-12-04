package com.katas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShapeTest {

    private final Shape paper = new Paper();
    private final Shape rock = new Rock();
    private final Shape scissors = new Scissors();

    @Test
    public void paper_beats_rock() {
        assertThat(paper.beats(rock)).isEqualTo(true);
    }

    @Test
    public void rock_does_not_beat_paper() {
        assertThat(rock.beats(paper)).isEqualTo(false);
    }

    @Test
    public void scissors_does_not_beat_rock() {
        assertThat(scissors.beats(rock)).isEqualTo(false);
    }

    @Test
    public void rock_beats_scissors() {
        assertThat(rock.beats(scissors)).isEqualTo(true);
    }

    @Test
    public void scissors_beats_paper() {
        assertThat(scissors.beats(paper)).isEqualTo(true);
    }

    @Test
    public void paper_does_not_beat_scissors() {
        assertThat(paper.beats(scissors)).isEqualTo(false);
    }
}
