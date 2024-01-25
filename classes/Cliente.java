package TrabalhoFinal;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Classe que representa um cliente do restaurante.
 */
public class Cliente extends Pessoa implements Registravel{
    static int numeroClienteTotal = 0;
    private int numeroCliente;
    private String email;
    private String telefone;
    private List<Pedido> pedidos;

    /**
     * Construtor para criar um objeto Cliente.
     * 
     * @param nome Nome do cliente.
     * @param email Endereço de email do cliente.
     * @param telefone Número de telefone do cliente.
     */
    public Cliente(String nome, String email, String telefone) {
        super(nome);
        numeroClienteTotal++;
        this.numeroCliente = numeroClienteTotal;
        this.email = email;
        this.telefone = telefone;
        this.pedidos = new ArrayList<>();
    }

    /**
     * Obtém o número do cliente.
     * 
     * @return Número do cliente.
     */
    public int getNumeroCliente() {
        return numeroCliente;
    }

    /**
     * Define o número do cliente.
     * 
     * @param numeroCliente Número do cliente a ser definido.
     */
    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    /**
     * Obtém o endereço de email do cliente.
     * 
     * @return Endereço de email do cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de email do cliente.
     * 
     * @param email Endereço de email do cliente a ser definido.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o número de telefone do cliente.
     * 
     * @return Número de telefone do cliente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o número de telefone do cliente.
     * 
     * @param telefone Número de telefone do cliente a ser definido.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém a lista de pedidos do cliente.
     * 
     * @return Lista de pedidos do cliente.
     */
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * Define a lista de pedidos do cliente.
     * 
     * @param pedidos Lista de pedidos do cliente a ser definida.
     */
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * Adiciona um pedido à lista de pedidos do cliente.
     * 
     * @param pedido Pedido a ser adicionado.
     */
    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
        pedido.setCliente(this);
    }

    /**
     * Exibe os detalhes do cliente, incluindo seus pedidos.
     */
    public void exibir() {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Cliente: ").append(getNome()).append("\n");
        mensagem.append("Pedidos:\n");

        for (Pedido pedido : pedidos) {
            mensagem.append(pedido.toString()).append("\n");
        }

        mensagem.append("----------------------");

        JOptionPane.showMessageDialog(null, mensagem.toString(), "Detalhes do Cliente", JOptionPane.INFORMATION_MESSAGE);
    }
}
