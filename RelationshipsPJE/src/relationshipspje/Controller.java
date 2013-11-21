/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
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
    private TreeMap<Integer, PeopleClass> personList;
    private TreeMap<Integer, RelationType> relationList;
    private int lastPersonId;
    private int lastRelTypeId;
    private int lastRelationId;
    
    
    public Controller()
    {
        relationList = new TreeMap<Integer, RelationType>();
    }
    
    
    //Read our list of people from a save file, and store them in a map for easy access by the user interface.
    public void openPeople()
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
                Scanner input = new Scanner(preferredPeopleFile);
                // read from the file, store relations into arrayList;
                while (input.hasNext())
                {
                    int id;
                    boolean gender;
                    String firstName;
                    String lastName;
                    
                    String inputString = input.nextLine();
                    
                    String[] part = inputString.split("\t");
                    
                    
                    
                    id = Integer.parseInt(part[0]);
                    gender = Boolean.parseBoolean(part[3]);
                    firstName = part[2];
                    lastName = part[1];
                    
                    
                    //Make a new person, and put it into my list of people, with the id as the dictionary key.
                    PeopleClass theNewGuy = new PeopleClass(id, firstName, lastName, gender);
                    
                    personList.put(id,theNewGuy);
                    
                    lastPersonId = id;
                    
                    
                }
               
                // output.println("Here is example stuff to save....");
                // put your output code here!
                
                
                
                input.close();
            }
            catch (FileNotFoundException fnfe)
            {
                throw new RuntimeException("File "+preferredPeopleFile+" cannot be loaded.");
            }
        }
    }
    
    public void openRelTypes()
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
                Scanner input = new Scanner(preferredRelTypeFile);
                // read from the file, store relations into arrayList;
                while (input.hasNext())
                {
                    String inputString = input.nextLine();
                    
                    String[] part = inputString.split("\t");
                    
                    int id;
                    String neutral;
                    String male;
                    String female;
                    String maleInv;
                    String femaleInv;
                    
                    
                    id = Integer.parseInt(part[0]);
                    neutral = part[1];
                    male = part[2];
                    female = part[3];
                    maleInv = part[4];
                    femaleInv = part[5];
                    
                    
                    
                    System.out.println(femaleInv);
                    System.out.println(maleInv);
                    System.out.println(male);
                    System.out.println(female);
                    System.out.println(neutral);
                    System.out.println(id);
                    
                    
                    
                    //Make a new person, and put it into my list of people, with the id as the dictionary key.
                    RelationType theNewRel = new RelationType(id, neutral, male, female, maleInv, femaleInv);
                    
                    relationList.put(id,theNewRel);
                    
                    lastRelTypeId = id;
                    
                    
                }
                // output.println("Here is example stuff to save....");
                // put your output code here!
                
                
                
                input.close();
            }
            catch (FileNotFoundException fnfe)
            {
                throw new RuntimeException("File "+preferredRelTypeFile+" cannot be laoded.");
            }
        }
    }
    
    public void openRelations()
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
                Scanner input = new Scanner(preferredRelationFile);
                // read from the file, store relations into arrayList;
                while (input.hasNext())
                {
                
                    String inputString = input.nextLine();
                    
                    String[] part = inputString.split("\t");
                    
                    int id;
                    int relatorId;
                    int relateeId;
                    int relationTypeId;
                    
                    id = Integer.parseInt(part[0]);
                    relatorId = Integer.parseInt(part[1]);
                    relateeId = Integer.parseInt(part[2]);
                    relationTypeId = Integer.parseInt(part[3]);
                    
                    
                    
                    
                    lastRelationId = id;
                }
               
                // output.println("Here is example stuff to save....");
                // put your output code here!
                
                
                
                input.close();
            }
            catch (FileNotFoundException fnfe)
            {
                throw new RuntimeException("File "+preferredRelationFile+" cannot be loaded.");
            }
        }
    }
    
    public void addPerson(String firstName, String lastName, Boolean isMale)
    {
        int id = lastPersonId++;
        
        
        PeopleClass theNewGuy = new PeopleClass(id, firstName, lastName, isMale);
                    
        personList.put(id,theNewGuy);
        
        lastPersonId = id;
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
    
    public void addRelType(String neutral, String male, String female, String maleInv, String femaleInv)
    {
        int id = lastRelTypeId++;
        
        RelationType theNewRel = new RelationType(id, neutral, male, female, maleInv, femaleInv);
                    
        relationList.put(id,theNewRel);
        
        lastRelTypeId = id;
    }
}
