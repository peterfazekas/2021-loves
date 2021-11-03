package hu.targetshooting;

import hu.targetshooting.model.domain.ShotResult;
import hu.targetshooting.model.service.DataApi;
import hu.targetshooting.model.service.DataParser;
import hu.targetshooting.model.service.FileReader;

import java.util.List;

public class App {

    public static void main(String[] args) {
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        List<ShotResult> list = dataApi.getData("verseny.txt");
        System.out.println(list);
    }
}
