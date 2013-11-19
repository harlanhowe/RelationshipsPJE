/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relationshipspje;

import java.io.File;
import java.io.FileNotFoundException;
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
    private TreeMap<Integer, PeopleClass> personList;
    private TreeMap<Integer, RelationType> relationList;
    
    public Controller()
    {
        
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
                    int genderNum;
                    String firstName;
                    String lastName;
                    
                    
                    //See if I can find the integer that designates the id. Fails if not.
                    try
                    {
                        id = input.nextInt();
                    }
                    catch (InputMismatchException noInt)
                    {
                        System.out.println(noInt);
                        System.out.println("I tried to read a non-existent int");
                        break;
                    }
                    
                    //See if I can find the next string to put as the first name. Fails if not.
                    try
                    {
                        lastName = input.next();
                    }
                    catch (NoSuchElementException noStrings)
                    {
                        System.out.println(noStrings);
                        System.out.println("I don't know how I am here, 'cause while loop, but you don't have anything else in this file. Stop reading it.");
                        break;
                    }
                    
                    //See if I can find the next string to put as the last name. Fails if not.
                    try
                    {
                        firstName = input.next();
                    }
                    catch (NoSuchElementException noStrings)
                    {
                        System.out.println(noStrings);
                        System.out.println("I don't know how I am here, 'cause while loop, but you don't have anything else in this file. Stop reading it.");
                        break;
                    }
                    
                    //See if I can find a 1 or a 0 for the gender. Fails if not.
                    try
                    {
                        genderNum = input.nextInt();
                    }
                    catch (InputMismatchException noInt)
                    {
                        System.out.println(noInt);
                        System.out.println("I tried to read a non-existent int");
                        break;
                    }
                    
                    boolean newBool = false;
                    
                    if (genderNum == 1)
                        newBool = true;
                    
                    
                    //Make a new person, and put it into my list of people, with the id as the dictionary key.
                    PeopleClass theNewGuy = new PeopleClass(id, firstName, lastName, newBool);
                    
                    personList.put(id,theNewGuy);
                    
                    
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
                    int id;
                    String neutral;
                    String male;
                    String female;
                    String maleInv;
                    String femaleInv;
                    
                    
                    //See if I can find the integer that designates the id. Fails if not.
                    try
                    {
                        id = input.nextInt();
                    }
                    catch (InputMismatchException noInt)
                    {
                        System.out.println(noInt);
                        System.out.println("I tried to read a non-existent int");
                        break;
                    }
                    
                    //See if I can find the next string to put as the first name. Fails if not.
                    try
                    {
                        neutral = input.next();
                    }
                    catch (NoSuchElementException noStrings)
                    {
                        System.out.println(noStrings);
                        System.out.println("I don't know how I am here, 'cause while loop, but you don't have anything else in this file. Stop reading it.");
                        break;
                    }
                    
                    //See if I can find the next string to put as the last name. Fails if not.
                    try
                    {
                        male = input.next();
                    }
                    catch (NoSuchElementException noStrings)
                    {
                        System.out.println(noStrings);
                        System.out.println("I don't know how I am here, 'cause while loop, but you don't have anything else in this file. Stop reading it.");
                        break;
                    }
                    
                    //See if I can find a 1 or a 0 for the gender. Fails if not.
                    try
                    {
                        female = input.next();
                    }
                    catch (NoSuchElementException noStrings)
                    {
                        System.out.println(noStrings);
                        System.out.println("I don't know how I am here, 'cause while loop, but you don't have anything else in this file. Stop reading it.");
                        break;
                    }
                    
                    
                    try
                    {
                        maleInv = input.next();
                    }
                    catch (NoSuchElementException noStrings)
                    {
                        System.out.println(noStrings);
                        System.out.println("I don't know how I am here, 'cause while loop, but you don't have anything else in this file. Stop reading it.");
                        break;
                    }
                    
                    
                    try
                    {
                        femaleInv = input.next();
                    }
                    catch (NoSuchElementException noStrings)
                    {
                        System.out.println(noStrings);
                        System.out.println("I don't know how I am here, 'cause while loop, but you don't have anything else in this file. Stop reading it.");
                        break;
                    }
                    
                    
                    
                    //Make a new person, and put it into my list of people, with the id as the dictionary key.
                    RelationType theNewRel = new RelationType(id, neutral, male, female, maleInv, femaleInv);
                    
                    relationList.put(id,theNewRel);
                    
                    
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
}
