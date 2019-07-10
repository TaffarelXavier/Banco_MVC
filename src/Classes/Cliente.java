package Classes;

/**
 *
 * @author Taffarel Xavier e Ramon - do 3º Período de Licenciatura em Computação<taffarel_deus@hotmail.com>
 */
public class Cliente {

    /**
     *
     */
    private String nome;

    /**
     *
     */
    private String sexo;

    /**
     *
     */
    private Endereco endereco;

    /**
     *
     */
    private String cpf;

    /**
     *
     * @param nome
     * @param sexo
     * @param endereco
     * @param cpf
     */
    public Cliente(String nome, String sexo,
            Endereco endereco, String cpf) {
        this.nome = nome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

}
