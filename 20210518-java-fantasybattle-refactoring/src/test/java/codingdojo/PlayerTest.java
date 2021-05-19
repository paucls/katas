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
        BasicItem sword = new BasicItem("sword", 10, 1);
        BasicItem zeroDamageItem = new BasicItem("empty hand", 0, 0);
        Equipment equipment = new Equipment(sword, zeroDamageItem, zeroDamageItem, zeroDamageItem, zeroDamageItem);
        Inventory inventory = new Inventory(equipment);
        Stats stats = new Stats(0);
        SimpleEnemy target = new SimpleEnemy(new SimpleArmor(0), Collections.emptyList());

        Damage damage = new Player(inventory, stats).calculateDamage(target);

        assertEquals(10, damage.getAmount());
    }
}
