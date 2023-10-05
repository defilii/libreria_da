package it.euris.academy.Libreria.dto;

import it.euris.academy.Libreria.dto.archetype.Dto;
import it.euris.academy.Libreria.entity.CasaEditrice;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CasaEditriceDTO implements Dto {

    private Long id;

    private String nome;

    @Override
    public CasaEditrice toModel() {
        return CasaEditrice.builder()
                .id(id)
                .nome(nome)
                .build();
    }
}
