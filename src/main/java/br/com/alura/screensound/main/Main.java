package br.com.alura.screensound.main;

import br.com.alura.screensound.models.Artist;
import br.com.alura.screensound.models.Genre;
import br.com.alura.screensound.models.Music;
import br.com.alura.screensound.models.Type;
import br.com.alura.screensound.repository.ArtistRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
                6 - Pesquisar dados sobre um artista
                
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
                    insertMusic();
                    break;
                case 3:
                    listAllMusics();
                    break;
                case 4:
                    listArtists();
                    break;
                case 5:
                    listMusics();
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
            System.out.println(artist);
            repository.save(artist);
        }
        catch (IllegalArgumentException e){
            System.out.println("Erro ao converter o tipo de artista!");
        }
    }

    private void listArtists() {
        artists = repository.findAll();
        if (artists.isEmpty()) {
            System.out.println("Nenhum Artista / Banda cadastrado!");
            return;
        }
        System.out.println("Artistas / Bandas:");
        artists.forEach(System.out::println);
    }

    private void insertMusic() {
        listArtists();
        if (artists.isEmpty()) return;
        System.out.println("Digite o nome do Artista / Banda: ");
        var artistName = sc.nextLine();
        Optional<Artist> artistExists = repository.findByNameContainingIgnoreCase(artistName);
        if (artistExists.isEmpty()) {
            System.out.println("Artista não encontrado!");
            return;
        }
        var artist = artistExists.get();
        System.out.println("Artista / Banda encontrado: "+artist.getName());
        System.out.print("Digite o nome da música: ");
        var name = sc.nextLine();
        System.out.print("Digite o gênero da música: ");
        var sGenre = sc.nextLine();
        try{
            var genre = Genre.valueOf(sGenre.toUpperCase());
            Music music = new Music(name, artist, genre);
            System.out.println(music);
            artist.getMusics().add(music);
            repository.save(artist);
        }
        catch (IllegalArgumentException e){
            System.out.println("Erro ao converter estido da música");
        }
    }

    private void listMusics(){
        listArtists();
        if (artists.isEmpty()) return;
        System.out.println("Digite o nome do Artista / Banda: ");
        var artistName = sc.nextLine();
        Optional<Artist> artistExists = repository.findByNameContainingIgnoreCase(artistName);
        if (artistExists.isEmpty()) {
            System.out.println("Artista não encontrado!");
            return;
        }
        var artist = artistExists.get();
        System.out.print("Artista / Banda encontrado: "+artist.getName());
        if ( artist.getMusics().isEmpty()){
            System.out.println("Não há musicas");
            return;
        }
        System.out.println("Musicas do Artista / Banda: ");
        List<Music> musics = repository.musicByArtist(artist);
        musics.forEach(System.out::println);
    }

    private void listAllMusics(){
        List<Music> musics = repository.allMusics();
        if (musics.isEmpty()) {
            System.out.println("Nenhuma música cadastrada!");
            return;
        }
        System.out.println("Músicas: ");
        musics.forEach(System.out::println);
    }
}
