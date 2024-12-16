public class agua extends Dragon {
    private String img;
    public agua(String nombre, int vida, Object[][] ataques, Object[][] defensa, Object[][] potencias,String img) {
        super(nombre, vida, ataques, defensa, potencias);
        this.img = img;
    }

    // Métodos getter y setter para los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen(){
        return img ;
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
}
