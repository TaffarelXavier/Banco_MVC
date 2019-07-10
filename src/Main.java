
import Classes.Agencia;
import Classes.Conta;
import Classes.Endereco;
import Classes.Cliente;
import Classes.Empresa;
import Classes.Funcionario;
import Classes.Login;
import Controller.ContollerEmpresa;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Esta classe é responsável por iniciar o programa. No primeiro método (Main), iniciarPrograma, são criados alguns vetores, a saber: de Clientes, contas e etc. Criação da Empresa, na variável banco, que foi instanciada da classe Empressa, porque todo Banco é uma empresa.
 *
 * Para ter noção
 *
 * @author Taffarel Xavier e Ramon 3º Período de Licenciatura em Computação<taffarel_deus@hotmail.com>
 */
public class Main {

    static void mostrarMenuPrincipal(String linha) {
        System.out.println();
        System.out.println(linha);
        System.out.println("\t\tMenu Principal");
        System.out.println("1 - Menu Funcionário");
        System.out.println("2 - Menu Cliente");
        System.out.println("3 - Sair");
        System.out.println(linha);
        System.out.print("Escolha uma opção: ");
    }

    /**
     *
     * @param linha
     * @param tipo : Pode ser Funcionário ou cliente
     */
    static void subMenu(String linha, String tipo) {
        System.out.println(linha);
        System.out.println("Menu Principal>" + tipo);

        if (tipo.equals("Funcionários")) {
            System.out.println("1 - Cadastrar Novo Funcionário");
            System.out.println("2 - Cadastrar Novo Cliente");
            System.out.println("3 - Listar Funcionários");
            System.out.println("4 - Fazer Logout");
            System.out.println("5 - Pesquisar Funcionário");
            System.out.println("6 - Encerrar Sessão");

        } else {
            System.out.println("1 - adfa");
            System.out.println("2 - Menu Cliente");
            System.out.println("3 - Sair");
        }

        System.out.println(linha);
        System.out.print("Escolha uma opção: ");
    }

