import java.util.Calendar;
import java.util.Scanner;

public class Menu {

	public void menuPrincipal(Scanner sc) {
		Integer escolha = 1;
		Conta conta;
		do {
			this.showMenuPrincipal();
			try {
				escolha = sc.nextInt();
				switch (escolha) {
				case 1:
					Pessoa aux = null;
					aux = this.buscarPessoa(sc);

					System.out.println("---------Digite o numero da Conta---------");
					int numeroC = sc.nextInt();

					System.out.println("---------Digite o saldo da Conta---------");
					double saldo = sc.nextDouble();
					System.out.println(
							"---------Digite o numero da TipoConta: 1 - Simples, 2 - Executiva, 3 - Premiun, 4 - Personalite---------");
					int ncat = sc.nextInt();
					sc.nextLine();
					String cat = null;
					if (ncat == 1) {
						cat = TipoConta.Simples.toString();
					} else if (ncat == 2) {
						cat = TipoConta.Executiva.toString();
					} else if (ncat == 3) {
						cat = TipoConta.Premiun.toString();
					} else if (ncat == 4) {
						cat = TipoConta.Personalite.toString();
					} else {
						System.out.println("---------Valor Invalido---------");
					}

					System.out.println("---------Conta Especial(E) ou Poupança(P)?---------");
					String tipo = sc.nextLine();
					switch (tipo) {
					case "E":
						System.out.println("Digite o limite:");
						double limite = sc.nextDouble();
						ContaEspecial auxContaE = new ContaEspecial(aux, numeroC, saldo, limite, cat);
						Main.contas.add(auxContaE);
						break;
					case "P":
						System.out.println("Digite a taxa de correção:");
						double taxa = sc.nextDouble();
						ContaPoupanca auxContaP = new ContaPoupanca(aux, numeroC, saldo, taxa, cat);
						Main.contas.add(auxContaP);
						break;
					}
					break;

				case 2:
					conta = this.buscarConta(sc);
					this.menuConta(sc, conta);
					break;

				case 3:
					this.cadastrarCliente(sc);
					break;

				case 4:
					System.out.println("------------------------------");
					System.out.println("1 - Saldo das Contas");
					System.out.println("2 - Total das Contas");

					Integer esc = sc.nextInt();
					sc.nextLine();

					switch (esc) {
					case 1:

						System.out.println("--------Saldo de cada uma das contas--------");
						for (Conta conta2 : Main.contas) {
							System.out.println("Nome do Titular: " + conta2.getCliente().getNome()
									+ " Numero da conta: " + conta2.getNrConta() + ", saldo: R$" + conta2.getSaldo());

						}
						System.out.println("--------------------------------------------");
						break;

					case 2:
						double total = 0;
						for (Conta conta2 : Main.contas)
							total += conta2.getSaldo();

						System.out.println("-----Saldo total somado de todas as contas-----");
						System.out.println("R$" + total);

						break;
					}
					break;

				case 5:
					System.out.println("5 - Sair");
					break;

				default:
					System.out.println("Opção Incorreta");
				}
			} catch (Exception e) {
				System.out.println("Opção Incorreta, sair.");
				escolha = 5;
			}
		} while (escolha != 5);

	}

	private void cadastrarCliente(Scanner sc) {

		System.out.println("--- Novo Cliente-----");
		System.out.println("Selecione o tipo de Pessoa");
		System.out.println("1 - Pessoa Física");
		System.out.println("2 - Pessoa Jurídica");

		Integer tipo = sc.nextInt();

		System.out.println("--- Informe o ID -----");
		Integer id = sc.nextInt();

		String nome2 = sc.nextLine();

		System.out.println("--- Informe o Nome -----");
		String nome = sc.nextLine();

		System.out.println("--- Informe o Endereço -----");
		String endereco = sc.nextLine();

		if (tipo == 1) {
			System.out.println("--- Informe o CPF -----");
			Integer cpf = sc.nextInt();

			System.out.println("Informe o ano de Nascimento: ");
			Integer ano = sc.nextInt();
			System.out.println("Informe o mês de Nascimento: ");
			Integer mes = sc.nextInt();
			System.out.println("Informe o dia de Nascimento: ");
			Integer dia = sc.nextInt();

			Calendar idade = Calendar.getInstance();
			idade.set(ano, mes, dia);

			System.out.println("--- Informe o Genero (M/F) -----");
			String genero = sc.next();

			Main.clientes.add(new PessoaFisica(id, nome, endereco, cpf, idade, genero));

		} else {
			System.out.println("--- Informe o CNPJ -----");
			Integer cnpj = sc.nextInt();

			System.out.println("--- Informe o Endereço -----");
			String atividade = sc.nextLine();

			Main.clientes.add(new PessoaJuridica(id, nome, endereco, cnpj, atividade));
		}

	}

