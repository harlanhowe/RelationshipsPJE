/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relationshipspje;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.TreeMap;
import javax.swing.JFileChooser;

/**
 *
 * @author phillip.johnson
 */
public class Controller 
{
    private File preferredPeople;
    private File preferredRelType;
    private File preferredRelation;
    private TreeMap<Integer, PeopleClass> personList;
    private TreeMap<Integer, RelationType> relationList;
    
    public Controller()
    {
        
    }
    
    public void openPeople()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(preferredPeople);
        int result = chooser.showOpenDialog(null);//this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            preferredPeople = chooser.getSelectedFile();
            
            // now try to open the file and read from it with a scanner.
        
        
            try
            {
                PrintWriter output = new PrintWriter(preferredPeople);
                // read from the file, store relations into arrayList;
               
                // output.println("Here is example stuff to save....");
                // put your output code here!
                
                
                
                output.close();
            }
            catch (FileNotFoundException fnfe)
            {
                throw new RuntimeException("File "+preferredPeople+" cannot be loaded.");
            }
        }
    }
    
    public void openRelTypes()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(preferredRelType);
        int result = chooser.showOpenDialog(null);//this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            preferredRelType = chooser.getSelectedFile();
            
            // now try to open the file and read from it with a scanner.
        
        
            try
            {
                PrintWriter output = new PrintWriter(preferredRelType);
                // read from the file, store relations into arrayList;
               
                // output.println("Here is example stuff to save....");
                // put your output code here!
                
                
                
                output.close();
            }
            catch (FileNotFoundException fnfe)
            {
                throw new RuntimeException("File "+preferredRelType+" cannot be laoded.");
            }
        }
    }
    
    public void openRelations()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(preferredRelation);
        int result = chooser.showOpenDialog(null);//this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            preferredRelation = chooser.getSelectedFile();
            
            // now try to open the file and read from it with a scanner.
        
        
            try
            {
                PrintWriter output = new PrintWriter(preferredRelation);
                // read from the file, store relations into arrayList;
               
                // output.println("Here is example stuff to save....");
                // put your output code here!
                
                
                
                output.close();
            }
            catch (FileNotFoundException fnfe)
            {
                throw new RuntimeException("File "+preferredRelation+" cannot be loaded.");
            }
        }
    }
}
