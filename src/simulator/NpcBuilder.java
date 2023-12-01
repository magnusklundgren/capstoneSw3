//Magnus Kirkeskov Lundgren - sd48tq@student.aau.dk
package simulator;

public class NpcBuilder {
    public static Npc buildNex() {
        return new Npc(260, 3400, 40, 140, 60);
    }

    public static Npc buildSpider() {
        return new Npc(150, 400, 60, 40, 10);
    }
}
