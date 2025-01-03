public class Dragon {
    protected String nombre;
    protected int vida;
    protected Object[][] ataques;
    protected Object[][] defensa;
    protected Object[][] potencias;

    // Constructor con todos los atributos
    public Dragon(String nombre, int vida, Object[][] ataques, Object[][] defensa, Object[][] potencias) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataques = ataques;
        this.defensa = defensa;
        this.potencias = potencias;
    }

    // Constructor con solo el nombre
    public Dragon(String nombre) {
        this.nombre = nombre;
    }

    // Métodos getter y setter para los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Object[][] getDefensa() {
        return ataques;
    }

    public void setDefensa(Object[][] ataques) {
        this.ataques = ataques;
    }

    
    public Object[][] getPotencia() {
        return ataques;
    }

    public void setPotencia(Object[][] ataques) {
        this.ataques = ataques;
    }

    
    public Object[][] getAtaques() {
        return ataques;
    }

    public void setAtaques(Object[][] ataques) {
        this.ataques = ataques;
    }

    public String getImagen() {
        return "error";
    }

}
