package com.aluracursos.asynctest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunAsyncService {

    @Autowired
    private PruebaAsync pruebaAsync;

    // Este método usaría el proxy correctamente si se descomenta
    // @Scheduled(fixedDelay = 1000)
    public void runAsyncWithProxy() {
        // Llamado desde otra clase, el proxy sí entra en acción
        this.pruebaAsync.printDataAsync();
    }
}
