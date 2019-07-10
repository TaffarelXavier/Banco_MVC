package Classes;

/**
 * Esta classe tem por objetivo a criação de bancos.
 *
 * @author Taffarel Xavier e Ramon 3º Período de Licenciatura em Computação
 * <taffarel_deus@hotmail.com>
 */
public class Empresa {

    /**
     *
     */
    private String nome;

    /**
     *
     */
    private String CNPJ;

    /**
     *
     */
    private String inscricaoEstadual;

    /**
     *
     */
    private String dataAbertura;

    /**
     *
     */
    private String numero;

    /**
     *
     */
    private String telefone;

    /**
     *
     */
    private Endereco endereco;

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return
     */
    public String getCNPJ() {
        return CNPJ;
    }

    /**
     * 
     * @param nome
     * @param CNPJ
     * @param inscricaoEstadual
     * @param dataAbertura
     * @param numero
     * @param telefone
     * @param endereco 
     */
    public Empresa(String nome, String CNPJ,
            String inscricaoEstadual,
            String dataAbertura,
            String numero,
            String telefone,
            Endereco endereco) {
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.inscricaoEstadual = inscricaoEstadual;
        this.dataAbertura = dataAbertura;
        this.numero = numero;
        this.telefone = telefone;
        this.endereco = endereco;
    }

}
