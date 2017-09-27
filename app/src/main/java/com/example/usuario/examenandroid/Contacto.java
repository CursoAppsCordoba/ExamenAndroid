package com.example.usuario.examenandroid;

import android.os.Parcel;
import android.os.Parcelable;


public class Contacto implements Parcelable {


    private String nombre;
    private String email;
    private Integer edad;


    protected Contacto(Parcel in) {
        nombre = in.readString();
        email = in.readString();
        edad = in.readInt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacto contacto = (Contacto) o;

        if (nombre != null ? !nombre.equals(contacto.nombre) : contacto.nombre != null)
            return false;
        if (email != null ? !email.equals(contacto.email) : contacto.email != null) return false;
        return edad != null ? edad.equals(contacto.edad) : contacto.edad == null;

    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (edad != null ? edad.hashCode() : 0);
        return result;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Contacto(String nombre, String email, Integer edad) {

        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    public static final Creator<Contacto> CREATOR = new Creator<Contacto>() {
        @Override
        public Contacto createFromParcel(Parcel in) {
            return new Contacto(in);
        }

        @Override
        public Contacto[] newArray(int size) {
            return new Contacto[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(email);
        parcel.writeInt(edad);
    }

    @Override
    public String toString() {
        return "-Nombre: " + nombre + "\n" + "-Email: " + email + "\n" + "-Edad: " + edad;
    }
}
