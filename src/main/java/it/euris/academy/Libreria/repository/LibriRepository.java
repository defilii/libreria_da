package it.euris.academy.Libreria.repository;

import it.euris.academy.Libreria.entity.Libri;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibriRepository extends JpaRepository<Libri, Long> {
}
