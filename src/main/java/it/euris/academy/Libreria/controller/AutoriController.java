package it.euris.academy.Libreria.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.euris.academy.Libreria.dto.AutoriDTO;
import it.euris.academy.Libreria.entity.Autori;
import it.euris.academy.Libreria.exceptions.IdMustBeNullException;
import it.euris.academy.Libreria.exceptions.IdMustNotBeNullException;
import it.euris.academy.Libreria.service.AutoriService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/autori")
public class AutoriController {

    AutoriService autoriService;

    @GetMapping("/v1")
    @Operation(description = """
      Get all autori
      """)
    public List<AutoriDTO> getAllAutori() {
        return autoriService.findAll().stream().map(Autori::toDto).toList();
    }

    @PostMapping("/v1")
    public AutoriDTO saveAutori(@RequestBody AutoriDTO autoriDTO) {
        try{
            Autori autori = autoriDTO.toModel();
            return autoriService.insert(autori).toDto();
        }
        catch(IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    public AutoriDTO updateAutori(@RequestBody AutoriDTO autoriDTO){
        try{
            Autori autori = autoriDTO.toModel();
            return autoriService.update(autori).toDto();
        }
        catch(IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    public Boolean deleteAutori(@PathVariable("id") Long idAutori) {
        return autoriService.deleteById(idAutori);
    }

    @GetMapping("/v1/{id}")
    public AutoriDTO getAutoriById(@PathVariable("id") Long idAutori) {
        return autoriService.findById(idAutori).toDto();
    }
}
