
public class Dragon {
    public String nombre;
    private int vida;
    private String elemento;
    private int[] ataque = new int[3];
    private int[] defensa = new int[3];
    private int[] potencia = new int[3];

    public Dragon(String nombre, String elemento, int vida, int[] ataque, int[] defensa, int[] potencia){

    }
    public Dragon(String nombre) {
        this.nombre = nombre;
    }

    public String[] getAtaques() {
        return new String[]{"Ataque1", "Ataque2", "Ataque3"};
    }

    public String[] getDefensas() {
        return new String[]{"Defensa1", "Defensa2", "Defensa3"};
    }

    public String[] getPotencias() {
        return new String[]{"Potencia1", "Potencia2", "Potencia3"};
    }
}
