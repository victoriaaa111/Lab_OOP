package Lab0;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args){
    ReadPrintFile inputFile = new ReadPrintFile();
    String inputFilePath = "./src/main/resources/input.json";
    ArrayList<IndividualTraits> indivs = inputFile.ReadFile(inputFilePath);

    //create universe objects
    StarWarsUniverse starWarsUniverse = new StarWarsUniverse();
    MarvelUniverse marvelUniverse = new MarvelUniverse();
    HitchhikersUniverse hitchhikersUniverse = new HitchhikersUniverse();
    LordOfTheRingsUniverse lordOfTheRingsUniverse = new LordOfTheRingsUniverse();

    //sort by universes
    for(IndividualTraits individual:indivs){
      boolean isStarWars = starWarsUniverse.checkIndividual(individual);
      if(isStarWars){
        continue; //if is part of starwars skips next universes and goes to next record
      }

      boolean isMarvel = marvelUniverse.checkIndividual(individual);
      if(isMarvel){
        continue;
      }

      boolean isVogons = hitchhikersUniverse.checkVogons(individual);
      if(isVogons){
        continue;
      }

      boolean isBetelgeusean = hitchhikersUniverse.checkBetelgeusian(individual);
      if(isBetelgeusean){
        continue;
      }

      boolean isElf = lordOfTheRingsUniverse.checkElf(individual);
      if(isElf){
        continue;
      }
      lordOfTheRingsUniverse.checkDwarf(individual);
    }

    //object to add to json
    View view = new View();

    // output to json
    view.printToJson("Star Wars", starWarsUniverse.getIndividuals(), "./src/main/output/starwars.json");
    view.printToJson("Hitchhiker", hitchhikersUniverse.getIndividuals(), "./src/main/output/hitchhiker.json");
    view.printToJson("Lord Of The Rings", lordOfTheRingsUniverse.getIndividuals(), "./src/main/output/rings.json");
    view.printToJson("Marvel", marvelUniverse.getIndividuals(), "./src/main/output/marvel.json");
  }
}

