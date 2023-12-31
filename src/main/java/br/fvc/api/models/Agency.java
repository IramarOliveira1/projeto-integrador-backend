package br.fvc.api.models;

import br.fvc.api.dtos.agency.AgencyRequestDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
@Entity(name = "agencia")
@Table(name = "agencia")
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "Varchar(80)")
    private String nome;

    @Column(nullable = false, unique = true, columnDefinition = "Varchar(15)")
    private String telefone;

    @Column
    private int quantidade_total;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", nullable = false, referencedColumnName = "id")
    public Address address;

    public Agency(AgencyRequestDTO data) {
        this.nome = data.nome.toUpperCase();
        this.telefone = data.telefone;
        this.quantidade_total = data.quantidade_total;
    }
}
