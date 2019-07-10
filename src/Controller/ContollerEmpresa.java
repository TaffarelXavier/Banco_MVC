/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.List;

import Classes.Empresa;
import Classes.Endereco;

/**
 *
 * @author Taffrel Xavier <taffarel_deus@hotmail.com>
 */
public class ContollerEmpresa {

    private static List<Empresa> empresa = new ArrayList<>();

    public static Empresa cadastrarEmpresa(String nome, String CNPJ,
            String inscricaoEstadual,
            String dataAbertura,
            String numero,
            String telefone,
            Endereco endereco) {
        empresa.add(new Empresa(nome, CNPJ, inscricaoEstadual, dataAbertura, numero, telefone, endereco));
        
        return empresa.get(empresa.size());
        
    }
}
