package com.example.viaggi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="posti")
public class Posti {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)    
private Integer id;

@Column(name="citta")
private String citta;

@Column(name="descrizione")
private String descrizione;



@Column(name="hostel")
private String hostel;

@Column(name="img")
private String img;

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getCitta() {
    return citta;
}

public void setCitta(String citta) {
    this.citta = citta;
}

public String getDescrizione() {
    return descrizione;
}

public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
}

public String getHostel() {
    return hostel;
}

public void setHostel(String hostel) {
    this.hostel = hostel;
}

public String getImg() {
    return img;
}

public void setImg(String img) {
    this.img = img;
}





}
