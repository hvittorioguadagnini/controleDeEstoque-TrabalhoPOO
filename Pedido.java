package TrabalhoFinal;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa um pedido feito por um cliente.
 */
public class Pedido implements Registravel {

    private static int numeroPedidoTotal = 0;
    private int numeroPedido;
    private Cliente cliente;
    private Map<Item, Integer> itens;

    /**
     * Cria uma nova instância de Pedido associada a um cliente.
     *
     * @param cliente O cliente que fez o pedido.
     */
    public Pedido(Cliente cliente) {
        numeroPedidoTotal++;
        this.numeroPedido = numeroPedidoTotal;
        this.cliente = cliente;
        this.itens = new HashMap<>();
    }

    // Métodos getters e setters omitidos para brevidade.

    /**
     * Adiciona um item ao pedido com a quantidade especificada.
     *
     * @param item      O item a ser adicionado ao pedido.
     * @param quantidade A quantidade do item a ser adicionada.
     */
    public void adicionarItem(Item item, int quantidade) {
        itens.put(item, quantidade);
    }

    /**
     * Exibe as informações do pedido no console.
     */
    public void exibir() {
        System.out.println("Pedido #" + numeroPedido);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Itens:");
        for (Map.Entry<Item, Integer> entry : itens.entrySet()) {
            Item item = entry.getKey();
            int quantidade = entry.getValue();
            System.out.println("- " + item.getNome() + ": " + quantidade);
        }
    }

    /**
     * Retorna uma representação em forma de string das informações do pedido.
     *
     * @return Uma string que contém as informações do pedido.
     */
    public String exibirString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pedido #").append(numeroPedido).append("\n");
        stringBuilder.append("Cliente: ").append(cliente.getNome()).append("\n");
        stringBuilder.append("Itens:\n");

        for (Map.Entry<Item, Integer> entry : itens.entrySet()) {
            Item item = entry.getKey();
            int quantidade = entry.getValue();
            stringBuilder.append("- ").append(item.getNome()).append(": ").append(quantidade).append("\n");
        }

        return stringBuilder.toString();
    }

	public static int getNumeroPedidoTotal() {
		return numeroPedidoTotal;
	}

	public static void setNumeroPedidoTotal(int numeroPedidoTotal) {
		Pedido.numeroPedidoTotal = numeroPedidoTotal;
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Map<Item, Integer> getItens() {
		return itens;
	}

	public void setItens(Map<Item, Integer> itens) {
		this.itens = itens;
	}

	
}
