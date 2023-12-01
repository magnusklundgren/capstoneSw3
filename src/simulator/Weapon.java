//Magnus Kirkeskov Lundgren - sd48tq@student.aau.dk
package simulator;

public class Weapon {
    protected int stab, slash, crush, strength;
    protected String style;

    protected int speed;

    public Weapon(int stab, int slash, int crush, String style, int strength, int speed) {
        this.stab = stab;
        this.slash = slash;
        this.crush = crush;
        this.style = style;
        this.speed = speed;
        this.strength = strength;
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
