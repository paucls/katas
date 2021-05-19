package codingdojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {

    @Test
    void damageCalculations() {
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        SimpleEnemy target = mock(SimpleEnemy.class);

        BasicItem sword = new BasicItem("sword", 10, 1);
        BasicItem zeroDamageItem = new BasicItem("empty hand", 0, 0);
        Equipment equipment = new Equipment(sword, zeroDamageItem, zeroDamageItem, zeroDamageItem, zeroDamageItem);

        when(inventory.getEquipment()).thenReturn(equipment);
        when(target.getArmor()).thenReturn(new SimpleArmor(0));

        // act
        Damage damage = new Player(inventory, stats).calculateDamage(target);

        // assert
        assertEquals(10, damage.getAmount());
    }

    @Test
    void damageCalculationsShouldBeZeroAgainstOtherPlayers() {
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        Player target = mock(Player.class);

        BasicItem sword = new BasicItem("sword", 10, 1);
        BasicItem zeroDamageItem = new BasicItem("empty hand", 0, 0);
        Equipment equipment = new Equipment(sword, zeroDamageItem, zeroDamageItem, zeroDamageItem, zeroDamageItem);

        when(inventory.getEquipment()).thenReturn(equipment);

        // act
        Damage damage = new Player(inventory, stats).calculateDamage(target);

        // assert
        assertEquals(0, damage.getAmount());
    }
}
