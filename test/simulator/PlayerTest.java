//Magnus Kirkeskov Lundgren - sd48tq@student.aau.dk
package simulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simulator.Exceptions.IllegalSpecialAttackValue;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player testPlayer = null;
    GearSet testGear = new GearSet(100, 100, 100, 50);
    Weapon testWeapon = new Weapon(100, 100, 100, "slash", 80, 4);
    SpecialWeapon testSpecialWeapon = new SpecialWeapon(100, 100, 100, "stab", 50, 2, 50);


    @BeforeEach
    void createTestPlayer() {
        testPlayer = new Player(99, 99, testGear, testWeapon, testSpecialWeapon);
    }

    void testPlayerExists() {
        assertNotNull(testPlayer);
    }

    void testGetWeapon() {
        //would be crush if nothing is passed in constructor, but weapon set is slash
        String weaponStyle = testPlayer.getWeaponStyle();
        assertEquals("slash", weaponStyle);
    }


    @Test
    void doHit() {
        int max = 33;
        for (int i = 0; i < 100; i++) {
            int hit = testPlayer.doHit();
            assertTrue(hit >= 0 && hit <= max);
        }
    }

    @Test
    void doSpecialHit() {
        int max = 36;
        for (int i = 0; i < 100; i++) {
            int hit = testPlayer.doSpecialHit();
            assertTrue(hit >= 0 && hit <= max);
        }

    }

    @Test
    void attackRoll() {
        int max = 28248;
        for (int i = 0; i < 100; i++) {
            int attackRoll = testPlayer.attackRoll();
            assertTrue(attackRoll >= 0 && attackRoll <= max);
        }
    }

    @Test
    void specialAttackRoll() {
        int max = 38948;
        for (int i = 0; i < 100; i++) {
            int specialAttackRoll = testPlayer.specialAttackRoll();
            assertTrue(specialAttackRoll >= 0 && specialAttackRoll <= max);
        }
    }


    @Test
    void useSpAttack() {
        testPlayer.useSpecialAttack();
        assertEquals(50,testPlayer.getSpAttack());
    }


    @Test
    void useSpAttackBelow0() {
        testPlayer.useSpecialAttack();
        testPlayer.useSpecialAttack();
        assertThrows(IllegalSpecialAttackValue.class, () -> {
            testPlayer.useSpecialAttack();
        });
    }

    @Test
    void regenSpAttack() {
        testPlayer.useSpecialAttack();
        testPlayer.regenSpAttack();
        assertEquals(60, testPlayer.getSpAttack());
    }

    @Test
    void regenSpecialAttackOver100 () {
        testPlayer.regenSpAttack();
        assertEquals(100, testPlayer.getSpAttack());
    }
}