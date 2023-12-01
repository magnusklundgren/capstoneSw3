//Magnus Kirkeskov Lundgren - sd48tq@student.aau.dk
package simulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GearSetTest {
    GearSet testGearSet = null;

    @BeforeEach
    void createTestGear() {
        testGearSet = new GearSet(100, 200, 300, 50);
    }

    void gearSetNotNull(){
        assertNotNull(testGearSet);
    }

    @Test
    void attackBonus() {
        assertEquals(100, testGearSet.attackBonus("stab"));
        assertEquals(200, testGearSet.attackBonus("slash"));
        assertEquals(300, testGearSet.attackBonus("crush"));
    }
}