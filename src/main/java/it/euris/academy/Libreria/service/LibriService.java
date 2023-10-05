package it.euris.academy.Libreria.service;

import it.euris.academy.Libreria.entity.Libri;

import java.util.List;

public interface LibriService {

    List<Libri> findAll();

    Libri insert(Libri libri);

    Libri update(Libri libri);

    Boolean deleteById(Long idLibri);

    Libri findById(Long idLibri);
}
