package relationshipspje;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
    private TreeMap<PeopleClass, RelationType> relations;
    
    /**
     *
     **/
    public PeopleClass()
    {
        
        relations=new TreeMap<PeopleClass ,RelationType>();
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
    /**Precondition: there is already a person given
     * 
     * @return the id number of this person
     */
    public int getId()
    {
        return id;
    }
    public void setId(int newId)
    {
        this.id=newId;
    }
    /**Precondition: there is already a person given
     * 
     * @return the last name of this person
     */
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String newLastName)
    {
        this.lastName=newLastName;
    }
    /**Precondition: there is already a person given
     * 
     * @return the first name of this person
     */
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String newFirstName)
    {
        this.firstName=newFirstName;
    }
    /**Precondition: there is already a person given
     * 
     * @return whether this person is male or not
     */
    public boolean getIsMale()
    {
        return isMale;
    }
    public void setIsMale(boolean newIsMale)
    {
        this.isMale=newIsMale;
    }
    /**Precondition: there is already a person given
     * Precondition: the person has a relationship
     * 
     * @return all the relations of this person
     */
    public TreeMap<PeopleClass ,RelationType> getAllRelationships()
    {
        return relations;
    }
    /**
     * 
     * @param person the relationshipee of the person
     * @param relationGiven the relation the person has with the relationshipee
     */
    public void addRelationship(PeopleClass person, RelationType relationGiven)
    {
        relations.put(person, relationGiven);
    }
    
}
