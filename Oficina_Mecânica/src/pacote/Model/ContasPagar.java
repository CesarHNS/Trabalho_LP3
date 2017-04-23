package pacote.Model;

public class ContasPagar {
	private String codigo;
	private Fornecedor fornecedor;

	// constructors
	public ContasPagar() {
		super();
	}

	public ContasPagar(String codigo, Fornecedor fornecedor) {
		super();
		this.codigo = codigo;
		this.fornecedor = fornecedor;
	}

	// getters and setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
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
		ContasPagar other = (ContasPagar) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContasPagar [codigo=").append(codigo).append(", fornecedor=").append(fornecedor).append("]");
		return builder.toString();
	}

}
