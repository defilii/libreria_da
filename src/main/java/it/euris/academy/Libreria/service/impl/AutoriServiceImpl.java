package it.euris.academy.Libreria.service.impl;

import it.euris.academy.Libreria.entity.Autori;
import it.euris.academy.Libreria.exceptions.IdMustBeNullException;
import it.euris.academy.Libreria.exceptions.IdMustNotBeNullException;
import it.euris.academy.Libreria.repository.AutoriRepository;
import it.euris.academy.Libreria.service.AutoriService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class AutoriServiceImpl implements AutoriService {

    private final AutoriRepository autoriRepository;

    @Override
    public List<Autori> findAll() {
        return autoriRepository.findAll();
    }

    @Override
    public Autori insert(Autori autori) {
        if(autori.getId() != null){
            throw new IdMustBeNullException();
        }
        return autoriRepository.save(autori);
    }

    @Override
    public Autori update(Autori autori) {
        if(autori.getId() == null){
            throw new IdMustNotBeNullException();
        }
        return autoriRepository.save(autori);
    }

    @Override
    public Boolean deleteById(Long idAutori) {
        autoriRepository.deleteById(idAutori);
        return autoriRepository.findById(idAutori).isEmpty();
    }

    @Override
    public Autori findById(Long idAutori) {
        return autoriRepository.findById(idAutori).orElse(Autori.builder().build());
    }
}
