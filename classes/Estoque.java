package TrabalhoFinal;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

/**
 * Classe que representa o estoque de ingredientes do restaurante.
 */
public class Estoque {
    private Map<Ingrediente, Double> estoque;

    /**
     * Construtor da classe Estoque.
     * Inicializa o mapa de estoque.
     */   
    public Estoque() {
        this.estoque = new HashMap<>();
    }

    /**
     * Adiciona um ingrediente ao estoque com a quantidade especificada.
     *
     * @param ingrediente O ingrediente a ser adicionado.
     * @param quantidade  A quantidade do ingrediente a ser adicionada.
     */ 
    public void adicionarIngrediente(Ingrediente ingrediente, double quantidade) {
        estoque.put(ingrediente, quantidade);
    }

    /**
     * Verifica se há disponibilidade da quantidade requerida do ingrediente no estoque.
     *
     * @param nomeIngrediente     O nome do ingrediente a ser verificado.
     * @param quantidadeRequerida A quantidade requerida do ingrediente.
     * @return True se houver disponibilidade, caso contrário False.
     */
    public boolean verificarDisponibilidade(String nomeIngrediente, double quantidadeRequerida) {
        for (Map.Entry<Ingrediente, Double> entry : estoque.entrySet()) {
            Ingrediente ingrediente = entry.getKey();
            if (ingrediente.getNome().equalsIgnoreCase(nomeIngrediente)) {
                double quantidadeDisponivel = entry.getValue();
                return quantidadeDisponivel >= quantidadeRequerida;
            }
        }
        return false; 
    }

    /**
     * Verifica se o ingrediente com o nome especificado existe no estoque.
     *
     * @param nomeIngrediente O nome do ingrediente a ser verificado.
     * @return True se o ingrediente existe, caso contrário False.
     */
    public boolean verificarIngredienteExistente(String nomeIngrediente) {
        for (Ingrediente ingrediente : estoque.keySet()) {
            if (ingrediente.getNome().equalsIgnoreCase(nomeIngrediente)) {
                return true;
            }
        }
        return false; 
    }
    
    /**
     * Adiciona a quantidade especificada do ingrediente ao estoque.
     *
     * @param nomeIngrediente O nome do ingrediente a ser adicionado.
     * @param quantidade      A quantidade do ingrediente a ser adicionada.
     */
    public void adicionarQuantidadeIngrediente(String nomeIngrediente, double quantidade) {
        Ingrediente ingredienteParaAdicionar = null;

        for (Ingrediente ingrediente : estoque.keySet()) {
            if (ingrediente.getNome().equals(nomeIngrediente)) {
                ingredienteParaAdicionar = ingrediente;
                break; 
            }
        }

        if (ingredienteParaAdicionar != null) {
            double quantidadeAtual = estoque.getOrDefault(ingredienteParaAdicionar, 0.0);
            estoque.put(ingredienteParaAdicionar, quantidadeAtual + quantidade);
            JOptionPane.showMessageDialog(null, quantidade + ingredienteParaAdicionar.getUnidadeQtd() + " do ingrediente " + ingredienteParaAdicionar.getNome() + " foram adicionados(as)");
        } else {
        	JOptionPane.showMessageDialog(null, "Ingrediente não encontrado para adicionar quantidade.");
        }
    }

    /**
     * Remove a quantidade especificada do ingrediente do estoque.
     *
     * @param nomeIngrediente O nome do ingrediente a ter a quantidade removida.
     * @param quantidade      A quantidade do ingrediente a ser removida.
     */
    public void removerQuantidadeIngrediente(String nomeIngrediente, double quantidade) {
        Ingrediente ingredienteParaRemover = null;

        for (Ingrediente ingrediente : estoque.keySet()) {
            if (ingrediente.getNome().equals(nomeIngrediente)) {
                ingredienteParaRemover = ingrediente;
                break; 
            }
        }

        if (ingredienteParaRemover != null) {
            double quantidadeAtual = estoque.getOrDefault(ingredienteParaRemover, 0.0);
            if (quantidadeAtual >= quantidade) {
                estoque.put(ingredienteParaRemover, quantidadeAtual - quantidade);
            } else {
            	JOptionPane.showMessageDialog(null, "Quantidade insuficiente de " + ingredienteParaRemover.getNome() + " no estoque.");
            }
        } else {
        	JOptionPane.showMessageDialog(null, "Ingrediente não encontrado no estoque.");
        }
    }

