package it.euris.academy.Libreria.service.impl;

import it.euris.academy.Libreria.entity.Libri;
import it.euris.academy.Libreria.exceptions.IdMustBeNullException;
import it.euris.academy.Libreria.exceptions.IdMustNotBeNullException;
import it.euris.academy.Libreria.repository.LibriRepository;
import it.euris.academy.Libreria.service.LibriService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class LibriServiceImpl implements LibriService {
    private final LibriRepository libriRepository;
    @Override
    public List<Libri> findAll() {
        return libriRepository.findAll();
    }

    @Override
    public Libri insert(Libri libri) {
        if (libri.getId() != null) {
            throw new IdMustBeNullException();
        }
        return libriRepository.save(libri);
    }

    @Override
    public Libri update(Libri libri) {
        if (libri.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return libriRepository.save(libri);
    }

    @Override
    public Boolean deleteById(Long idLibri) {
        libriRepository.deleteById(idLibri);
        return libriRepository.findById(idLibri).isEmpty();
    }

    @Override
    public Libri findById(Long idLibri) {
        return libriRepository.findById(idLibri).orElse(Libri.builder().build());    }
}
