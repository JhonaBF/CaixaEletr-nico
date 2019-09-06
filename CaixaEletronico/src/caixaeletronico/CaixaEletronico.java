package caixaeletronico;

import java.util.Scanner;

public class CaixaEletronico {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Entre com o valor que você deseja sacar");
        
        double saque = in.nextDouble();
        
        verificarSaque(saque);

    }
    
    private static void verificarSaque(double saque){
        int[] notas = new int[] {100, 50, 20, 10, 5, 2, 1};
        int[] moedas = new int[] {50, 25, 10, 5, 1};
        
        int centavos = 0;
        int reais = 0;
        
        if (saque % 1 != 0){
            centavos = (int) (saque % 1) * 100;
            reais = (int) saque;
        } else
            reais = (int) saque;
        
        boolean fim = false;
        int reaisSobra = reais;
        int centavosSobra = centavos;
        
        System.out.println("Serão necessárias as seguintes notas");
        
        do{
            int[] notasPossiveis = new int[] {0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i <= notas.length; i++) {
            if (notas[i] <= reaisSobra)
                notasPossiveis[i] = notas[i];
        }
        
        int[] moedasPossiveis = new int[] {0, 0, 0, 0, 0};
        for (int i = 0; i <= moedas.length; i++) {
            if (notas[i] <= centavosSobra)
                moedasPossiveis[i] = moedas[i];
        }
        
        int[] qtNotas = new int[] {0, 0, 0, 0, 0, 0, 0};
        int[] qtMoedas = new int[] {0, 0, 0, 0, 0};
        
        if (centavos != 0){
            for (int i = 0; i < notasPossiveis.length; i++) {
                if (notasPossiveis[i] != 0){
                    qtNotas[i] = contaNotas(reaisSobra, notasPossiveis[i]);

                    System.out.println(qtNotas[i] + " × " + notasPossiveis[i]);
                    reaisSobra -= qtNotas[i] * notasPossiveis[i];
                }
                if (reaisSobra == 0){
                    fim = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i < notasPossiveis.length; i++) {
                if (notasPossiveis[i] != 0){
                    qtNotas[i] = contaNotas(reaisSobra, notasPossiveis[i]);

                    System.out.println(qtNotas[i] + " × " + notasPossiveis[i]);
                    reaisSobra -= qtNotas[i] * notasPossiveis[i];
                }
                if (reaisSobra == 0){
                    fim = true;
                    break;
                }
            }
            
            for (int i = 0; i < moedasPossiveis.length; i++) {
                
            }
            
        }
            
        } while (fim == false);
        
    }
    
    private static int contaNotas(int reais, int nota){
        int notas = (int) reais/nota;
        return notas;
    }
    
        private static int contaMoedas(int centavos, int moeda){
        int moedas = (int) centavos/moeda;
        return moedas;
    }
    
}
