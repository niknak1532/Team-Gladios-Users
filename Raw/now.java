import java.util.Scanner;
import java.lang.Math;
public class now 
{
   public static void main( String args[] )
     {
        boolean result =true;
        int check=0;
        String username,password,fullname,email,phoneNum="";

        do{
        	System.out.println("---------------------------------------------------------");
   				
        	System.out.println("please enter the number of the function you wanna use: ");
        	System.out.println("1-> to register User");
        	System.out.println("2-> to login");
        	System.out.println("3->to remove user");
        	System.out.println("4-> to get user details");
        	System.out.println("5-> to get user email");
        	System.out.println("6-> to get user phone");
        	System.out.println("7-> to activate user");
        	System.out.println("8-> to quit the program");


        	Scanner sc= new Scanner(System.in);
   			int answer=sc.nextInt();
   			if(answer==8){
   				System.out.println("---------------------------------------------------------");
   				
   				result=false;
   			}
   			else if(answer==1){

   				System.out.println("---------------------------------------------------------");
   				System.out.println("enter username: ");
   				Scanner read= new Scanner(System.in);
   				username=read.nextLine();
   				username=username.substring(0,Math.min(username.length(),50));
   				System.out.println("enter password: ");
   				password= read.nextLine();
   				password=password.substring(0,Math.min(password.length(),50));
   				System.out.println("enter fullname: ");
   				fullname=read.nextLine();
   				fullname=fullname.substring(0,Math.min(fullname.length(),50));
   				System.out.println("enter email: ");
   				email=read.nextLine();
   				email=email.substring(0,Math.min(email.length(),50));
   				System.out.println("enter phone number:");
   				phoneNum=read.nextLine();
   				phoneNum=phoneNum.substring(0,Math.min(phoneNum.length(),10));

   				boolean st=UsersInterface.registerUser( username,password,fullname,email,phoneNum);

   				if(st==true){
   					System.out.println("The "+username+" has been register.");
   					System.out.println("please activate the account.");
   					String activationKey=UsersInterface.getActivation(username);
   					System.out.println("the activation key is: "+ activationKey);

   					System.out.println("to activate the account now please enter 1 or 2 to activate later.");

   					Scanner r= new Scanner(System.in);
   					int n=r.nextInt();
   					if(n==1){
   						boolean eish=true;
   						do{
	   						System.out.println("enter the activation key: ");
	   						String act= read.nextLine();

	   					 eish=UsersInterface.testActivatedKey(username,act);
	   						if(eish==true){
	   							System.out.println("user activated");
	   						}else{
	   							System.out.println("incorrect activation key");
	   						}
   						}while(eish==false);


   					}

   				}else{
   					System.out.println("Failed to add "+username+" in the System.");
   				}

   			}
   			else if(answer==2){

   				System.out.println("---------------------------------------------------------");

   				Scanner read= new Scanner(System.in);
   				System.out.println("enter username: ");
   				username=read.nextLine();
   				System.out.println("enter password: ");
   				password= read.nextLine();

   				int id=UsersInterface.login(username,password);
   				if(id<0){
   					System.out.println("cannot login it might be the user has not registered");

   				}else{
   					System.out.println("login successful");
   				}

   			}
   			else if(answer==3){

   				System.out.println("---------------------------------------------------------");
   				Scanner read= new Scanner(System.in);
   				System.out.println("enter the username of the user you want to remove");
   				username=read.nextLine();
   				boolean st=UsersInterface.removeUser(username);
   				if(st==true){
   					System.out.println("the user has been removed successfully");
   				}else{
   					System.out.println("failed to remove user");
   				}
   			}
   			else if(answer==4){
   				System.out.println("---------------------------------------------------------");
   				Scanner read= new Scanner(System.in);
   				System.out.println("enter the username of the user you want to get details of");
   				username=read.nextLine();

   				String st=UsersInterface.getUserDetails(username);
   				if(st==null){
   					System.out.println("the user does not exist");
   				}else{
   					System.out.println("The details of the user are: "+st.trim());
   				}
   			}
   			else if(answer==5){
   				System.out.println("---------------------------------------------------------");
   				System.out.println("enter the username of the user you want to get the email:");
   				Scanner read= new Scanner(System.in);
   				username=read.nextLine();

   				String st=UsersInterface.getEmail(username);

   				if(st==null){
   					System.out.println("the user does not exist");
   				}else{
   					System.out.println("The email of the user are: "+st.trim());
   				}

   			}
   			else if(answer==6){
   				System.out.println("---------------------------------------------------------");
   				System.out.println("enter the username of the user you want to get the phone number:");
   				Scanner read= new Scanner(System.in);
   				username=read.nextLine();

   				String st=UsersInterface.getPhoneNumber(username);

   				if(st==null){
   					System.out.println("the user does not exist");
   				}else{
   					System.out.println("The phone number of the user are: "+st.trim());
   				}

   			}
   			else if(answer==7){
   				System.out.println("---------------------------------------------------------");
   				System.out.println("enter the username of the user you want to get the activation: ");
   				Scanner read= new Scanner(System.in);
   				username=read.nextLine();

   				String st=UsersInterface.getActivation(username);
   				System.out.println(UsersInterface.getActivation(username));

   						System.out.println("this is the activation key: "+st);

   						boolean eish=true;
   						do{
	   						System.out.println("enter the activation key: ");
	   						String act= read.nextLine();

	   					 eish=UsersInterface.testActivatedKey(username,act);
	   						if(eish==true){
	   							System.out.println("user activated");
	   						}else{
	   							System.out.println("incorrect activation key");
	   						}
   						}while(eish==false);

   					

   			}


        }while(result==true);

        System.out.println("done with the program");

     }
   }
