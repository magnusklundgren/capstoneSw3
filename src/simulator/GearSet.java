package simulator;

public class GearSet {
    private int stab, slash, crush, strength;

    public GearSet(int stab, int slash, int crush, int strength) {
        this.stab = stab;
        this.slash = slash;
        this.crush = crush;
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
            default ->{
                return 0;
            }
        }
    }

    public int getStrength() {
        return strength;
    }
}
