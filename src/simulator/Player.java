package simulator;
import java.util.Random;

public class Player {

    Random rand = new Random();
    private int attack, strength, ranged, magic;
    private int spAttack;

    private GearSet gear;

    private Weapon weapon;

    public Player(int attack, int strength, int ranged, int magic) {
        this.attack = attack;
        this.strength = strength;
        this.ranged = ranged;
        this.magic = magic;
        this.spAttack = 100;
        this.weapon = new Weapon(0,0,0,0,0,"crush", 0, 4);
        this.gear = new GearSet(0,0,0,0, 0, 0);
    }

    public Player(int attack, int strength, int ranged, int magic, GearSet gear) {
        this.attack = attack;
        this.strength = strength;
        this.ranged = ranged;
        this.magic = magic;
        this.gear = gear;
        this.weapon = new Weapon(0,0,0,0,0,"crush", 0, 4);
    }

    public Player(int attack, int strength, int ranged, int magic, Weapon weapon) {
        this.attack = attack;
        this.strength = strength;
        this.ranged = ranged;
        this.magic = magic;
        this.weapon = weapon;
        this.gear = new GearSet(0,0,0,0, 0,0);
    }

    public Player(int attack, int strength, int ranged, int magic, GearSet gear, Weapon weapon) {
        this.attack = attack;
        this.strength = strength;
        this.ranged = ranged;
        this.magic = magic;
        this.gear = gear;
        this.weapon = weapon;
    }


    //performs calculation of an attack on opponent
    public int maxHit(){
        int weaponStr = weapon.getStrength();
        int gearStr = gear.getStrength();
        int effectiveStrLvl = strength + 8;

        int maxHit = (effectiveStrLvl * (weaponStr+gearStr+64)
                + 420) / 640;

        return maxHit;
    }

    public int attackRoll () {
        String weaponStyle = this.getWeaponStyle();

        int effectiveAttackLvl = this.attack + 8;
        int weaponBonus = weapon.getWeaponBonus(weaponStyle);
        int gearbonus = gear.attackBonus(weaponStyle);

        int maxRoll = effectiveAttackLvl * (weaponBonus + gearbonus + 64);

        int attackRoll = rand.nextInt(maxRoll);
        return attackRoll;
    }


    public int getWeaponSpeed() {
        return weapon.getSpeed();
    }

    public String getWeaponStyle() {
        return weapon.getStyle();
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setGear(GearSet gear) {
        this.gear = gear;
    }
}
