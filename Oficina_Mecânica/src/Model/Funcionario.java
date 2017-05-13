package model;

public class Funcionario {
	private String codigo;
	private String nome;
	private String cpf;
	private String senha;
	private String cargo;

	private Endereco endereco;
	private Contato contato;

	// constructors
	public Funcionario() {
		super();
	}

	public Funcionario(String codigo, String nome, String cpf, String senha, String cargo, Endereco endereco,
			Contato contato) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.cargo = cargo;
		this.endereco = endereco;
		this.contato = contato;
	}

	public Funcionario(String codigo, String nome, String cpf, String senha, String cargo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.cargo = cargo;
	}

	public Funcionario(String nome, String cpf, String senha, String cargo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.cargo = cargo;
	}

	// getters and setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario [codigo=").append(codigo).append(", nome=").append(nome).append(", cpf=")
				.append(cpf).append(", senha=").append(senha).append(", cargo=").append(cargo).append(", endereco=")
				.append(endereco).append(", contato=").append(contato).append("]");
		return builder.toString();
	}

}
