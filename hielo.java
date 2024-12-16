public class hielo extends Dragon{

    public hielo(String nombre, String elemento, int vida, int[] ataque, int[] defensa, int[] potencia) {
        super(nombre, elemento, vida, potencia, potencia, potencia);
        //TODO Auto-generated constructor stub
    }
    
    public hielo() {
        super("Dragón de Hielo");
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
