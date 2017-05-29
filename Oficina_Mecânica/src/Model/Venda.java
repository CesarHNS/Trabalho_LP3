package model;

public class Venda {
	private short codigoVenda;
	private double valorVenda;
	private String dataVenda;
	private short codigoCliente;

	public Venda() {
		super();
	}

	public Venda(short codigoVenda, double valorVenda, String dataVenda, short codigoCliente) {
		super();
		this.codigoVenda = codigoVenda;
		this.valorVenda = valorVenda;
		this.dataVenda = dataVenda;
		this.codigoCliente = codigoCliente;
	}

	public short getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(short codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public short getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(short codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoCliente;
		result = prime * result + codigoVenda;
		result = prime * result + ((dataVenda == null) ? 0 : dataVenda.hashCode());
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
		if (codigoCliente != other.codigoCliente)
			return false;
		if (codigoVenda != other.codigoVenda)
			return false;
		if (dataVenda == null) {
			if (other.dataVenda != null)
				return false;
		} else if (!dataVenda.equals(other.dataVenda))
			return false;
		if (Double.doubleToLongBits(valorVenda) != Double.doubleToLongBits(other.valorVenda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venda [codigoVenda=" + codigoVenda + ", valorVenda=" + valorVenda + ", dataVenda=" + dataVenda
				+ ", codigoCliente=" + codigoCliente + "]";
	}

}
