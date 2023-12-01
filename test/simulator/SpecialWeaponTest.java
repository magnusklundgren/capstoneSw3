//Magnus Kirkeskov Lundgren - sd48tq@student.aau.dk
package simulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialWeaponTest {

    SpecialWeapon testSpecialWeapon = null;

    @BeforeEach
    void createSpecialWeapon() {
        testSpecialWeapon = new SpecialWeapon(100,200, 300, "crush", 75, 4, 50);
    }

    @Test
    void getCost() {
        assertEquals(50, testSpecialWeapon.getCost());
    }

    @Test
    void costOver100() {
        SpecialWeapon testSpecialWeapon2 = new SpecialWeapon(100, 200, 300, "crush", 75, 4, 200);
        assertEquals(100, testSpecialWeapon2.getCost());
    }

    @Test
    void getStrength() {
        int strength = testSpecialWeapon.getStrength();
        for (int i = 0; i < 10; i++) {
            assertTrue(strength >= 75 && strength <= 150);
        }
    }

    @Test
    void getWeaponBonus() {
        int bonus = testSpecialWeapon.getWeaponBonus("crush");
        assertEquals(600, bonus);
    }
}