package TrabalhoFinal;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa um item que pode ser parte de um pedido, contendo um nome e uma lista de ingredientes.
 */
public class Item {
    private String nome;
    private Map<Ingrediente, Double> ingredientes;

    /**
     * Cria um novo item com o nome especificado.
     *
     * @param nome O nome do item.
     */
    public Item(String nome) {
        this.nome = nome;
        this.ingredientes = new HashMap<>();
    }

    /**
     * Adiciona um ingrediente ao item com a quantidade especificada.
     *
     * @param ingrediente O ingrediente a ser adicionado.
     * @param quantidade A quantidade do ingrediente a ser adicionada.
     */
    public void adicionarIngrediente(Ingrediente ingrediente, double quantidade) {
        ingredientes.put(ingrediente, quantidade);
    }

    /**
     * Obtém o nome do item.
     *
     * @return O nome do item.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do item.
     *
     * @param nome O nome do item a ser definido.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a lista de ingredientes e suas quantidades associadas deste item.
     *
     * @return A lista de ingredientes e suas quantidades associadas.
     */
    public Map<Ingrediente, Double> getIngredientes() {
        return ingredientes;
    }

    /**
     * Define a lista de ingredientes e suas quantidades associadas deste item.
     *
     * @param ingredientes A lista de ingredientes e suas quantidades associadas a ser definida.
     */
    public void setIngredientes(Map<Ingrediente, Double> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
