package mvc.model;

public abstract class Usuario {
    private int id;
    private Medidor medidor;
    private Tarifa tarifa;
    private int nroUsuario;
    private String calle;
    private int altura;
    private int piso;
    private String dpto;
    private int codigoPostal;
    private String localidad;
    private String provincia;


    /* constructor */
    public Usuario(int id, String calle, int altura, int piso, String dpto, int cp, String local, String pcia){
        this.setId(id);
        this.setCalle(calle);
        this.setAltura(altura);
        this.setPiso(piso);
        this.setDpto(dpto);
        this.setCodigoPostal(cp);
        this.setLocalidad(local);
        this.setProvincia(pcia);
    }

    private void setId(int id) {
        this.id = id;
    }

    /* getters && setters */
    public Medidor getMedidor() {
        return medidor;
    }

    public void setMedidor(Medidor medidor) {
        this.medidor = medidor;
    }

    public int getNroUsuario() {
        return nroUsuario;
    }

    public void setNroUsuario(int nroUsuario) {
        this.nroUsuario = nroUsuario;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    /* metodos */
    public abstract int obtenerUltimoConsumo(int anio, int bimestre);


    public boolean sosUsuario(int nroUsuario){
        if(this.getNroUsuario() == nroUsuario){
            return true;
        }else{
            return false;
        }
    }

    public abstract <T> boolean sosUsuarioPorDato(T dato);

    public int getId() {
        return id;
    }
}
