public class electrico extends Dragon {

    public electrico(String nombre, String elemento, int vida, int[] ataque, int[] defensa, int[] potencia) {
        super(nombre, elemento, vida, potencia, potencia, potencia);
        //TODO Auto-generated constructor stub
    }
    
    public electrico() {
        super("Dragón Electrico");
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
