package mvc.model;

public abstract class Tarifa {
	private float valorKhw;
	private float iva;

	
	/* constructor */
	
	/* getters && setters */
	public float getValorKhw() {
		return valorKhw;
	}
	public void setValorKhw(float valorKhw) {
		this.valorKhw = valorKhw;
	}
	public float getIva() {
		return iva;
	}
	public void setIva(float iva) {
		this.iva = iva;
	}
	
	/* metodos */
	public abstract float calcularTarifa(int consumo);
}
