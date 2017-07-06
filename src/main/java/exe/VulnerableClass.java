package exe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VulnerableClass {
  /**
   * Javadoc comment.
   */
  public void vulnerableMethod(String filename) throws IOException {
    boolean usuarioQuerOperacao = true;
    //while (usuarioQuerOperacao) {
    Scanner console = new Scanner(System.in);
    int cont = 2;
    boolean comandoValido = false;
    String opr = "";
    //so deve aceitar R ou W e nao deve pedir operacoes por um numero infinito de vezes
    while (!comandoValido) {
      if (cont == 0) {
        System.out.println("Acabaram-se as chances de digitar um comando");
        break;
      }
      System.out.print("Digite a operacao desejada para realizar no arquivo <R para ler um"
          + "arquivo, W para escrever em um arquivo>?\n" + "(Voce tem " + cont 
          + " chances de digitar um comando valido)\n");
      opr = console.nextLine();
      if (opr.equals("R")) {
        //Scanner scan = new Scanner(System.in); /* Para teste */
        int numberOfCaracteresRead = 5;
        BufferedReader br = null;
        FileReader fr = null;
        try {
          fr = new FileReader(filename);
          br = new BufferedReader(fr, numberOfCaracteresRead);
          char [] auxBuffer = new char [numberOfCaracteresRead];
          while (br.read(auxBuffer, 0, numberOfCaracteresRead) != -1) {
            String scurrentLine = String.valueOf(auxBuffer);
            System.out.print(scurrentLine);
            //String s = scan.nextLine(); /* Para teste */
          }
        } catch (IOException e) {
          throw e;
        }
        comandoValido = true;
      } else if (opr.equals("W")) {
        BufferedWriter buffWrite = null;
        try {
          //para nao sobrescrever
          buffWrite = new BufferedWriter(new FileWriter(filename, true));
          String linha = "";
          System.out.println("Escreva algo: ");
          linha = console.nextLine();
          buffWrite.append(linha);
          //buffWrite.write("\n" + linha + "\n");
          System.out.println("LINHA: " + linha);   
        } catch (IOException e) {
          throw e;
        } finally {
          try {
            buffWrite.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        comandoValido = true;
      }
      cont--;
    }
  }
}
