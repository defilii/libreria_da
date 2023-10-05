package it.euris.academy.Libreria.dto;

import it.euris.academy.Libreria.dto.archetype.Dto;
import it.euris.academy.Libreria.entity.Autori;
import it.euris.academy.Libreria.entity.CasaEditrice;
import it.euris.academy.Libreria.entity.Libri;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LibriDTO implements Dto {

    private Long id;

    private String isbn;


    private String titolo;

    private Autori autori;

    private CasaEditrice casaEditrice;


    @Override
    public Libri toModel() {
        return Libri.builder()
                .id(id)
                .isbn(isbn)
                .titolo(titolo)
                .autori(autori)
                .casaEditrice(casaEditrice)
                .build();
    }
}