    /**
     * Remove o ingrediente do estoque.
     *
     * @param nomeIngrediente O nome do ingrediente a ser removido do estoque.
     */
    public void removerIngrediente(String nomeIngrediente) {
        Ingrediente ingredienteParaRemover = null;

        for (Ingrediente ingrediente : estoque.keySet()) {
            if (ingrediente.getNome().equals(nomeIngrediente)) {
                ingredienteParaRemover = ingrediente;
                break; 
            }
        }

        if (ingredienteParaRemover != null) {
            estoque.remove(ingredienteParaRemover);
        }
    }
    
    /**
     * Remove a quantidade consumida de ingredientes do estoque com base nos pedidos.
     *
     * @param pedido O pedido que contém os itens e suas quantidades.
     */  
    public void removerIngredientesDoPedido(Pedido pedido) {
        for (Map.Entry<Item, Integer> entry : pedido.getItens().entrySet()) {
            Item item = entry.getKey();
            int quantidadePedido = entry.getValue();

            Map<Ingrediente, Double> ingredientesItem = item.getIngredientes();
            for (Map.Entry<Ingrediente, Double> ingredientesEntry : ingredientesItem.entrySet()) {
                Ingrediente ingrediente = ingredientesEntry.getKey();
                double quantidadeConsumida = ingredientesEntry.getValue() * quantidadePedido;

                double quantidadeAtual = estoque.getOrDefault(ingrediente, 0.0);
                if (quantidadeAtual >= quantidadeConsumida) {
                    estoque.put(ingrediente, quantidadeAtual - quantidadeConsumida);
                } else {
                    JOptionPane.showMessageDialog(null, "Quantidade insuficiente de " + ingrediente.getNome() + " no estoque.");
                }
            }
        }
    }
    
    /**
     * Exibe as informações sobre o estoque na forma de uma mensagem JOptionPane.
     */
    public void mostrarEstoque() {
        StringBuilder mensagem = new StringBuilder("Estoque:\n");

        for (Map.Entry<Ingrediente, Double> entry : estoque.entrySet()) {
            Ingrediente ingrediente = entry.getKey();
            Double quantidade = entry.getValue();
            mensagem.append(ingrediente.getNome()).append(": ").append(quantidade).append(" ").append(ingrediente.getUnidadeQtd()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensagem.toString(), "Estoque", JOptionPane.INFORMATION_MESSAGE);
    }


    
    /**
     * Busca um ingrediente no estoque pelo seu nome.
     *
     * @param nome O nome do ingrediente a ser buscado.
     * @return O ingrediente encontrado ou null se não encontrado.
     */
    
    public Ingrediente encontrarIngredientePorNome(String nome) {
        for (Map.Entry<Ingrediente, Double> entry : estoque.entrySet()) {
            Ingrediente ingrediente = entry.getKey();
            if (ingrediente.getNome().equalsIgnoreCase(nome)) {
                return ingrediente;
            }
        }
        return null;
    }
    
    /**
     * Obtém a quantidade de um ingrediente no estoque pelo seu nome.
     *
     * @param nomeIngrediente O nome do ingrediente a ser buscado.
     * @return A quantidade do ingrediente no estoque ou 0.0 se não encontrado.
     */
    
    public double obterQuantidadePorNome(String nomeIngrediente) {
        for (Map.Entry<Ingrediente, Double> entry : estoque.entrySet()) {
            Ingrediente ingrediente = entry.getKey();
            if (ingrediente.getNome().equalsIgnoreCase(nomeIngrediente)) {
                return entry.getValue();
            }
        }
        return 0.0;
    }
    
	public Map<Ingrediente, Double> getEstoque() {
		return estoque;
	}

	public void setEstoque(Map<Ingrediente, Double> estoque) {
		this.estoque = estoque;
	}
}
