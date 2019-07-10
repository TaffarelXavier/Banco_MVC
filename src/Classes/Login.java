/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Scanner;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 */
public class Login {

    private static Scanner entrada;

    static {
        //Cria o funcionário padrão/administrador número 1.
        Funcionario funcionario = new Funcionario();
    }

    public static boolean fazerLogin() {

        entrada = new Scanner(System.in);

        boolean logado = false;

        System.out.print("Digite o CPF:");

        String cpfLogin = entrada.nextLine();

        System.out.print("Digite a senha: ");

        String senhaLogin = entrada.nextLine();

        int quantTentativasLogin = 1;

        while (!logado) {

            if (quantTentativasLogin < 3) {

                for (Funcionario pessoa : Funcionario.getFuncionarios()) {
                    if (pessoa.getCpf().equals(cpfLogin) && pessoa.getSenha().equals(senhaLogin)) {
                        return true;
                    } else {
                        System.out.println("Usuário ou senha incorretos.\n");

                        System.out.print("Digite o CPF:");

                        cpfLogin = entrada.nextLine();

                        System.out.print("Digite a senha: ");

                        senhaLogin = entrada.nextLine();

                        quantTentativasLogin++;

                        break;
                    }
                }

            } else {
                return false;
            }

        }
        return false;
    }
}
