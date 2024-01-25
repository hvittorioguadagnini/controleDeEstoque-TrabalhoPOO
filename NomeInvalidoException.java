package TrabalhoFinal;

/**
 * Exceção personalizada para indicar um nome inválido.
 */
public class NomeInvalidoException extends RuntimeException {

    /**
     * Cria uma nova instância da exceção com a mensagem de erro especificada.
     *
     * @param mensagem A mensagem de erro que descreve o motivo da exceção.
     */
    public NomeInvalidoException(String mensagem) {
        super(mensagem);
    }
}

