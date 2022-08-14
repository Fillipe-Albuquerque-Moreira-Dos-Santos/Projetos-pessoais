package entities;

import utilitarios.Utils;

public class Conta {
	
	private static int contadorDeContas = 1;
	private int numeroConta;
	private Pessoa pessoa;
	private double saldo = 0.0;
	
	
	public Conta(Pessoa pessoa) {
		this.numeroConta = contadorDeContas;
		this.pessoa = pessoa;
		contadorDeContas += 1;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String toString() {
		return "\nNúmero da Conta: " + this.getNumeroConta() + "\nNome: " + this.getPessoa().getNome() + "\nCPF: "
				+ this.pessoa.getCpf() + "\nEmail " + this.pessoa.getEmail() + "\nSaldo: "
				+ Utils.doubleToString(this.getSaldo()) + "\n";
	}

	public void Depositar(double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Seu depósito foi realizado com sucesso! ");
		} else {
			System.out.println("Não foi possível realizar o depósito");
		}
	}

	public void Sacar(double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			this.setSaldo(getSaldo() - valor);
			System.out.println("Saque realizado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar o saque!");
		}
	}

	public void Transferir(Conta contaparaDeposito, double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			this.setSaldo(getSaldo() - valor);
			contaparaDeposito.saldo = contaparaDeposito.getSaldo() + valor;
			System.out.println("Transferência realizada com sucesso!");
		} else {
			System.out.println("Não foi possível realizar a transferência");
		}
	}

}
