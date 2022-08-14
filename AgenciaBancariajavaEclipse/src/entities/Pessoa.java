package entities;

public class Pessoa {

	private static int contador = 1;

	private String nome;
	private String Cpf;
	private String email;

	public Pessoa(String nome, String cpf, String email) {
		this.nome = nome;
		this.Cpf = cpf;
		this.email = email;
		contador += 1;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		this.Cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString () {
		return "\nNome: " + nome
			  +"\nCPF: " + Cpf
			  +"\nEmail " + email;

	}
	
	

}
