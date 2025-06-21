import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Conta encontrarConta(List<Conta> contas, String numeroConta) {
        for (Conta c : contas) {
            if (c.getNumeroConta().equals(numeroConta)) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        List<Conta> contas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int opc;

        do {
            System.out.println("\n--- Banco ---");
            System.out.println("1. Criar Conta");
            System.out.println("2. Realizar Depósito ");
            System.out.println("3. Realizar Saque");
            System.out.println("4. Realizar Transferência");
            System.out.println("5. Listar Clientes");
            System.out.println("6. Listar Contas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("\n--- Criar Cliente e Conta ---");
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    System.out.print("Endereco do cliente: ");
                    String enderecoCliente = scanner.nextLine();

                    Cliente novoCliente = new Cliente(nomeCliente, cpfCliente, enderecoCliente);
                    clientes.add(novoCliente);
                    System.out.println("Cliente " + novoCliente.getNome() + " cadastrado com sucesso!");

                    System.out.print("Numero da conta: ");
                    String numeroConta = scanner.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldoConta = scanner.nextDouble();
                    scanner.nextLine();

                    Conta novaConta = new Conta(novoCliente, saldoConta, numeroConta);
                    contas.add(novaConta);
                    System.out.println("Conta " + novaConta.getNumeroConta() + " criada para " + novoCliente.getNome() + "!");
                    break;

                case 2:
                    System.out.println("\n--- Realizar Depósito ---");
                    System.out.print("Número da conta para depósito: ");
                    String numDeposito = scanner.nextLine();
                    Conta contaDeposito = encontrarConta(contas, numDeposito);

                    if (contaDeposito != null) {
                        System.out.print("Valor a depositar: ");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();
                        contaDeposito.depositar(valorDeposito);
                    } else {
                        System.out.println("Erro: Conta não encontrada.");
                    }
                    break;
                case 3:
                    System.out.println("\n--- Realizar Saque ---");
                    System.out.print("Número da conta para saque: ");
                    String numSaque = scanner.nextLine();
                    Conta contaSaque = encontrarConta(contas, numSaque);

                    if (contaSaque != null) {
                        System.out.print("Valor a sacar: ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine();
                        contaSaque.sacar(valorSaque);
                    } else {
                        System.out.println("Erro: Conta não encontrada.");
                    }
                    break;
                case 4:
                    System.out.println("\n--- Realizar Transferência ---");
                    System.out.print("Número da conta de origem: ");
                    String numOrigem = scanner.nextLine();
                    Conta contaOrigem = encontrarConta(contas, numOrigem);

                    System.out.print("Número da conta de destino: ");
                    String numDestino = scanner.nextLine();
                    Conta contaDestino = encontrarConta(contas, numDestino);

                    if (contaOrigem != null && contaDestino != null) {
                        System.out.print("Valor a transferir: ");
                        double valorTransferencia = scanner.nextDouble();
                        scanner.nextLine();
                        contaOrigem.transferir(contaDestino, valorTransferencia);
                    } else {
                        System.out.println("Erro: Uma ou ambas as contas não foram encontradas.");
                    }
                    break;
                case 5:
                    System.out.println("\n--- Clientes Cadastrados ---");
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        for (Cliente c : clientes) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 6:
                    System.out.println("\n--- Contas Cadastradas ---");
                    if (contas.isEmpty()) {
                        System.out.println("Nenhuma conta cadastrada.");
                    } else {
                        for (Conta co : contas) {
                            System.out.println(co);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saindo do aplicativo do banco. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opc != 0);

        scanner.close();
    }
}
