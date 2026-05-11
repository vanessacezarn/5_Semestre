package controller;

import beans.Produto;
import java.io.FileWriter;
import java.io.IOException;
 /*
 * @author laboratorio
 */
public class arquivo {
    private static final String Arquivo = "produtos.csv";
    
    public static void salvar(Produto produto) {
        try (FileWriter writer = new FileWriter(Arquivo, true)) {
            writer.write(produto.toCSV() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