	private void menuConta(Scanner sc, Conta conta) {

		Integer escolha = 1;
		do {
			this.showMenuConta(conta);
			try {
				escolha = sc.nextInt();
				Double vr;
				switch (escolha) {
				case 1:
					this.menuConta(sc, buscarConta(sc));

					break;
				case 2:
					System.out.println("Informe o Valor do Depósito");
					vr = sc.nextDouble();
					conta.depositar(vr);
					break;
				case 3:
					System.out.println("Informe o Valor para Saque");
					vr = sc.nextDouble();
					conta.sacar(vr);

					break;
				case 4:
					Conta dest = this.buscarConta(sc);
					System.out.println("Informe o Valor para Transferência");
					vr = sc.nextDouble();
					conta.transferir(vr, dest);
					break;
				case 5:
					System.out.println("-------------------------");
					System.out.println("--- SALDO: R$ " + conta.getSaldo());
					System.out.println("-------------------------");

					break;
				}

			} catch (Exception e) {
				System.out.println("Opção Incorreta, sair.");
				escolha = 6;
			}
		} while (escolha != 6);
	}

	private void showMenuPrincipal() {
		System.out.println("-------------------------");
		System.out.println("---Selecione Uma Opção---");
		System.out.println("---------------	----------");
		System.out.println("1 - Abrir Nova Conta");
		System.out.println("2 - Selecionar Conta");
		System.out.println("3 - Cadastrar Cliente");
		System.out.println("4 - Relatórios");
		System.out.println("5 - Sair");
		System.out.println("-------------------------");
	}

	private void showMenuConta(Conta conta) {
		System.out.println("-------------------------");
		System.out.println("Cliente: " + conta.getCliente().getNome());
		System.out.println("Nr Conta: " + conta.getNrConta());
		System.out.println("-------------------------");
		System.out.println("---Selecione Uma Opção---");
		System.out.println("-------------------------");
		System.out.println("1 - Alterar Conta");
		System.out.println("2 - Deposito");
		System.out.println("3 - Saque");
		System.out.println("4 - Transferência");
		System.out.println("5 - Saldo");
		System.out.println("6 - Sair");
		System.out.println("-------------------------");
	}

	public Conta buscarConta(Scanner sc) {

		Conta conta = null;
		do {
			System.out.println("------------------------------");
			System.out.println("---Digite o número da Conta---");
			System.out.println("------------------------------");
			Integer escolha = sc.nextInt();
			for (Conta c : Main.contas) {

				if (c.getNrConta() == escolha) {
					conta = c;
					break;
				}
			}
			if (conta == null) {
				System.out.println("------------------------------");
				System.out.println("-----Conta Não Encontrada-----");
				System.out.println("------------------------------");
			}

		} while (conta == null);

		return conta;
	}

	public Pessoa buscarPessoa(Scanner sc) {

		Pessoa aux = null;
		do {

			System.out.println("----Digite o id do Cliente----");

			int id = sc.nextInt();
			for (Pessoa p : Main.clientes) {
				if (p.getId() == id)
					aux = p;

			}
			if (aux == null) {
				System.out.println("-----Cliente não Encontrado-----");
			}
		} while (aux == null);

		return aux;
	}
}