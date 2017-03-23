
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gladiator
 */
public class Update_User {
    
    
   
    

   
     /**
     * @param id
     * @param firstname
     * @param Surname
     * @param description
     */
    public void get_user_update(int id,String firstname,String Surname, String description )
    {
        String dbfirstname = "Ahmadreza"; //Get FirstName from DB
        String dbSurname ="Mousa"; //Get SurName from DB
        String dbdescription = "i am Lecturer"; //Get Description from DB
    
        if(id == 45) //check id of the User we want modify on DB
        {
            dbfirstname = firstname; // send new New name to DB
            dbSurname = Surname; // send new New surname to DB
            dbdescription = description; // send new Description to DB
            
        }
        else
        {
            System.out.print("User Does Not exist");
        } 
    }
    

   public static void main(String args[]) {
   
//       int idn = 0;
//       System.out.print("Please Enter Your User id");
//       Scanner sc = new Scanner(System.in);
//       idn = sc.nextInt();
//   
//       get_user_update(idn,"Peter","Soroush","i am Student");
       
       
   }    
}
