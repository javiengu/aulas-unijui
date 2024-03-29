/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author manchini
 */
public class FileUtils {

    /**
     * Metodo Que le um Arquivo é retorna seu conteudo Generico
     * @param arquivo
     * @return
     * @throws Exception
     */
    public static StringBuffer leArquivo(File arquivo) throws Exception {
        return leArquivoCodificacao(arquivo, "UTF-8");
        
    }

    /**
     * Metodo Que grava um Arquivo Generico
     * @param conteudo
     * @param destino
     * @throws Exception
     */
    public static void gravaArquivo(StringBuffer conteudo, String destino) throws Exception {
        gravaArquivo(conteudo, destino, false);
    }

    /**
     * Metodo Que grava um Arquivo Generico
     * @param conteudo
     * @param destino
     * @param addFinal
     * @return
     * @throws IOException
     */
    public static void gravaArquivo(StringBuffer conteudo, String destino, boolean addFinal) throws Exception {
        gravaArquivoCodificacao(conteudo, destino, "UTF-8", addFinal);
    }

    /**
     * Le Arquivo Passando Codificação
     * @param arquivo
     * @param codificacao
     * @return
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    public static StringBuffer leArquivoCodificacao(File arquivo, String codificacao) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        FileInputStream leitor = new FileInputStream(arquivo);
        InputStreamReader in = new InputStreamReader(leitor, codificacao);
        BufferedReader leitorBuf = new BufferedReader(in);
        String line = null;
        while ((line = leitorBuf.readLine()) != null) {
            stringBuffer.append(line+"\r\n");
        }
        in.close();
        leitor.close();
        System.out.println(stringBuffer.toString());
        return stringBuffer;
    }

      public static StringBuffer leArquivoCodificacao(InputStream arquivo, String codificacao) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();

        InputStreamReader in = new InputStreamReader(arquivo, codificacao);
        BufferedReader leitorBuf = new BufferedReader(in);
        String line = null;
        while ((line = leitorBuf.readLine()) != null) {
            stringBuffer.append(line+"\r\n");
        }
        in.close();
        return stringBuffer;
    }

    /**
     * Grava Arquivo passando Codificacao
     * @param conteudo
     * @param destino
     * @param codificacao
     * @return
     * @throws Exception
     */
    public static boolean gravaArquivoCodificacao(StringBuffer conteudo, String destino, String codificacao, boolean addFinal) throws Exception {
        File file = new File(destino);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream escritor = new FileOutputStream(file, addFinal);
        OutputStreamWriter escritorBuf = new OutputStreamWriter(escritor, codificacao);
        escritorBuf.append(conteudo);
        escritorBuf.close();
        escritor.close();
        return true;
    }

    public static void main(String arqs[]) {
        try {
            StringBuffer st = leArquivo(new File("C:/JPlayer/teste.mp3"));
            System.out.println(st);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
