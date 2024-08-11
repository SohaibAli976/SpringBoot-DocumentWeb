package com.sohaib.documentweb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jdk.jfr.DataAmount;

import javax.xml.crypto.Data;


@Entity
public class Document {
    @Id
private Long id;
private String name;
    @Lob
    private byte[] data;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
