
public class tierra extends Dragon{
    public tierra(String nombre, String elemento, int vida, int[] ataque, int[] defensa, int[] potencia) {
        super(nombre, elemento, vida, potencia, potencia, potencia);
    }
    
    public tierra() {
        super("Dragón de Tierra");
    }

    @Override
    public String[] getAtaques() {
        return new String[]{"", "", " "};
    }

    @Override
    public String[] getDefensas() {
        return new String[]{"  ", "  ", " "};
    }

    @Override
    public String[] getPotencias() {
        return new String[]{" ", " ", "  "};
    }
}
