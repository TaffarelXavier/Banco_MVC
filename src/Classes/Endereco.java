/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 */
public class Endereco {
        
    /**
     * 
     */
    private String cidade;
    /**
     * 
     */
    private String uf;
    /**
     * 
     */
    private String endereco;
    
    /**
     * 
     */
    private String bairro;
    
    /**
     * 
     */
    private String CEP;
    
    
    
    public Endereco(String cidade, String uf, String endereco) {
        this.cidade = cidade;
        this.uf = uf;
        this.endereco = endereco;
    }

}
