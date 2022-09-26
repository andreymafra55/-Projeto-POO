package bancario;

import java.util.Scanner;

import persistencia.PersistenciaArquivo;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PersistenciaArquivo pa = new PersistenciaArquivo();
		Scanner sc = new Scanner(System.in);

		boolean sair = true;
		int opcao = 0;

		while (sair) {
			System.out.println("Escolha uma opção:\n1) Cadastrar um cliente;\n2) Opcoes para conta;\n3) Listar Clientes;\n4) Sair");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				String nome = "";
				String cpf = "";
				System.out.println("Insira o nome do cliente: ");
				nome = sc.next();
				System.out.println("Insira o CPF: ");
				cpf = sc.next();
				Cliente cli = new Cliente(cpf, nome);
				pa.cadastrarCliente(cli);
				break;
			case 2:
				System.out.println("Insira o CPF do cliente: ");
				String cpfConsulta = "";
				int segundaOpcao = 0;
				boolean segundoSair = true;
				cpfConsulta = sc.next();
				Cliente cliConsulta = pa.buscarClienteCPF(cpfConsulta);
				if (cliConsulta != null) {
					while (segundoSair) {
						System.out.println(
								"\n\n\n\nEscolha as opções para CONTA: \n1) Cadastrar uma conta;\n2) Remover uma conta;\n3) Listar contas;\n4) Realizar Deposito;\n5) Realizar saque;\n6) Sair;");
						segundaOpcao = sc.nextInt();
						switch (segundaOpcao) {
						case 1:
							String numeroConta = "";
							System.out.println("Insira o número da conta");
							numeroConta = sc.next();
							Conta c1 = new Conta(numeroConta);
							cliConsulta.adicionarConta(c1);
							pa.atualizarCliente(cliConsulta);
							break;
						case 2:
							System.out.println("Insira o número da conta que deseja remover");
							numeroConta = sc.next();
							Conta c2= new Conta(numeroConta);
							cliConsulta.removerConta(c2);
							pa.atualizarCliente(cliConsulta);
							break;
						case 3:
							System.out.print(cliConsulta.getContas());
							break ;
						
						case 4:
							System.out.println("Insira o numero a sua conta:");
							numeroConta =sc.next();
							Conta c3 = new Conta(numeroConta);
							System.out.println("Insira o valor do deposito:");
							float valor = sc.nextFloat();
							cliConsulta.Depositar(c3, valor);
							cliConsulta.atualizarConta(c3);
							pa.atualizarCliente(cliConsulta);
							
							
							break;
						
						case 5:
							System.out.println("Insira o numero a sua conta:");
							numeroConta =sc.next();
							Conta c4 = new Conta(numeroConta);
							System.out.println("Insira o valor do Saque:");
							Float quantia = sc.nextFloat();
							cliConsulta.sacar(c4, quantia);
							cliConsulta.atualizarConta(c4);
							pa.atualizarCliente(cliConsulta);
							break;
							
						case 6:
							System.out.println("Insira o numero a sua conta:");
							numeroConta =sc.next();
							Conta c5 = new Conta(numeroConta);
							cliConsulta.verSaldo(c5); 
							break;
							
						case 7:
							segundoSair = false;
							System.out.println("\n\n\n");
							break;
						
						default:

							break;
						}
					}
				} else
					System.err.println("Cliente não encontrado!");
				break;
				
			case 3:
				pa.buscarCliente();
				break;
			case 4:
				sair = false;
				break;
			default:
				break;
			}
		}
	}

}