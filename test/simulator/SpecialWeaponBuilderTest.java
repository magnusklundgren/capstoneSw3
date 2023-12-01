//Magnus Kirkeskov Lundgren - sd48tq@student.aau.dk
package simulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialWeaponBuilderTest {
    SpecialWeapon testSpecialWeapon = null;

    @BeforeEach
    void buildSlowHeavyWeapon() {
        testSpecialWeapon = SpecialWeaponBuilder.buildSlowHeavyWeapon();
    }

    @Test
    void specialWeaponNotNull() {
        assertNotNull(testSpecialWeapon);
    }

    @Test
    void getCost() {
        int cost  = testSpecialWeapon.getCost();
        assertEquals(50, cost);
    }
}