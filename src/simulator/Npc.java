//Magnus Kirkeskov Lundgren - sd48tq@student.aau.dk
package simulator;
import java.util.Random;

public class Npc {
    private Random rand = new Random();
    private int def, hp;
    private int stabDef, slashDef, crushDef;

    public Npc(int def, int hp, int stabDef, int slashDef, int crushDef) {
        this.def = def;
        this.hp = hp;
        this.stabDef = stabDef;
        this.slashDef = slashDef;
        this.crushDef = crushDef;
    }

    public int getDefenceRoll(String style) {
        int styleDefence = getTargetStyleDefence(style);
        int maxDefenceRoll = (this.def + 9) * (styleDefence + 64);

        int defenceRoll = rand.nextInt(maxDefenceRoll);

        return defenceRoll;

    }

    private int getTargetStyleDefence(String style) {
        switch (style) {
            case "stab" -> {
                return this.stabDef;
            }
            case "crush" -> {
                return this.crushDef;
            }
            case "slash" -> {
                return this.slashDef;
            }
            default -> {
                return 0;
            }
        }
    }

    public int getHp() {
        return hp;
    }
}
