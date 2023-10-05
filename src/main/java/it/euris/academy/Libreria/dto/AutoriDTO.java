package it.euris.academy.Libreria.dto;

import it.euris.academy.Libreria.dto.archetype.Dto;
import it.euris.academy.Libreria.entity.Autori;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
public class AutoriDTO implements Dto {

    private Long id;

    private String nome;

    private String cognome;

    @Override
    public Autori toModel() {
        return Autori.builder()
                .id(id)
                .cognome(cognome)
                .nome(nome)
                .build();
    }
}
