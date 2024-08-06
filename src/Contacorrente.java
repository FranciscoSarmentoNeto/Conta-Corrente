import java.util.Random;
import java.util.Scanner;

public class Contacorrente {
    private float saldoAtualDaConta = 0f;
    private String nomeTitularDaConta = "";
    private String cpfTitularDaConta = "";
    private String numeroDeTelefoneTitularDaconta = "";
    private String senhaDaConta = "";
    private String numeroDaConta = "";
    static Contacorrente conta = new Contacorrente();
    
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

    public static Contacorrente cadastrarContaCorrente(Scanner scanner) {
        System.out.println("========== CADASTRO DE CONTA CORRENTE ==========\n");
        System.out.println("Insira o nome do titular da conta: ");
        conta.nomeTitularDaConta = scanner.nextLine();
        System.out.println("Insira o CPF do titular da conta: ");
        conta.cpfTitularDaConta = scanner.nextLine();
        System.out.println("Insira o número de telefone do titular da conta: ");
        conta.numeroDeTelefoneTitularDaconta = scanner.nextLine();
        System.out.println("Cadastre uma senha para a conta: ");
        conta.senhaDaConta = scanner.nextLine();
        System.out.print("Insira o valor inicial da conta: ");
        conta.saldoAtualDaConta = scanner.nextFloat();
        scanner.nextLine();  // Consome a nova linha
        conta.setSaldoInicial(conta.saldoAtualDaConta);
        limparTela();
        System.out.println("Conta cadastrada com sucesso!\n");
        System.out.println("Detalhes da conta corrente cadastrada:\n");
        System.out.println("Nome do titular: " + conta.nomeTitularDaConta);
        System.out.println("CPF do titular: " + conta.cpfTitularDaConta);
        System.out.println("Número de telefone do titular: " + conta.numeroDeTelefoneTitularDaconta);
        System.out.println("Senha cadastrada: " + conta.senhaDaConta);
        System.out.println("Número da conta: " + conta.numeroDaConta);
        System.out.println("Saldo atual da conta: R$ " + conta.saldoAtualDaConta + "\n");

        return conta;
    }

    public void depositar(String nomeTitularDaContaPesquisado, String cpfTitularDacontaPesquisado, String senhaDaContaInserida, float quantia) {
        boolean contaPesquisadaEncontrada = false;

        if (nomeTitularDaContaPesquisado.equals(conta.nomeTitularDaConta)
                && cpfTitularDacontaPesquisado.equals(conta.cpfTitularDaConta)
                && senhaDaContaInserida.equals(conta.senhaDaConta)) {
            contaPesquisadaEncontrada = true;
        }

        if (contaPesquisadaEncontrada && quantia > 0) {
            saldoAtualDaConta += quantia;
            System.out.println("Depósito de R$ " + quantia + " realizado com sucesso.");
        } else if (quantia <= 0) {
            System.out.println("Depósito inválido. A quantia deve ser maior que zero.");
        } else if (!contaPesquisadaEncontrada) {
            System.out.println("Erro: conta pesquisada não encontrada.");
        }
    }

    public void sacar(String nomeTitularDaContaPesquisado, String cpfTitularDacontaPesquisado, String senhaDaContaInserida, float quantia) {
        boolean contaPesquisadaEncontrada = false;

        if (nomeTitularDaContaPesquisado.equals(conta.nomeTitularDaConta)
                && cpfTitularDacontaPesquisado.equals(conta.cpfTitularDaConta)
                && senhaDaContaInserida.equals(conta.senhaDaConta)) {
            contaPesquisadaEncontrada = true;
        }

        if (contaPesquisadaEncontrada && quantia > 0) {
            if (saldoAtualDaConta >= quantia) {
                saldoAtualDaConta -= quantia;
                System.out.println("Saque de R$ " + quantia + " realizado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para realizar o saque.");
            }
        } else if (quantia <= 0) {
            System.out.println("Saque inválido. A quantia deve ser maior que zero.");
        } else if (!contaPesquisadaEncontrada) {
            System.out.println("Erro: conta pesquisada não encontrada.");
        }
    }

    public void imprimirComprovanteDeDeposito(float quantia) {
        System.out.println("\n========== COMPROVANTE DE DEPÓSITO ==========");
        System.out.println("Titular da conta: " + conta.nomeTitularDaConta);
        System.out.println("CPF do titular da conta: " + conta.cpfTitularDaConta);
        System.out.println("Valor depositado: R$ " + quantia);
        System.out.println("Saldo atual: R$ " + conta.saldoAtualDaConta);
        System.out.println("===========================================\n");
    }

    public void imprimirComprovanteDeSaque(float quantia, float taxa) {
        System.out.println("\n========== COMPROVANTE DE SAQUE ==========");
        System.out.println("Titular da conta: " + conta.nomeTitularDaConta);
        System.out.println("CPF do titular da conta: " + conta.cpfTitularDaConta);
        System.out.println("Valor sacado: R$ " + quantia);
        System.out.println("Taxa de saque: R$ " + taxa);
        System.out.println("Saldo atual: R$ " + conta.saldoAtualDaConta);
        System.out.println("=========================================\n");
    }

    public void imprimirContaCorrente(String nomeTitularDaContaPesquisado, String cpfTitularDacontaPesquisado, String senhaDaContaInserida) {
        boolean contaPesquisadaEncontrada = false;

        if (nomeTitularDaContaPesquisado.equals(conta.nomeTitularDaConta)
                && cpfTitularDacontaPesquisado.equals(conta.cpfTitularDaConta)
                && senhaDaContaInserida.equals(conta.senhaDaConta)) {
            contaPesquisadaEncontrada = true;
        }

        if (contaPesquisadaEncontrada) {
            System.out.println("\n========== DETALHES DA CONTA CORRENTE ==========");
            System.out.println("Nome do titular: " + conta.nomeTitularDaConta);
            System.out.println("CPF do titular: " + conta.cpfTitularDaConta);
            System.out.println("Número de telefone do titular: " + conta.numeroDeTelefoneTitularDaconta);
            System.out.println("Número da conta: " + conta.numeroDaConta);
            System.out.println("Saldo atual: R$ " + conta.saldoAtualDaConta);
            System.out.println("===============================================\n");
        } else {
            System.out.println("Erro: conta pesquisada não encontrada.");
        }
    }

    private void setSaldoInicial(float saldoInicial) {
        this.saldoAtualDaConta = saldoInicial;
        this.numeroDaConta = gerarNumeroConta();
    }

    private String gerarNumeroConta() {
        Random random = new Random();
        StringBuilder numeroConta = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            numeroConta.append(random.nextInt(10));
        }
        return numeroConta.toString();
    }
}
