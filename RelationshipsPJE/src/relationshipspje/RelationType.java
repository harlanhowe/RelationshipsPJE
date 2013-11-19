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
     * @param newId
     * @param newType
     * @param newMaleName
     * @param newFemaleName
     * @param newInverseMaleName
     * @param newInverseFemaleName 
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
}
