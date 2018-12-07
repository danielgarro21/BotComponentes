/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Daniel Garro
 */
public class Bot {
    private String idBot;
    private String nombre;
    private String descripcion;

    private Bot(){
        
    }
    
    public Bot(String idBot, String nombre, String descripcion) {
        this.idBot = idBot;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getIdBot() {
        return idBot;
    }

    public void setIdBot(String idBot) {
        this.idBot = idBot;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
