package model;

public class Item {
	private short codVenda;
	private int quantidade;
	private short codProduto;
	private String nomeProduto;

	public Item() {
		super();
	}

	public Item(short codVenda, int quantidade, short codProduto) {
		super();
		this.codVenda = codVenda;
		this.quantidade = quantidade;
		this.codProduto = codProduto;
	}

	public short getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(short codVenda) {
		this.codVenda = codVenda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public short getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(short codProduto) {
		this.codProduto = codProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codProduto;
		result = prime * result + codVenda;
		result = prime * result + quantidade;
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
		Item other = (Item) obj;
		if (codProduto != other.codProduto)
			return false;
		if (codVenda != other.codVenda)
			return false;
		if (quantidade != other.quantidade)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [codigo=" + codVenda + ", quantidade=" + quantidade + ", codProduto=" + codProduto + "]";
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	

}
