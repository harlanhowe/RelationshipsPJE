package relationshipspje;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JFileChooser;

/**
 *
 * @author phillip.johnson
 */
public class Controller 
{
    private File preferredPeopleFile;
    private File preferredRelTypeFile;
    private File preferredRelationFile;
    
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
        
        
            Scanner input;
            try 
            {
                input = new Scanner(new File("people.dat"));
	
				// read from the file, store relations into arrayList;
		while (input.hasNext())
		{
                    int id;
                    boolean isMale;
                    String firstName;
                    String lastName;

                    String inputString = input.nextLine();

                    String[] part = inputString.split("\t");

                    id = Integer.parseInt(part[0]);
                    firstName = part[1];
                    lastName = part[2];
                    if (part[3].equals("true"))
                    isMale = true;
                    else
                        isMale = false;
                    PeopleClass theNewGuy = new PeopleClass(id, firstName, lastName, isMale);

                    personList.add(theNewGuy);

                    if (!input.hasNext())
                        {
                            lastPersonId = id;
                            break;
                        }
				    
                }
				
				
                input.close();
	    }
            catch(Exception e)
            {
	        	
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
                // read from the file, store relations into arrayList;
                while (input.hasNext())
                {
                    int id;
                    String genericName;
                    String fwdMaleName;
                    String fwdFemaleName;
                    String revMaleName;
                    String revFemaleName;
                    
                    String inputString = input.nextLine();
                    
				    String[] part = inputString.split("\t");
				    id = Integer.parseInt(part[0]);
				    genericName = part[1];
				    fwdMaleName = part[2];
				    fwdFemaleName = part[3];
				    revMaleName = part[4];
				    revFemaleName = part[5];
				    
				    RelationType theNewRel = new RelationType(id, genericName, fwdMaleName, fwdFemaleName, revMaleName, revFemaleName);
                    relationTypeList.add(theNewRel);
                    
                    if (!input.hasNext()){
				    	lastRelTypeId = id;
				    	break;
				    }
                    

                    

                    
                    
                }

                
                
                
                input.close();
            }
            catch (FileNotFoundException fnfe)
            {
                throw new RuntimeException("File "+preferredRelTypeFile+" cannot be laoded.");
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
                // read from the file, store relations into arrayList;
               
                // output.println("Here is example stuff to save....");
                // put your output code here!
                
                while (input.hasNext())
                {
                	int id;
                	int person1id;
                	int person2id;
                	int relTypeid;
                	String inputString = input.nextLine();
				    String[] part = inputString.split("\t");
                	
				    
				    id = Integer.parseInt(part[0]);
				    person1id = Integer.parseInt(part[1]);
				    person2id = Integer.parseInt(part[2]);
				    relTypeid = Integer.parseInt(part[3]);
				    
				    PeopleClass person1 = this.getPersonById(person1id);
				    PeopleClass person2 = this.getPersonById(person2id);
				    RelationType relType = this.getRelationTypeById(relTypeid);
				    
				    Relationship newRelationship = new Relationship(id,person1,person2,relType);
				    relationshipsList.add(newRelationship);
				    
				    if (!input.hasNext()){
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
                    
        personList.add(id,theNewGuy);
        
        lastPersonId = id;
    }
    
    public ArrayList<Relationship> getAllRelationshispForPerson(PeopleClass person){
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
    
    
    public void removePerson(String name)
    {
        for (int i = 0; i < personList.size(); i ++)
        {
            if (personList.get(i).getFirstName().equals(name) || personList.get(i).getLastName().equals(name))
            {
                //
                //
                //IMPORTANT!!! Talk about having the TreeMap in PeopleClass be in the format <RelateeId, RelationTypeId>.
                //
                //
                
                personList.remove(i);
            }
        }
    }
    
    public void addRelation(String relatorName, String relateeName, String relationType)
    {
        int relationId = lastRelTypeId++;
    }
    
    
    


	public ArrayList<RelationType> getAllRelationshipTypes() {
		// TODO Auto-generated method stub
		return relationTypeList;
	}


	public void deleteRelationship(Relationship relationship) {
		// TODO Auto-generated method stub
		relationshipsList.remove(relationship);
		
	}


	public void addNewRelationship(PeopleClass currentPerson, PeopleClass target, RelationType type) {
		int id = lastRelationshipId++;
		Relationship newRelationship = new Relationship(id,currentPerson,target,type);
		id++;
		Relationship newInverseRelationship = new Relationship(id,target,currentPerson,type);
		relationshipsList.add(newRelationship);
		relationshipsList.add(newInverseRelationship);
		lastRelationshipId = id;
	}

	//add realtionship without inverse
	public void addRelType(String neutral, String male, String female, String maleInv, String femaleInv)
    {
        int id = lastRelTypeId++;
        
        RelationType theNewRel = new RelationType(id, neutral, male, female, maleInv, femaleInv);
                    
        relationTypeList.add(theNewRel);
        
        lastRelTypeId = id;
    }
	
	//Add relationship type with inverse
	public void addRelType(String genericName, String fwdMaleName,String fwdFemaleName, String revMaleName, String revFemaleName,String inverseGenericName) {
		// TODO Auto-generated method stub
		int id = lastRelTypeId++;
        
        RelationType theNewRel = new RelationType(id, genericName, fwdMaleName, fwdFemaleName, revMaleName, revFemaleName);
        id++;
        RelationType newRelInverse = new RelationType(id,inverseGenericName,revMaleName,revFemaleName,fwdMaleName,fwdFemaleName);
        relationTypeList.add(theNewRel);
        relationTypeList.add(newRelInverse);
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
        
        public void saveData()
        {
            
        }
        
        public void deletePerson(PeopleClass personToDel)
        {
            
            for (int i = 0; i <relationshipsList.size(); i++)
                if (relationshipsList.get(i).isRelationshipOf(personToDel)||relationshipsList.get(i).getSecondaryPerson().equals(personToDel))
                    relationshipsList.remove(i);
            personList.remove(personToDel);
        }
}
