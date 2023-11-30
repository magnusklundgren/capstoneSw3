import simulator.*;

public class Main {
    public static void main(String[] args) {
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

    }
}