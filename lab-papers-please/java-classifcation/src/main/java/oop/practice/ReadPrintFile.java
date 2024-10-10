package oop.practice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ReadPrintFile {
    private JsonNode rootNode;

    //method to read data from file
    public void ReadFile(String FilePath) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            File jsonFile = new File(FilePath);
            rootNode = mapper.readTree(jsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //method to print data from file
    public void PrintFile() {
        if(rootNode != null) {
            System.out.println(rootNode.toPrettyString());
        }else{
            System.out.println("No data in JSON file");
        }
    }

    public void PrintEachObject(){
        if(rootNode != null && rootNode.has("data")) {
            JsonNode DataNode = rootNode.get("data");
            ArrayList<IndividualTraits> individuals = new ArrayList<>();
            for(JsonNode individual : DataNode) {
                IndividualTraits ind = new IndividualTraits();

                System.out.println("------------");
                if(individual.has("id")) {
                    ind.setId(individual.get("id").asInt());
                }else {
                    System.out.println("Id not found");
                }
                if(individual.has("isHumanoid")){
                    ind.setHumanoid(individual.get("isHumanoid").asBoolean());
                }else{
                    System.out.println("Humanoid status not found");
                }
                if(individual.has("planet")){
                    ind.setPlanet(individual.get("planet").asText());
                }else{
                    System.out.println("Planet name not found");
                }
                if(individual.has("age")){
                    ind.setAge(individual.get("age").asInt());
                }else{
                    System.out.println("Age not found");
                }
                if(individual.has("traits")){
                    ArrayList<String> traitList = new ArrayList<>();
                    for(JsonNode trait : individual.get("traits")) {
                        traitList.add(trait.asText());
                    }
                    ind.setTraits(traitList);
                }else{
                    System.out.println("Traits not found");
                }
                individuals.add(ind);
                System.out.println("\nIndividual nr. " + ind.getId() + " :");
                System.out.println("\nId: "+ind.getId());
                System.out.println("\nAge: "+ind.getAge());
                System.out.println("\nHumanoid: "+ind.getIsHumanoid());
                System.out.println("\nPlanet: "+ind.getPlanet());
                System.out.println("\nTraits: ");
                for(String trait : ind.getTraits()) {
                    System.out.println("\n - " + trait);
                }
            }
        } else {
            System.out.println("No data in JSON file");
        }
        }


//    public void PrintObjectById(int Id){
//        if(rootNode != null && rootNode.has("data")) {
//            JsonNode DataNode = rootNode.get("data");
//            boolean found = false;
//            for(JsonNode individual : DataNode) {
//                if (individual.has("id") && individual.get("id").asInt() == Id) {
//                    System.out.println("\n Individual nr. " + individual.get("id").asInt() + ":");
//
//                    if (individual.has("isHumanoid")) {
//                        System.out.println("\n Is Humanoid: " + individual.get("isHumanoid").asBoolean());
//                    }else{
//                        System.out.println("\n Humanoid status not found");
//                    }
//                    if (individual.has("planet")) {
//                        System.out.println("\n Planet: " + individual.get("planet").asText());
//                    }else{
//                        System.out.println("\n Planet name not found");
//                    }
//                    if (individual.has("age")) {
//                        System.out.println("\n Age: " + individual.get("age").asText());
//                    }else{
//                        System.out.println("\n Age not found");
//                    }
//                    if (individual.has("traits")) {
//                        System.out.println("\n Traits: " + individual.get("traits").asText());
//                    }else{
//                        System.out.println("\n Traits not found");
//                    }
//                    found = true;
//                    break;
//                }
//            }
//            if (!found) {
//                System.out.println("\nNo Individual with id " + Id + " found");
//            }
//        }else{
//            System.out.println("No data in JSON file");
//        }
//    }

    }
