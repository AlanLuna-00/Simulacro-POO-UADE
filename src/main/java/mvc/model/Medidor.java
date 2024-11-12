package mvc.model;

import java.util.Date;
import java.util.Vector;


public class Medidor {
	private int nroMedidor;
	private Date fechaInstalacion;
	private Vector<Medicion>mediciones;
	
	/* constructor */
	public void agregar(Medicion m1) {
		mediciones.add(m1);
	}
	
	/* getters && setters */
	public int getNroMedidor() {
		return nroMedidor;
	}

	public void setNroMedidor(int nroMedidor) {
		this.nroMedidor = nroMedidor;
	}

	public Date getFechaInstalacion() {
		return fechaInstalacion;
	}

	public void setFechaInstalacion(Date fechaInstalacion) {
		this.fechaInstalacion = fechaInstalacion;
	}

	public Vector<Medicion> getMediciones() {
		return mediciones;
	}

	public void setMediciones(Vector<Medicion> mediciones) {
		this.mediciones = mediciones;
	}
	
	/* metodos */
	public int obtenerUltimoConsumo(int anio, int bimestre){
		Medicion medicion = buscarMedicion(anio, bimestre);
		if(medicion!= null){
			return medicion.getLectura();
		}else{
			return 0;
		}
	}
	
	public int obtenerAnteriorConsumo(int anio, int bimestre){
		Medicion medicion = buscarMedicion(anio, bimestre - 1);
		if(medicion!= null){
			return medicion.getLectura();
		}else{
			return 0;
		}
	}
	
	public Medicion buscarMedicion(int anio, int bimestre){
		for(int i = 0; i < mediciones.size(); i++){
			if(mediciones.elementAt(i).sosMedicion(anio, bimestre)){
				return mediciones.elementAt(i);
			}
		}
		return null;
	}
}
