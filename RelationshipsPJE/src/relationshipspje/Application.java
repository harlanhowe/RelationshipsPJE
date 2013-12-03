package relationshipspje;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Application {
	
	private Scanner input;
	private PeopleClass currentPerson;
	private Controller controller;
	
	public Application(){
		 input =  new Scanner(System.in);
		 currentPerson = null;
		 controller = new Controller();
		 controller.openPeople();
		 controller.openRelTypes();
		 controller.openRelationships();
	}
	
	/*
	 * Pre-condition: Nothing in the entire program has started
	 * Post-condition: Program ends
	 */
	public void run(){
		while(true){
			if (currentPerson!=null){ //you have selected a person to view their information
				displayInformation(currentPerson);
				int response = displayMenu(); //output the main menu every run and store the input in variable 'response'
				processResponse(response);
			}
			else{ //Ask user to select a person to view their relationship
				selectPerson();
			}
			
			

		}
		
		
	}
	/*
	 * Displays all the relationships of current person
	 * 
	 */
	private void displayInformation(PeopleClass person) {
		System.out.println("You are viewing the relationships of: "+person.getLastName()+", "+person.getFirstName()); 
		
		ArrayList<Relationship> relationships = controller.getAllRelationshispForPerson(currentPerson); //get all relationships for person
		for (int i = 0;i<relationships.size();i++){ //iterate through each relationship
			
			Relationship relationship = relationships.get(i);
			RelationType type = relationship.getRelationType(); //get the type of the relationship
			PeopleClass secondaryPerson = relationship.getSecondaryPerson();//get the secondary person of the relationship
			
			String relationshipTypeName;
			if (secondaryPerson.getIsMale()) //depending on the gender of the secondary person, the title will be different
				relationshipTypeName = type.getFwdMaleName();
			else
				relationshipTypeName = type.getFwdFemaleName();
			
			//Print out the 'currentPerson' has a 'relationshipTypeName', 'secondaryPerson' statement
			System.out.print(currentPerson.getLastName()+", "+currentPerson.getFirstName()+" has a ");
			System.out.print(relationshipTypeName+", ");
			System.out.println(relationship.getSecondaryPerson().getLastName()+", "+relationship.getSecondaryPerson().getFirstName());
			
		}
		
		
		
		
	}

	/*
	 * Prompts user to select a person from all people in database
	 * sets currentUser to the person that the user selected
	 */
	private void selectPerson() { 
		ArrayList<PeopleClass> people = controller.getAllPeople();
		
		ArrayList<String> options = new ArrayList<String>(); 
		String name;
		for (int i = 0;i<people.size();i++){ //Add to 'options' Strings that are in the form of 'firstname','lastname' like 'Howe, Harlan'
			name = people.get(i).getLastName()+", "+people.get(i).getFirstName();
			options.add(name);
			
		}
		int person = displayMenuAndGetResponse("People", options, "Please Select a Person to View", false); //display menu and get user to select a person
		currentPerson = people.get(person); //set current person
		
		
	}
	
	
	
	/*
	 * Processes the number that the user clicked from the main menu
	 */
	private void processResponse(int userInput) {
		switch (userInput)
		{
		case 0: //switch person to view
			System.out.println("Switching Person...");
			currentPerson = null;
			break;
		case 1: //Add Relationship
			addRelationship();
			break;
		case 2://Delete Relationship
			deleteRelationship();
			break;
		case 3://Add New Person
			addPerson();
			break;
		case 4: //Delete Person
			deletePerson();
			break;
		case 5: //Add New Relationship Type
			addRelationshipType();
			break;
		case 6: //Delete Relationship Type
			deleteRelationshipType();
			break;
		case 7: //Save
			saveState();
			break;
		case 8: //Exit Program
			endProgram();
			break;
		}
		
		
	}

	/*
	 * Calls controller method that will save all changes to the database files themselves
	 */
	private void saveState() {
		// TODO Auto-generated method stub
		controller.saveAll();
		
	}

	/*
	 * Deletes a relationship type
	 */
	private void deleteRelationshipType() {
		// TODO Auto-generated method stub
		ArrayList<RelationType> relationshipTypes = controller.getAllRelationshipTypes(); //get all relationship types
		ArrayList<String> options = new ArrayList<String>();
		
		for (int i = 0;i<relationshipTypes.size();i++){ //add each to options so that the user can choose which to delete
			options.add(relationshipTypes.get(i).getGenericName());

		}
		int response = this.displayMenuAndGetResponse("Relationshp Types",options,"Select a relationship type to delete",true);
		if (response == -1){
			System.out.println("Relationship Type Deletion Cancelled");
			return;
		}else{
			controller.deleteRelationshipType(relationshipTypes.get(response)); //call controller method to delete the relationshp type

		}
		
	}

	/*
	 * Adds a new relationship type
	 */
	private void addRelationshipType() {
		// TODO Auto-generated method stub
		input.nextLine(); //clear the input buffer
		
		//Asks the user to input information pertaining to the new relationship type
		System.out.println("Please enter the generic name of the relationship type");
		String genericName = input.nextLine();
		System.out.println("Please enter the forward male name of the relationship type");
		String fwdMaleName = input.nextLine();
		System.out.println("Please enter the forward female name of the relationship type");
		String fwdFemaleName = input.nextLine();
		System.out.println("Please enter the reverse male name of the relationship type");
		String revMaleName = input.nextLine();
		System.out.println("Please enter the reverse female name of the relationship type");
		String revFemaleName = input.nextLine();
		
		
		//Checks if an inverse relationship needs to be created
		if (fwdMaleName.equals(revMaleName) && fwdFemaleName.equals(revFemaleName)){
			controller.addRelType(genericName, fwdMaleName, fwdFemaleName, revMaleName, revFemaleName); //Create without inverse 
		}
		else{
			System.out.println("Please enter the generic name of the inverse relationship type");
			String inverseGenericName  = input.nextLine();

			controller.addRelType(genericName,fwdMaleName,fwdFemaleName,revMaleName,revFemaleName,inverseGenericName);//Create with inverse
		}

		


		
	}

	/*
	 * Deletes a person from the database
	 */
	private void deletePerson() {
		ArrayList<PeopleClass> people = controller.getAllPeople(); //gets all people form database
		ArrayList<String> options = new ArrayList<String>();
		for (int i = 0;i<people.size();i++){ //Add to 'options' Strings that are in the form of 'firstname','lastname' like 'Howe, Harlan'
			String name = people.get(i).getLastName()+", "+people.get(i).getFirstName();
			options.add(name);
		}
		int response = this.displayMenuAndGetResponse("People",options,"Select a person to delete from database",true); //display menu
		if (response == -1){
			System.out.println("Person Deletion Cancelled");
			return;
		}
		else{
			controller.deletePerson(people.get(response)); //Call controller method to delete a person
		}
		
	}

	/*
	 * Adds a person to the database
	 */
	private void addPerson() {
		input.nextLine(); //clear input buffer
		
		//Ask information about the new person
		System.out.print("Please enter the first name of the person: ");
		String firstname = input.nextLine(); //get firstname
		System.out.print("Please enter the last name of the person: ");
		String lastName = input.nextLine(); //get lastname

		boolean male = true;
		String[] choices = {"Y","N"};
		String choice = this.displayStringChoiceAndGetResponse("Is this is person male?", choices); //Ask user if the person is male or not
		if (choice.equals("N")){ //if user says no, then person is not male
			male = false;
		}

		controller.addPerson(firstname,lastName,male); //add person to database

		
	}

	/*
	 * Deletes a relationship from a current person
	 * Also deletes the inverse relationship from secondary person
	 * So if Mr. howe has a wife Ms. Howe, it also deletes Ms. Howe as a husband Mr. Howe
	 */
	private void deleteRelationship() {
		ArrayList<Relationship> relationships = controller.getAllRelationshispForPerson(currentPerson); //gets all relationships
		ArrayList<String> options = new ArrayList<String>(); 

		for (int i = 0;i<relationships.size();i++){ //Create a string in the format of "currentPerson" has a "relationshipName", "secondaryPerson" and adds it to options
			Relationship relationship = relationships.get(i);
			RelationType type = relationship.getRelationType();
			PeopleClass secondaryPerson = relationship.getSecondaryPerson();
			
			String relationshipTypeName;
			if (secondaryPerson.getIsMale())
				relationshipTypeName = type.getFwdMaleName();
			else
				relationshipTypeName = type.getFwdFemaleName();
			
			String option = currentPerson.getLastName()+", "+currentPerson.getFirstName()+" has a "
					+relationshipTypeName+", "+relationship.getSecondaryPerson().getLastName()+", "
					+relationship.getSecondaryPerson().getFirstName();
			options.add(option);
		}
		
		int response = this.displayMenuAndGetResponse("Relationships",options,"Select relationship to delete:",true);
		if (response == -1){
			System.out.println("Relationship Deletion Cancelled");
			return;
		}
		else{
			//Call a delete method in current person and delete according to response
			
			controller.deleteRelationship(relationships.get(response));//call controller method to delete relationship

		}

		
		
		
	}

	
	/*Gets a list of all people, displays a menu to select one of them, displays another menu to select a relationship type, 
	 * and adds a new relationship to the currentPerson
	 */
	private void addRelationship() {
		ArrayList<PeopleClass> people = controller.getAllPeople();
		people.remove(currentPerson); //Make sure to remove the current person 
		ArrayList<String> options = new ArrayList<String>(); 
		String name;
		for (int i = 0;i<people.size();i++){ //Add to 'options' Strings that are in the form of 'firstname','lastname' like 'Howe, Harlan'
			
			name = people.get(i).getLastName()+", "+people.get(i).getFirstName();
			options.add(name);
			
		}
		
		int personResponse = this.displayMenuAndGetResponse("People", options, "Who should be related to "+currentPerson.getLastName()+", "+currentPerson.getFirstName()+"?", true);
		
		if (personResponse == -1){
			System.out.println("Relationship Creation Cancelled");
			return;
		}
		PeopleClass target = people.get(personResponse); //gets the PeopleClass that the user selected
		//At this point user has selected a target person, he now just needs to select a relationshipType
		options.clear(); //clears the options array so that it can now store options of relationship types
		ArrayList<RelationType> relationshipTypes = controller.getAllRelationshipTypes();
		for (int i = 0;i<relationshipTypes.size();i++){ //fills options with generic names of relationshipTypes
			options.add(relationshipTypes.get(i).getGenericName());
		}
		
		int relationTypeResponse = this.displayMenuAndGetResponse("Relationship Types", options, "Select a relationship type", true);
		if (relationTypeResponse == -1){
			System.out.println("Relationship Creation Cancelled");
			return;
		}
		RelationType type = relationshipTypes.get(relationTypeResponse); //Stores the relationshipType the user selected in a class
		
		controller.addNewRelationship(currentPerson, target, type); //calls controller method to add new relationship 
		System.out.println("Relationship added!");
		
		
		
	}

	/*
	 * Ends Program with good-bye message
	 */
	private void endProgram() {
		System.out.println("Thank you for using the program!");
		System.exit(0);
		
	}

	/*
	 * Sets up the options for the main  menu and displays the menu
	 */
	public int displayMenu(){
		ArrayList<String> options = new ArrayList<String>();		
		//Create Options
		options.add("Switch Current Person");
		options.add("Add Relationship");
		options.add("Delete Relationship");
		options.add("Add New Person");
		options.add("Delete Person");
		options.add("Add New Relationship Type");
		options.add("Delete Relationship Type");
		options.add("Save");
		options.add("End Program");
		
		return displayMenuAndGetResponse("Main Menu",options,"Pick one:",false);//create the menu and return the response
	}
	

	
	/*Mr. Howe's functions*/
	
	
	 public static final int CANCEL_OPTION = -1;

	    /**
	     * Displays a text-based menu and gets the user's response; returns the number
	     * of the option chosen by the user, or -1 if the user cancels. The user will
	     * be asked repeatedly, until a valid option is chosen.
	     * @param title - a string to display at the top of the menu
	     * @param options - a list of strings to display as choices
	     * @param prompt - the string to display below the menu, asking the user to choose.
	     * @param allowCancel - whether the user is given the option to cancel
	     * @return - the number of the menu option chosen, or CANCEL_OPTION if canceling
	     */
	    public int displayMenuAndGetResponse(String title, ArrayList<String> options, String prompt, boolean allowCancel)
	    {
	        if (title != null)
	            System.out.println("--------------------------------\n"+title);
	        System.out.println("--------------------------------");
	        for (int i=0; i<options.size(); i++)
	        {
	            System.out.println((i+1)+"\t"+options.get(i));
	        }
	        System.out.println("--------------------------------");
	        boolean goodAnswer = false;
	        int selection = 0;
	        do
	        {
	            if (prompt != null)
	                System.out.print(prompt);
	            if (allowCancel)
	                System.out.print(" (Type zero to cancel)");
	            System.out.print(" ");

	            try
	            {
	                selection = input.nextInt();
	                if (allowCancel && selection == 0)
	                    return CANCEL_OPTION;
	                if (selection<1 || selection>options.size())
	                    System.out.println("That number is out of range. Please try again.");
	                else
	                    goodAnswer=true;
	            }
	            catch (NumberFormatException nfe)
	            {
	                System.out.println("That was not a valid numeric choice. Please try again.");
	            }
	                    
	        }while (!goodAnswer);
	        return selection -1;
	    }
	    
	    /**
	     * Asks the user a question and gives a list of Strings that the user can pick from;
	     * repeats questions until one of the chosen options is selected (ignoring 
	     * upper/lower case). For example if prompt is "Play again?" and options are
	     * {"Y","N"}, the user will see:<p>Play again? (Y,N)<p> Examples of what this
	     * function might return from this call would be: "Y", "N", "y", "n". You would
	     * not receive "Yes", "Maybe", "", or "m".
	     * @param prompt - the message that the user sees, sans options
	     * @param options - an array of possible strings the user could enter
	     * @return a string that matches one of the options strings, ignoring case
	     */
	    public String displayStringChoiceAndGetResponse(String prompt, String[] options)
	    {
	        String optionList = "(";
	        for (int i =0; i<options.length; i++)
	        {
	            optionList+= options[i];
	            if (i<options.length-1)
	                optionList+=", ";
	        }
	        optionList+=")";
	        System.out.print(prompt+" "+optionList+" ");
	        
	        boolean goodAnswer=false;
	        do
	        {
	            String response = input.nextLine();
	            for (String s:options)
	                if (s.equalsIgnoreCase(response))
	                    return s;
	            System.out.println("That is not one of your options. Please choose from "
	                                +optionList+" ");
	        }while (!goodAnswer);
	        return null;
	        
	    }

	
	
	
	
}
