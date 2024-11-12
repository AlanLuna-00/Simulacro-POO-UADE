package mvc.model;

public class TarifaResidencial extends Tarifa {
	private float contribucionesMunicipales;
	
	/* constructor*/
	public TarifaResidencial(int i, double d, double e) {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public float calcularTarifa(int consumo) {
		return consumo + super.getIva() +  contribucionesMunicipales;
	}
	
	/* getters && setters */
	public float getContribucionesMunicipales() {
		return contribucionesMunicipales;
	}

	public void setContribucionesMunicipales(float contribucionesMunicipales) {
		this.contribucionesMunicipales = contribucionesMunicipales;
	}
	
	/* metodos */

}
