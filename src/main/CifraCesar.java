
package main;

import java.io.*;

/**
 *
 * @author Ussumane-Momade
 */
public class CifraCesar {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static char alfabeto[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) throws IOException {
        CifraCesar cc = new CifraCesar();
        cc.menu();
    }

    private static void menu() throws IOException {
        int op = -1;
        char mensagemCadeia[];
        String mensagem, mensagemEncriptada = "", mensagemDecriptada = "";

        while (op != 3) {
            System.out.println("***********************************");
            System.out.println("*                                 *");
            System.out.println("*    BEM VINDO AO algoritmo C3    *");
            System.out.println("*                                 *");
            System.out.println("***********************************\n");
            System.out.println("###################################\n"
                    + "#\t1. Encriptar mensagem.\t  #\n"
                    + "#\t2. Decriptar mensagem.\t  #\n"
                    + "#\t3. Sair.\t\t  #\n"
                    + "###################################\n"
                    + "Escolha uma opcao: ");
            op = Integer.parseInt(br.readLine());
            switch (op) {
                case 1:
                    System.out.println("\n\tIntroduza a mensagem que pretende encriptar com Cifra de César: ");
                    mensagem = br.readLine().toLowerCase();
                    mensagemCadeia = mensagem.toCharArray();
                    mensagemEncriptada = encriptarMensagem(mensagemCadeia);
                    System.out.println("\n\tMensagem encriptada: " + mensagemEncriptada.toUpperCase());
                    break;
                case 2:
                    System.out.println("\n\tIntroduza a mensagem encriptada que quer decriptar: ");
                    mensagem = br.readLine().toLowerCase();
                    mensagemCadeia = mensagem.toCharArray();
                    mensagemDecriptada = decriptarMensagem(mensagemCadeia);
                    System.out.println("\n\tmensagem decriptada: " + mensagemDecriptada.toUpperCase());
                    break;
                case 3:
                    System.out.println("\n\tSaindo do programa...");
                    System.exit(0);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    private static String encriptarMensagem(char mensagemChar[]) {
        int posicao = 0;
        String mensagemEncriptada = "";
        for (int i = 0; i < mensagemChar.length; i++) {
            for (int j = 0; j < alfabeto.length; j++) {
                if (mensagemChar[i] == alfabeto[j]) {
                    posicao = j;
                    if (posicao > 22) {
                        if (posicao == 23) {
                            mensagemEncriptada = mensagemEncriptada + alfabeto[0];
                        } else if (posicao == 24) {
                            mensagemEncriptada = mensagemEncriptada + alfabeto[1];
                        } else if (posicao == 25) {
                            mensagemEncriptada = mensagemEncriptada + alfabeto[2];
                        }
                    } else {
                        mensagemEncriptada = mensagemEncriptada + alfabeto[posicao + 3];
                    }
                }
            }
        }
        return mensagemEncriptada;
    }

    private static String decriptarMensagem(char mensagemChar[]) {
        int posicao = 0;
        String mensagemDecriptada = "";
        for (int i = 0; i < mensagemChar.length; i++) {
            for (int j = 0; j < alfabeto.length; j++) {
                if (mensagemChar[i] == alfabeto[j]) {
                    posicao = j;
                    if (posicao < 3) {
                        if (posicao == 2) {
                            mensagemDecriptada = mensagemDecriptada + alfabeto[25];
                        } else if (posicao == 1) {
                            mensagemDecriptada = mensagemDecriptada + alfabeto[24];
                        } else if (posicao == 0) {
                            mensagemDecriptada = mensagemDecriptada + alfabeto[23];
                        }
                    } else {
                        mensagemDecriptada = mensagemDecriptada + alfabeto[posicao - 3];
                    }
                }
            }
        }
        return mensagemDecriptada;
    }
}
