


import java.util.Scanner;
public class BMRBeverageFINAL {

public static void main(String[] args) {
    

        
     System.out.println("This program will take your height, weight, age, and gender \nand calculate how many calories your body burns in \na day. It will then assist you in determining how many more calories \nyou can have today, and allow you to calculate how many portions of a variety \nof caloric foods that you can consume and still meet your fitness goals!");
     System.out.println("This tool is intended for individuals who have been told by a doctor\nthat they need to gain or lose weight, or have decided\nthat they want to gain or lose weight on their own.");
     
     
      //variables save variable values for use later in program execution 
    
        int goalgain;
        int goallose;
        int actlevel;
        int weight;
        int age;                                  
        int height;                              
        double caloriesleft;
        double totalcalories =0;
        int nummeals = 0;
        int foodcalories;
        int beveragecalories;
        int snackcalories;

        //Prompt User to enter their gender to calculate BMR
        Scanner input = new Scanner(System.in);

        System.out.println("\nWhat is your gender? Please enter Male or Female: ");
        String gender = input.next(); 

       //Gathering inputs from user 
        
        System.out.println("Please enter your height in inches: ");
        height = input.nextInt();
        
        System.out.println("Please enter your weight in pounds (We don't judge...we promise) :): ");
        weight = input.nextInt();
        
        System.out.println("Please enter your age: ");
        age = input.nextInt();

        
        //outputting BMR method calculation results to user  
       
        System.out.printf("\nYour body burns %.2f calories per day by just being alive!, also known as BMR (Basal Metabolic Rate)", FinalCalculatons.BMR(gender, height, weight, age));
             
        
        //informing user of upcoming prompts   
        
        System.out.println("\nLets Dive in a bit deeper using this information to further understand your calorie needs!");
        
       
        //asking user to rate activity level on scale of 1-4          
                        
        System.out.println("\nIn order to get a true representation of your body's daily calorie\n consumption, we must adjust your basal metabolic rate that we just calculated\n to your lifestyle. See lifestyle descriptions\n below, and choose the one that best fits yours.");
       
        System.out.println("\n1) Sedentary is someome who is confined to a bed, or spends less than 1 hour per day on their feet.");
        
        System.out.println("\n2) Lightly Active is someone who works at a job that requires little to no physical activity,\n and does not exercise reqularly.");
        
        System.out.println("\n3) Moderatley Active is someone who either works at a job that requires physical exertion\n for atleast half of the day, but does not exercise reqularley.\n It is also someone who works at a job that requires no physical activity, but exercises 2 to 5 times per week.");
        
        
        System.out.println("\n4) Very Active is someone who either works at a job that requires heavy physical exertion\n for more that 75% of the day, but does not exercise.\n It is also someone who exercises intensly and regularly for 5 or more days per week in general.");
        
        System.out.println("\nRate your lifetyle on a scale from 1 to 4 by selecting the number that corresponds to\n the description that most closely fits you: ");
       
       
       
        System.out.println("\n1 = Sedentary, 2 = Lightly Active, 3 = Moderatley Active, 4 = Very Active");
           
        
        //user inputs integer value according to activity level 
        
        actlevel = input.nextInt();//asking user for activity level
             
        
        //actlevelcalc method adjusts caloric consumption based on lifestyle and returns value to main method to show user
        
       
        
        //next section of program assesses the users specific fitness goals
        
        System.out.println("\nAre you trying to lose or gain weight? (Enter Gain or Lose): ");
                    
         //input string value from user for fitness goal
       
        
        //creating string input for user
       
        String fitnessgoal = input.next();
          
        char fitnessChar = fitnessgoal.charAt(0);
     
         //if statement looks for char value (0) in string "g or G" for gain, and "l or L" for lose.
     
     if (fitnessChar == 'g' || fitnessChar == 'G') {
       
         System.out.println("The Physician recommended healthy weight gain goal is either 1, or 2 pounds per week.");
         System.out.println("How many pounds per week would you like to gain (1 or 2)?: ");
          
           //asking user how much weight they want to gain 
           
            goalgain = input.nextInt();
           
           if(goalgain == 1){
           
            totalcalories = FinalCalculatons.actlevelcalc(actlevel, gender, height, weight, age) + 500;
           
            //output results to user
            
            System.out.printf("To gain 1 pound per week, you need to eat %.2f calories.", totalcalories);
             
         
              }//end if statement for 1 pound 
             
            
           if (goalgain == 2){ // if statement inside another 
            
            totalcalories = FinalCalculatons.actlevelcalc(actlevel, gender, height, weight, age) + 1000;
           
            System.out.printf("To gain 2 pounds per week, you need to eat %.2f calories per day.", totalcalories);
            
            
            
               //output results to user
           
               }//end if statement for 2 pounds
          
      
      
      
         }//end if gain
     
     
     
      else if (fitnessChar == 'l' || fitnessChar == 'L'){
      
         System.out.println("The Physician recommended healthy weight loss goal in either 1, or 2 pounds per week.");
         System.out.println("How many pounds per week would you like to lose (1 or 2)?: ");
           
           //asking user how much weight they want to gain 
           goallose = input.nextInt();
           
           if(goallose == 1){
       
           totalcalories = FinalCalculatons.actlevelcalc(actlevel, gender, height, weight, age) - 500;
           
           //output results to user
            
           System.out.printf("To lose 1 pound per week, you need to eat %.2f calories per day.", totalcalories);
      
             }// end goal lose 1 pound 
      
           
           if (goallose == 2){
           
           
           totalcalories = FinalCalculatons.actlevelcalc(actlevel, gender, height, weight, age) - 1000; 
           
          System.out.printf("To lose 2 pounds per week, you need to eat %.2f calories per day.", totalcalories);


              }//end lose 2 pounds
           
       
       
       }//end if else
    
       
         else {
         
             System.out.println("We are unable to calculate your required calories, as You have entered an invalid value.\nPlease try again, and enter Gain or Lose as your goal.");
      
               System.exit(3);
      
           }
   

      
             
       //this is a seperate process that gets data from user and calculates how many more calories they can have 
      
       System.out.println("\nWe must deduct the amount of calories that you have already eaten today.\n Please answer questions below, and we will do the calculations for you.");
      
       
       System.out.println("\nPlease enter the number of calories you have eaten today from solid food only: ");
       
           foodcalories = input.nextInt();
      
       System.out.println("\nPlease enter the amount of calories that are in all of the beverages you have had today: ");
     
           beveragecalories = input.nextInt();
       
       System.out.println("\nDont forget about snacks! It all adds up!. How many calories have you had from snacks today?: ");
     
           snackcalories = input.nextInt();
       
       
        //function to calculate total calories left for cosumption 
    
        caloriesleft = totalcalories - foodcalories - beveragecalories - snackcalories;
     
          
         //ifelse statement determines if calorie needs have already been met 
         
          if (caloriesleft > 0){
          
          System.out.printf("You still have %.2f calories that to can eat today and still meet your fitness goals.", caloriesleft);
          System.out.println("\nNow that we know how many calories you can have, lets see how much food you can eat for the remainder of the day.");
          System.out.println("Using industry averages for calorie counts in various foods, you can enjoy the following quatities of the most popular foods:"); 
           
           
           
           
       }// end if
           
          else if (caloriesleft <= 0){
       
           double caloriesleftpos = (caloriesleft* -1);//converting negative value into positive before showing user
           
           System.out.printf("You have alreay exceeded your caloric intake for the day by %.2f calories.", caloriesleftpos);
           System.out.println("\nYou can increase your body's caloric consumption by increasing physical activity, as to allow more room in your daily caloric budget.");
        
        
        }//end else 
       
    
      //printing table from action method contained in class FinalCalculations
     
      FinalCalculatons.printtableoutput(actlevel, gender, height, weight, age , caloriesleft, totalcalories ,foodcalories , beveragecalories ,snackcalories);
    
   
   
   
    }// end main method
       
 
    
    
    
  }//end class 
  
  
  
  
   

    