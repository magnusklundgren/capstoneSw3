package simulator;

public class Npc {
    int def, magic, hp;
    int stabDef, slashDef, crushDef, mageDef, rangeDef;
    int size;

    public Npc(int def, int magic, int hp, int stabDef, int slashDef, int crushDef, int mageDef, int rangeDef, int size) {
        this.def = def;
        this.magic = magic;
        this.hp = hp;
        this.stabDef = stabDef;
        this.slashDef = slashDef;
        this.crushDef = crushDef;
        this.mageDef = mageDef;
        this.rangeDef = rangeDef;
        this.size = size;
    }
}
