//Magnus Kirkeskov Lundgren - sd48tq@student.aau.dk
package simulator;

public class GearSetBuilder {
    public static GearSet buildMaxStrength() {
        return new GearSet(67, 66, 65 ,75);
    }

    public static GearSet buildMidStrength() {
        return new GearSet(48,47,46,54);
    }
}
