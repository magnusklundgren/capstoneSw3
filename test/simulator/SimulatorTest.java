//Magnus Kirkeskov Lundgren - sd48tq@student.aau.dk
package simulator;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulatorTest {

    Simulator testSim;

    @BeforeEach
    void createSim(){
        Player testPlayer = PlayerBuilder.buildMaxGearMace();
        Npc testNpc = NpcBuilder.buildSpider();

        testSim = new Simulator(testPlayer, testNpc);
    }

    @Test
    void doSim() {
        assertDoesNotThrow(() -> {
            testSim.doSim(100);
        });
    }

    @Test
    void simNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            testSim.doSim(-10);
        });
    }

    @Test
    void fight() {
        int res = testSim.fight();
        //test multiple times, because randomizer involved
        for (int i = 0; i < 100; i++) {
            assertTrue(res > 0);
        }
    }
}