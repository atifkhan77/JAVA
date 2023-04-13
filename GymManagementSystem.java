import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Gym_Management_System {

	public static void main(String[] args) throws IOException {
		    Scanner sc = new Scanner(System.in);
		    String[] Admin = {"admin", "12345", "5am-11am", "4pm-11pm"};
		    String[][] Members = new String[200][12];
		    String[][] trainer = new String[20][4];
		    System.out.println("____________________________________________________________________________");
		    System.out.println("                            Welcome to Console");
		    System.out.println("____________________________________________________________________________");
		    System.out.println("*  *      *     *   *     * _________ *  _____     *     *     *    *     *");
		    System.out.println("   *   *     *  *    *  *   |  _____|   |  ___|  *    *   *     *   *      *");
		    System.out.println("*   *   *     *     *     * | |_____ *  | |         *     *   *      *    *");
		    System.out.println("   *   *     *  *     *   * |  ___| *   | |___  *      *     *   *     *   *");
		    System.out.println("*   *     *   *     *  *    | | *    *  |_____|      *   *     *   *     * ");
		    System.out.println("  *     *   *     *   *  *    FITNESS CLUB *     *     *   *     *    *      *");
		    System.out.println("_____________________________________________________________________________\n");
		    System.out.println("                             Admin Login \n\n \t\t\t   Welcome to Admin");
		    System.out.print("Enter UserName: ");
		    String U_name = sc.nextLine();
		    boolean isValidUserName;
		    do{
		        if(U_name.equals("admin")){
		           isValidUserName = false;
		        }
		        else{
		        	System.out.println("Invalid User Name! Please enter valid User Name");
		            U_name = sc.nextLine();
		    	    isValidUserName = true;
		        }
		    }while(isValidUserName);
		    System.out.print("Enter Password: ");
		    String password = sc.nextLine();
		    boolean isValidPassword;
		    do{
		        if(password.equals("12345")){
		           isValidPassword = false;
		        }
		        else{
		        	System.out.println("Invalid Password! Please enter Valid Password");
		            password = sc.nextLine();
		    	    isValidPassword = true;
		        }
		    }while(isValidPassword);
		        System.out.println("_________________________________________________________________________________________________________");
		        System.out.println("\t\t\t\t\tAdmin Details");
		        System.out.println("Admin Name: " + Admin[0]);
		        System.out.println("Morning Time: " + Admin[2]);
		        System.out.println("Evening Time: " + Admin[3]);
		        System.out.println("__________________________________________________________________________________________________________");	
		        try {
		        File a1 = new File("Members.txt");
		        Scanner input = new Scanner(a1);
		        //Storing data from file to Members 2d Array
		        for(int i = 0; i < Members.length; i++){
		            String ab = input.nextLine();
		            String[] data = ab.split("#");
		            for(int j = 0; j < Members[0].length; j++){
		                Members[i][j] = data[j];
		            }
		        }
		      //Storing data from file to trainers 2d Array
		        File a2 = new File("trainers.txt");
		        Scanner ins = new Scanner(a2);
		        for(int k = 0; k < trainer.length; k++){
		            String dt = ins.nextLine();
		            String[] Trn = dt.split("#");
		            for(int s = 0; s < trainer[0].length; s++){
		                    trainer[k][s] = Trn[s];
		            }
		        }
		        }catch(FileNotFoundException e) {
		        	System.out.println("File not found.... Sorry we are exiting");
		        	System.exit(1);
		        }catch(IndexOutOfBoundsException e) {
		        	System.out.println("Index out of bound exception...Sorry we are exiting");
		        	System.exit(1);
		        }
		        while(true){
		        	System.out.println("\t\t\t\t\t***************");
			        System.out.println("\t\t\t\t\t*** OPTIONS ***");
			        System.out.println("\t\t\t\t\t***************");
		            System.out.println("Enter your choice: ");
		            System.out.println("1- Details of Members");
		            System.out.println("2- View Members");
		            System.out.println("3- Modify Member");
		            System.out.println("4- Add new Member");
		            System.out.println("5- Delete Member");
		            System.out.println("6- View Trainers");
		            System.out.println("7- Trainers detail");
		            System.out.println("8- Add Trainer");
		            System.out.println("9- Modify Trainer");
		            System.out.println("10- Delete Trainer");
		            System.out.println("0- Exit");
		            System.out.print("Enter choice from(0 - 10): ");
		            int choic = sc.nextInt();
		            if (choic == 1) {
		                DetailsOfMember(Members);
		            } else if (choic == 2) {
		                View_Members(Members);
		            } else if (choic == 3) {
		                modify_Members(Members, trainer);
		                //Modify the file Members(Store from 2d Member Array to File)
		                PrintWriter myFile = new PrintWriter("./Members.txt");
		                for(int i = 0;i<Members.length;i++) {
		                	for(int j = 0 ; j < Members[0].length ; j++) {
		                	 myFile.print(Members[i][j]+"#");
		                     }
		                	myFile.println();
		                }
		                myFile.close();
		            } else if (choic == 4) {
		                add_new_members(Members, trainer);
		              //Modify the file Members(Store from 2d Member Array to File)
		                PrintWriter myFile = new PrintWriter("./Members.txt");
		                for(int i = 0;i<Members.length;i++) {
		                	for(int j = 0 ; j < Members[0].length ; j++) {
		                	 myFile.print(Members[i][j]+"#");
		                     }
		                	myFile.println();
		                }
		                myFile.close();
		            } else if(choic == 5) {
		            	delete_Members(Members);
		            } else if(choic == 6) {
		            	View_Trainers(trainer);
		            } else if (choic == 7) {
		                Trainers_detail(trainer);
		            } else if (choic == 8) {
		                Add_Trainer(trainer);
		              //Modify the file trainers(Store from 2d trainer Array to File)
		                PrintWriter myFile = new PrintWriter("./trainers.txt");
		                for(int i = 0;i<trainer.length;i++) {
		                	for(int j = 0 ; j < trainer[0].length ; j++) {
		                	 myFile.print(trainer[i][j]+"#");
		                     }
		                	myFile.println();
		                }
		                myFile.close();
		                
		            }else if(choic == 9){
		                Modify_trainer(trainer);
		               //Modify the file trainers(Store from 2d trainer Array to File)
		                PrintWriter myFile = new PrintWriter("trainers.txt");
		                for(int i = 0;i<trainer.length;i++) {
		                	for(int j = 0 ; j < trainer[0].length ; j++) {
		                	 myFile.print(trainer[i][j]+"#");
		                     }
		                	myFile.println();
		                }
		                myFile.close();
		            }else if(choic == 10) {
		            	delete_Trainers(trainer);
		            }else if (choic == 0) {
		                break;
		            }else {
		                System.out.println("Wrong Choice! Select choice from (0 - 11)");
		            }
		        }
		}
	public static void DetailsOfMember(String[][] list3) {
		System.out.println("_________________________________________________________________________________________________________");
	    System.out.println("\t\t\t\t\tDetails Of Members ");
		int index = -1;
		String No;
	    do{
			Scanner input = new Scanner(System.in);
	    	System.out.print("Enter registration Number: ");
	        No = input.next();
	        for(int i = 0; i < list3.length; i++){
		        if(No.equals(list3[i][0])){
		            index = i;
		            break;
		        }
	        }
		    if(index != -1){
			    System.out.println("_________________________________________________________________________________________________________");
			    System.out.println("\t\t\t\t\t* Data of "+list3[index][1]+" *");
			    System.out.println("_________________________________________________________________________________________________________");
			    System.out.println("-> Registration Number: " + list3[index][0]);
			    System.out.println("-> First Name: " + list3[index][1]);
			    System.out.println("-> Last Name: " + list3[index][2]);
			    System.out.println("-> Date Of Birth: " + list3[index][3]);
			    System.out.println("-> Gender: " + list3[index][4]);
			    System.out.println("-> Weight: " + list3[index][5]);
			    System.out.println("-> Height: " + list3[index][6]);
			    System.out.println("-> Fitness Program: " + list3[index][7]);
			    System.out.println("-> Contact Number: " + list3[index][8]);
			    System.out.println("-> Trainer: " + list3[index][9]);
			    System.out.println("-> Workout Session: " + list3[index][10]);
			    System.out.println("-> MemberShip: " + list3[index][11]);
			    System.out.println("_________________________________________________________________________________________________________");
		    }
		    else{
		    	System.out.print("Member not found. PLEASE AGAIN  ");
		    }
		}while(index == -1);
	}
	public static void View_Members(String[][] list) {
	    System.out.println("_________________________________________________________________________________________________________");
	    System.out.println("\t\t\t\t\tList Of Members : ");
	    System.out.println("Reg. No."+"\t| "+ "\tNames");
	    for (int i = 0; i < list.length; i++) {
	        if (list[i][0].equals("null") == false) {
	            System.out.println(list[i][0]+"\t\t| \t"+list[i][1] + " " + list[i][2]);
	        }
	    }
	    System.out.println("_________________________________________________________________________________________________________");
	}
	public static void modify_Members(String list[][], String list2[][]){
		System.out.println("_________________________________________________________________________________________________________");
	    System.out.println("\t\t\t\t\t\tModify Members");
		int index;
		do{
		    Scanner input = new Scanner(System.in);
		    System.out.print("Enter Registration Number: ");
		    String Reg_No = input.next();
		    index = -1;
		    for (int i = 0; i < list.length; i++) { //Finding index of the row where reg No. match
		        if (Reg_No.equals(list[i][0]) == true) {
		            System.out.println("_________________________________________________________________________________________________________");
		            System.out.println("\t\t\t\t\t* Modify the Details of "+list[i][1]+" "+ list[i][2]+" *");
		            index = i;
		            break;
		        }
		    }
		    if(index != -1){
			    System.out.println("What you want to modify: ");
			    System.out.println("1- Name! ");
			    System.out.println("2- Weight! ");
			    System.out.println("3- Height! ");
			    System.out.println("4- Trainer! ");
			    System.out.println("5- Contact Number! ");
			    System.out.println("6- Program! ");
			    System.out.println("7- Session! ");
			    System.out.print("Enter choice from (1 - 7): ");
			    int choic = input.nextInt();
			    while(choic != 1 && choic != 2 && choic != 3 && choic != 4 && choic != 5 && choic != 6 && choic != 7) {
			        System.out.println("Invalid choice... Please Enter valid choice! ");
			        choic = input.nextInt();
			    }
			    if(choic == 1) {
			        System.out.print("Enter Name: ");
			        String name = input.next();
			        list[index][1] = name;
			        System.out.println("_________________________________________________________________________________________________________");
			        System.out.println("\t\t\t\t\tName Updated Successfully! ");
			    }else if (choic == 2) {
			    	int colunm = 5;
			    	InputforHeightAndWeight(list,choic,index,colunm);
			        System.out.println("_________________________________________________________________________________________________________");
			        System.out.println("\t\t\t\t\tWeight Updated Successfully! ");
			    }else if (choic == 3) {
			    	int colunm = 6;
			    	InputforHeightAndWeight(list,choic,index,colunm);
			        System.out.println("_________________________________________________________________________________________________________");
			        System.out.println("\t\t\t\t\tHeight Updated Successfully! ");
			    }else if (choic == 4) {
			        System.out.println("Trainers Details are as Follows! ");
			        int j = 1;
			        //To print list of trainers available
			        for (int i = 0; i < list2.length; i++) {
			        	if (list2[i][0].equals("null") != true) {
			                System.out.println(j+". "+list2[i][0] + " "+list2[i][1]);
			                j++;}
			        }
			        System.out.print("Choose number of trainer you want: ");
			        String trainer = input.next();
			        list[index][9] = trainer;
			        System.out.println("_________________________________________________________________________________________________________");
			        System.out.println("\t\t\t\t\tTrainer Updated Successfully! ");
			    }else if (choic == 5) {
			        System.out.print("Enter contact Number: ");
			        String contact_num = input.next();
			        list[index][8] = contact_num;
			        System.out.println("_________________________________________________________________________________________________________");
			        System.out.println("\t\t\t\t\tContact Number Updated Successfully! ");
			    }else if (choic == 6) {
			        System.out.println("Select your fitness Program");
			        System.out.println("1- Weight Loss");
			        System.out.println("2- Muscle Gain");
			        System.out.println("3- Shreding");
			        String choice2 = input.next();
			        while(choice2.equals("1") == false && choice2.equals("2") == false && choice2.equals("3") == false) {
			            System.out.println("Wrong choice! Please Select Valid Choice");
			            System.out.println("Select choice from 1-3");
			            choice2 = input.next();
			        }
			        if(choice2.equals("1")) {
			            list[index][7] = "Weight Loss";
			        }
			        if(choice2.equals("2")) {
			            list2[index][7] = "Muscle Gain";
			        }
			        if(choice2.equals("3")) {
			            list[index][7] = "Shreding";
			        }
			        System.out.println("_________________________________________________________________________________________________________");
			        System.out.println("\t\t\t\t\tFitness Program Updated Successfully! ");
			    }else if (choic == 7) {
			        System.out.println("Select Workout Session : ");
			        System.out.println("1- Morning");
			        System.out.println("2- Evening");
			        System.out.println("3- Morning and Evening");
			        String ch = input.next();
			        while (ch.equals("1") == false && ch.equals("2") == false && ch.equals("3") == false) {
			            System.out.print("Invalid choice. Choose between 1-3: ");
			            ch = input.next();
			        }
			        if(ch.equals("1")) {
			            list[index][10] = "Morning";
			        }
			        else if(ch.equals("2")) {
			            list[index][10] = "Evening";
			        }
			        else {
			            list[index][10] = "Morning and Evening";
			        }
			        System.out.println("_________________________________________________________________________________________________________");
			        System.out.println("\t\t\t\tWorkout Session Updated Successfully! ");
			        
			    }
			}
		    else{
		    	System.out.print("Sorry! Member Not FOUND. Please Again ");
		    }
	   }while(index == -1);
		System.out.println("_________________________________________________________________________________________________________");
	}
	public static String[][] add_new_members(String[][] list1, String list2[][]) {
	    System.out.println("_________________________________________________________________________________________________________");
	    System.out.println("\t\t\t\t\tAdd New Member");
	    Scanner input = new Scanner(System.in);
	    int index = -1;
	    for(int i = 0; i < list1.length; i++) {
	        if (list1[i][0].equals("null")) {
	            index = i;
	            break;
	        }
	    }
	    System.out.print("Enter the Registration Number: ");
	    String regNo = input.next();
	    for (int i = 0; i < list1.length; i++) {
	        while (list1[i][0].equals(regNo)) {
	        	System.out.print("This registration Number already written please Enter a unique registration number: ");
	            regNo = input.next();
	        }
	     
	    }
	    list1[index][0] = regNo;
	    System.out.print("Enter the first name of member and last ");
	    String firstName = input.next();
	    list1[index][1] = firstName;
	    String lastName = input.next();
	    list1[index][2] = lastName;
	    System.out.print("Enter your Date Of Birth: ");
	    String dateOfBirth = input.next();
	    list1[index][3] = dateOfBirth;
	    System.out.println("Select Gender ");
	    System.out.println("1- Male");
	    System.out.println("2- Female");
	    System.out.println("3- Other");
	    String choice = input.next();
	    while (choice.equals("1") == false && choice.equals("2") == false && choice.equals("3") == false) {
	            System.out.println("Wrong choice! Please select valid choice");
	            System.out.println("Select choice from 1-3");
	            choice = input.next();
	    }
	    if(choice.equals("1") == true) {
	        list1[index][4] = "Male";
	    }
	    else if(choice.equals("2") == true) {
	        list1[index][4] = "Female";
	    }
	    else{
	        list1[index][4] = "Others";
	    }
	    int colunm = 5;
	    int choiceforWeight = 2;
	    InputforHeightAndWeight(list1,choiceforWeight,index,colunm);
	    colunm = 6;
	    int choiceforHeight = 3;
	    InputforHeightAndWeight(list1,choiceforHeight,index,colunm);
	    System.out.println("Select your fitness Program");
	    System.out.println("1- Weight Loss");
	    System.out.println("2- Muscle Gain");
	    System.out.println("3- Shreding");
	    System.out.print("Enter the choice(1-3)");
	    String choice2 = input.next();
	    while (choice2.equals("1") == false && choice2.equals("2") == false && choice2.equals("3") == false) {
	        System.out.println("Wrong choice! Please Select Valid Choice");
	        System.out.println("Select choice from 1-3");
	        choice2 = input.next();
	    }
	    if(choice2.equals("1")) {
	        list1[index][7] = "Weight Loss";
	    }
	    else if(choice2.equals("2")) {
	        list1[index][7] = "Muscle Gain";
	    }
	    else{
	        list1[index][7] = "Shreding";
	    }
	    System.out.print("Enter your Contact Number: ");
	    String Phone = input.next();
	    list1[index][8] = Phone;
	    System.out.println("Need Trainer! ");
	    System.out.println("Press Y for Yess and for No press any other key: ");
	    String c = input.next();
	    if(c.equalsIgnoreCase("Y")) {
	        System.out.println("Following Trainers are avaliable: ");
	        for(int i = 0; i < list2.length; i++) {
	        	if(!(list2[i][0].equals("null"))) 
	                System.out.println("->"+list2[i][0] + " "+list2[i][1]);
	                
	        }
	        String trainer_name;
	        boolean n = true;
	        while(n){
	        	System.out.print("Enter name of trainer from list you want: ");
	        	trainer_name = input.next();
	           for(int i = 0; i < list2.length; i++) {
	                if(trainer_name.equalsIgnoreCase(list2[i][0])) {
	                    list1[index][9] = trainer_name;
	                    n = false;
	                    break;
	                } 
	           }
	           
	        }
	    }
	    else{
	        list1[index][9] = "None";
	    }
	    System.out.println("Select Workout Session : ");
	    System.out.println("1- Morning");
	    System.out.println("2- Evening");
	    System.out.println("3- Morning and Evening");
	    System.out.print("Enter the choice(1-3)");
	    String ch = input.next();
	    while (ch.equals("1") == false && ch.equals("2") == false && ch.equals("3") == false) {
	        System.out.println("Invalid choice. Please Select the valid choice ");
	        System.out.print("Select the choice(1-3)");
	        ch = input.next();
	    }
	    if(ch.equals("1")) {
	        list1[index][10] = "Morning";
	    }
	    else if(ch.equals("2")) {
	        list1[index][10] = "Evening";
	    }
	    else{
	        list1[index][10] = "Morning and Evening";
	    }
	    System.out.println("Select Your MemberShip: ");
	    System.out.println("MemberShip Rates");
	    System.out.println("Press Y to see MemberShip details with Trainer and N to see MemberShip rates without Trainer");
	    String ch1 = input.next();
	    boolean n = true;
	    while(n) {
	    	if(ch1.equalsIgnoreCase("N") == false && ch1.equalsIgnoreCase("Y") == false) {
	    		System.out.println("Invalid Input...Entry must b (Y/N): ");
	    		ch1 = input.next();
	    	}
	    	else{
	    		n = false;
	    	}
	    }
	    if(ch1.equalsIgnoreCase("N")) {
	        System.out.println("Select Your Choice: ");
	        System.out.println("1- One Year (50,000PKR)");
	        System.out.println("2- Six Month (25,000PKR)");
	        System.out.println("3- Three Month (12,000PKR)");
	        System.out.println("4- One Month (5,000PKR)");
	        String choice1 = input.next();
	        while(choice1.equals("1") == false && choice1.equals("2") == false && choice1.equals("3") == false && choice1.equals("4") == false) {
	            System.out.println("Invalid choice. Please Select the valid choice ");
	            System.out.print("Select the choice(1-4)");
	            choice1 = input.next();
	        }
	        if(choice1 == "1") {
	            list1[index][11] = "One Year (50,000PKR)";
	        }else if (choice1 == "2") {
	            list1[index][11] = "Six Month (25,000PKR)";
	        }else if (choice1 == "3") {
	            list1[index][11] = "Three Month (12,000PKR)";
	        }else{
	            list1[index][11] = "One Month (5,000PKR)";
	        }
	    }
	    if(ch1.equalsIgnoreCase("Y")) {
	        System.out.println("Select Your Choice: ");
	        System.out.println("1- One Year (80,000PKR)");
	        System.out.println("2- Six Month (40,000PKR)");
	        System.out.println("3- Three Month (20,000PKR)");
	        System.out.println("4- One Month (10,000PKR)");
	        String ch2 = input.next();
	        while (ch2.equals("1") == false && ch2.equals("2") == false && ch2.equals("3") == false && ch2.equals("4") == false) {
	            System.out.println("Invalid choice. Please Select the valid choice ");
	            System.out.print("Select the choice(1-4)");
	            ch2 = input.next();
	        }
	        if(ch2 == "1") {
	            list1[index][11] = "One Year (80,000PKR)";
	        }else if (ch2 == "2") {
	            list1[index][11] = "Six Month (40,000PKR)";
	        }else if (ch2 == "3") {
	            list1[index][11] = "Three Month (20,000PKR)";
	        }else {
	            list1[index][11] = "One Month (10,000PKR)";
	        } 
	    }
	    System.out.println("");
	    System.out.println("");
	    System.out.println("\t\t\t\t\tMember Added Successfuly");
	    System.out.println("_________________________________________________________________________________________________________");
	    return list1;
	}
	public static void delete_Members(String list[][]) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the regNo to delete the member: ");
		String str = input.nextLine();
		File myFile = new File("Members.txt");
		Scanner sc = new Scanner(myFile);
		boolean x = false;
		while (sc.hasNextLine()){
		    String s = sc.nextLine();
			if (s.startsWith(str)){
			    x = true;
				System.out.println("Member found\nDo you want Delete (Y/N): ");
				String choice = input.next();
				if (choice.equalsIgnoreCase("Y")){
					break;
				}
				else if (choice.equalsIgnoreCase("N"))
					return; //nothing return
			}
		}
		if(x == false){
	       System.out.println("Member not found\n");
	       return;
		}
		sc.close();
		Scanner scan = new Scanner(myFile);
		String data = "";
		while (scan.hasNextLine()){
			String line = scan.nextLine();
			if (line.startsWith(str))
				data +=  "null#null#null#null#null#null#null#null#null#null#null#null#\n";
			else
				data += line+"\n";
		}
		scan.close();
		//delete previous file
		myFile.delete();
		//create new file with the same name
		File myNewFile = new File("./Members.txt");
		FileWriter writer = new FileWriter(myNewFile);
		//write data from data(String) into Members file
		writer.write(data);
		writer.close();
		System.out.println("Membership removed successfully");
		System.out.println("_________________________________________________________________________________________________________");
		
	}
	
	public static void View_Trainers(String[][] list) {
	    System.out.println("_________________________________________________________________________________________________________");
		System.out.println("\t\t\t\tList Of Trainers : ");
		System.out.println("No."+ "\tNames");
		int j = 1; 
		for(int i = 0; i < list.length; i++) {
		     if(list[i][0].equals("null") == false) {
		                              // j use for numbering     Names
		          System.out.println((j)+".\t"+list[i][0]+" "+list[i][1]);
		          j++;
		     }
		}
		System.out.println("_________________________________________________________________________________________________________");
		}
	
	public static void Trainers_detail(String list[][]) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("_________________________________________________________________________________________________________");
	    System.out.println("\t\t\t\t\tTrainers' Deatils");
	    int index;
	    do {
	          System.out.print("Enter the name of trainer: ");
	          String name = sc.next();
	          index = -1;
	          for (int i = 0; i < list.length; i++) {
	             if (name.equalsIgnoreCase(list[i][0]) == true) {
	               index = i;
	               break;
	             }
	          }
	         if(index != -1) {
	        	System.out.println("_________________________________________________________________________________________________________");
	            System.out.println("\t\t\t\t\tDetails of "+list[index][0]);
	        	System.out.println("Trainer's Name: " + list[index][0]);
	            System.out.println("Last Name: " + list[index][1]);
	            System.out.println("Gender: " + list[index][2]);
	            System.out.println("Contact Number: " + list[index][3]);
	        }
	        else{
	            System.out.print("Sorry! Trainer not Found. Please Again ");
	        }  
	    } while( index == -1);
	    System.out.println("_________________________________________________________________________________________________________");
	}
	
	public static String [][] Add_Trainer(String[][] list) {
		Scanner input = new Scanner(System.in);
		int index = -1;
		for(int i = 0; i < list.length; i++) {
		      if(list[i][0].equals("null") == true) {
			     index = i;
			     break;
		      }
		}
		if(index == -1) {
		        System.out.println("Sorry, there is no available membership");
		    }
		    if(index != -1) {
		        System.out.print("Enter first name: ");
		        String f_name = input.next();
		        list[index][0] = f_name;
		        System.out.print("Enter last name: ");
		        String l_name = input.next();
		        list[index][1] = l_name;
		        System.out.println("Select gender: ");
		        System.out.println("1- Male");
		        System.out.println("2- Female");
		        System.out.println("3- Others");
		        int choice = input.nextInt();
		        while(choice != 1 && choice != 2 && choice != 3){
		            System.out.println("Wrong Choice! Please enter valid choice");
		            System.out.print("Select from (1-3): ");
		            choice = input.nextInt();
		        }
		        if(choice == 1){
		           list[index][2] = "Male";
		        }
		        else if(choice == 2){
		            list[index][2] = "Female";
		        }
		        else{
		            list[index][2] = "Others";
		        }
		        System.out.print("Enter contact Number: ");
		        String C_no = input.next();
		        list[index][3] = C_no;
		        System.out.println("\t\t\t\t\tTrainer Added Successfuly");
		        System.out.println("_________________________________________________________________________________________________________");		        
		    }
		    return list;
		}
	
	public static void Modify_trainer(String[][]list){
	    Scanner input = new Scanner(System.in);
	    System.out.println("Trainers' names are as follows");
	    for(int i = 0;i<list.length;i++){
	        if(!(list[i][0].equals("null"))){
	            System.out.println("-> "+list[i][0]+" "+list[i][1]);
	        }
	    }
	    String trainer_name;
	    boolean n = true;
	    int index = 1;
	    while(n){
	        System.out.print("Enter name of trainer from list you want: ");
	        trainer_name = input.next();
	        for (int j = 0; j < list.length; j++) {
	                if(trainer_name.equalsIgnoreCase(list[j][0])) {
	                	index = j;
	                    n = false;
	                } 
	        }    
	    }
	    System.out.println("What do you want to modify");
	    System.out.println("1- Name");
	    System.out.println("2- Last Name");
	    System.out.println("3- Contact Number");
	    int choice = input.nextInt();
	    while(choice != 1 && choice != 2 && choice != 3){
	        System.out.println("Wrong Choice! Please enter valid choice");
	        System.out.print("Select from (1-3): ");
	        choice = input.nextInt();
	    }
		if(choice == 1){
	        System.out.print("Enter first Name: ");
	        String f_name = input.next();
	        list[index][0] = f_name;
	        System.out.println("__________________________________________________________________________________________________________");
	        System.out.println("\t\t\t\t\tName Updated Successfully");
	    }
	    else if(choice == 2){
	        System.out.print("Enter Last Name: ");
	        String l_name = input.next();
	        list[index][1] = l_name;
	        System.out.println("___________________________________________________________________________________________________________");
	        System.out.println("\t\t\t\t\tLast Name Updated Successfully");
	    }
	    else{
	        System.out.print("Enter Contact Number: ");
	        String contactNumber = input.next();
	        list[index][3] = contactNumber;
	        System.out.println("____________________________________________________________________________________________________________");
	        System.out.println("\t\t\t\t\tContact Number Updated Successfully");
	    
	    }
		System.out.println("____________________________________________________________________________________________________________");
    } 
	
	public static void delete_Trainers(String list[][]) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the Name to delete the trainer: ");
	    String str = input.nextLine();
   	    File myFile = new File("./trainers.txt");
		Scanner sc = new Scanner(myFile);
		boolean x = false;
		while(sc.hasNextLine()){
			    String s = sc.nextLine();
				if (s.startsWith(str)){
				    x = true;
					System.out.println("Trainer found\nDo you want Delete (Y/N): ");
					char choice = input.next().toLowerCase().charAt(0);
					if(choice == 'y'){
						break;
					}
					else if (choice == 'n')
						return;
			   }
			}
	   if (x == false){
		        System.out.println("Trainer not found");
		        return;
	   }
	   sc.close();
	   Scanner scan = new Scanner(myFile);
	   String data = "";
	   while (scan.hasNextLine()){
		        String line = scan.nextLine();
		  		if(!(line.startsWith(str)))
		  		    data += line+"\n";
		  		else if (line.startsWith(str))
		  			data +=  "null#null#null#null#\n";
			 }
		scan.close();
		//Previous file delete
		myFile.delete();
		// create new file with the same name
		File myNewFile = new File("./trainers.txt");
		FileWriter writer = new FileWriter(myNewFile);
		writer.write(data);
		writer.close();
		System.out.println("Membership removed successfully");
		System.out.println("_________________________________________________________________________________________________________");
		}
		
		public static void InputforHeightAndWeight(String list[][], int choice, int index, int i) {
			Scanner input = new Scanner(System.in);
			boolean takeInput = true;
			double weightdoub;
			double heightdoub;
			String str = (choice == 2)?"weight":"height";
			do{
				try{
					if(choice == 2) {
						System.out.print("Enter Weight: ");
			            weightdoub = input.nextDouble();
			            String weightstr = String.valueOf(weightdoub);
			            list[index][i] = weightstr;
					    takeInput = false;
			    	}
			    	else {
			    		System.out.print("Enter Height: ");
			            heightdoub = input.nextDouble();
			            String weightstr = String.valueOf(heightdoub);
			            list[index][i] = weightstr;
					    takeInput = false;
				    }
				}catch (Exception ex) {
				        System.out.println("Try again. (" + "Incorrect input: "+str+" must be in a number)");
				        input.nextLine();
			     }
			}while(takeInput);
		}
}
