package model;

import java.util.Scanner;

public class Entrada {
    public static final Scanner scanner = new Scanner(System.in);

    public static String lerString(){
        String linha = scanner.nextLine();
        while(linha.trim().isEmpty()){
            System.out.println("Entrada vazia! Tente novamente!");
            linha = scanner.nextLine();
        }
        return linha.trim();
    }

    public static int lerInt(){
        while(true){
            try{
                String linha = scanner.nextLine();
                Integer.parseInt(linha);
                return Integer.parseInt(linha.trim());
            }
            catch(NumberFormatException e){
                System.out.println("Valor inválido! Tente novamente!");
            }
        }
    }

    public static double lerDouble(){
        while(true){
            try {
                String linha = scanner.nextLine();
                Double.parseDouble(linha);
                return Double.parseDouble(linha.trim());
            }
            catch(NumberFormatException e){
                System.out.println("Valor inválido! Tente novamente!");
            }
        }
    }

    public static void fecharScanner(){
        scanner.close();
    }
}
