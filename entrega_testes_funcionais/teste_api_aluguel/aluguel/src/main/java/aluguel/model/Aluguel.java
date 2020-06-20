package aluguel.model;

public class Aluguel {

	private Double valor_nominal;
	
	private Integer dia;
	
	public Aluguel(Double valor_nominal, Integer dia) {
		super();
		this.valor_nominal = valor_nominal;
		this.dia = dia;
	}

	public Double getValor_nominal() {
		return valor_nominal;
	}

	public Integer getDia() {
		return dia;
	}

}
