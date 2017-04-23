package pacote.Model;

public class Cliente {
	private long id;
	private String nome;
	private String dataNasc;
	private String cpf;
	
	private Endereco endereco ;
	private Contato contato;
	
	//constructors
	public Cliente(long id, String nome, String dataNasc, String cpf, Endereco endereco, Contato contato) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.cpf = cpf;
		this.endereco = endereco;
		this.contato = contato;
	}
	public Cliente(long id, String nome, String dataNasc, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.cpf = cpf;
	}
	public Cliente(String nome, String dataNasc, String cpf) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.cpf = cpf;
	}
	
	//getters and setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNasc == null) ? 0 : dataNasc.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNasc == null) {
			if (other.dataNasc != null)
				return false;
		} else if (!dataNasc.equals(other.dataNasc))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [id=").append(id).append(", nome=").append(nome).append(", dataNasc=").append(dataNasc)
				.append(", cpf=").append(cpf).append(", endereco=").append(endereco).append(", contato=")
				.append(contato).append("]");
		return builder.toString();
	}
	
	

}
