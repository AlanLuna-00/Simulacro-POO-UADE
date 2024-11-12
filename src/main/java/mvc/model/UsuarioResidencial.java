package mvc.model;

public class UsuarioResidencial extends Usuario {
    private String nombre;
    private int dni;

    /* constructor*/
    public UsuarioResidencial(int id,String calle, int altura, int piso, String dpto, int cp, String local, String pcia, String nombre, int dni) {
        super(id, calle, altura, piso, dpto, cp, local, pcia);
        this.setNombre(nombre);
        this.setDni(dni);
    }

    /* getters && setters */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    /* metodos */
    @Override
    public int obtenerUltimoConsumo(int anio, int bimestre) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <T> boolean sosUsuarioPorDato(T dato) {
        return this.getDni() == (int) dato;
    }
}
