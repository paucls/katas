package codingdojo

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test
import kotlin.test.assertEquals

class PlayerTest {

    @Test
    fun damageCalculationsWithMocks() {
        val inventory: Inventory = mock()
        val stats: Stats = mock()
        val target: SimpleEnemy = mock()
        whenever(target.armor).thenReturn(SimpleArmor(5))

        val leftHand = BasicItem("sword", 10, 1.0F)
        val rightHand = BasicItem("shield", 0, 1.4F)
        val head = BasicItem("helmet", 0, 1.2F)
        val feet = BasicItem("boots", 0, 0.1F)
        val chest = BasicItem("breastplate", 0, 1.4F)
        val equipment = Equipment(leftHand, rightHand, head, feet, chest)
        whenever(inventory.equipment).thenReturn(equipment)

        val damage = Player(inventory, stats).calculateDamage(target)

        assertEquals(50, damage.amount)
    }
}
