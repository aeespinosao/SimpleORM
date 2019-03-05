package com.test.orm;

import Annotations.PK;
import Annotations.Table;
import ORM.entity;

@Table(tableName="punto_venta")
public class puntoVenta extends entity {
	@PK
	public int id;
	public String nombre;
	public String direccion;
	
	public puntoVenta(int id, String nombre, String direccion) {
		this.id=id;
		this.nombre=nombre;
		this.direccion=direccion;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
        
        
}
