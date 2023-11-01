package simulator;

public class Simulator {
    Player player;
    Npc npc;

    public Simulator(Player player, Npc npc) {
        this.player = player;
        this.npc = npc;
    }

    public int fight() {
        int time = 0;
        int weaponSpeed = 5;

        while (this.npc.hp > 0) {
            int dmg = this.player.doAttack();
            this.npc.hp -= dmg;
            time += weaponSpeed;

        }
//        return time + this.player.weapon.speed;
        return time;
    }
}
