package Program;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import entities.Conta;
import entities.Pessoa;

public class Program {
	
	
	static Scanner sc = new Scanner(System.in).useLocale(Locale.US);
	static ArrayList<Conta> ContasBancarias;

	public static void main(String[] args) {
		
		ContasBancarias = new ArrayList<Conta>();
		operacoes();

	}

	public static void operacoes() {
		System.out.println("------------------------------------------------------------------");
		System.out.println("------------------Bem vindos a Agência Feliz-----------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.println("----------Selecione uma operação que deseja realizar--------------");
		System.out.println("------------------------------------------------------------------");
		System.out.println("|   Opção 1 - Criar conta |");
		System.out.println("|   Opção 2 - Depositar |");
		System.out.println("|   Opção 3 - Sacar |");
		System.out.println("|   Opção 4 - Transferir |");
		System.out.println("|   Opção 5 - Listar |");
		System.out.println("|   Opção 6 - Sair |");

		int operacao = sc.nextInt();

		switch (operacao) {
		case 1:
			CriarConta();
			break;
		case 2:
			Depositar();
			break;
		case 3:
			Sacar();
			break;
		case 4:
			Transferir();
			break;
		case 5:
			ListarContas();
			break;
		case 6:
			System.out.println("Obrigado por escolher nossa sistema de agência");
			System.exit(0);
		default:
			System.out.println("Opção Inválida");
			operacoes();
			break;

		}
	}

	public static void CriarConta() {

		System.out.println("\nNome: ");
		String nome = sc.next();
		sc.nextLine();

		System.out.println("\nCPF: ");
		String cpf = sc.next();

		System.out.println("\nEmail: ");
		String email = sc.next();
		
		Pessoa pessoa = new Pessoa(nome, cpf, email);
		Conta conta = new Conta(pessoa);
		
		ContasBancarias.add(conta);
		System.out.println("Sua conta foi criada com sucesso! ");

		operacoes();
	}

	private static Conta EncontrarConta(int NumeroConta) {
		Conta conta = null;
		if (ContasBancarias.size() > 0) {
			for (Conta c : ContasBancarias) {
				if (c.getNumeroConta() == NumeroConta)
					;
				conta = c;
			
			}
		}
		return conta;
	}

	public static void Depositar() {
		System.out.println("Número da Conta: ");
		int NumeroConta = sc.nextInt();
		Conta conta = EncontrarConta(NumeroConta);

		if (conta != null) {
			System.out.println("Qual o valor deseja depositar");
			double ValorDeposito = sc.nextDouble();
			conta.Depositar(ValorDeposito);
			System.out.println("Valor depositado com sucesso");
		} else {
			System.out.println("A conta não foi encontrada! ");
		}
		operacoes();
	}

	public static void Sacar() {
		System.out.println("Número da Conta: ");
		int NumeroConta = sc.nextInt();
		Conta conta = EncontrarConta(NumeroConta);
		if (conta != null) {
			System.out.println("Qual o valor que deseja sacar?");
			double ValorSaque = sc.nextDouble();
			conta.Sacar(ValorSaque);
			System.out.println("Valor sacado com sucesso! ");
		} else {
			System.out.println("Conta não encontrada");
		}
		operacoes();
	}

	public static void Transferir() {
		System.out.println("Número da Contado Remetente: ");
		int NumeroContaRemetente = sc.nextInt();

		Conta ContaRemetente = EncontrarConta(NumeroContaRemetente);

		if (ContaRemetente != null) {
			System.out.println("Número da conta do destinatário: ");
			int NumeroContaDestinatario = sc.nextInt();

			Conta ContaDestinatario = EncontrarConta(NumeroContaDestinatario);

			if (ContaDestinatario != null) {
				System.out.println("Valor da transferência: ");
				double valor = sc.nextDouble();

				ContaRemetente.Transferir(ContaDestinatario, valor);
			}

		}

		operacoes();

	}

	public static void ListarContas() {
		if (ContasBancarias.size() > 0) {
			for (Conta conta: ContasBancarias) {
				System.out.println(conta);
			}
		}else{
			System.out.println("Não tem contas cadastradas");
		}
		operacoes();
	}
}
