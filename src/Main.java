import simulator.*;

public class Main {
    public static void main(String[] args) {
        //Look into builder classes for Weapon, GearSet, NPC

        Player p1 = PlayerBuilder.buildBaseStats();
        Npc n1 = NpcBuilder.buildNex();

        Weapon rapier = WeaponBuilder.buildRapier();

        GearSet maxStrength = GearSetBuilder.buildMaxStrength();
        GearSet midStrength = GearSetBuilder.buildMidStrength();

        p1.setWeapon(rapier);
        p1.setGear(maxStrength);

        Simulator sim = new Simulator(p1, n1);

//        int res = sim.fight();
        sim.doSim(1000);
        p1.setGear(midStrength);

//        int res2 = sim.fight();

//        System.out.println(res);
//        System.out.println(res2);
        sim.doSim(1000);

    }
}