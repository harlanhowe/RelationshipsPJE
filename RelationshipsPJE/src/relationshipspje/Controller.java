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
                    
                    PeopleClass theNewGuy = new PeopleClass(id, firstName, lastName, genderNum);
                    
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
