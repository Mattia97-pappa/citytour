package com.example.viaggi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {


@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)    
private Integer id;

@Column(name="username")
private String username;

@Column(name="password")
private String password;

@Column(name="cittapub")
private String cittapub;

@Column(name = "crawl_id")
    private Integer crawlId;

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public String getCittapub() {
    return cittapub;
}

public void setCittapub(String cittapub) {
    this.cittapub = cittapub;
}

public Integer getCrawlId() {
    return crawlId;
}

public void setCrawlId(Integer crawlId) {
    this.crawlId = crawlId;
}

}


