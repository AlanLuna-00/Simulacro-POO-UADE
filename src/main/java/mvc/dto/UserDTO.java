package mvc.dto;

public class UserDTO {
    private int id;
    private String tipoUsuario; // "Industrial" o "Residencial"
    private String calle;
    private int altura;
    private int piso;
    private String dpto;
    private int codigoPostal;
    private String localidad;
    private String provincia;

    // Atributos específicos de UsuarioIndustrial
    private String razonSocial;
    private String cuit;
    private String iibb;
    private String condicionFiscal;

    // Atributos específicos de UsuarioResidencial
    private String nombre;
    private int dni;

    public UserDTO( int id, String tipoUsuario, String calle, int altura, int piso, String dpto, int codigoPostal, String localidad, String provincia, String razonSocial, String cuit, String iibb, String condicionFiscal, String nombre, int dni) {
        this.id = id;
        this.tipoUsuario = tipoUsuario;
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.dpto = dpto;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.provincia = provincia;
        if (tipoUsuario.equals("Industrial")) {
            this.razonSocial = razonSocial;
            this.cuit = cuit;
            this.iibb = iibb;
            this.condicionFiscal = condicionFiscal;
        } else {
            this.nombre = nombre;
            this.dni = dni;
        }
    }

    // Getters y setters generales
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public int getId() {
        return id;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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

    // Getters y setters para UsuarioIndustrial
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getIIBB() {
        return iibb;
    }

    public void setIIBB(String iibb) {
        this.iibb = iibb;
    }

    public String getCondicionFiscal() {
        return condicionFiscal;
    }

    public void setCondicionFiscal(String condicionFiscal) {
        this.condicionFiscal = condicionFiscal;
    }

    // Getters y setters para UsuarioResidencial
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


}
