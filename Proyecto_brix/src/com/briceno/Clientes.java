package com.briceno;

import com.briceno.excepciones.ErrorValidacion;

public class Clientes {
    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    public Clientes(String id, String nombre, String apellido){

    }

    public void setId(String id) throws Exception {
        if (id.length()!=13){
            throw new ErrorValidacion("EL numero de id debe contener 13 caracteres");
        }
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombreCompleto(){
        return this.nombre + "" + this.apellido;
    }

    public void setTelefono(String telefono) throws ErrorValidacion{
        if (!telefono.matches("^(\\+504\\s?)?[0-9]{4}\\-?[0-9]{4}")){
            throw new  ErrorValidacion("El numero de telefono es invalido");
        }
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if (!email.matches("^\\w+@\\w+\\.[a-z]{2,4}"));
        this.email = email;
    }
}
