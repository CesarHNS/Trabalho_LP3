package pacote.Model;

public class ContasReceber {
	private String codigo;
	private OrdemServico ordemServico;

	// constructors
	public ContasReceber() {
		super();
	}

	public ContasReceber(String codigo, OrdemServico ordemServico) {
		super();
		this.codigo = codigo;
		this.ordemServico = ordemServico;
	}

	// getters and setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((ordemServico == null) ? 0 : ordemServico.hashCode());
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
		ContasReceber other = (ContasReceber) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (ordemServico == null) {
			if (other.ordemServico != null)
				return false;
		} else if (!ordemServico.equals(other.ordemServico))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContasReceber [codigo=").append(codigo).append(", ordemServico=").append(ordemServico)
				.append("]");
		return builder.toString();
	}

}
