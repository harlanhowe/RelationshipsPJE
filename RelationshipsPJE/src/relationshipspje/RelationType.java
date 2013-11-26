package relationshipspje;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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

    
    /** Precondition: data must be given from Controller
     * 
     * @param newId Id for the new relation
     * @param newGenericType What type is the new relation
     * @param newFwdMaleName the masculine version of the person who is related to the other people
     * @param newFwdFemaleName the feminine version of the person who is related to the other people
     * @param newRevMaleName the masculine version of the related person
     * @param newRevFemaleName the feminine version of the related person
     */
    public RelationType(int newId, String newGenericType, String newFwdMaleName, String newFwdFemaleName, String newRevMaleName, String newRevFemaleName)
    {
        id=newId;
        genericName=newGenericType;
        fwdMaleName=newFwdMaleName;
        fwdFemaleName=newFwdFemaleName;
        revMaleName=newRevMaleName;
        revFemaleName=newRevFemaleName;

    }

    
    public int getId() 
    {
	return id;
    }
    public void setId(int id) 
    {
	this.id = id;
    }
    public String getGenericName() 
    {
	return genericName;
    }
    public void setGenericName(String genericName) 
    {
	this.genericName = genericName;
    }
    public String getFwdMaleName() 
    {
	return fwdMaleName;
    }
    public void setFwdMaleName(String fwdMaleName) 
    {
	this.fwdMaleName = fwdMaleName;
    }
    public String getFwdFemaleName() 
    {
	return fwdFemaleName;
    }
    public void setFwdFemaleName(String fwdFemaleName) 
    {
	this.fwdFemaleName = fwdFemaleName;
    }
    public String getRevMaleName() 
    {
	return revMaleName;
    }
    public void setRevMaleName(String revMaleName) 
    {
	this.revMaleName = revMaleName;
    }
    public String getRevFemaleName() 
    {
	return revFemaleName;
    }
    public void setRevFemaleName(String revFemaleName) 
    {
	this.revFemaleName = revFemaleName;
    }
}
