package simulator;

public class WeaponBuilder {

    public static Weapon buildRapier() {
        return new Weapon(94,55,0, "stab", 89, 4);
    }

    public static Weapon buildSaeldor() {
        return new Weapon(55,94,0,"slash", 89,4);
    }

    public static Weapon buildMace() {
        return new Weapon(52, -4, 95 , "crush", 89, 4);
    }
}
