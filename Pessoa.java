package TrabalhoFinal;

/**
 * Classe abstrata que representa uma pessoa genérica.
 */
public abstract class Pessoa {

    private String nome;

    /**
     * Cria uma instância de Pessoa com o nome especificado.
     *
     * @param nome O nome da pessoa.
     * @throws NomeInvalidoException Se o nome fornecido for vazio.
     */
    public Pessoa(String nome) {
        if (nome.length() == 0) {
            throw new NomeInvalidoException("O nome é inválido");
        }
        this.nome = nome;
    }

    /**
     * Obtém o nome da pessoa.
     *
     * @return O nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     *
     * @param nome O novo nome da pessoa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
