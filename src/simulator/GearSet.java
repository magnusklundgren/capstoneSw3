package simulator;

public class GearSet {
    String name;
    int stab, slash, crush, magic, ranged;
    String style;

    public GearSet(String name, int stab, int slash, int crush, int magic, int ranged, String style) {
        this.name = name;
        this.stab = stab;
        this.slash = slash;
        this.crush = crush;
        this.magic = magic;
        this.ranged = ranged;
        this.style = style;
    }
}
