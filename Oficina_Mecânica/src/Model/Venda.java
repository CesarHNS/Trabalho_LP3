package model;

public class Venda {
	private short codigoVenda;
	private String dataVenda;
	private double valorVenda;	
	private String nomeCliente;
	private String nomeProduto;
	private int quantidadeItem;
	private String situacao;
	public Venda() {
		super();
	}
	public Venda(short codigoVenda, String dataVenda, double valorVenda, String nomeCliente, String nomeProduto,
			int quantidadeItem) {
		super();
		this.codigoVenda = codigoVenda;
		this.dataVenda = dataVenda;
		this.valorVenda = valorVenda;
		this.nomeCliente = nomeCliente;
		this.nomeProduto = nomeProduto;
		this.quantidadeItem = quantidadeItem;
	}
	public short getCodigoVenda() {
		return codigoVenda;
	}
	public void setCodigoVenda(short codigoVenda) {
		this.codigoVenda = codigoVenda;
	}
	public String getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public int getQuantidadeItem() {
		return quantidadeItem;
	}
	public void setQuantidadeItem(int quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoVenda;
		result = prime * result + ((dataVenda == null) ? 0 : dataVenda.hashCode());
		result = prime * result + ((nomeCliente == null) ? 0 : nomeCliente.hashCode());
		result = prime * result + ((nomeProduto == null) ? 0 : nomeProduto.hashCode());
		result = prime * result + quantidadeItem;
		long temp;
		temp = Double.doubleToLongBits(valorVenda);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (codigoVenda != other.codigoVenda)
			return false;
		if (dataVenda == null) {
			if (other.dataVenda != null)
				return false;
		} else if (!dataVenda.equals(other.dataVenda))
			return false;
		if (nomeCliente == null) {
			if (other.nomeCliente != null)
				return false;
		} else if (!nomeCliente.equals(other.nomeCliente))
			return false;
		if (nomeProduto == null) {
			if (other.nomeProduto != null)
				return false;
		} else if (!nomeProduto.equals(other.nomeProduto))
			return false;
		if (quantidadeItem != other.quantidadeItem)
			return false;
		if (Double.doubleToLongBits(valorVenda) != Double.doubleToLongBits(other.valorVenda))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Venda [codigoVenda=" + codigoVenda + ", dataVenda=" + dataVenda + ", valorVenda=" + valorVenda
				+ ", nomeCliente=" + nomeCliente + ", nomeProduto=" + nomeProduto + ", quantidadeItem=" + quantidadeItem
				+ "]";
	}
	public String getSituacao() {
		return null;
	}	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}
