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
	
	private void displayInformation(PeopleClass person) {//Output information about selected Person
		System.out.println("You are viewing the relationships of: "+person.getLastName()+", "+person.getFirstName());
		//TODO output information here
		TreeMap<PeopleClass,RelationType> relationships = currentPerson.getAllRelationships();
		ArrayList<PeopleClass> people = (ArrayList<PeopleClass>) relationships.keySet();
		for (int i = 0;i<relationships.size();i++){
			/*Output the person's information here*/
			System.out.print(currentPerson.getLastName()+","+currentPerson.getFirstName()+" has a ");
			
			
		}
		
		
		
		
	}

	private void selectPerson() { //Prompts the user to select a person from all the people in the database, and sets currentPerson accordingly
		// TODO UNCOMMENT WHEN CODE UPDATED
		//ArrayList<PeopleClass> people = controller.getAllPeople(); //get people in alphabetical order
		
		ArrayList<PeopleClass> people = new ArrayList<PeopleClass>();
		people.add(new PeopleClass(0,"John","Smith",true));
		people.add(new PeopleClass(1,"Jane","Doe",false));
		
		ArrayList<String> options = new ArrayList<String>(); 
		String name;
		for (int i = 0;i<people.size();i++){ //Add to 'options' Strings that are in the form of 'firstname','lastname' like 'Howe, Harlan'
			name = people.get(i).getLastName()+", "+people.get(i).getFirstName();
			options.add(name);
			
		}
		int person = displayMenuAndGetResponse("People", options, "Please Select a Person to View", false); //display menu and get user to select a person
		currentPerson = people.get(person); //set current person
		
		
	}
	
	
	

	private void processResponse(int userInput) {//Processes the user response and chooses appropriate way to deal with it 
		switch (userInput)
		{
		case 0: //switch person to view
			currentPerson = null;
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

	private void saveState() {
		// TODO Auto-generated method stub
		controller.saveData();
		
	}

	private void deleteRelationshipType() {
		// TODO Auto-generated method stub
		ArrayList<RelationType> relationshipTypes = controller.getAllRelationshipTypes();
		ArrayList<String> options = new ArrayList<String>();
		for (int i = 0;i<relationshipTypes.size();i++){
			options.add(relationshipTypes.get(i).getGenericName());

		}
		int response = this.displayMenuAndGetResponse("Relationshp Types",options,"Select a relationship type to delete",true);
		if (response == -1){
			System.out.println("Relationship Type Deletion Cancelled");
			return;
		}else{
			controller.deleteRelationshipType(relationshipTypes.get(response));

		}
		
	}

	private void addRelationshipType() {
		// TODO Auto-generated method stub

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
		
		boolean needsInverse = true;
		if (fwdMaleName.equals(revMaleName) && fwdFemaleName.equals(revFemaleName)){
			needsInverse = false;
		}
		else{
			System.out.println("Please enter the generic name of the inverse relationship type");
			String inverseGenericName  = input.nextLine();

			controller.addRelationshipType(genericName,fwdMaleName,fwdFemaleName,revMaleName,revFemaleName,inverseGenericName);
		}

		


		
	}

	private void deletePerson() {
		// TODO Auto-generated method stub
		ArrayList<PeopleClass> people = controller.getAllPeople();
		ArrayList<String> options = new ArrayList<String>();
		for (int i = 0;i<people.size();i++){ //Add to 'options' Strings that are in the form of 'firstname','lastname' like 'Howe, Harlan'
			
			name = people.get(i).getLastName()+", "+people.get(i).getFirstName();
			options.add(name);
			
		}
		int response = this.displayMenuAndGetResponse("People",options,"Select a person to delete from database",true);
		if (response == -1){
			System.out.println("Person Deletion Cancelled");
			return;
		}
		else{
			controller.deletePerson(people.get(response));
		}
		
	}

	private void addPerson() {
		// TODO Auto-generated method stub

		System.out.println("Please enter the first name of the person");
		String firstname = input.nextLine(); //get firstname
		System.out.println("Please enter the last name of the person");
		String lastName = input.nextLine(); //get lastname

		boolean male = true;
		String[] choices = {"Y","N"};
		String choice = this.displayStringChoiceAndGetResponse("Is this is person male?", choices);
		if (choice.equals("N")){ //if user says no, then person is not male
			male = false;
		}

		controller.addPerson(firstname,lastName,male); //add person to database

		
	}

	private void deleteRelationship() {
		// TODO Auto-generated method stub
		TreeMap<PeopleClass,RelationType> relationships = currentPerson.getAllRelationships();
		ArrayList<String> options = new ArrayList<String>();

		for (int i = 0;i<relationships.size();i++){
			/*Output the person's information here*/
			options.add(currentPerson.getLastName()+","+currentPerson.getFirstName()+" has a "

				);
		}
		int response = this.displayMenuAndGetResponse("Relationships",options,"Select relationship to delete:",true);
		if (response == -1){
			System.out.println("Relationship Deletion Cancelled");
			return;
		}
		else{
			//Call a delete method in current person and delete according to response
			currentPerson.deleteRelationship()

		}

		
		
		
	}

	
	/*Gets a list of all people, displays a menu to select one of them, displays another menu to select a relationship type, 
	 * and adds a new relationship to the currentPerson
	 */
	
	private void addRelationship() {
		TreeMap<Integer,PeopleClass> people = controller.getPersonList();
		people.remove(currentPerson.getId()); //Make sure to remove the current person 
		ArrayList<String> options = new ArrayList<String>(); 
		String name;
		for (int i = 0;i<people.size();i++){ //Add to 'options' Strings that are in the form of 'firstname','lastname' like 'Howe, Harlan'
			
			name = people.get(i).getLastName()+", "+people.get(i).getFirstName();
			options.add(name);
			
		}
		for (Map.Entry<Integer, PeopleClass> entry : people.entrySet())
		{
			
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		
		
		int personResponse = this.displayMenuAndGetResponse("People", options, "Who should be related to "+currentPerson.getLastName()+", "+currentPerson.getFirstName()+"?", true);
		
		if (personResponse == -1){
			System.out.println("Relationship Creation Cancelled");
			return;
		}
		PeopleClass target = people.get(personResponse);
		
		options.clear();
		ArrayList<RelationType> relationshipTypes = controller.getAllRelationshipTypes();
		for (int i = 0;i<relationshipTypes.size();i++){
			//options.add(relationshipTypes.get(i).)
			//TODO fill an options arraylist of relationship names
		}
		
		int relationTypeResponse = this.displayMenuAndGetResponse("Relationship Types", options, "Select a relationship type", true);
		if (relationTypeResponse == -1){
			System.out.println("Relationship Creation Cancelled");
			return;
		}
		RelationType type = relationshipTypes.get(relationTypeResponse);
		
		currentPerson.addNewRelation(target,type);
		System.out.println("Relationship added!");
		
		
		
	}

	private void endProgram() {//End the program with a good-bye message
		System.out.println("Thank you for using the program!");
		System.exit(0);
		
	}

	public int displayMenu(){ //Sets up options and displays the main menu
		ArrayList<String> options = new ArrayList<String>();
		//Process Options
		
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
