//Magnus Kirkeskov Lundgren - sd48tq@student.aau.dk
package simulator;

public class PlayerBuilder {
    public static Player buildBaseStats() {
        return new Player(99,99);
    }

    public static Player buildBoostedStats() {
        return new Player(145,147);
    }

    public static Player buildMaxGearMace() {
        Weapon mace = WeaponBuilder.buildMace();
        GearSet maxGear = GearSetBuilder.buildMaxStrength();
        return new Player(145, 147, maxGear, mace);
    }
}
