package simulator;

public class Weapon {
    int stab, slash, crush, magic, ranged;
    String style;

    int speed;
    int travelTime;

    public Weapon(int stab, int slash, int crush, int magic, int ranged, String style, int speed) {
        this.stab = stab;
        this.slash = slash;
        this.crush = crush;
        this.magic = magic;
        this.ranged = ranged;
        this.style = style;
        this.speed = speed;
        this.travelTime = 0;
    }
}
