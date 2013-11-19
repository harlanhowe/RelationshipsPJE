/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relationshipspje;

import java.util.*;

/**
 *
 * @author john.woodhouse
 */
public class PeopleClass 
{
    private int id;
    private String lastName;
    private String firstName;
    private boolean isMale;
    private Map<String, ArrayList<Integer>> relations;
    private ArrayList relationshipList= new ArrayList<Integer>();
    /**
     *
     **/
    public PeopleClass()
    {
        
        relations=new TreeMap<String,ArrayList<Integer>>();
    }
    /**precondition: need to receive information from Controller 
     * 
     * @param newId The new id number for the new PeopleClass person
     * @param newFirstName The first name of the new person
     * @param newLastName The last name of the new person
     * @param newIsMale Whether or not the new person is male
     */
    public PeopleClass(int newId, String newFirstName, String newLastName, boolean newIsMale)
    {
        id = newId;
        firstName=newFirstName;
        lastName=newLastName;
        isMale=newIsMale;
    }
    
    public int getId()
    {
        return id;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public boolean getIsMale()
    {
        return isMale;
    }
    public ArrayList<Integer> getRelationship()
    {
        return relationshipList;
    }
}
