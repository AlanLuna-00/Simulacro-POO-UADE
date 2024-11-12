package mvc.model;

public class TarifaIndustrial extends Tarifa {
	private float iibb;
	
	/* constructor*/
	
	public TarifaIndustrial(int i, double d, double e) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public float calcularTarifa(int consumo) {
		return consumo + super.getIva() + iibb;
	}

	/* getters && setters */
	public float getIibb() {
		return iibb;
	}

	public void setIibb(float iibb) {
		this.iibb = iibb;
	}
	
	/* metodos */

}
