package GameUnit;

public enum Symbol {
    HIT ('X'),
    MISS ('o'),
    SHIP ('#'),
    WATER ('~');

    private char sym;
    private Symbol(char sym){
        this.sym = sym;
    }
    public char getSym(){
        return sym;
    }
}
