//this class contains the calculations that we will reuse 
//throughtout the program 



import java.util.Random;
import java.util.Scanner;

public class FinalCalculatons {

public static void printtableoutput (int actlevel, String gender, int height, int weight, int age , double caloriesleft, double totalcalories, int foodcalories, int beveragecalories, int snackcalories){
    
    System.out.println("\nPersonal Metabolic Report");
    System.out.println("________________________________________");
    System.out.printf("\nReported Age: %d Years Old " , age);
    System.out.printf("\nReported Weight: %d Pounds " , weight);
    System.out.printf("\nReported Height: %d Inches" , height);
    System.out.printf("\nReported Activity Level: %d ", actlevel);
    System.out.printf("\nCorresponding BMR: %.2f Calories per day",  BMR(gender, height, weight, age));
    System.out.printf("\nMetabolic Rate adjusted to lifestyle: %.2f Calories per day" , actlevelcalc(actlevel, gender, height, weight, age));
    System.out.printf("\nCalories you can still eat today: %.2f Calories" , caloriesleft);
    
     Random randomNums = new Random();
      // 1. create the array object

      //any item is refered to as a single slice or a 1 cup volume 
      //all data off of google
      String [] food = { "Apple\t\t\t","Corn\t\t\t\t", "Pasta\t\t\t", "Pizza\t\t\t", "Rice\t\t\t\t","Baked Potato\t","Mixed Nuts\t\t", "Chicken Breast", 
      "Steak\t\t\t", "Lobster\t\t\t", "Salmon\t\t\t","Hot Dog\t\t\t", "Cheese Burger\t", "Burrito\t\t\t", "Ramen\t\t\t", "Pho\t\t\t\t", "Soft Pretzel  ", 
      "Cookie\t\t\t","Ice Cream Cake", "Pudding Cup\t" };
      
      String [] calories = { " \t72", " \t86", "\t  313", "\t  298", "\t  205","\t  161", "\t  168", "\t  142",
      "\t  679","\t  129","\t  412", "\t  151", "\t  303", "  1000", "\t  290", "\t  367", "\t  389", " \t59", 
      "\t  250", "\t  170" };
      
      String [] drinks = {"Water\t\t","Black Coffee", "Green Tea\t", "Black Tea\t", "Orange Juice", "Coke\t\t\t", 
      "Milk\t\t\t", "Beer\t\t\t", "Red Wine\t", "White Wine\t", };
      String [] dCalories = {"  0", "  2", "  0", "  2"," 39", "150", "103","154", "125", "120" };
      

      System.out.println("\n________________________________________");
      
      
      System.out.println("\nAll items are the average calorie count and are in proper portion size. \n Quantitys of 1(ie. 1 slice, 1 cup, 1 bowl, etc)\n");
      
      System.out.println(" ________________________________________ ");
      System.out.println("|Food\t\t\t\t\t\t|\t\t\t\tCalories|" ); 
      
      for (int count = 0; count < food.length; count ++){
         System.out.println("|----------------------------------------|");
         System.out.println("|" + food[count] + "\t\t" + "|" + "\t\t\t\t  " + calories[count] + "|" );
      }
       System.out.println("|________________________________________|");
      
      System.out.println();  
   
      System.out.println("Calories are averages of the particular beverage.\n (Quantity of 1 Glass)\n");
  
      System.out.println(" ___________________________________ ");
      System.out.println("|Drinks\t\t\t\t|\t\t\t Calories|" ); 
      
      for (int count = 0; count < drinks.length; count ++){
         System.out.println("|-----------------------------------|");
         System.out.println("|" + drinks[count] + "\t\t" + "|" + "\t\t\t\t\t" + dCalories[count] +"|" );
      }
      System.out.println("|___________________________________|");
  

     
     
     }//end method tableoutput
    
    
    
    
    
    
    
    //BMR method calculated basal metabolic output, or rate. 
    
    
    public static double BMR(String gender, int height, int weight, int age){
    
    
         double BMR = 0; //initializing dummy variable
    
    
         char genderChar = gender.charAt(0);  //looks for first character match in user input

               
         if (genderChar == 'm' || genderChar =='M')   //BMR is calculated using the harris-benedict formula
            
            BMR = (66 + (6.23 * weight) + (12.7 * height) - (6.8 * age));
        
              /// end male BMR
        
         else if (genderChar == 'f' || genderChar == 'F')  //calculation for female
            
            BMR = (665 + (4.35 * weight) + (4.7 * height) - (4.7 * age));
        
              //end female BMR
        
         else {
           
             System.out.println("We could not calculate your BMR. You have entered an invalid input.\nPlease enter Male or Female for Gender, and try again..");
        
                System.exit(1);
       
               }  //informs user of invalid input and closes program. 
    
            return BMR;
    
    }//end BMR method
 
 
   //actlevelcalc method adjusts BMR to actual metabolic rate based on lifestyle
     
     
     public static double actlevelcalc(int actlevel, String gender, int height, int weight, int age){
    
          double BMRtotal = 0; //creating dummy variable to assign various values
      
      
          switch (actlevel){
                
              
              case 1: BMRtotal = BMR(gender, height, weight, age)*1.2;
                
                break;
                 
                 
              case 2:
                
                BMRtotal = BMR(gender, height, weight, age)*1.4;
                
                break;
                 

              case 3:
                
                BMRtotal = BMR(gender, height, weight, age)*1.6;
                
                break;
             
                
              case 4:
                
                BMRtotal = BMR(gender, height, weight, age)*1.8;
                
                break;
                
                 
              default:
              
                 System.out.println("Invalid input. Please enter a value from 1-4 for lifestyle, and try again."); 
                 
                    System.exit(2);
                 
                 }//end switch statement 

             
             return BMRtotal;
    
    
   }//end method actlevelcalc
 


}//end class 