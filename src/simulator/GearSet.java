package simulator;

public class GearSet {
    private int stab, slash, crush, magic, ranged, strength;

    public GearSet(int stab, int slash, int crush, int magic, int ranged, int strength) {
        this.stab = stab;
        this.slash = slash;
        this.crush = crush;
        this.magic = magic;
        this.ranged = ranged;
        this.strength = strength;
    }

    public int attackBonus(String style) {
        switch (style) {
            case "stab" -> {
                return stab;
            }
            case "slash" -> {
                return slash;
            }
            case "crush" -> {
                return crush;
            }
            case "ranged" -> {
                return ranged;
            }
            case "magic" -> {
                return magic;
            }
            default ->{
                return 0;
            }
        }
    }

    public int getStrength() {
        return strength;
    }
}
