package mvc.model;

import java.util.Date;


public class Medicion {
	private Date fechaLectura;
	private int anio;
	private int bimestre;
	private int lectura;
	
	/* constructor */
	public Medicion(Date fechaLectura, int anio, int bimestre, int lectura) {
		this.setFechaLectura(fechaLectura);
		this.setAnio(anio);
		this.setBimestre(bimestre);
		this.setLectura(lectura);
	}
	
	/* getters && setters */
	public Date getFechaLectura() {
		return fechaLectura;
	}
	public void setFechaLectura(Date fechaLectura) {
		this.fechaLectura = fechaLectura;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getBimestre() {
		return bimestre;
	}
	public void setBimestre(int bimestre) {
		this.bimestre = bimestre;
	}
	public int getLectura() {
		return lectura;
	}
	public void setLectura(int lectura) {
		this.lectura = lectura;
	}
	
	/* metodos */
	public boolean sosMedicion(int anio, int bimestre){
		if(this.getAnio() == anio && this.getBimestre() == bimestre){
			return true;
		}else{
			return false;
		}
	}

}
