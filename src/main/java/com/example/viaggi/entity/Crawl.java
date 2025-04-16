package com.example.viaggi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="crawl")
public class Crawl {


@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)    
private Integer id;

@Column(name="posto_id")
private Integer posto_id;


@Column(name="cittapub")
private String cittapub;


@Column(name="descrizione")
private String descrizione;

@Column(name="prezzo")
private Integer prezzo;

@Column(name="immagine")
private String immagine;

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public Integer getPosto_id() {
    return posto_id;
}

public void setPosto_id(Integer posto_id) {
    this.posto_id = posto_id;
}

public String getCittapub() {
    return cittapub;
}

public void setCittapub(String cittapub) {
    this.cittapub = cittapub;
}

public String getDescrizione() {
    return descrizione;
}

public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
}

public Integer getPrezzo() {
    return prezzo;
}

public void setPrezzo(Integer prezzo) {
    this.prezzo = prezzo;
}

public String getImmagine() {
    return immagine;
}

public void setImmagine(String immagine) {
    this.immagine = immagine;
}



}
