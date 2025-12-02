package com.example.soldadura.util;

public class codigo {
    public String generarCodigo(String prefijo , int numero){
        return String.format("%s-%04d", prefijo, numero);
    }
}
