package mvc.model;

import java.util.Date;


public class Factura {
	private Date fecha;
	private Usuario usuario;
	private Tarifa tarifa;
	private Medicion medicionAnterior;
	private Medicion medicionActual;
	private int consumo;
	private float montoTotal;

	
	/* constructor */
	
	
	/* getters && setters */
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Tarifa getTarifa() {
		return tarifa;
	}
	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}
	public Medicion getMedicionAnterior() {
		return medicionAnterior;
	}
	public void setMedicionAnterior(Medicion medicionAnterior) {
		this.medicionAnterior = medicionAnterior;
	}
	public Medicion getMedicionActual() {
		return medicionActual;
	}
	public void setMedicionActual(Medicion medicionActual) {
		this.medicionActual = medicionActual;
	}
	public int getConsumo() {
		return consumo;
	}
	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}
	public float getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	
	/* metodos */
	
	
}
