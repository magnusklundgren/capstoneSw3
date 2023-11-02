package simulator;

public class Weapon {
    private int stab, slash, crush, magic, ranged, strength;
    private String style;

    private int speed;
    private int travelTime;

    public Weapon(int stab, int slash, int crush, int magic, int ranged, String style, int strength, int speed) {
        this.stab = stab;
        this.slash = slash;
        this.crush = crush;
        this.magic = magic;
        this.ranged = ranged;
        this.style = style;
        this.speed = speed;
        this.strength = strength;
        this.travelTime = 0;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStrength() {
        return strength;
    }

    public String getStyle() {
        return style;
    }

    public int getWeaponBonus(String style ) {
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
            default -> {
                return 0;
            }
        }
    }
}
