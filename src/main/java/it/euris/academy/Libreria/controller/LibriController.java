package it.euris.academy.Libreria.controller;

import it.euris.academy.Libreria.dto.LibriDTO;
import it.euris.academy.Libreria.entity.Libri;
import it.euris.academy.Libreria.exceptions.IdMustBeNullException;
import it.euris.academy.Libreria.exceptions.IdMustNotBeNullException;
import it.euris.academy.Libreria.service.LibriService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/libri")
public class LibriController {

    LibriService libriService;

    @GetMapping("/v1")
    public List<LibriDTO> getAllLibri() {
        return libriService.findAll().stream().map(Libri::toDto).toList();
    }

    @PostMapping("/v1")
    public LibriDTO saveLibri(@RequestBody LibriDTO libriDTO) {
        try{
            Libri libri = libriDTO.toModel();
            return libriService.insert(libri).toDto();
        }
        catch(IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    public LibriDTO updateLibri(@RequestBody LibriDTO libriDTO){
        try{
            Libri libri = libriDTO.toModel();
            return libriService.update(libri).toDto();
        }
        catch(IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    public Boolean deleteLibri(@PathVariable("id") Long idLibri) {
        return libriService.deleteById(idLibri);
    }

    @GetMapping("/v1/{id}")
    public LibriDTO getCasaLibriById(@PathVariable("id") Long idLibri) {
        return libriService.findById(idLibri).toDto();
    }
}
