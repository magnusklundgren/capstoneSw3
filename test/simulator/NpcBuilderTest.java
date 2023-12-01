//Magnus Kirkeskov Lundgren - sd48tq@student.aau.dk
package simulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NpcBuilderTest {
    Npc testNpc = null;

    @BeforeEach
    void buildTestNpc() {
        testNpc = NpcBuilder.buildNex();
    }

    @Test
    void testNpcCreated() {
        assertNotNull(testNpc);
    }

    @Test
    void getNpcStats() {
        assertEquals(3400, testNpc.getHp());
    }
}