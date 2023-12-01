package simulator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponBuilderTest {

    Weapon testWeapon = null;

    @Test
    void buildRapier() {
        testWeapon = WeaponBuilder.buildRapier();
        assertNotNull(testWeapon);
        assertEquals(94, testWeapon.getWeaponBonus("stab"));
    }
}