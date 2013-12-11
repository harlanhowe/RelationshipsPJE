package relationshipspje;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author phillip.johnson
 */
public class Controller 
{
    private File preferredPeopleFile;
    private File preferredRelTypeFile;
    private File preferredRelationFile;
    private File preferredFile;
    
    private ArrayList<PeopleClass> personList;
    private ArrayList<RelationType> relationTypeList;
    private ArrayList<Relationship> relationshipsList;
   // private TreeMap<Integer, PeopleClass> personList;
    //private TreeMap<Integer, RelationType> relationList;
    private int lastPersonId;
    private int lastRelTypeId;
    private int lastRelationshipId;
    
    
    public Controller()
    {
        //relationList = new TreeMap<Integer, RelationType>();
        personList = new ArrayList<PeopleClass>();
        relationTypeList = new ArrayList<RelationType>();
        relationshipsList = new ArrayList<Relationship>();
    }
    
    public void clearData(){
        personList.clear();
        relationTypeList.clear();
        relationshipsList.clear();
    }
    //Read our list of people from a save file, and store them in a map for easy access by the user interface.
    public void openPeople()
    {
//        JFileChooser chooser = new JFileChooser();
//        chooser.setSelectedFile(preferredPeopleFile);
//        int result = chooser.showOpenDialog(null);//this);
//        if (result == JFileChooser.APPROVE_OPTION)
//        {
//            preferredPeopleFile = chooser.getSelectedFile();
//        }
            
            // now try to open the file and read from it with a scanner.
        
        
        
            try 
            {
                Scanner input = new Scanner(new File("people.dat"));
                personList.clear();
                //Scanner input = new Scanner(preferredPeopleFile);
	
		// read from the file, store relations into arrayList;
		while (input.hasNext())
		{
                    //set up variables to store info
                    int id;
                    boolean isMale;
                    String firstName;
                    String lastName;
                    
                    //process each line by splitting string by tab and storing values into variables
                    String inputString = input.nextLine();

                    String[] part = inputString.split("\t");

                    id = Integer.parseInt(part[0]);
                    lastName = part[1];
                    firstName = part[2];
                    
                    //if the person is male, set ismale to true
                    if (part[3].equals("true"))
                        isMale = true;
                    else
                        isMale = false;
                    //create a new person class and add it to the list
                    PeopleClass theNewGuy = new PeopleClass(id, firstName, lastName, isMale);
                    personList.add(theNewGuy);

                    //if last line of input, set the last id to the last person and exi the loop
                    if (!input.hasNext())
                        {
                            lastPersonId = id;
                            break;
                        }
				    
                }
				
                //close input
                input.close();
	    }
            catch(Exception e)
            {
	           JOptionPane.showMessageDialog(null, "people.dat could not be loaded automatically.");

	    }
            
            

        
        
    }
    
    public void loadPeopleAs()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(preferredPeopleFile);
        int result = chooser.showOpenDialog(null);//this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            preferredPeopleFile = chooser.getSelectedFile();
        
            
            // now try to open the file and read from it with a scanner.
        
            
        
