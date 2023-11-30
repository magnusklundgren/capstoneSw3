package simulator;

public class SpecialWeapon extends Weapon{
    private int stab, slash, crush, strength;
    private String style;

    private int speed;

    private int cost;

    public SpecialWeapon(int stab, int slash, int crush, String style, int strength, int speed, int cost) {
        super(stab, slash, crush, style, strength, speed);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int getWeaponBonus(String style) {
        switch (style) {
            case "stab" -> {
                return stab*2;
            }
            case "slash" -> {
                return slash*2;
            }
            case "crush" -> {
                return crush*2;
            }
            default -> {
                return 0;
            }
        }
    }
}
