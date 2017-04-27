package Model;

import java.util.Arrays;

public class Cliente {
	private long[] id;
	private String[] nome;
	private String[] dataNasc;
	private String[] cpf;
	
	private Endereco[] endereco;
	private Contato[] contato;
	
	public Cliente() {
		super();
	}
	
	public Cliente(long[] id, String[] nome, String[] dataNasc, String[] cpf, Endereco[] endereco, Contato[] contato) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.cpf = cpf;
		this.endereco = endereco;
		this.contato = contato;
	}

	public long[] getId() {
		return id;
	}

	public void setId(long[] id) {
		this.id = id;
	}

	public String[] getNome() {
		return nome;
	}

	public void setNome(String[] nome) {
		this.nome = nome;
	}

	public String[] getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String[] dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String[] getCpf() {
		return cpf;
	}

	public void setCpf(String[] cpf) {
		this.cpf = cpf;
	}

	public Endereco[] getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco[] endereco) {
		this.endereco = endereco;
	}

	public Contato[] getContato() {
		return contato;
	}

	public void setContato(Contato[] contato) {
		this.contato = contato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contato);
		result = prime * result + Arrays.hashCode(cpf);
		result = prime * result + Arrays.hashCode(dataNasc);
		result = prime * result + Arrays.hashCode(endereco);
		result = prime * result + Arrays.hashCode(id);
		result = prime * result + Arrays.hashCode(nome);
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
		if (!Arrays.equals(contato, other.contato))
			return false;
		if (!Arrays.equals(cpf, other.cpf))
			return false;
		if (!Arrays.equals(dataNasc, other.dataNasc))
			return false;
		if (!Arrays.equals(endereco, other.endereco))
			return false;
		if (!Arrays.equals(id, other.id))
			return false;
		if (!Arrays.equals(nome, other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + Arrays.toString(id) + ", nome=" + Arrays.toString(nome) + ", dataNasc="
				+ Arrays.toString(dataNasc) + ", cpf=" + Arrays.toString(cpf) + ", endereco="
				+ Arrays.toString(endereco) + ", contato=" + Arrays.toString(contato) + "]";
	}

	
}