    /**
     * Inicialização de Algumas Variáveis e alguns dados.
     */
    public static void IniciarPrograma() {
        /**
         * BANCO DE DADOS COMO VETORES:
         */
        //Criando o Endereço da Empresa
        Endereco endEmpresa = new Endereco("Augustinópolis", "TO", "Rua Dom Pedro II");

        //Criando uma agência e relacinando com o endereço criado acima.
        Agencia agencia = new Agencia("8484", endEmpresa);

        //Criação da Empresa e relacionado-a ao endereço criado acima.
        Empresa banco = ContollerEmpresa.cadastrarEmpresa("TRD LTDA",
                "39.586.598/0001-88", "893.175.693.098", "21-03-2019", "626", "AD", endEmpresa);

        //Criação de 5 Cadastros de Clientes:
        Cliente[] clientes = new Cliente[6];

        clientes[0] = new Cliente("Raimundo Osvaldo Juan Assis", "M",
                new Endereco("Sampaio", "TO", "Rua Dom Vital"), "152.765.411-70");

        clientes[1] = new Cliente("Valentina Rafaela Sarah", "F",
                new Endereco("Sampaio", "TO", "Rua Dom Vital"), "135.765.411-71");

        clientes[2] = new Cliente("Antonella Laura da Mota", "F",
                new Endereco("Sampaio", "TO", "Rua Dom Vital"), "152.765.411-75");

        clientes[3] = new Cliente("Luan Breno Ramos", "M",
                new Endereco("Sampaio", "TO", "Rua Dom Vital"), "504.470.651-57");

        clientes[4] = new Cliente("Alícia Isabelle Marcela Monteiro", "F",
                new Endereco("Sampaio", "TO", "Rua Dom Vital"), "112.784.741-45");

        clientes[5] = new Cliente("Iara Brito de Sousa Xavier", "F",
                new Endereco("Sampaio", "TO", "Rua Dom Vital"), "112.784.741-45");

        //Vetor: Criação de 5 contas
        Conta[] contas = new Conta[7];

        contas[1] = new Conta(clientes[0], agencia, "C", banco, 0001, "123", 20);
        contas[2] = new Conta(clientes[1], agencia, "P", banco, 0002, "123", 20);
        contas[3] = new Conta(clientes[2], agencia, "P", banco, 0003, "123", 20);
        contas[4] = new Conta(clientes[3], agencia, "C", banco, 0004, "123", 20);
        contas[5] = new Conta(clientes[4], agencia, "P", banco, 0005, "123", 20);
        contas[6] = new Conta(clientes[5], agencia, "C", banco, 0005, "iara", 10);

        //<!-- FIM DO BANCO DE DADOS
        /**
         * INICIALIZAÇÃO DAS ATIVIDADES
         */
        //Conta contaTranferencia = new Conta();
        //contaTranferencia.setContas(contas);
        /*Para selecionar uma conta.
            Entrada do usuário:*/
        int numeroConta2, numeroAgenciaCliente, errosTentativasLogin = 0;

        String senhaUsuario;

        Scanner nConta = new Scanner(System.in);

        Scanner contaSenha = new Scanner(System.in);

        Scanner entrada = new Scanner(System.in);

        String linha = contas[1].linhaDivisoria;

        System.out.println(linha);
        System.out.println("\t\tTAFFAREL, RAMON E DIANA:");
        System.out.println(linha);
        System.out.println(linha);
        System.out.print("+-----------------BANCO:" + banco.getNome().toUpperCase() + "-------------------------+\n"
                + "+-----------------CNPJ:\t" + banco.getCNPJ() + "---------------+\n");

        boolean logado;

        int sessao = 1;

        while (sessao == 1) {

            int numeroOpcao;

            mostrarMenuPrincipal(linha);

            while (!entrada.hasNextInt()) {
                entrada.next();
                mostrarMenuPrincipal(linha);
            }

            numeroOpcao = entrada.nextInt();

            switch (numeroOpcao) {

                case 1: //Funcionários

                    //Se o login estiver OKAY
                    if (Login.fazerLogin() == true) {

                        logado = true;

                        System.out.println("Boa noite");

                        subMenu(linha, "Funcionários");

                        while (logado) {

                            entrada = new Scanner(System.in);

                            int opcaoFunciona = entrada.nextInt();

                            switch (opcaoFunciona) {
                                case 1:
                                    System.out.println("\n+-------------Cadastrar Novo Funcionário-------------+\n");

                                    entrada = new Scanner(System.in);

                                    System.out.print("Nome do Funcionário:");
                                    String nome = entrada.nextLine();

                                    System.out.print("CPF:");
                                    String cpf = entrada.nextLine();

                                    System.out.print("Senha:");
                                    String senha = entrada.nextLine();

                                    Funcionario.cadastrarFuncionario(nome, cpf, senha);
                                    break;
                                case 2:
                                    //System.out.println(Funcionario.getTotalDeFuncionarios());
                                    break;
                                case 3:
                                    Funcionario.listarTodosFuncionarios(linha);
                                    break;
                                case 4:
                                    System.out.println("Logout Realizado com Sucesso!");
                                    logado = false;
                                    //sessao = -1;
                                    break;
                                case 5:
                                    entrada = new Scanner(System.in);

                                    String cpfFuncionario = entrada.nextLine();

                                    Funcionario.pesquisarFuncionarioPorCPF(cpfFuncionario);
                                    // sessao = -1;
                                    break;
                                case 6:
                                    System.exit(0);
                                    // sessao = -1;
                                    break;
                                default:
                                    System.out.println("Opção Inválida");
                                    break;
                            }
                            subMenu(linha, "Funcionários");
                        }

                    }

                    break;

                case 2: //Clientes
                    subMenu(linha, "Clientes");
                    System.out.println(linha);
                    System.out.println();
                    System.out.print("NÚMERO DA CONTA:");

                    //Verifica se o número digitado é um número.
                    while (!nConta.hasNextInt()) {
                        nConta.next();
                        System.out.print("NÚMERO DA CONTA:");
                    }

                    numeroConta2 = nConta.nextInt();

                    while (numeroConta2 > (contas.length - 1) || numeroConta2 == 0) {
                        System.out.print("Conta não encontrada.\n" + linha + "\n"
                                + "NÚMERO DA CONTA:");
                        //Verifica se o número digitado é um número.
                        while (!nConta.hasNextInt()) {
                            nConta.next();
                            System.out.print("NÚMERO DA CONTA:");
                        }
                        numeroConta2 = nConta.nextInt();
                    }

                    //VERIFICAÇÃO DA AGÊNCIA
                    System.out.print("NÚMERO DA AGÊNCIA:");

                    while (!entrada.hasNext()) {
                        entrada.next();
                        System.out.print("NÚMERO DA AGÊNCIA:");
                    }

                    numeroAgenciaCliente = entrada.nextInt();

                    while (numeroAgenciaCliente != Integer.parseInt(contas[numeroConta2].getAgencia().getAgenciaNumero())) {
                        System.out.print("AGÊNCIA NÃO ENCONTRADA:");
                        entrada.next();
                    }

                    //FIM VERIFICAÇÃO DA AGÊNCIA
                    System.out.print("SENHA:");

                    senhaUsuario = contaSenha.nextLine();

                    //Verificação da senha.
                    while (!senhaUsuario.equals(contas[numeroConta2].getSenha())) {
                        System.out.println("\t\tSenha incorreta!");
                        ++errosTentativasLogin;
                        if (errosTentativasLogin <= 1) {
                            System.out.println("\nVocê só tem mais 3 chances,\ncaso contrário, sua conta será bloqueada:\n");
                            System.out.print("SENHA:");
                        } else {
                            System.out.print("SENHA:");
                        }
                        senhaUsuario = contaSenha.nextLine();
                        if (errosTentativasLogin >= 4) {
                            JOptionPane.showMessageDialog(null, "Sua conta foi bloqueada");
                            System.exit(0);
                        }

                    }

                    contas[numeroConta2].detalheDaContaCliente();

                    System.out.println(linha);

                    //Iniciar Transações para a conta número 0.
                    contas[numeroConta2].iniciar(contas);
                    break;

                case 3:
                    System.exit(0);
                    break;
            }

        }

    }

    public static void main(String[] args) {

        //Inicializa todo o programa
        Main.IniciarPrograma();

    }

}
