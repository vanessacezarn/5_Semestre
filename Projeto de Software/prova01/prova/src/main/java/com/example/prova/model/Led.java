package com.example.prova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Led {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String estado; //ligado ou desligado
    private LocalDateTime dataHora;

    public Led() {
    }

    public Led(int id, String estado, LocalDateTime dataHora) {
        this.id = id;
        this.estado = estado;
        this.dataHora = dataHora;
    }

    public Led(String estado, LocalDateTime dataHora) {
        this.estado = estado;
        this.dataHora = dataHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Led{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", dataHora=" + dataHora +
                '}';
    }
}
