package model;

public class Veiculo {

	private short codigo;
	private String descricao;
	private String montadora;
	private String placa;
	private String nomeCliente;

	public Veiculo() {
		super();
	}

	public Veiculo(short codigo, String descricao, String montadora, String placa, String nomeCliente) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.montadora = montadora;
		this.placa = placa;
		this.nomeCliente = nomeCliente;
	}

	public short getCodigo() {
		return codigo;
	}

	public void setCodigo(short codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMontadora() {
		return montadora;
	}

	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	
	

}
