package model;

public class OrdemServico {
	private Short codigo_os;
	private String veiculo;
	private String defeito;
	private Short servico;
	private Short funcionario;
	private Double valor;
	private Short cliente;
	private String data_os;
	private String situacao;

	public Short getCodigo_os() {
		return codigo_os;
	}

	public void setCodigo_os(Short codigo_os) {
		this.codigo_os = codigo_os;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getDefeito() {
		return defeito;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	public Short getServico() {
		return servico;
	}

	public void setServico(Short servico) {
		this.servico = servico;
	}

	public Short getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Short funcionario) {
		this.funcionario = funcionario;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Short getCliente() {
		return cliente;
	}

	public void setCliente(Short cliente) {
		this.cliente = cliente;
	}

	public String getData_os() {
		return data_os;
	}

	public void setData_os(String data_os) {
		this.data_os = data_os;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
