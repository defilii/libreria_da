package it.euris.academy.Libreria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.Libreria.dto.CasaEditriceDTO;
import it.euris.academy.Libreria.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "casa_editrice")
public class CasaEditrice implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "casaEditrice", fetch = FetchType.EAGER)
    @JsonIgnore
    @Builder.Default
    private List<Libri> libri = new ArrayList<>();

    @Override
    public CasaEditriceDTO toDto() {
        return CasaEditriceDTO.builder()
                .id(id)
                .nome(nome)
                .build();
    }
}