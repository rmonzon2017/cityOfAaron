/*********************************************
 * Class: GameControl
 * CIT_260
 * Spring 2018
 * Team: James Kennedy, Mallory DiBartolo
 ********************************************/

package control;

import java.util.ArrayList;
import cityofaaron.CityOfAaron;
import model.*; 

/**
 *
 * @author
 */

public class GameControl {
    
    //size of the Locations array
    private static final int MAX_ROW = 5; 
    private static final int MAX_COL = 5; 
    
    //reference to a Game object
    private static Game theGame; 
    
    public static void createNewGame(String name) {
        //create the game object. Save it in the main driver file
        
        theGame = new Game();
        CityOfAaron.setTheGame(theGame); 
        
        //create the player object. Save it in the game object
        Player thePlayer = new Player();
        thePlayer.setName(name);
        theGame.setThePlayer(thePlayer); 
        
     
    }
    
    //create the CropData object
        
        public static void createCropDataObject() {
            CropData theCrops = new CropData();
            
            theCrops.setYear(0);
            theCrops.setPopulation(100);
            theCrops.setNewPeople(5);
            theCrops.setCropYield(3);
            theCrops.setNumberWhoDied(0);
            theCrops.setOffering(10);
            theCrops.setWheatInStore(2700);
            theCrops.setAcresOwned(1000);
            theCrops.setAcresPlanted(1000);
            theCrops.setHarvest(3000);
            theCrops.setOfferingBushels(300);
            theCrops.setAcresPlanted(1000);
            
            //save the cropData in the Game object
            theGame.setCropData(theCrops); 
        }
        
        //create the list of animals
        public static void createAnimalList() {
            ArrayList<ListItem> animals = new ArrayList<>();
            
            animals.add(new ListItem("cows", 12));
            animals.add(new ListItem("horses", 3));
            animals.add(new ListItem("pigs", 7));
            animals.add(new ListItem("goats", 4)); 
            
            //save the animals in the game
            theGame.setAnimals(animals);
        }
        //create the list of tools
        //create the list of provisions
        
        //create the Locations and the Map object 
        
        /**
         * The createMap method
         * Purpose: creates the location objects and the map
         * Parameters: none
         * Returns: none
         */
        public static void createMap() {
            //create the Map object
            //refer to the Map constructor
            Map theMap = new Map(MAX_ROW, MAX_COL); 
            
            //create a string that will go in the Location objects
            //that contain the river
            String river = "You are on the River. The river is the source\n" +
                           "of life for our city. The river marks the eastern\n" +
                           "boundary of the city - it is wilderness to the East.\n";
            
            Location loc = new Location(); 
            
            //use setters in the Location class to set the description and symbol
            loc.setDescription(river);
            loc.setSymbol("~~~");
            
            //set this location object in each cell of the array in column 4
            for(int i = 0; i < MAX_ROW; i++) {
                theMap.setLocation(i, 4, loc); 
            }
            
            //define the string for a farm land location
            String farmland = "You are on the fertile banks of the River.\n" +
                              "In the spring, this low farmland floods and is covered with rich\n" +
                              "new soil. Wheat is planted as far as you can see.";
            
            //set a farmland location with a hint
            loc = new Location();
            loc.setDescription(farmland + "\nOne bushel will plant two acres of wheat.");
            loc.setSymbol("///");
            theMap.setLocation(0, 2, loc);
            
            //define the string for a mountain range
            String mountain = "You are in a mountain range. \n"; 
            
            loc = new Location();
            
            loc.setDescription(mountain);
            loc.setSymbol("^^^");
            
            for(int i = 0; i < MAX_COL; i++){
            theMap.setLocation(2, i, loc);
            }
             
            //define the string for the plains
            String plains = "You are in the plains. \n"; 
            
            loc = new Location();
            
            loc.setDescription(plains);
            loc.setSymbol("'''");
            
            for(int i = 3; i < 6; i++){
            theMap.setLocation(i, i, loc);
            }
            
            //define the string for a trading post
            
            String tradingPost = "Welcome to the trading post. \n";
            loc = new Location();
            loc.setDescription(tradingPost);
            loc.setSymbol("$"); 
            theMap.setLocation(5, 5, loc);
            
                    
            //save a reference to the map object 
            theGame.setTheMap(theMap); 
        }
        
        public void displayMap() {
            Game theGame = CityOfAaron.getTheGame();
            Map theMap = theGame.getTheMap(); 
            System.out.println("Hi, I am the Map");
            System.out.println(theMap.getLocation(0, 0));
        }
        
        
       
}
