package br.com.alura.screensound.main;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void showMenu(){
        var option = 1;
        while (true) {
            var menu = """
                1 - Cadastrar Artista / Banda
                2 - Cadastrar Musica
                3 - Listar Musicas
                4 - Listar Artistas / Bandas
                5 - Buscar Musicas por Artista / Banda
                6 - Pesquisar dados sobre um artirta
                
                0 - Exit
                """;
            System.out.println(menu);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:

                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção Inválida");
            }
        }
    }
}
