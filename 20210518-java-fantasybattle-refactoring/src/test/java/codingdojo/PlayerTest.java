package codingdojo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class PlayerTest {

    // choose this one if you are familiar with mocks
    @Disabled("Test is not finished yet")
    @Test
    void damageCalculationsWithMocks() {
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        SimpleEnemy target = mock(SimpleEnemy.class);

        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(10, damage.getAmount());
    }

    // choose this one if you are not familiar with mocks
    @Test
    void damageCalculations() {
        BasicItem leftHand = new BasicItem("sword", 10, 1.0F);
        BasicItem rightHand = new BasicItem("shield", 0, 1.4F);
        BasicItem head = new BasicItem("helmet", 0, 1.2F);
        BasicItem feet = new BasicItem("boots", 0, 0.1F);
        BasicItem chest = new BasicItem("breastplate", 0, 1.4F);
        Equipment equipment = new Equipment(leftHand, rightHand, head, feet, chest);
        Inventory inventory = new Inventory(equipment);
        Stats stats = new Stats(0);
        SimpleEnemy target = new SimpleEnemy(new SimpleArmor(5), Collections.emptyList());

        Damage damage = new Player(inventory, stats).calculateDamage(target);

        assertEquals(46, damage.getAmount());
    }
}
