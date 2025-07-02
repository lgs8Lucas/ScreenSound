package br.com.alura.screensound.models;

import jakarta.persistence.*;

@Entity
@Table(name = "musics")
public class Music {
    private String title;
    @ManyToOne
    private Artist artist;
    private Genre genre;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Music() {
    }

    public Music(String title, Artist artist, Genre genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Musica: "+ title + ",  " + artist + "  |  " + genre;
    }
}
