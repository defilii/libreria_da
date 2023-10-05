package it.euris.academy.Libreria.service;

import it.euris.academy.Libreria.entity.Autori;

import java.util.List;

public interface AutoriService {

    List<Autori> findAll();

    Autori insert(Autori autori);

    Autori update(Autori autori);

    Boolean deleteById(Long idAutori);

    Autori findById(Long idAutori);

}
