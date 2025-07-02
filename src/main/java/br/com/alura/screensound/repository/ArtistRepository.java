package br.com.alura.screensound.repository;

import br.com.alura.screensound.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
