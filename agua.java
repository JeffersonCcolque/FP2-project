public class agua extends Dragon {

    public agua(String nombre, String elemento, int vida, int[] ataque, int[] defensa, int[] potencia) {
        super(nombre, elemento, vida, potencia, potencia, potencia);
    }
    public agua() {
        super("Dragón de Agua");
    }

    @Override
    public String[] getAtaques() {
        return new String[]{"Ola Gigante", "Torrente", "Tsunami"};
    }

    @Override
    public String[] getDefensas() {
        return new String[]{"Escudo de Agua", "Burbuja Protectora", "Corriente Suave"};
    }

    @Override
    public String[] getPotencias() {
        return new String[]{"Lluvia Curativa", "Vapor Energético", "Fuerza del Mar"};
    }
    
}
