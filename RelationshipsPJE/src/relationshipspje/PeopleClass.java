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
    public PeopleClass(int newId, String newFirstName, String newLastName, boolean newIsMale)
    {
        id = newId;
        
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
