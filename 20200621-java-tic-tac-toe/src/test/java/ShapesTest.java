import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShapesTest {

    private final Shape rock = new Rock();
    private final Shape scissors = new Scissors();
    private Shape paper = new Paper();

    @Test
    public void rock_beats_scissor() {
        assertThat(rock.beats(scissors)).isTrue();
    }

    @Test
    public void scissors_does_not_beat_rock() {
        assertThat(scissors.beats(rock)).isFalse();
    }

    @Test
    public void scissors_beats_paper() {
        assertThat(scissors.beats(paper)).isTrue();
    }
}