            try 
            {
                //Scanner input = new Scanner(new File("people.dat"));
                Scanner input = new Scanner(preferredPeopleFile);
                personList.clear();
	
		// read from the file, store relations into arrayList;
		while (input.hasNext())
		{
                    //set up variables to store info
                    int id;
                    boolean isMale;
                    String firstName;
                    String lastName;
                    
                    //process each line by splitting string by tab and storing values into variables
                    String inputString = input.nextLine();

                    String[] part = inputString.split("\t");

                    id = Integer.parseInt(part[0]);
                    lastName = part[1];
                    firstName = part[2];
                    
                    //if the person is male, set ismale to true
                    if (part[3].equals("true"))
                        isMale = true;
                    else
                        isMale = false;
                    //create a new person class and add it to the list
                    PeopleClass theNewGuy = new PeopleClass(id, firstName, lastName, isMale);
                    personList.add(theNewGuy);

                    //if last line of input, set the last id to the last person and exi the loop
                    if (!input.hasNext())
                        {
                            lastPersonId = id;
                            break;
                        }
				    
                }
				
                //close input
                input.close();
	    }
            catch(Exception e)
            {
	        throw new RuntimeException("File not found error.");
	    }
        }
    }
    
    
    public void openRelTypes()
    {
//        JFileChooser chooser = new JFileChooser();
//        chooser.setSelectedFile(preferredRelTypeFile);
//        int result = chooser.showOpenDialog(null);//this);
//        if (result == JFileChooser.APPROVE_OPTION)
//        {
//            preferredRelTypeFile = chooser.getSelectedFile();
//        }
        
        
            
            // now try to open the file and read from it with a scanner.
        
        
            try
            {
                Scanner input = new Scanner(new File("relTypes.dat"));
                relationTypeList.clear();
                //Scanner input = new Scanner(preferredRelTypeFile);
                // read from the file, store relations into arrayList;
                while (input.hasNext())
                {
                    //set up variables
                    int id;
                    String genericName;
                    String fwdMaleName;
                    String fwdFemaleName;
                    String revMaleName;
                    String revFemaleName;
                    
                    //process each string by splitting lines by tabs and storing info in variables
                    String inputString = input.nextLine();
                    
                    String[] part = inputString.split("\t");
                    id = Integer.parseInt(part[0]);
                    genericName = part[1];
                    fwdMaleName = part[2];
                    fwdFemaleName = part[3];
                    revMaleName = part[4];
                    revFemaleName = part[5];

                    //create a new RelationType class and add it to the main list
                    RelationType theNewRel = new RelationType(id, genericName, fwdMaleName, fwdFemaleName, revMaleName, revFemaleName);
                    relationTypeList.add(theNewRel);
                    
                    //if last line of input set the last id to the id of the last used relationtype and exit loop
                    if (!input.hasNext()){
                        lastRelTypeId = id;
                        break;
                    }
                    

                    

                    
                    
                }

                
                
                
                input.close();
            }
            catch (FileNotFoundException fnfe)
            {
                fnfe.printStackTrace();
                throw new RuntimeException("File "+preferredRelTypeFile+" cannot be laoded.");
            }
    }
    
    public void loadTypesAs()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(preferredRelTypeFile);
        int result = chooser.showOpenDialog(null);//this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            preferredRelTypeFile = chooser.getSelectedFile();
        
        
        
            
            // now try to open the file and read from it with a scanner.
        
        
            try
            {
                //Scanner input = new Scanner(new File("relTypes.dat"));
                Scanner input = new Scanner(preferredRelTypeFile);
                relationTypeList.clear();
                // read from the file, store relations into arrayList;
                while (input.hasNext())
                {
                    //set up variables
                    int id;
                    String genericName;
                    String fwdMaleName;
                    String fwdFemaleName;
                    String revMaleName;
                    String revFemaleName;
                    
                    //process each string by splitting lines by tabs and storing info in variables
                    String inputString = input.nextLine();
                    
                    String[] part = inputString.split("\t");
                    id = Integer.parseInt(part[0]);
                    genericName = part[1];
                    fwdMaleName = part[2];
                    fwdFemaleName = part[3];
                    revMaleName = part[4];
                    revFemaleName = part[5];

                    //create a new RelationType class and add it to the main list
                    RelationType theNewRel = new RelationType(id, genericName, fwdMaleName, fwdFemaleName, revMaleName, revFemaleName);
                    relationTypeList.add(theNewRel);
                    
                    //if last line of input set the last id to the id of the last used relationtype and exit loop
                    if (!input.hasNext()){
                        lastRelTypeId = id;
                        break;
                    }
                    

                    

                    
                    
                }

                
                
                
                input.close();
            }
            catch (FileNotFoundException fnfe)
            {
                JOptionPane.showMessageDialog(null, "relTypes.dat could not be loaded automatically.");
            }
        }
    }
    
    public void openRelationships()
    {
//        JFileChooser chooser = new JFileChooser();
//        chooser.setSelectedFile(preferredRelationFile);
//        int result = chooser.showOpenDialog(null);//this);
//        if (result == JFileChooser.APPROVE_OPTION)
//        {
//            preferredRelationFile = chooser.getSelectedFile();
//        }
        
            
            // now try to open the file and read from it with a scanner.
        
        
            try
            {
                Scanner input = new Scanner(new File("relationships.dat"));
                relationshipsList.clear();
                //Scanner input = new Scanner(preferredRelationFile);
                // read from the file, store relations into arrayList;
               
                // output.println("Here is example stuff to save....");
                // put your output code here!
                
                while (input.hasNext())
                {
                    //set up variables to store info in
                	int id;
                	int person1id;
                	int person2id;
                	int relTypeid;
                        
                        //process each string by splitting each line by tab and storing values in variables
                	String inputString = input.nextLine();
                        String[] part = inputString.split("\t");


                        id = Integer.parseInt(part[0]);
                        person1id = Integer.parseInt(part[1]);
                        person2id = Integer.parseInt(part[2]);
                        relTypeid = Integer.parseInt(part[3]);

                        PeopleClass person1 = this.getPersonById(person1id);
                        PeopleClass person2 = this.getPersonById(person2id);
                        RelationType relType = this.getRelationTypeById(relTypeid);

                        //creating new Relationship class and add it to the list
                        Relationship newRelationship = new Relationship(id,person1,person2,relType);
                        relationshipsList.add(newRelationship);

                        //if last line of input store the last id value and exit the loop
                        if (!input.hasNext())
                        {
                            lastRelationshipId = id;
                            break;
                        }
				    
                }
                
                
                input.close();
            }
            catch (FileNotFoundException fnfe)
            {
                JOptionPane.showMessageDialog(null, "relationships.dat could not be loaded automatically.");
            }
        
    }
    
    public void loadRelationsAs()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(preferredRelationFile);
        int result = chooser.showOpenDialog(null);//this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            preferredRelationFile = chooser.getSelectedFile();
        
            
            
            // now try to open the file and read from it with a scanner.
        
        
            try
            {
                //Scanner input = new Scanner(new File("relationships.dat"));
                Scanner input = new Scanner(preferredRelationFile);
                relationshipsList.clear();
                // read from the file, store relations into arrayList;
               
                // output.println("Here is example stuff to save....");
                // put your output code here!
                
                while (input.hasNext())
                {
                    //set up variables to store info in
                	int id;
                	int person1id;
                	int person2id;
                	int relTypeid;
                        
                        //process each string by splitting each line by tab and storing values in variables
                	String inputString = input.nextLine();
                        String[] part = inputString.split("\t");


                        id = Integer.parseInt(part[0]);
                        person1id = Integer.parseInt(part[1]);
                        person2id = Integer.parseInt(part[2]);
                        relTypeid = Integer.parseInt(part[3]);

                        PeopleClass person1 = this.getPersonById(person1id);
                        PeopleClass person2 = this.getPersonById(person2id);
                        RelationType relType = this.getRelationTypeById(relTypeid);

                        //creating new Relationship class and add it to the list
                        Relationship newRelationship = new Relationship(id,person1,person2,relType);
                        relationshipsList.add(newRelationship);

                        //if last line of input store the last id value and exit the loop
                        if (!input.hasNext())
                        {
                            lastRelationshipId = id;
                            break;
                        }
				    
                }
                
                
                input.close();
            }
        
            catch (FileNotFoundException fnfe)
            {
                throw new RuntimeException("File "+preferredRelationFile+" cannot be loaded.");
            }
        }
    }
    
    
    public PeopleClass getPersonById(int id){ //return a person whose id matches the id you're searching for
    	for (int i =0;i<personList.size();i++){
    		if (personList.get(i).getId() == id)
    			return personList.get(i);
    		
    	}
    	return null; //return null if nobody is found
    	
    }
    public RelationType getRelationTypeById(int id){
    	for (int i = 0;i<relationTypeList.size();i++){
    		if (relationTypeList.get(i).getId() == id)
    			return relationTypeList.get(i);
    	}
    	return null;
    }
    
    
    public void addPerson(String firstName, String lastName, Boolean isMale)
    {
        int id = lastPersonId++;
        
        
        PeopleClass theNewGuy = new PeopleClass(id, firstName, lastName, isMale);
                    
        personList.add(theNewGuy);
        
        lastPersonId = id;
    }
    
    public ArrayList<Relationship> getAllRelationships(){
        return this.relationshipsList;
    }
    public ArrayList<Relationship> getAllRelationshispForPerson(PeopleClass person)
    {
    	ArrayList<Relationship> relationships = new ArrayList<Relationship>();
    	
    	for (int i = 0;i<relationshipsList.size();i++){
    		if (relationshipsList.get(i).isRelationshipOf(person)){
    			relationships.add(relationshipsList.get(i));
    		}
    		
    		
    	}
    	return relationships;
    }
    
    public ArrayList<PeopleClass> getAllPeople(){
    	return this.personList;
    }
    
    


	public ArrayList<RelationType> getAllRelationshipTypes() {
		return relationTypeList;
	}


	
	/*
	 * adds a single relationship to the current person
	 */

	public void addNewRelationship(PeopleClass currentPerson, PeopleClass target, RelationType type) {
		int id = lastRelationshipId++;
		Relationship newRelationship = new Relationship(id,currentPerson,target,type); //Creates relationship
		relationshipsList.add(newRelationship);//Adds it to the list
		

		lastRelationshipId = id;
	}
        
        /*
	 * adds two relationships, one for the current person and one for the target person
	 */
        public void addNewRelationshipAndReciprocal (PeopleClass currentPerson, PeopleClass target, RelationType type){
            int id = lastRelationshipId++;
            Relationship newRelationship = new Relationship(id,currentPerson,target,type); //Creates relationship
            relationshipsList.add(newRelationship);//Adds it to the list

            //Now, adds a relationship to the target person that is an inverse of the realtionship you are adding
            //E.G. If you add Mrs. Howe as Mr. Howe's wife, it will add Mr. Howe as Mrs. Howe's husband
            // look for an inverse relationship for the one we're adding if it has one (if it's not the inverse of itself) and add a new relationship for the target
            RelationType inverseType = getInverseRelationType(type);//get the inverse relationtype
            if (type == null){ //if there is not one defined, display error message
                JOptionPane.showMessageDialog(null, "There is no inverse relationship defined. Please create one.");
                lastRelationshipId = id; //set the last id
                return; //bail
            }
            //otherwise, increment id and create a new relationship that is an inverse
            id++;
            Relationship newInverseRelationship = new Relationship(id,target,currentPerson,inverseType);
            relationshipsList.add(newInverseRelationship);
            lastRelationshipId = id;
            
        }
        
        public RelationType getRelationTypeByGenericName(String name){
            for (int i = 0;i<relationTypeList.size();i++){
                if (relationTypeList.get(i).getGenericName().equals(name))
                    return relationTypeList.get(i);
            }
            return null;
            
            
        }
        
        
        
	public void deleteRelationship(Relationship relationship) {
            
            RelationType inverseType = getInverseRelationType(relationship.getRelationType());
            PeopleClass primaryPerson = relationship.getPrimaryPerson();
            PeopleClass secondaryPerson = relationship.getSecondaryPerson();
            Relationship inverse = null;

            for (int i = 0;i<relationshipsList.size();i++){
                Relationship rel = relationshipsList.get(i);
                if (rel.getPrimaryPerson().getId() == secondaryPerson.getId() && rel.getSecondaryPerson().getId()==primaryPerson.getId() && rel.getRelationType().getId()==inverseType.getId()){
                    inverse = rel;
                    break;
                }
            }
            relationshipsList.remove(relationship);
            if (inverse!=null)
                relationshipsList.remove(inverse);
		
	
	}
        
        public RelationType getInverseRelationType(RelationType relationToCompare)
        {
            for (RelationType relation:relationTypeList)
            {
                if (relation.getRevMaleName().equals(relationToCompare.getFwdMaleName()))
                    return relation;
            }
            return null;
        }
	
	//add realtionship without inverse
	public void addRelType(String neutral, String male, String female, String maleInv, String femaleInv)
        {
            int id = lastRelTypeId++;

            RelationType theNewRel = new RelationType(id, neutral, male, female, maleInv, femaleInv);

            relationTypeList.add(theNewRel);

            lastRelTypeId = id;
        }



	public void deleteRelationshipType(RelationType relationType) {
		// TODO Auto-generated method stub
		relationTypeList.remove(relationType);
		ArrayList<Relationship> relationshipsListClone = (ArrayList<Relationship>) relationshipsList.clone();
		for (int i =0 ;i<relationshipsListClone.size();i++){
			if (relationshipsListClone.get(i).getRelationType() == relationType){
				relationshipsList.remove(relationshipsListClone.get(i));
			}
		}
	}
        
        public void savePeopleData()
        {
//            JFileChooser chooser = new JFileChooser();
//            chooser.setSelectedFile(preferredPeopleFile);
//            int result = chooser.showSaveDialog(chooser);
//            if (result == JFileChooser.APPROVE_OPTION) // if the user clicked "save"
//            {
                //preferredPeopleFile = chooser.getSelectedFile();
                
                preferredPeopleFile = new File("people.dat");
                try
                {
                    PrintWriter output = new PrintWriter(preferredPeopleFile);
                    // you can now write to the file by saying
                    
                    for (int i = 0; i < personList.size(); i ++)
                        output.println(personList.get(i).getId()+"\t"+personList.get(i).getFirstName()+"\t"+personList.get(i).getLastName()+"\t"+personList.get(i).getIsMale());
                
                    output.close();
                }
                catch (FileNotFoundException fnfe)
                {
                    throw new RuntimeException("File "+preferredPeopleFile+" cannot be saved.");
                }
            //}
        }
        
        public void savePeopleAs()
        {
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(preferredPeopleFile);
            int result = chooser.showSaveDialog(chooser);
            if (result == JFileChooser.APPROVE_OPTION) // if the user clicked "save"
            {
                preferredPeopleFile = chooser.getSelectedFile();
                
                //preferredPeopleFile = new File("people.dat");
                try
                {
                    PrintWriter output = new PrintWriter(preferredPeopleFile);
                    // you can now write to the file by saying
                    
                    for (int i = 0; i < personList.size(); i ++)
                        output.println(personList.get(i).getId()+"\t"+personList.get(i).getFirstName()+"\t"+personList.get(i).getLastName()+"\t"+personList.get(i).getIsMale());
                
                    output.close();
                }
                catch (FileNotFoundException fnfe)
                {
                    throw new RuntimeException("File "+preferredPeopleFile+" cannot be saved.");
                }
            }
        }
        
        public void saveRelationships()
        {
//            JFileChooser chooser = new JFileChooser();
//            chooser.setSelectedFile(preferredRelationFile);
//            int result = chooser.showSaveDialog(chooser);
//            if (result == JFileChooser.APPROVE_OPTION) // if the user clicked "save"
            //{
                //preferredRelationFile = chooser.getSelectedFile();
                preferredRelationFile = new File("relationships.dat");
                try
                {
                    PrintWriter output = new PrintWriter(preferredRelationFile);
                    // you can now write to the file by saying
                    
                    for (int i = 0; i < relationshipsList.size(); i ++)
                        output.println(relationshipsList.get(i).getId()+"\t"+relationshipsList.get(i).getPrimaryPerson().getId()+"\t"+relationshipsList.get(i).getSecondaryPerson().getId()+"\t"+relationshipsList.get(i).getRelationType().getId());
                
                    output.close();
                }
                catch (FileNotFoundException fnfe)
                {
                    throw new RuntimeException("File "+preferredRelationFile+" cannot be saved.");
                }
            //}
        }
        
        public void saveRelationsAs()
        {
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(preferredRelationFile);
            int result = chooser.showSaveDialog(chooser);
            if (result == JFileChooser.APPROVE_OPTION) // if the user clicked "save"
            {
                preferredRelationFile = chooser.getSelectedFile();
                //preferredRelationFile = new File("relationships.dat");
                try
                {
                    PrintWriter output = new PrintWriter(preferredRelationFile);
                    // you can now write to the file by saying
                    
                    for (int i = 0; i < relationshipsList.size(); i ++)
                        output.println(relationshipsList.get(i).getId()+"\t"+relationshipsList.get(i).getPrimaryPerson().getId()+"\t"+relationshipsList.get(i).getSecondaryPerson().getId()+"\t"+relationshipsList.get(i).getRelationType().getId());
                
                    output.close();
                }
                catch (FileNotFoundException fnfe)
                {
                    throw new RuntimeException("File "+preferredRelationFile+" cannot be saved.");
                }
            }
        }
        
        public void saveRelTypes()
        {
//            JFileChooser chooser = new JFileChooser();
//            chooser.setSelectedFile(preferredRelTypeFile);
//            int result = chooser.showSaveDialog(chooser);
//            if (result == JFileChooser.APPROVE_OPTION) // if the user clicked "save"
//            {
                preferredRelTypeFile = new File("relTypes.dat");
                try
                {
                    PrintWriter output = new PrintWriter(preferredRelTypeFile);
                    // you can now write to the file by saying
                    
                    for (int i = 0; i < relationTypeList.size(); i ++)
                        output.println(relationTypeList.get(i).getId()+"\t"+relationTypeList.get(i).getGenericName()+"\t"+relationTypeList.get(i).getFwdMaleName()+"\t"+relationTypeList.get(i).getFwdFemaleName()+"\t"+relationTypeList.get(i).getRevMaleName()+"\t"+relationTypeList.get(i).getRevFemaleName());
                
                    output.close();
                }
                catch (FileNotFoundException fnfe)
                {
                    throw new RuntimeException("File "+preferredRelTypeFile+" cannot be saved.");
                }
            //}
        }
        
        public void saveTypesAs()
        {
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(preferredRelTypeFile);
            int result = chooser.showSaveDialog(chooser);
            if (result == JFileChooser.APPROVE_OPTION) // if the user clicked "save"
            {
                //preferredRelTypeFile = new File("relTypes.dat");
                preferredRelTypeFile = chooser.getSelectedFile();
                try
                {
                    PrintWriter output = new PrintWriter(preferredRelTypeFile);
                    // you can now write to the file by saying
                    
                    for (int i = 0; i < relationTypeList.size(); i ++)
                        output.println(relationTypeList.get(i).getId()+"\t"+relationTypeList.get(i).getGenericName()+"\t"+relationTypeList.get(i).getFwdMaleName()+"\t"+relationTypeList.get(i).getFwdFemaleName()+"\t"+relationTypeList.get(i).getRevMaleName()+"\t"+relationTypeList.get(i).getRevFemaleName());
                
                    output.close();
                }
                catch (FileNotFoundException fnfe)
                {
                    throw new RuntimeException("File "+preferredRelTypeFile+" cannot be saved.");
                }
            }
        }
        
        public void saveAll()
        {
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(preferredFile);
            int result = chooser.showSaveDialog(chooser);
            if (result == JFileChooser.APPROVE_OPTION) // if the user clicked "save"
            {
                preferredFile = chooser.getSelectedFile();
                try
                {
                    PrintWriter output = new PrintWriter(preferredFile);
                    // you can now write to the file by saying
                    
                    //output.println("People");
                    //save the people
                    for (int i = 0; i < personList.size(); i ++)
                        output.println(personList.get(i).getId()+"\t"+personList.get(i).getFirstName()+"\t"+personList.get(i).getLastName()+"\t"+personList.get(i).getIsMale());
                    
                    output.println("Types");
                    //save the rel types
                    for (int i = 0; i < relationTypeList.size(); i ++)
                        output.println(relationTypeList.get(i).getId()+"\t"+relationTypeList.get(i).getGenericName()+"\t"+relationTypeList.get(i).getFwdMaleName()+"\t"+relationTypeList.get(i).getFwdFemaleName()+"\t"+relationTypeList.get(i).getRevMaleName()+"\t"+relationTypeList.get(i).getRevFemaleName());
                
                    output.println("Relations");
                    //save the relationships
                    for (int i = 0; i < relationshipsList.size(); i ++)
                        output.println(relationshipsList.get(i).getId()+"\t"+relationshipsList.get(i).getPrimaryPerson().getId()+"\t"+relationshipsList.get(i).getSecondaryPerson().getId()+"\t"+relationshipsList.get(i).getRelationType().getId());
                    
                    output.close();
                }
                catch (FileNotFoundException fnfe)
                {
                    throw new RuntimeException("File "+preferredRelTypeFile+" cannot be saved.");
                }
            }
        }
        
        public void loadAll()
        {
            
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(preferredFile);
            int result = chooser.showOpenDialog(null);//this);
            if (result == JFileChooser.APPROVE_OPTION)
            {
                preferredFile = chooser.getSelectedFile();
            }
            
            Scanner input;
            try 
            {
                input = new Scanner(preferredFile);
                int phase = 1;
	
				// read from the file, store relations into arrayList;
		while (input.hasNext())
		{
                    String eater;
                    
                    int personId;
                    boolean personIsMale;
                    String personFirstName;
                    String personLastName;
                    
                    int typeId;
                    String genericName;
                    String fwdMaleName;
                    String fwdFemaleName;
                    String revMaleName;
                    String revFemaleName;
                    
                    int relationId;
                    int person1id;
                    int person2id;
                    int relTypeid;

                    String inputString = input.nextLine();
                        
                    if (inputString.equals("Types"))
                    {
                        phase = 2;
                        continue;
                    }
                    else if (inputString.equals("Relations"))
                    {
                        phase = 3;
                        continue;
                    }
                    
                    
                    String[] part = inputString.split("\t");
                    
                    if (phase == 1)
                    {
                        
                        personId = Integer.parseInt(part[0]);
                        personFirstName = part[1];
                        personLastName = part[2];
                        personIsMale = Boolean.parseBoolean(part[3]);
                    
                        PeopleClass theNewGuy = new PeopleClass(personId, personFirstName, personLastName, personIsMale);

                        personList.add(theNewGuy);

                        lastPersonId = personId;
                        
                    }
                    else if(phase == 2)
                    {
                        typeId = Integer.parseInt(part[0]);
                        genericName = part[1];
			fwdMaleName = part[2];
			fwdFemaleName = part[3];
			revMaleName = part[4];
			revFemaleName = part[5];
				    
			RelationType theNewRel = new RelationType(typeId, genericName, fwdMaleName, fwdFemaleName, revMaleName, revFemaleName);
                        relationTypeList.add(theNewRel);
                        
                        lastRelTypeId = typeId;
                    }
                    else if(phase == 3)
                    {


                        relationId = Integer.parseInt(part[0]);
                        person1id = Integer.parseInt(part[1]);
                        person2id = Integer.parseInt(part[2]);
                        relTypeid = Integer.parseInt(part[3]);

                        PeopleClass person1 = this.getPersonById(person1id);
                        PeopleClass person2 = this.getPersonById(person2id);
                        RelationType relType = this.getRelationTypeById(relTypeid);

                        Relationship newRelationship = new Relationship(relationId,person1,person2,relType);
                        relationshipsList.add(newRelationship);
                        
                        lastRelationshipId = relationId;
                    }
                   
				    
                }
				
				
                input.close();
	    }
            catch(Exception e)
            {
	        	
	    }
        }
        
        public void deletePerson(PeopleClass personToDel)
        {
            ArrayList<Relationship> removeList = relationshipsList;
            ArrayList<Relationship> toBeRemovedList= new ArrayList<Relationship>();
            for (Relationship rel:removeList)
                if (rel.isRelationshipOf(personToDel)||rel.isRelationshipTo(personToDel))
                    toBeRemovedList.add(rel);
            for(int i=0; i<toBeRemovedList.size(); i++)
            {
                relationshipsList.remove(toBeRemovedList.get(i));
            }
            personList.remove(personToDel);
        }
}
