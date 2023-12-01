//Magnus Kirkeskov Lundgren - sd48tq@student.aau.dk
package simulator;

import java.util.Random;

public class SpecialWeapon extends Weapon{

    private Random rand = new Random();
    private int cost;

    public SpecialWeapon(int stab, int slash, int crush, String style, int strength, int speed, int cost) {
        super(stab, slash, crush, style, strength, speed);
        //default cost to 100 if outside 1-100 range.
        this.cost = cost > 0 ? Math.min(cost, 100) : 100;
    }



    public int getCost() {
        return cost;
    }

    @Override
    public int getStrength() {
        //50/50 to double strength
        int modifier = rand.nextInt(1,3);
        int modifiedStrength = super.strength*modifier;

        return modifiedStrength;
    }

    @Override
    public int getWeaponBonus(String style) {
        switch (style) {
            case "stab" -> {
                return super.stab*2;
            }
            case "slash" -> {
                return super.slash*2;
            }
            case "crush" -> {
                return super.crush*2;
            }
            default -> {
                return 0;
            }
        }
    }
}
