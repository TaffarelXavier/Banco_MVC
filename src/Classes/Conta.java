/**
 * CRIADORES:
 * FRANCISCO TAFFAREL XAVIER DE BRITO,
 * RAMON DEIVID,
 * DIANA
 */
package Classes;

import java.util.Arrays;
import java.util.Scanner;

public class Conta {

    /**
     * O cliente relacionado a esta conta.
     */
    private Cliente cliente;

    public String linhaDivisoria = "+--------------------------------------------------------+";

    
    /**
     *
     */
    private boolean isConjugado;

    /**
     *
     */
    private Agencia agencia;

    /**
     *
     */
    private Empresa banco;

    /**
     *
     */
    private String senha;

    /**
     * tipoConta: Corrente, Poupança, Poupança e Corrente.
     */
    private String tipoConta;

    /**
     *
     */
    private int numeroConta;

    /**
     *
     */
    private int saques;

    /**
     *
     */
    private double saldo;

    
    private Conta contas[];

    public Conta[] getContas() {
        return contas;
    }
    
    private final Scanner entrada;


    /**
     *
     * @return
     */
    public String getSenha() {
        return senha;
    }


    public Agencia getAgencia() {
        return agencia;
    }


    public String getTipoConta() {
        return tipoConta;
    }


    public int getNumeroConta() {
        return numeroConta;
    }


    public Conta() {
        this.entrada = new Scanner(System.in);
    }

