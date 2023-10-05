package it.euris.academy.Libreria.entity;

import it.euris.academy.Libreria.dto.LibriDTO;
import it.euris.academy.Libreria.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "libri")
public class Libri implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "titolo", nullable = false)
    private String titolo;

    @ManyToOne
    @JoinColumn(name = "autori_Id", nullable = false)
    private Autori autori;

    @ManyToOne
    @JoinColumn(name = "casaEditrice_Id", nullable = false)
    private CasaEditrice casaEditrice;

    @Override
    public LibriDTO toDto() {
        return LibriDTO.builder()
                .id(id)
                .isbn(isbn)
                .titolo(titolo)
                .autori(autori)
                .casaEditrice(casaEditrice)
                .build();
    }
}