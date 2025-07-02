package br.com.alura.screensound.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artists")
public class Artist {
    @Column(unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Music> musics = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Artist(String name, Type type, List<Music> musics) {
        this.name = name;
        this.type = type;
        this.musics = musics;
    }

    public Artist(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Artist() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }

    @Override
    public String toString() {
        return "Artista: "+ name + ",  " + type+ ", Músicas: "+musics.stream().map(Music::getTitle).toList();
    }
}
