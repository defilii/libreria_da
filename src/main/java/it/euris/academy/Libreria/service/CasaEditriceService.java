package it.euris.academy.Libreria.service;

import it.euris.academy.Libreria.entity.CasaEditrice;

import java.util.List;

public interface CasaEditriceService {

    List<CasaEditrice> findAll();

    CasaEditrice insert(CasaEditrice casaEditrice);

    CasaEditrice update(CasaEditrice casaEditrice);

    Boolean deleteById(Long idCasaEditrice);

    CasaEditrice findById(Long idCasaEditrice);

}
