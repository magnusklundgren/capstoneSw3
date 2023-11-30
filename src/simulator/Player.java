package simulator;
import java.util.Random;

public class Player {

    private Random rand = new Random();
    private int attack, strength;
    private int spAttack;


    private GearSet gear;

    private Weapon weapon;
    private SpecialWeapon specialAttackWeapon = null;

    public Player(int attack, int strength) {
        this.attack = attack;
        this.strength = strength;
        this.spAttack = 100;
        this.weapon = new Weapon(0,0,0,"crush", 0, 4);
        this.gear = new GearSet(0,0,0, 0);
    }

    public Player(int attack, int strength, GearSet gear) {
        this.attack = attack;
        this.strength = strength;
        this.gear = gear;
        this.spAttack = 100;
        this.weapon = new Weapon(0,0,0,"crush", 0, 4);
    }

    public Player(int attack, int strength, Weapon weapon) {
        this.attack = attack;
        this.strength = strength;
        this.weapon = weapon;
        this.spAttack = 100;
        this.gear = new GearSet(0,0,0,0);
    }

    public Player(int attack, int strengths, GearSet gear, Weapon weapon) {
        this.attack = attack;
        this.strength = strength;
        this.gear = gear;
        this.weapon = weapon;
        this.spAttack = 100;
    }


    //performs calculation of an attack on opponent
    public int doHit(){
        int weaponStr = weapon.getStrength();
        int gearStr = gear.getStrength();
        int effectiveStrLvl = strength + 8;

        int maxHit = (effectiveStrLvl * (weaponStr+gearStr+64)
                + 420) / 640;

        //roll between 0 and max hit
        return rand.nextInt(maxHit);
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

    public String getSpecialAttackWeaponStyle () {
        return specialAttackWeapon.getStyle();
    }
}
