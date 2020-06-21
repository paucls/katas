import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShapesTest {

    @Test
    public void rock_beats_scissor() {
        Shape rock = new Rock();
        Shape scissors = new Scissors();
        assertThat(rock.beats(scissors)).isTrue();
    }

    @Test
    public void scissors_does_not_beat_rock() {
        Shape rock = new Rock();
        Shape scissors = new Scissors();
        assertThat(scissors.beats(rock)).isFalse();
    }
}
