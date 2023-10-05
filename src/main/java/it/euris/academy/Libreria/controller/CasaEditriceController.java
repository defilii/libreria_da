package it.euris.academy.Libreria.controller;

import it.euris.academy.Libreria.dto.CasaEditriceDTO;
import it.euris.academy.Libreria.entity.CasaEditrice;
import it.euris.academy.Libreria.exceptions.IdMustBeNullException;
import it.euris.academy.Libreria.exceptions.IdMustNotBeNullException;
import it.euris.academy.Libreria.service.CasaEditriceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/casaeditrice")
public class CasaEditriceController {

    CasaEditriceService casaEditriceService;

    @GetMapping("/v1")
    public List<CasaEditriceDTO> getAllCasaEditrice() {
        return casaEditriceService.findAll().stream().map(CasaEditrice::toDto).toList();
    }

    @PostMapping("/v1")
    public CasaEditriceDTO saveCasaEditrice(@RequestBody CasaEditriceDTO casaEditriceDTO) {
        try{
            CasaEditrice casaEditrice = casaEditriceDTO.toModel();
            return casaEditriceService.insert(casaEditrice).toDto();
        }
        catch(IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    public CasaEditriceDTO updateCasaEditrice(@RequestBody CasaEditriceDTO casaEditriceDTO){
        try{
            CasaEditrice casaEditrice = casaEditriceDTO.toModel();
            return casaEditriceService.update(casaEditrice).toDto();
        }
        catch(IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    public Boolean deleteCasaEditrice(@PathVariable("id") Long idCasaEditrice) {
        return casaEditriceService.deleteById(idCasaEditrice);
    }

    @GetMapping("/v1/{id}")
    public CasaEditriceDTO getCasaEditriceById(@PathVariable("id") Long idCasaEditrice) {
        return casaEditriceService.findById(idCasaEditrice).toDto();
    }
}
