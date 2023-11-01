import simulator.*;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player(141,145,99,99);
        Npc n1 = new Npc(260, 100, 3400, 40, 140, 60, 100, 100, 3);

        Weapon rapier = new Weapon(94,55,0,0,0, "stab", 89, 4);
        Weapon saeldor = new Weapon(55,94,0,0,0,"slash", 89,4);

        GearSet maxStrength = new GearSet(67, 66, 65, -71, -50,75);
        GearSet midStrength = new GearSet(48,47,46,-50,13,54);

        p1.setWeapon(rapier);
        p1.setGear(maxStrength);

        Simulator sim = new Simulator(p1, n1);

//        int res = sim.fight();
        sim.doSim(100000);
        p1.setGear(midStrength);

//        int res2 = sim.fight();

//        System.out.println(res);
//        System.out.println(res2);
        sim.doSim(100000);

    }
}