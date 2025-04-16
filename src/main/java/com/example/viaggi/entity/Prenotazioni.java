package com.example.viaggi.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="prenotazioni")
public class Prenotazioni {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)    
private Integer id;

@Column(name="crawl_id")
private Integer crawlId;

@Column(name="nome_cognome")
private String nomeCognome;

@Column(name="telefono")
private String telefono;

@Column(name="email")
private String email;


@Column(name="data_evento")
private LocalDate dataEvento;


@Column(name="quantita")
private Integer quantita;

@Column(name="created_at")
private LocalDate createdAt;

@Column(name="prezzoTot")
private Integer prezzoTot;

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public Integer getCrawlId() {
    return crawlId;
}

public void setCrawlId(Integer crawlId) {
    this.crawlId = crawlId;
}

public String getNomeCognome() {
    return nomeCognome;
}

public void setNomeCognome(String nomeCognome) {
    this.nomeCognome = nomeCognome;
}

public String getTelefono() {
    return telefono;
}

public void setTelefono(String telefono) {
    this.telefono = telefono;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public LocalDate getDataEvento() {
    return dataEvento;
}

public void setDataEvento(LocalDate dataEvento) {
    this.dataEvento = dataEvento;
}

public Integer getQuantita() {
    return quantita;
}

public void setQuantita(Integer quantita) {
    this.quantita = quantita;
}

public LocalDate getCreatedAt() {
    return createdAt;
}

public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
}

public Integer getPrezzoTot() {
    return prezzoTot;
}

public void setPrezzoTot(Integer prezzoTot) {
    this.prezzoTot = prezzoTot;
}






}
