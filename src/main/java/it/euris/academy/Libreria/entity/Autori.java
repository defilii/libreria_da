package it.euris.academy.Libreria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.Libreria.dto.AutoriDTO;
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
@Table(name = "autori")
public class Autori implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @OneToMany(mappedBy = "autori", fetch = FetchType.EAGER)
    @JsonIgnore
    @Builder.Default
    private List<Libri> libri = new ArrayList<>();

    @Override
    public AutoriDTO toDto() {
        return AutoriDTO.builder()
                .id(id)
                .cognome(cognome)
                .nome(nome)
                .build();
    }
}