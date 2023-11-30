package simulator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;


class WeaponTest {

    Weapon testWeapon = null;

    @BeforeEach
    public void createWeapon () {
        testWeapon = new Weapon(100, 200, 300, "crush", 50, 4);
    }


    @Test
    public void weaponExists() {
        assertNotNull(testWeapon);
    }


    @Test
    void getStyle() {
        assertEquals("crush", testWeapon.getStyle());
    }

    @Test
    void getWeaponBonus() {
        assertEquals(100, testWeapon.getWeaponBonus("stab"));
        assertEquals(200, testWeapon.getWeaponBonus("slash"));
        assertEquals(300, testWeapon.getWeaponBonus("crush"));

    }
}