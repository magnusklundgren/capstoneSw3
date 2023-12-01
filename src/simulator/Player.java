//Magnus Kirkeskov Lundgren - sd48tq@student.aau.dk
package simulator;
import simulator.Exceptions.IllegalSpecialAttackValue;

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
        this.weapon = new Weapon(0, 0, 0, "crush", 0, 4);
        this.gear = new GearSet(0, 0, 0, 0);
    }

    public Player(int attack, int strength, GearSet gear) {
        this.attack = attack;
        this.strength = strength;
        this.gear = gear;
        this.spAttack = 100;
        this.weapon = new Weapon(0, 0, 0, "crush", 0, 4);
    }

    public Player(int attack, int strength, Weapon weapon) {
        this.attack = attack;
        this.strength = strength;
        this.weapon = weapon;
        this.spAttack = 100;
        this.gear = new GearSet(0, 0, 0, 0);
    }

    public Player(int attack, int strength, GearSet gear, Weapon weapon) {
        this.attack = attack;
        this.strength = strength;
        this.gear = gear;
        this.weapon = weapon;
        this.spAttack = 100;
    }

    public Player(int attack, int strength, GearSet gear, Weapon weapon, SpecialWeapon specialAttackWeapon) {
        this.attack = attack;
        this.strength = strength;
        this.spAttack = 100;
        this.gear = gear;
        this.weapon = weapon;
        this.specialAttackWeapon = specialAttackWeapon;
    }

    public Player(int attack, int strength, GearSet gear, SpecialWeapon specialAttackWeapon) {
        this.attack = attack;
        this.strength = strength;
        this.spAttack = 100;
        this.gear = gear;
        this.weapon = new Weapon(0, 0, 0, "crush", 0, 4);
        this.specialAttackWeapon = specialAttackWeapon;
    }

    public Player(int attack, int strength, Weapon weapon, SpecialWeapon specialAttackWeapon) {
        this.attack = attack;
        this.strength = strength;
        this.spAttack = 100;
        this.gear = new GearSet(0, 0, 0, 0);
        this.weapon = weapon;
        this.specialAttackWeapon = specialAttackWeapon;
    }

    public Player(int attack, int strength, SpecialWeapon specialAttackWeapon) {
        this.attack = attack;
        this.strength = strength;
        this.spAttack = 100;
        this.gear = new GearSet(0, 0, 0, 0);
        this.weapon = new Weapon(0, 0, 0, "crush", 0, 4);
        this.specialAttackWeapon = specialAttackWeapon;
    }


    //performs calculation of an attack on opponent
    public int doHit() {
        int weaponStr = weapon.getStrength();
        int gearStr = gear.getStrength();
        int effectiveStrLvl = strength + 8;

        int maxHit = (effectiveStrLvl * (weaponStr + gearStr + 64)
                + 420) / 640;

        //roll between 0 and max hit
        return rand.nextInt(maxHit+1);
    }

    public int doSpecialHit() {
        int weaponStr = specialAttackWeapon.getStrength();
        int gearStr = gear.getStrength();
        int effectiveStrLvl = strength + 8;

        int maxHit = (effectiveStrLvl * (weaponStr + gearStr + 64)
                + 420) / 640;

        //roll between 0 and max hit
        return rand.nextInt(maxHit+1);
    }

    public int attackRoll() {
        String weaponStyle = this.getWeaponStyle();

        int effectiveAttackLvl = this.attack + 8;
        int weaponBonus = weapon.getWeaponBonus(weaponStyle);
        int gearbonus = gear.attackBonus(weaponStyle);

        int maxRoll = effectiveAttackLvl * (weaponBonus + gearbonus + 64);

        int attackRoll = rand.nextInt(maxRoll);
        return attackRoll;
    }

    public int specialAttackRoll() {
        String weaponStyle = this.getSpecialAttackWeaponStyle();

        int effectiveAttackLvl = this.attack + 8;
        int weaponBonus = specialAttackWeapon.getWeaponBonus(weaponStyle);
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

    public void setSpecialAttackWeapon(SpecialWeapon specialAttackWeapon) {
        this.specialAttackWeapon = specialAttackWeapon;
    }

    public String getSpecialAttackWeaponStyle() {
        return specialAttackWeapon.getStyle();
    }

    public int getSpAttack() {
        return spAttack;
    }
    public int getSpecialAttackWeaponCost() {
        return this.specialAttackWeapon != null ? this.specialAttackWeapon.getCost() : 0;
    }

    public int getSpecialSpeed() {
        return this.specialAttackWeapon.getSpeed();
    }

    public void regenSpAttack() {
        this.spAttack = Math.min(100, this.spAttack + 10);
    }

    public void useSpecialAttack() {
        if(this.spAttack-getSpecialAttackWeaponCost() < 0) {
            throw new IllegalSpecialAttackValue();
        } else {
            this.spAttack -= getSpecialAttackWeaponCost();
        }
    }

    public boolean hasSpecialAttackWeapon() {
        return this.specialAttackWeapon != null;
    }

    public void resetSpecialAttack() {
        this.spAttack = 100;
    }
}

