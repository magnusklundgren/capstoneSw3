package simulator;

public class SpecialWeaponBuilder {

    public static SpecialWeapon buildSlowHeavyWeapon() {
      return new SpecialWeapon(50, 50, 200, "crush", 200, 8, 50);
    }
}
