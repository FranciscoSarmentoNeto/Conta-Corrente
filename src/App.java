import java.util.Scanner;

public class App {

    public static void imprimeMenu() {
        System.out.println("\n========== OPERAÇÕES DE CAIXA ==========");
        System.out.println("0 - Cadastrar uma conta.");
        System.out.println("1 - Depositar valor à conta.");
        System.out.println("2 - Sacar valor da conta.");
        System.out.println("3 - Situação atual da conta.");
        System.out.println("4 - Sair.");
        System.out.print("\nEscolha uma opção: ");
    }

    public static void pausar() {
        System.out.println("Pressione Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Scanner scanner = new Scanner(System.in);
    static Contacorrente conta;

    public static void main(String[] args) throws Exception {
        
        int opcao = 0;
        do {
            imprimeMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consome a nova linha
            limparTela();

            switch (opcao) {
                case 0:
                    if (conta == null) {
                        conta = Contacorrente.cadastrarContaCorrente(scanner);
                        pausar();
                        limparTela();
                    } else {
                        System.out.println("Você já cadastrou uma conta!");
                        pausar();
                        limparTela();
                    }
                    break;
                case 1:
                    if (conta != null) {
                        System.out.println("========== DEPÓSITO DE VALOR ==========\n");
                        System.out.println("Insira o nome do titular da conta para realizar o depósito: ");
                        String nomeTitularDaContaPesquisado = scanner.nextLine();
                        System.out.println("Insira o CPF do titular da conta para realizar o depósito: ");
                        String cpfTitularDacontaPesquisado = scanner.nextLine();
                        System.out.println("Insira a senha cadastrada pelo titular da conta para realizar o depósito: ");
                        String senhaDaContaInserida = scanner.nextLine();
                        System.out.print("Insira o valor para depósito: ");
                        float valorDeposito = scanner.nextFloat();
                        scanner.nextLine();  // Consome a nova linha
                        limparTela();
                        conta.depositar(nomeTitularDaContaPesquisado, cpfTitularDacontaPesquisado, senhaDaContaInserida, valorDeposito);
                        conta.imprimirComprovanteDeDeposito(valorDeposito);
                        pausar();
                        limparTela();
                    } else {
                        System.out.println("Nenhuma conta cadastrada!");
                        pausar();
                        limparTela();
                    }
                    break;
                case 2:
                    if (conta != null) {
                        System.out.println("========== SAQUE DE VALOR ==========\n");
                        System.out.println("Insira o nome do titular da conta para realizar o saque: ");
                        String nomeTitularDaContaPesquisado = scanner.nextLine();
                        System.out.println("Insira o CPF do titular da conta para realizar o saque: ");
                        String cpfTitularDacontaPesquisado = scanner.nextLine();
                        System.out.println("Insira a senha cadastrada pelo titular da conta para realizar o saque: ");
                        String senhaDaContaInserida = scanner.nextLine();
                        System.out.print("Insira o valor para saque: ");
                        float valorSaque = scanner.nextFloat();
                        scanner.nextLine();  // Consome a nova linha
                        limparTela();
                        float taxa = valorSaque * 0.005f;  // Calcula a taxa correta
                        conta.sacar(nomeTitularDaContaPesquisado, cpfTitularDacontaPesquisado, senhaDaContaInserida, valorSaque);
                        conta.imprimirComprovanteDeSaque(valorSaque, taxa);
                        pausar();
                        limparTela();
                    } else {
                        System.out.println("Nenhuma conta cadastrada!");
                        pausar();
                        limparTela();
                    }
                    break;
                case 3:
                    if (conta != null) {
                        System.out.println("========== SITUAÇÃO DA CONTA ==========\n");
                        System.out.println("Insira o nome do titular da conta para visualizar os dados: ");
                        String nomeTitularDaContaPesquisado = scanner.nextLine();
                        System.out.println("Insira o CPF do titular da conta para visualizar os dados: ");
                        String cpfTitularDacontaPesquisado = scanner.nextLine();
                        System.out.println("Insira a senha cadastrada pelo titular da conta para visualizar os dados: ");
                        String senhaDaContaInserida = scanner.nextLine();
                        limparTela();
                        conta.imprimirContaCorrente(nomeTitularDaContaPesquisado, cpfTitularDacontaPesquisado, senhaDaContaInserida);
                        pausar();
                        limparTela();
                    } else {
                        System.out.println("Nenhuma conta cadastrada!");
                        pausar();
                        limparTela();
                    }
                    break;
                case 4:
                    System.out.println("Encerrando a execução do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
                    pausar();
                    limparTela();
                    break;
            }
        } while (opcao != 4);

        scanner.close();
    }
}
