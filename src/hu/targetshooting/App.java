package hu.targetshooting;

import hu.targetshooting.controller.ShotService;
import hu.targetshooting.model.service.DataApi;
import hu.targetshooting.model.service.DataParser;
import hu.targetshooting.model.service.FileReader;

public class App {

    private final ShotService service;

    public App() {
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        service = new ShotService(dataApi.getData("verseny.txt"));
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat");
        System.out.println("Az egymást követően többszőr találó versenyzők: "
                + service.getTwoSuccessShotIds());
        System.out.println("Az egymást követően többszőr találó versenyzők: "
                + service.getTwoSuccessShotIds2());
    }
}
