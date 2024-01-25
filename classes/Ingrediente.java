package TrabalhoFinal;

/**
 * Representa um ingrediente com nome, quantidade e unidade de medida.
 */
public class Ingrediente {
	 private String nome;
	 private double quantidade;
	 private String unidadeQtd;
	 
	 /**
     * Cria um novo ingrediente com o nome especificado.
     *
     * @param nome O nome do ingrediente.
     */
	 public Ingrediente(String nome) {
	     this.nome = nome;
	 }

	 /**
     * Obtém o nome do ingrediente.
     *
     * @return O nome do ingrediente.
     */
	public String getNome() {
		return nome;
	}

	/**
     * Define o nome do ingrediente.
     *
     * @param nome O nome do ingrediente a ser definido.
     */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
     * Cria um novo ingrediente com nome, quantidade e unidade de medida.
     *
     * @param nome       O nome do ingrediente.
     * @param quantidade A quantidade do ingrediente.
     * @param unidadeQtd A unidade de medida da quantidade do ingrediente.
     */
	public Ingrediente(String nome, double quantidade, String unidadeQtd) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidadeQtd = unidadeQtd;
	}
	
	/**
     * Cria um novo ingrediente com nome e quantidade.
     *
     * @param nome       O nome do ingrediente.
     * @param quantidade A quantidade do ingrediente.
     */
	public Ingrediente(String nome, double quantidade) {
		this.nome = nome;
		this.quantidade = quantidade;
	}

	/**
     * Obtém a quantidade do ingrediente.
     *
     * @return A quantidade do ingrediente.
     */
	public double getQuantidade() {
		return quantidade;
	}

	/**
     * Define a quantidade do ingrediente.
     *
     * @param quantidade A quantidade do ingrediente a ser definida.
     */
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	/**
     * Obtém a unidade de medida da quantidade do ingrediente.
     *
     * @return A unidade de medida da quantidade do ingrediente.
     */
	public String getUnidadeQtd() {
		return unidadeQtd;
	}

	/**
     * Define a unidade de medida da quantidade do ingrediente.
     *
     * @param unidadeQtd A unidade de medida da quantidade do ingrediente a ser definida.
     */
	public void setUnidadeQtd(String unidadeQtd) {
		this.unidadeQtd = unidadeQtd;
	}
	 
	 
}
