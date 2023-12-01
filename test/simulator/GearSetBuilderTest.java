//Magnus Kirkeskov Lundgren - sd48tq@student.aau.dk
package simulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GearSetBuilderTest {

    GearSet testBuildGearSet = null;

    @BeforeEach
    void buildMaxStrength() {
        testBuildGearSet = GearSetBuilder.buildMaxStrength();
    }

    @Test
    void testGearSetExists() {
        assertNotNull(testBuildGearSet);
    }

    @Test
    void testStatsSetCorrectly() {
        assertEquals(67, testBuildGearSet.attackBonus("stab"));
    }
}