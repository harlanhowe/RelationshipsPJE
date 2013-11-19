/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relationshipspje;

import java.util.Map;

/**
 *
 * @author john.woodhouse
 */
public class RelationType 
{
    private int id;
    private String type;
    private String maleName;
    private String femaleName;
    private String inverseMaleName;
    private String inverseFemaleName;
    private Map<Integer, String> relationNumber;
    
    public RelationType()
    {
        
    }
    /** Precondition: data must be given from Controller
     * 
     * @param newId Id for the new relation
     * @param newType What type is the new relation
     * @param newMaleName the masculine version of the person who is related to the other people
     * @param newFemaleName the feminine version of the person who is related to the other people
     * @param newInverseMaleName the masculine version of the related person
     * @param newInverseFemaleName the feminine version of the related person
     */
    public RelationType(int newId, String newType, String newMaleName, String newFemaleName, String newInverseMaleName, String newInverseFemaleName)
    {
        id=newId;
        type=newType;
        maleName=newMaleName;
        femaleName=newFemaleName;
        inverseMaleName=newInverseMaleName;
        inverseFemaleName=newInverseFemaleName;
    }
    public int id()
    {
        return id;
    }
    public String type()
    {
        return type;
    }
    public String maleName()
    {
        return maleName;
    }
    public String femaleName()
    {
        return femaleName;
    }
    public String inverseMaleName()
    {
        return inverseMaleName;
    }
    public String inverseFemaleName()
    {
        return inverseFemaleName;
    }
}
