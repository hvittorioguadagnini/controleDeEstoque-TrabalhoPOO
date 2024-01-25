# Controle de Estoque - Trabalho de POO

Este repositório contém o código-fonte desenvolvido como trabalho final da disciplina de Programação Orientada a Objetos. O projeto consiste em um sistema de controle de estoque para um restaurante, implementado em Java.

## Estrutura do Projeto

O projeto é dividido em várias classes, cada uma representando uma entidade ou funcionalidade específica. Aqui está uma breve descrição de cada classe:

1. **Arquivo.java**: Responsável pela manipulação de arquivos, utilizada para salvar e carregar dados do estoque e pedidos.

2. **Cliente.java**: Representa um cliente que realiza pedidos no restaurante.

3. **Estoque.java**: Classe que gerencia o estoque de ingredientes do restaurante.

4. **Ingrediente.java**: Define a estrutura de um ingrediente, incluindo nome, quantidade disponível e métodos relacionados.

5. **Item.java**: Representa um item específico em um pedido, associando um ingrediente a uma quantidade.

6. **NomeInvalidoException.java**: Exceção customizada para lidar com nomes inválidos.

7. **Pedido.java**: Classe responsável por representar um pedido feito por um cliente, incluindo a lista de itens solicitados.

8. **Pessoa.java**: Classe base para representar pessoas no sistema, incluindo clientes e funcionários.

9. **Registravel.java**: Interface que define métodos para objetos que podem ser registrados, como ingredientes e pedidos.

10. **Restaurante.java**: Classe principal que coordena todas as operações do restaurante, como gerenciamento de estoque e pedidos.

11. **RestauranteTeste.java**: Classe de teste para validar o funcionamento correto do sistema.

## Como Utilizar

Para utilizar o sistema de controle de estoque, siga estas etapas:

1. Clone o repositório para o seu ambiente local.

```bash
git clone https://github.com/seu-usuario/controleDeEstoque-TrabalhoPOO.git
cd controleDeEstoque-TrabalhoPOO
```

2. Compile o código-fonte.

```bash
javac *.java
```

3. Execute a classe principal.

```bash
java Restaurante
```

Certifique-se de ter uma máquina virtual Java (JVM) instalada em seu sistema.
