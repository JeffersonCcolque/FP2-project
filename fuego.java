public class fuego extends Dragon {

    public fuego(String nombre, String elemento, int vida, int[] ataque, int[] defensa, int[] potencia) {
        super(nombre, elemento, vida, ataque, ataque, ataque);
    }
    
     public fuego() {
        super("Dragón de Fuego");
        vida = 100;
        atk = 20;
        dfns = 10;
    }
    @Override
    public String[] getAtaques() {
        return new String[]{"Llamarada", "Explosión", "Fuego Cruzado"};
    }

    @Override
    public String[] getDefensas() {
        return new String[]{"Escudo de Fuego", "Muro de Lava", "Ceniza Protectora"};
    }

    @Override
    public String[] getPotencias() {
        return new String[]{"Fuego Potenciado", "Calor Extremo", "Rugido de Fuego"};
    }
}
