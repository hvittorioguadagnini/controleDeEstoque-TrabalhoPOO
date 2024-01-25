package TrabalhoFinal;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa o sistema de restaurante, permitindo interações com clientes, pedidos, cardápio e estoque.
 */
public class Restaurante {
	
	public static void main(String[] args) {
		// Inicialização das estruturas de dados para armazenar informações sobre clientes, pedidos, cardápio e estoque
        Map<Cliente, Integer> clientes = new HashMap<>(); // Mapa para armazenar clientes e seus números correspondentes
        List<Pedido> pedidos = new ArrayList<>(); // Lista para armazenar pedidos
        Map<Item, String> cardapio = new HashMap<>(); // Mapa para armazenar itens do cardápio e seus nomes
        Estoque estoque = new Estoque(); // Instância da classe Estoque para controlar o estoque de ingredientes
		
		int verifica;
			
		
		do{
			// Exibição do menu principal para escolher as funcionalidades
			int option = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n"
					+ "1 para interagir com as funcionalidades relacionadas ao cliente\n"
					+ "2 para interagir com as funcionalidades relacionadas ao pedido de um cliente\n"
					+ "3 para interagir com as funcionalidades relacionadas ao cardápio\n"
					+ "4 para ir para o estoque"));
			
			if(option == 1) {
				int opcaoCliente = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n"
						+ "1 para registrar um cliente\n"
						+ "2 para remover um cliente registrado\n"
						+ "3 para mostrar todos os clientes registrados"));
				if(opcaoCliente == 1) {
					String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
					String email = JOptionPane.showInputDialog("Digite o email do cliente:");
					String telefone = JOptionPane.showInputDialog("Digite o telefone do cliente:");
					Cliente cliente = new Cliente(nome, email, telefone);
					clientes.put(cliente, cliente.getNumeroCliente());
					JOptionPane.showMessageDialog(null, "Cliente " + nome + ", número " + cliente.getNumeroCliente() + ", com email " + email + " e telefone " + telefone + " foi registrado com sucesso!");
					Arquivo.clientes += nome + ";" + email + ";" + telefone + ";\n";
					Arquivo.Write(Arquivo.clienteArq, Arquivo.clientes);
				}else if(opcaoCliente == 2){
					String nomeARemover = JOptionPane.showInputDialog("Digite o nome do cliente que deseja remover:");
					String emailARemover = JOptionPane.showInputDialog("Digite o email do cliente que deseja remover:");
					String telefoneARemover = JOptionPane.showInputDialog("Digite o telefone do cliente que deseja remover:");
					
					File arquivoOriginal = new File(Arquivo.clienteArq);
					
					try {
			            BufferedReader reader = new BufferedReader(new FileReader(arquivoOriginal));
			            List<String> linhas = new ArrayList<>();
			            String linha;

			            while ((linha = reader.readLine()) != null) {
			                String[] partes = linha.split(";");
			                if (partes.length >= 3) {
			                    String nome = partes[0];
			                    String email = partes[1];
			                    String telefone = partes[2];

			                    if (!nome.equals(nomeARemover) && !email.equals(emailARemover) && !telefone.equals(telefoneARemover)) {
			                        linhas.add(linha);
			                    }
			                }
			            }

			            reader.close();

			            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoOriginal));

			            for (String linhaNova : linhas) {
			                writer.write(linhaNova);
			                writer.newLine();
			            }

			            writer.close();
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
					
					Iterator<Map.Entry<Cliente, Integer>> iterator = clientes.entrySet().iterator();
			        while (iterator.hasNext()) {
			            Map.Entry<Cliente, Integer> entry = iterator.next();
			            Cliente cliente = entry.getKey();
			            if (cliente.getNome().equals(nomeARemover)
			                    && cliente.getEmail().equals(emailARemover)
			                    && cliente.getTelefone().equals(telefoneARemover)) {
			                iterator.remove();
			            }
			        }
					
					
				}else {
					for (Map.Entry<Cliente, Integer> entry : clientes.entrySet()) {
			            Cliente cliente = entry.getKey();
			            Integer valor = entry.getValue();
			            JOptionPane.showMessageDialog(null, "Cliente: \n"
			            		+ "nome: " + cliente.getNome() + "\n"
			            		+ "email: " + cliente.getEmail() + "\n"
			            		+ "telefone: " + cliente.getNome() + "\n"
			            		+ "id: " + valor);
			        }
				}
				
			}else if(option == 2) {
				int opcaoPedido;
				int controlePedido = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n"
						+ "1 para registrar um pedido de um cliente\n"
						+ "2 para mostrar todos os pedidos registrados"));
				
				if(controlePedido == 1) {
					int numCliente = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do cliente que deseja fazer o pedido:"));
					Cliente clientePedido = null;
					while(clientePedido == null) {
						for (Map.Entry<Cliente, Integer> entry : clientes.entrySet()) {
				            if (entry.getValue() == numCliente) {
				                clientePedido = entry.getKey();
				                break;
				            }
				        }
						if (clientePedido != null) {
							break;
				        } else {
				            numCliente = Integer.parseInt(JOptionPane.showInputDialog("Cliente não encontrado. Digite outro número: "));
				        }
					}
					
					Pedido pedido = new Pedido(clientePedido);
					
					do{
						String nome = JOptionPane.showInputDialog("Digite o nome do item do pedido: ");
						int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade desejada do item: "));
						
						Item itemPedido = null;
						for (Map.Entry<Item, String> entry : cardapio.entrySet()) {
				            if (entry.getValue().equals(nome)) {
				                itemPedido = entry.getKey();
				                pedido.adicionarItem(itemPedido, quantidade);
								pedidos.add(pedido);
								Map<Ingrediente, Double> ingredientesItem = itemPedido.getIngredientes();
								for (Map.Entry<Ingrediente, Double> ingredientesEntry : ingredientesItem.entrySet()) {
					                Ingrediente ingrediente = ingredientesEntry.getKey();
					                double quantidadeConsumida = ingredientesEntry.getValue() * quantidade;
					                estoque.removerQuantidadeIngrediente(ingrediente.getNome(), quantidadeConsumida);
					            }
				                break;
				            }
				        }
						
						if(itemPedido == null) {
							JOptionPane.showMessageDialog(null, "Esse item não foi encontrado no cardápio");
						}
					
						opcaoPedido = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para registrar outro item ou 0 para continuar: "));
					
						JOptionPane.showMessageDialog(null, pedido.exibirString());
					}while(opcaoPedido != 0);
				}else {
					for(Pedido pedido: pedidos) {
						JOptionPane.showMessageDialog(null, pedido.exibirString());
					}
				}
						
				
			}else if(option == 3) {
				int opcaoCardapio = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n"
						+ "1 para registrar um item ao cardápio\n"
						+ "2 para mostrar os itens do cardápio com seus respectivos ingredientes e quantidades de cada ingrediente"));
				
				if(opcaoCardapio == 1) {
					String nomeItem = JOptionPane.showInputDialog("Digite o nome do item: ");
					Item item = new Item(nomeItem);
					cardapio.put(item, nomeItem);
					
					int qtdIngredientes = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade ingredientes que o item possui: "));
					for(int i = 1; i<=qtdIngredientes; i++){
						String nomeIngrediente = JOptionPane.showInputDialog("Digite o nome do ingrediente " + i + " do item: ");
						int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade deste ingrediente necessária para fazer o item: "));
						
						Ingrediente ingrediente = new Ingrediente(nomeIngrediente, quantidade);
						item.adicionarIngrediente(ingrediente, quantidade);
					}
				}else {
					StringBuilder mensagem = new StringBuilder();
			        
			        for (Map.Entry<Item, String> entry : cardapio.entrySet()) {
			            Item item = entry.getKey();
			            String nomeItem = entry.getValue();
			            
			            mensagem.append("Item: ").append(nomeItem).append("\n");
			            mensagem.append("Ingredientes:\n");
			            
			            for (Map.Entry<Ingrediente, Double> ingredienteEntry : item.getIngredientes().entrySet()) {
			                Ingrediente ingrediente = ingredienteEntry.getKey();
			                Double quantidade = ingredienteEntry.getValue();
			                
			                mensagem.append("- ").append(ingrediente.getNome()).append(": ").append(quantidade).append(" gramas\n");
			            }
			            
			            mensagem.append("----------------------\n");
			        }
			        
			        JOptionPane.showMessageDialog(null, mensagem.toString(), "Cardápio", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}else {
				int optionEstoque = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n"
						+ "1 para registrar um ingrediente no estoque\n"
						+ "2 para registrar o aumento de quantidade em algum ingrediente do estoque\n"
						+ "3 para registrar a remoção de quantidade em algum ingrediente do estoque\n"
						+ "4 para remover um ingrediente do estoque\n"
						+ "5 para verificar a disponibilidade de algum ingrediente do estoque\n"
						+ "6 para mostrar os ingrediente do estoque com suas respectivas quantidades"));
				if(optionEstoque == 1) {
					String nome = JOptionPane.showInputDialog("Digite o nome do ingrediente que deseja adicionar no estoque: ");
					int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade que será inserida no estoque: "));
					String unidadeQtd = JOptionPane.showInputDialog("Digite a unidade de medida dessa quantidade: ");
					
					Ingrediente ingrediente = new Ingrediente(nome, quantidade, unidadeQtd); 
					estoque.adicionarIngrediente(ingrediente, quantidade);
				}else if(optionEstoque == 2) {
					String nome = JOptionPane.showInputDialog("Digite o nome do ingrediente que deseja aumentar a quantidade: ");
					double quantidade = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade que será inserida do ingrediente no estoque: "));
					estoque.adicionarQuantidadeIngrediente(nome, quantidade); 
				}else if(optionEstoque == 3) {
					String nome = JOptionPane.showInputDialog("Digite o nome do ingrediente que deseja diminuir a quantidade: ");
					double quantidade = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade que será removida do ingrediente no estoque: "));
					estoque.removerQuantidadeIngrediente(nome, quantidade); 
				}else if(optionEstoque == 4) {
					String nome = JOptionPane.showInputDialog("Digite o nome do ingrediente que deseja remover: ");
					estoque.removerIngrediente(nome);
				}else if(optionEstoque == 5) {
					String nomeIngrediente = JOptionPane.showInputDialog("Digite o nome do ingrediente que deseja verificar a disponibilidade: ");
					double quantidadeRequerida = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade que deseja verificar se está disponível no estoque: "));
					if (estoque.verificarIngredienteExistente(nomeIngrediente)) {
			            boolean disponivel = estoque.verificarDisponibilidade(nomeIngrediente, quantidadeRequerida);

			            if (disponivel) {
			            	JOptionPane.showMessageDialog(null, "O ingrediente está disponível em quantidade suficiente.");
			            } else {
			            	JOptionPane.showMessageDialog(null, "O ingrediente não está disponível em quantidade suficiente.");
			            }
			        } else {
			        	JOptionPane.showMessageDialog(null, "O ingrediente não está presente no estoque.");
			        }
				}else {
					estoque.mostrarEstoque();
				}
					
			}
			
			
			verifica = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para continuar no programa ou 0 para sair:"));
		
		//JOptionPane.showMessageDialog(null, "Nome = " + retorno); 
			
	}while(verifica != 0);
	}
}