    /**
     *
     * @param cliente
     * @param agencia
     * @param tipoConta Pode Ser C=Correte, P=Poupança
     * @param banco
     * @param numeroConta
     * @param senha
     * @param saldo
     */
    public Conta(Cliente cliente,
            Agencia agencia, String tipoConta, Empresa banco,
            int numeroConta, String senha, double saldo) {
        this.entrada = new Scanner(System.in);
        this.cliente = cliente;
        this.agencia = agencia;
        this.tipoConta = tipoConta;
        this.banco = banco;
        this.numeroConta = numeroConta;
        this.senha = senha;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    /**
     *
     */
    public void extrato() {
        System.out.println(this.linhaDivisoria);
        System.out.println("\t\t\tEXTRATO");
        System.out.println("NÚMERO DA CONTA:\t" + this.numeroConta);
        System.out.println("NÚMERO AGÊNCIA:\t\t" + this.agencia.getAgenciaNumero());
        System.out.printf("SALDO ATUAL:\t\t%.2f\n", this.saldo);
        System.out.println("SAQUES FEITOS HOJE:\t" + this.saques + "\n");
    }

    /**
     *
     */
    public void detalheDaContaCliente() {
        System.out.println(this.linhaDivisoria);
        System.out.println("\t\t\tDETALHES");
        System.out.println("TÍTULAR:\t\t" + this.cliente.getNome());
        System.out.println("NÚMERO DA CONTA:\t" + this.numeroConta);
        System.out.println("NÚMERO AGÊNCIA:\t\t" + this.agencia.getAgenciaNumero());
        System.out.printf("SALDO ATUAL:\t\t%.2f\n", this.saldo);
        System.out.println("SAQUES FEITOS HOJE:\t" + this.saques + "\n");
    }

    /**
     *
     * @param valor
     */
    public void sacar(double valor) {

        if (saldo >= valor) {
            saldo = saldo - valor;
            saques++;
            System.out.println("Sacado: " + valor);
            System.out.println("Novo saldo: " + saldo + "\n");
        } else {
            System.out.println("Saldo insuficiente. Faça um depósito\n");
        }
    }

    /**
     *
     * @param valor
     */
    public void trasferirTo(double valor) {
        if (saldo >= valor) {
            saldo = saldo - valor;
            saques++;
            System.out.println("Transferido: " + valor);
            System.out.println("Novo saldo: " + saldo + "\n");
        } else {
            System.out.println("Saldo insuficiente. Faça um depósito\n");
        }
    }

    /**
     *
     * @param valor
     */
    public void depositar(double valor) {
        saldo = saldo + valor;
        System.out.println("Depositado: " + valor);
        System.out.println("Novo saldo: " + saldo + "\n");
    }

    /**
     * <p>
     * Inicia Transações. Enquanto a opção for diferente de 4,<br>
     * que é para sair do sistema, fica executando transações<br>
     * referentes a uma conta de um cliente.
     * </p>
     *
     * @param contas
     */
    public void iniciar(Conta[] contas) {

        int opcao;

        do {

            mostrarOpcoes();

            while (!entrada.hasNextInt()) {
                entrada.next();
                System.out.print("Digite um número inteiro entre 1 e 6, por favor:");
            }
            opcao = entrada.nextInt();

            selecionarNovaOpcao(opcao, contas);

        } while (opcao != 5);

    }

    /**
     * Inicia
     */
    public void mostrarOpcoes() {

        System.out.println("\t\t\tEscolha uma das opções abaixo:".toUpperCase());
        System.out.println("1 - CONSULTAR EXTRATO");
        System.out.println("2 - SACAR");
        System.out.println("3 - DEPOSITAR");
        System.out.println("4 - TRANSFERIR");
        System.out.println("5 - MUDAR CONTA");
        System.out.println("6 - SAIR\n");
        System.out.print("Opção: ");

    }

    /**
     * <p style="font-weight:900;">Todas essas opções são referente a uma conta que está relacionada a um cliente.</p>
     *
     * @param opcao Pode ser: 1=Mostrar o Extrato;2=Sacar;3=Depositar, 4=Transferir;5=sair
     * @param contas
     */
    public void selecionarNovaOpcao(int opcao, Conta[] contas) {

        try {

            double valor;

            switch (opcao) {
                case 1:
                    extrato();
                    break;
                case 2: //Sacar
                    if (saques < 3) {
                        System.out.println(this.linhaDivisoria);
                        System.out.println("\t\t\tSACAR");
                        System.out.print("VALOR:");
                        valor = entrada.nextDouble();
                        sacar(valor);
                    } else {
                        System.out.println("Limite de saques diários atingidos.\n");
                    }
                    break;

                case 3: //Depósito
                    System.out.println(this.linhaDivisoria);
                    System.out.println("\t\t\tDEPÓSITO");
                    System.out.print("VALOR: ");
                    valor = entrada.nextDouble();
                    depositar(valor);
                    break;
                case 4:
                    transferir(contas);
                    break;

                case 5:
                    System.out.println("LOGOUT realizado com sucesso!");
                    break;
                case 6:
                    System.out.println("Sistema encerrado.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA");
            }

            System.out.println(this.linhaDivisoria);

        } catch (Exception ex) {
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }

    }

    /**
     * TRANSFERIR PARA O PRÓPRIO CLIENTE OU PARA SI.
     *
     * @param contas
     */
    public void transferir(Conta[] contas) {

        System.out.println(this.linhaDivisoria);

        System.out.println("\t\t\tTRANSFERÊNCIA");

        try {
            int numContaParaTransferir;

            System.out.println(this.linhaDivisoria);

            System.out.print("Digite o número da conta para a\n"
                    + "qual você quer fazer a transferência:");

            numContaParaTransferir = entrada.nextInt();

            //Se for para  a mesma conta logada,
            //no entanto, com tipos diferentes.
            Conta minhaConta = contas[numContaParaTransferir];

            if (this.getNumeroConta() == numContaParaTransferir) {

                System.out.println("TÍTULAR:\t\t"
                        + minhaConta.getCliente().getNome());
                System.out.println("NÚMERO DA CONTA:\t"
                        + minhaConta.getNumeroConta());
                System.out.println("NÚMERO AGÊNCIA:\t\t"
                        + minhaConta.getAgencia().getAgenciaNumero());
                System.out.println("TIPO DA CONTA:\t\t"
                        + minhaConta.getTipoConta());
                System.out.println();

                /*Faz uma interação para pesquisar no vetor
                de contas para pesquisar se o cliente tem mais de uma 
                conta.
                 */
                for (int k = 1; k < contas.length; k++) {
                    //Verifica somente se os CPF do vetor Contas é igual ao CPF do Cliente selecionado.
                    if (contas[numContaParaTransferir].getCliente().getCpf()
                            .equals(contas[k].getCliente().getCpf())) {

                        /*Algo interessante: se o cliente tiver mais de uma conta
                        aqui, é verificado se a conta do cliente é diferente (!) da que está
                        inteirada no vetor contas. Por exemplo: se a conta do cliente que logou é do tipo P (Poupança) e
                        ele tem mais de uma conta, então, aqui vai selecionar a conta C (Corrente).*/
                        if (!(contas[k].getTipoConta()
                                .equals(minhaConta.getTipoConta()))) {

                            System.out.print("Digite o valor da transferência:");

                            //Valor da transferência:
                            double valorTransferencia;

                            valorTransferencia = entrada.nextDouble();

                            System.out.println(valorTransferencia);

                            String confirmaTransferencia;

                            System.out.print("Para confirmar, digite 's' para sim ou 'n' para cancelar:");

                            confirmaTransferencia = entrada.next().trim();

                            while (!confirmaTransferencia.equals("s") && !confirmaTransferencia.equals("n")) {
                                System.out.print("Para confirmar, digite 's' para sim ou 'n' para cancelar:");
                                confirmaTransferencia = entrada.next();
                            }

                            if (confirmaTransferencia.equals("s")) {
                                //Deposita para
                                contas[k].depositar(valorTransferencia);

                                //Tira de
                                this.trasferirTo(valorTransferencia);

                            }
                        }
                    }

                }

            } else {

                Conta outraConta = contas[numContaParaTransferir];

                System.out.println("TÍTULAR:\t\t"
                        + outraConta.getCliente().getNome());

                System.out.println("NÚMERO DA CONTA:\t"
                        + outraConta.getNumeroConta());

                System.out.println("NÚMERO AGÊNCIA:\t\t"
                        + outraConta.getAgencia().getAgenciaNumero());

                System.out.println("TIPO DA CONTA:\t\t"
                        + outraConta.getTipoConta());

                System.out.println();

                System.out.print("Digite o valor da transferência:");

                //Valor da transferência:
                double valorTransferencia;

                valorTransferencia = entrada.nextDouble();

                System.out.println(valorTransferencia);

                String confirmaTransferencia;

                System.out.print("Para confirmar, digite 's' para sim ou 'n' para cancelar:");

                confirmaTransferencia = entrada.next().trim();

                while (!confirmaTransferencia.equals("s") && !confirmaTransferencia.equals("n")) {
                    System.out.print("Para confirmar, digite 's' para sim ou 'n' para cancelar:");
                    confirmaTransferencia = entrada.next();
                }

                if (confirmaTransferencia.equals("s")) {
                    outraConta.depositar(valorTransferencia);
                    this.trasferirTo(valorTransferencia);
                }
            }
            System.out.println(this.linhaDivisoria);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}