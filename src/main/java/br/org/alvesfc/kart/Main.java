package br.org.alvesfc.kart;

import br.org.alvesfc.kart.service.RaceService;

public class Main {

    public static void main(String args[]) {

        if(args.length == 1){
            RaceService raceService = new RaceService(args[0]);

            System.out.println(raceService.getResultAsString());
        }else{
            System.out.println("Arquivo não informado!");
        }



    }

}
