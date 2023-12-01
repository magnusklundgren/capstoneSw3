//Magnus Kirkeskov Lundgren - sd48tq@student.aau.dk
package simulator;

import java.util.Random;

public class Simulator {

    private Random rand = new Random();
    private Player player;
    private Npc npc;

    public Simulator(Player player, Npc npc) {
        this.player = player;
        this.npc = npc;
    }

    public void doSim(int n) {
        if(n <= 0) {
            String msg = "Number of runs must be greater than 0";
            throw new IllegalArgumentException(msg);
        } else {
            int res1 = fight();
            int sum = res1;
            int fastest = res1;
            int slowest = res1;

            for (int i = 0; i < n - 1; i++) {
                int res = fight();
                fastest = Math.min(res, fastest);
                slowest = Math.max(res, slowest);

                sum += res;
            }
            int avg = sum / n;

            System.out.println("Fastest kill was: " + fastest);
            System.out.println("Slowest kill was: " + slowest);
            System.out.println("Average kill was: " + avg);
            System.out.println("");
        }
    }

    public int fight() {
        int time = 0;
        int npcHealth = npc.getHp();
        int weaponSpeed = player.getWeaponSpeed();
        boolean playerHasSpecialWeapon = player.hasSpecialAttackWeapon();
        int specialCost = playerHasSpecialWeapon ?
                player.getSpecialAttackWeaponCost() : 110;
        int specialSpeed = playerHasSpecialWeapon ?
                player.getSpecialSpeed() : 0;

        //regenerate 10 specialEnergy every 50 time, counter keeps track of cycles regenerated
        int specialRegenCounter = 0;

        while (npcHealth > 0) {
            if (time/50 > specialRegenCounter) {
                player.regenSpAttack();
                specialRegenCounter += 1;
            }

            int dmg;
            if (playerHasSpecialWeapon && player.getSpAttack() - specialCost >=0) {
                player.useSpecialAttack();
                dmg = doSpecial();
                System.out.println("Special damage: "+ dmg);
                time += specialSpeed;
            } else {
                dmg = this.doAttack();
                time += weaponSpeed;
            }
            npcHealth -= dmg;

        }
        player.resetSpecialAttack();
        return time;
    }

    private int doAttack () {
        int attackRoll = this.player.attackRoll();
        int defenceRoll = this.npc.getDefenceRoll(this.player.getWeaponStyle());

        if (attackRoll > defenceRoll) {
            return player.doHit();
        } else {
            return 0;
        }
    }


    private int doSpecial() {
        int attackRoll = this.player.specialAttackRoll();
        int defenceRoll = this.npc.getDefenceRoll(this.player.getSpecialAttackWeaponStyle());

        if (attackRoll > defenceRoll) {
            return player.doSpecialHit();
        } else {
            return 0;
        }
    }
}
