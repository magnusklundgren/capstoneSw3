//Magnus Kirkeskov Lundgren - sd48tq@student.aau.dk
package simulator;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NpcTest {
    Npc testNPC = null;


    @BeforeEach
    void createNpc () {
        testNPC = new Npc(200, 1000, 50, 100, 200);
    }

    @Test
    void npcCreated() {
        assertNotNull(testNPC);
    }


    //Testing random return value
    @Test
    void getDefenceRoll() {
        int defenceRoll = testNPC.getDefenceRoll("stab");
        for (int i = 0; i < 100; i++) {
            assertTrue(defenceRoll >= 0 && defenceRoll < 23826);
        }
    }
}