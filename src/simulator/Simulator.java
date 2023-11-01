package simulator;
import java.util.Random;

public class Simulator {

    Random rand = new Random();
    Player player;
    Npc npc;

    public Simulator(Player player, Npc npc) {
        this.player = player;
        this.npc = npc;
    }

    public void doSim(int n) {
        int res1 = fight();
        int sum = res1;
        int fastest = res1;
        int slowest = res1;

        for (int i = 0; i < n-1; i++) {
            int res = fight();
            fastest = Math.min(res, fastest);
            slowest = Math.max(res, slowest);

            sum += res;
        }
        int avg = sum/n;

        System.out.println("Fastest kill was: " + fastest);
        System.out.println("Slowest kill was: " + slowest);
        System.out.println("Average kill was: " + avg);
        System.out.println("");
    }

    public int fight() {
        int time = 0;
        int npcHealth = npc.hp;
        int weaponSpeed = player.getWeaponSpeed();
        int maxHit = player.maxHit();

        while (npcHealth > 0) {
            int dmg = this.doAttack(maxHit);
            npcHealth -= dmg;
            time += weaponSpeed;

        }
//        return time + this.player.weapon.speed;
        return time;
    }

    private int doAttack (int maxHit) {
        int attackRoll = this.player.attackRoll();
        int defenceRoll = this.npc.getDefenceRoll(this.player.getWeaponStyle());

        if (attackRoll > defenceRoll) {
            int hit = rand.nextInt(maxHit);
            return hit;
        } else {
            return 0;
        }
    }
}
