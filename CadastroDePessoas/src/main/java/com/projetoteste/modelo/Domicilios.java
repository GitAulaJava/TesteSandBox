package com.projetoteste.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity(name = "DOMICILIOS")
public class Domicilios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @NotNull
    @Column(name = "CODIGO")
    private String codigo;

    @ManyToMany
    @JoinTable(name = "DOMICILIOS_PESSOAS",
            joinColumns = {
                @JoinColumn(name = "DOMICILIO_ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "PESSOA_ID")})
    private List<Pessoas> pessoas;

    public Domicilios() {
    }

    public Domicilios(long id, String codigo, List<Pessoas> pessoas) {
        this.id = id;
        this.codigo = codigo;
        this.pessoas = pessoas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Pessoas> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoas> pessoas) {
        this.pessoas = pessoas;
    }

}
