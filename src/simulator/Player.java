package simulator;

public class Player {
    int attack, strength, ranged, magic;
    int spAttack;

    GearSet gear;

    Weapon weapon;

    public Player(int attack, int strength, int ranged, int magic) {
        this.attack = attack;
        this.strength = strength;
        this.ranged = ranged;
        this.magic = magic;
        this.spAttack = 100;
    }

    //performs calculation of an attack on opponent
    public int doAttack(){
        return 10;
    }

    //returns highest style based on weapon and gear.
    private String getStyle() {
        return "Slash";
    }

}
