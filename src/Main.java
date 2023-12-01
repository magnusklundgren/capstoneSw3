//Magnus Kirkeskov Lundgren - sd48tq@student.aau.dk
import simulator.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*Main used to show examples of how to run the program*/

        Player p1 = PlayerBuilder.buildBaseStats();
        Npc n1 = NpcBuilder.buildNex();

        Weapon rapier = WeaponBuilder.buildRapier();

        GearSet maxStrength = GearSetBuilder.buildMaxStrength();
        GearSet midStrength = GearSetBuilder.buildMidStrength();

        p1.setWeapon(rapier);
        p1.setGear(maxStrength);

        Simulator sim = new Simulator(p1, n1);

        sim.doSim(1000);

        p1.setGear(midStrength);
        sim.doSim(1000);


        Player p2 = PlayerBuilder.buildMaxGearMace();
        Npc n2 = NpcBuilder.buildSpider();

        Simulator sim2 = new Simulator (p2, n2);

        sim2.doSim(1000);

        Player p3 = PlayerBuilder.buildMaxGearMace();
        SpecialWeapon p3Special = SpecialWeaponBuilder.buildSlowHeavyWeapon();

        p3.setSpecialAttackWeapon(p3Special);

        Simulator sim3 = new Simulator(p3, n2);

        sim3.doSim(1000);
    }
}