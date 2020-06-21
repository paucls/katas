import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShapesTest {

    @Test
    public void rock_beats_scissor() {
        Shape rock = new Rock();
        Shape scissor = new Scissor();
        assertThat(rock.beats(scissor)).isTrue();
    }
}
