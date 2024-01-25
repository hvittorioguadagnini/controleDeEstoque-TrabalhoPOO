package TrabalhoFinal;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Classe de testes para verificar o funcionamento das classes do pacote TrabalhoFinal.
 */
public class RestauranteTeste {

    /**
     * Testa as funcionalidades da classe Estoque.
     */
    @Test
    void testEstoque() {
        Estoque estoque = new Estoque();
        Ingrediente ingrediente = new Ingrediente("Queijo", 500.0, "gramas");
        
        estoque.adicionarIngrediente(ingrediente, 100.0);
        
        assertTrue(estoque.verificarIngredienteExistente("Queijo"));
        assertTrue(estoque.verificarDisponibilidade("Queijo", 100.0));
        
        estoque.removerQuantidadeIngrediente("Queijo", 50.0);
        assertEquals(50, estoque.obterQuantidadePorNome("Queijo"));
    }

    /**
     * Testa as funcionalidades da classe Cliente.
     */
    @Test
    void testCliente() {
        Cliente cliente = new Cliente("João", "joao@hotmail.com", "1234567890");
        
        assertEquals("João", cliente.getNome());
        assertEquals("joao@hotmail.com", cliente.getEmail());
        assertEquals("1234567890", cliente.getTelefone());
    }

    /**
     * Testa as funcionalidades da classe Pedido.
     */
    @Test
    void testPedido() {
        Cliente cliente = new Cliente("Maria", "maria@gmail.com", "9876543210");
        Pedido pedido = new Pedido(cliente);
        Item item = new Item("Pizza");
        
        pedido.adicionarItem(item, 2);

        assertEquals(1, pedido.getItens().size());
        assertTrue(pedido.getItens().containsKey(item));
        assertEquals(2, pedido.getItens().get(item));
    }

    /**
     * Testa as funcionalidades da classe Ingrediente.
     */
    @Test
    void testIngrediente() {
        Ingrediente ingrediente = new Ingrediente("Tomate", 3.0, "unidades");
        
        assertEquals("Tomate", ingrediente.getNome());
        assertEquals(3.0, ingrediente.getQuantidade());
        assertEquals("unidades", ingrediente.getUnidadeQtd());
    }

    /**
     * Testa as funcionalidades da classe Item.
     */
    @Test
    void testItem() {
        Ingrediente ingrediente = new Ingrediente("Queijo", 200.0, "gramas");
        Item item = new Item("Hambúrguer");
        item.adicionarIngrediente(ingrediente, 100.0);
        
        assertEquals("Hambúrguer", item.getNome());
        assertTrue(item.getIngredientes().containsKey(ingrediente));
        assertEquals(100.0, item.getIngredientes().get(ingrediente));
    }
}

