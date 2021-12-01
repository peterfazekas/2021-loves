package hu.targetshooting;

import hu.targetshooting.controller.ShotService;
import hu.targetshooting.model.service.Console;
import hu.targetshooting.model.service.DataApi;
import hu.targetshooting.model.service.DataParser;
import hu.targetshooting.model.service.FileReader;
import hu.targetshooting.model.service.FileWriter;

import java.util.Scanner;

public class App {

    private final ShotService service;
    private final Console console;
    private final FileWriter writer;

    public App() {
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        service = new ShotService(dataApi.getData("verseny.txt"));
        console = new Console(new Scanner(System.in));
        writer = new FileWriter("sorrend.txt");
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat");
        System.out.println("Az egymást követően többszőr találó versenyzők: "
                + service.getTwoSuccessShotIds());
        System.out.println("3. feladat");
        System.out.println("A legtöbb lövést leadó versenyző rajtszáma: "
                + service.getLongestShotSequenceId());
        System.out.print("5. feladat: Adjon meg egy rajtszámot: ");
        int id = console.readId();
        System.out.println("5a. feladat: Célt érő lövések: "
                + service.getSuccessShotIndexesById(id));
        System.out.println("5b. feladat: Az eltalált korongok száma: "
                + service.countSuccessShotsById(id));
        System.out.println("5c. feladat: A leghosszabb hibátlan sorozat hossza: "
                + service.getLongestSuccessSequenceSizeById(id));
        System.out.println("5d. feladat: A versenyző pontszáma: "
                + service.getScoreById(id));
        writer.write(service.getFinalResult());
    }
}
