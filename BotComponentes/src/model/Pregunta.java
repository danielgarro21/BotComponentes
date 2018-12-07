/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Daniel Garro
 */
public class Pregunta {
    private int idPregunta;
    private String contenido;
    private String chatId;
    private Date fecha;
    
    
    public Pregunta(){
        
    }

    public Pregunta(int idPregunta, String contenido, String chatId, Date fecha) {
        this.idPregunta = idPregunta;
        this.contenido = contenido;
        this.chatId = chatId;
        this.fecha = fecha;
    }
    

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public String toString(){
        return "Pregunta {" + ", idPregunta=" + idPregunta + ",contenidot=" + contenido + ",fecha=" + fecha + ",chatId=" + '}';
    }
    
}

  

