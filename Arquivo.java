package TrabalhoFinal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Classe que fornece métodos para leitura e escrita em arquivos.
 */
public class Arquivo {

    /**
     * Nome do arquivo de clientes.
     */
    public static String clienteArq = "clientes.txt";
    
    /**
     * String que armazena o conteúdo dos clientes.
     */
    public static String clientes = "";

    /**
     * Lê o conteúdo de um arquivo.
     *
     * @param Caminho O caminho do arquivo a ser lido.
     * @return O conteúdo do arquivo lido.
     */
    public static String Read(String Caminho) {
        String conteudo = "";
        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    conteudo += linha + "\n";
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }

    /**
     * Escreve um texto em um arquivo.
     *
     * @param Caminho O caminho do arquivo onde o texto será escrito.
     * @param Texto O texto a ser escrito no arquivo.
     * @return true se a escrita foi bem-sucedida, false caso contrário.
     */
    public static boolean Write(String Caminho, String Texto) {
        try {
            FileWriter arq = new FileWriter(Caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(Texto);
            gravarArq.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
