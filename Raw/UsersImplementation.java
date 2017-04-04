/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersimplementation;

import java.sql.SQLException;

/**
 *
 * @author BrianKamau
 */
public class UsersImplementation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Database db= Database.getInstance();
        Users users=new Users(db);
        
    }
    
}
