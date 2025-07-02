package br.com.alura.screensound.main;

import br.com.alura.screensound.models.Artist;
import br.com.alura.screensound.models.Type;
import br.com.alura.screensound.repository.ArtistRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner sc = new Scanner(System.in);
    ArtistRepository repository;
    List<Artist> artists = new ArrayList<>();

    public Main(ArtistRepository artistRepository) {
        this.repository = artistRepository;
    }

    public void showMenu(){
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
                    insertArtist();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    listArtists();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção Inválida");
            }
        }
    }

    private void insertArtist() {
        System.out.print("Digite o nome do Artista / Banda: ");
        var artistName = sc.nextLine();
        System.out.print("Digite o que é [SOLO, DUPLA, BANDA]: ");
        var sType = sc.nextLine();
        try{
            var type = Type.valueOf(sType.toUpperCase());
            Artist artist = new Artist(artistName, type);
            repository.save(artist);
        }
        catch (IllegalArgumentException e){
            System.out.println("Erro ao converter o tipo de artista!");
        }
    }

    private void listArtists() {
        artists = repository.findAll();
        artists.forEach(System.out::println);
    }
}
