import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShapesTest {

    @Test
    public void rock_beats_scissor() {
        Shape rock = new Rock();
        Shape scissor = new Scissor();
        assertThat(rock.beats(scissor)).isTrue();
    }

    @Test
    public void scissors_does_not_beat_rock() {
        Shape rock = new Rock();
        Shape scissors = new Scissor();
        assertThat(scissors.beats(rock)).isFalse();
    }
}
