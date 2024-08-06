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

    public static Contacorrente cadastrarContaCorrente(Scanner scanner) {

        System.out.println("========== CADASTRO DE CONTA CORRENTE ==========\n");
        System.out.println("Insira o nome do titular da conta: ");
        conta.nomeTitularDaConta = scanner.nextLine();
        System.out.println("Insira o CPF do titular da conta: ");
        conta.cpfTitularDaConta = scanner.nextLine();
        System.out.println("Insira o número de telefone do titular da conta");
        conta.numeroDeTelefoneTitularDaconta = scanner.nextLine();
        System.out.println("Cadastre uma senha para a conta: ");
        conta.senhaDaConta = scanner.nextLine();
        System.out.print("Insira o valor inicial da conta: ");
        conta.saldoAtualDaConta = scanner.nextFloat();
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

    public void depositar(String nomeTitularDaContaPesquisado, String cpfTitularDacontaPesquisado,
            String senhaDaContaInserida, float quantia) {

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
        } else if (contaPesquisadaEncontrada == false) {
            System.out.println("Erro: conta pesquisada não encontrada.");
        }

    }

    public void sacar(String nomeTitularDaContaPesquisado, String cpfTitularDacontaPesquisado,
            String senhaDaContaInserida, float quantia) {

        boolean contaPesquisadaEncontrada = false;

        if (nomeTitularDaContaPesquisado.equals(conta.nomeTitularDaConta)
                && cpfTitularDacontaPesquisado.equals(conta.cpfTitularDaConta)
                && senhaDaContaInserida.equals(conta.senhaDaConta)) {

            contaPesquisadaEncontrada = true;
        }

        float taxa = quantia * 0.005f;
        float valorTotal = quantia + taxa;
        if (contaPesquisadaEncontrada && quantia > 0 && saldoAtualDaConta >= valorTotal) {
            saldoAtualDaConta -= valorTotal;
            System.out.println("Saque de R$ " + quantia + " realizado com sucesso. Taxa de operação: R$ " + taxa);
        } else if (quantia <= 0) {
            System.out.println("Saque inválido. A quantia deve ser maior que zero.");
        } else {
            System.out.println("Saldo insuficiente. Saque não realizado.");
        }
    }

    public void imprimirContaCorrente(String nomeTitularDaContaPesquisado, String cpfTitularDacontaPesquisado,
            String senhaDaContaInserida) {

        if (nomeTitularDaContaPesquisado.equals(conta.nomeTitularDaConta)
                && cpfTitularDacontaPesquisado.equals(conta.cpfTitularDaConta)
                && senhaDaContaInserida.equals(conta.senhaDaConta)) {

            System.out.println("Detalhes da Conta Corrente:\n");
            System.out.println("Nome do titular: " + nomeTitularDaConta);
            System.out.println("CPF do titular: " + cpfTitularDaConta);
            System.out.println("Número de telefone do titular: " + numeroDeTelefoneTitularDaconta);
            System.out.println("Senha cadastrada: " + senhaDaConta);
            System.out.println("Número da conta: " + numeroDaConta);
            System.out.println("Saldo atual da conta: R$ " + saldoAtualDaConta + "\n");
            pausar();
            limparTela();

        }

    }

    public void imprimirComprovanteDeDepósito() {

        /* FAZER ISSO */

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
 nao sei
    private String gerarNumeroAleatorio() {
        Random random = new Random();
        return String.format("%09d", random.nextInt(900000000) + 100000000);
    }

    public Contacorrente() {
        this.numeroDaConta = gerarNumeroAleatorio();
        ;
    }

    public void setSaldoInicial(float saldoInicial) {
        this.saldoAtualDaConta = saldoInicial;
    }

    public String getNomeTitularDaConta() {
        return nomeTitularDaConta;
    }

    public void setNomeTitularDaConta(String nomeTitularDaConta) {
        this.nomeTitularDaConta = nomeTitularDaConta;
    }

    public String getCpfTitularDaConta() {
        return cpfTitularDaConta;
    }

    public void setCpfTitularDaConta(String cpfTitularDaConta) {
        this.cpfTitularDaConta = cpfTitularDaConta;
    }

    public String getNumeroDeTelefoneTitularDaconta() {
        return numeroDeTelefoneTitularDaconta;
    }

    public void setNumeroDeTelefoneTitularDaconta(String numeroDeTelefoneTitularDaconta) {
        this.numeroDeTelefoneTitularDaconta = numeroDeTelefoneTitularDaconta;
    }

    public float getSaldoAtualDaConta() {
        return saldoAtualDaConta;
    }

    public void setSaldoAtualDaConta(float saldoAtualDaConta) {
        this.saldoAtualDaConta = saldoAtualDaConta;
    }

    public String getSenhaDaConta() {
        return senhaDaConta;
    }

    public void setSenhaDaConta(String senhaDaConta) {
        this.senhaDaConta = senhaDaConta;
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(String numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public static Contacorrente getConta() {
        return conta;
    }

    public static void setConta(Contacorrente conta) {
        Contacorrente.conta = conta;
    }

}
