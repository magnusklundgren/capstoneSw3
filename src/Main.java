import simulator.Npc;
import simulator.Player;
import simulator.Simulator;

public class Main {
    public static void main(String[] args) {

        Player p1 = new Player(99,99,99,99);
        Npc n1 = new Npc(100, 100, 100, 100, 100, 100, 100, 100, 3);

        Simulator sim = new Simulator(p1, n1);

        int res = sim.fight();

        System.out.println(res);

    }
}