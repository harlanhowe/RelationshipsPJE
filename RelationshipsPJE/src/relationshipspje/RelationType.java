package relationshipspje;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.TreeMap;

/**
 *
 * @author john.woodhouse
 */
public class RelationType 
{
    private int id;
    private String genericName;
    private String fwdMaleName;
    private String fwdFemaleName;
    private String revMaleName;
    private String revFemaleName;
    private TreeMap<Integer, Integer> relationNumber;
    
    public RelationType()
    {
        relationNumber=new TreeMap<Integer, Integer>();
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
        genericName=newType;
        fwdMaleName=newMaleName;
        fwdFemaleName=newFemaleName;
        revMaleName=newInverseMaleName;
        revFemaleName=newInverseFemaleName;
    }
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenericName() {
		return genericName;
	}
	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
	public String getFwdMaleName() {
		return fwdMaleName;
	}
	public void setFwdMaleName(String fwdMaleName) {
		this.fwdMaleName = fwdMaleName;
	}
	public String getFwdFemaleName() {
		return fwdFemaleName;
	}
	public void setFwdFemaleName(String fwdFemaleName) {
		this.fwdFemaleName = fwdFemaleName;
	}
	public String getRevMaleName() {
		return revMaleName;
	}
	public void setRevMaleName(String revMaleName) {
		this.revMaleName = revMaleName;
	}
	public String getRevFemaleName() {
		return revFemaleName;
	}
	public void setRevFemaleName(String revFemaleName) {
		this.revFemaleName = revFemaleName;
	}
	public TreeMap<Integer, Integer> getRelationNumber() {
		return relationNumber;
	}
	public void setRelationNumber(TreeMap<Integer, Integer> relationNumber) {
		this.relationNumber = relationNumber;
	}
	/**
     * 
     * @return whether or not the relationship is an inverse of itself
     */
    public boolean inverseOfSelf()
    {
        if((maleName.equals(inverseMaleName))&&(femaleName.equals(inverseFemaleName)))
            return true;
        else
            return false;
    }
}
