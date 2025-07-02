package br.com.alura.screensound.repository;

import br.com.alura.screensound.models.Artist;
import br.com.alura.screensound.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findByNameContainingIgnoreCase(String name);
    @Query("SELECT m FROM Music m WHERE m.artist = :artist")
    List<Music> musicByArtist(Artist artist);

    @Query("SELECT m FROM Music m ORDER BY m.artist.name")
    List<Music> allMusics();
}
