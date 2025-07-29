package com.aluracursos.asynctest;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PruebaAsync {

    @Scheduled(fixedDelay = 1000)
    public void printData(){
        System.out.println("Hola mundo in thread name: " + Thread.currentThread().getId());
        //@Async no funcionara en el metodo de abajo cuando se llama desde la misma clase.
        printDataAsync();
    }

    @Async
    public void printDataAsync(){
        System.out.println("Hola mundo in thread name: " + Thread.currentThread().getId());
    }
}
