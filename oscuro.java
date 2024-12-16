public class oscuro extends Dragon {

    public oscuro(String nombre, String elemento, int vida, int[] ataque, int[] defensa, int[] potencia) {
        super(nombre, elemento, vida, potencia, potencia, potencia);
    }
    
    public oscuro() {
        super("Dragón Oscuro");
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
