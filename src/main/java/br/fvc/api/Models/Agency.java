package br.fvc.api.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "agencia")
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "Varchar(80)")
    private String nome;

    @Column(nullable = false, unique = true, columnDefinition = "Varchar(15)")
    private String telefone;

    @OneToOne
    @JoinColumn(name = "id_estoque" , nullable = false)
    private Stock estoque;

    @ManyToOne
    @JoinColumn(name = "id_endereco", nullable = false)
    private Address endereco;
}
