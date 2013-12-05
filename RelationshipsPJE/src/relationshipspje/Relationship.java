package relationshipspje;

public class Relationship {

	private int id;
	private PeopleClass primaryPerson;
	private PeopleClass secondaryPerson;
	private RelationType relationType;
	
	public Relationship(int id,PeopleClass person1, PeopleClass person2, RelationType relationType){
		this.id = id;
		this.primaryPerson = person1;
		this.secondaryPerson = person2;
		this.relationType = relationType;
	}

	public PeopleClass getPersonRelatedTo(PeopleClass person){
		if (primaryPerson == person)
			return secondaryPerson;
		else
			return primaryPerson;
	}
	
	public boolean isRelationshipOf(PeopleClass person){
		if (primaryPerson == person)
			return true;
		else
			return false;
	}
        
        public boolean isRelationshipTo(PeopleClass person)
        {
            if (secondaryPerson == person)
			return true;
		else
			return false;
        }

	public PeopleClass getSecondaryPerson() {
		return secondaryPerson;
	}

	public void setSecondaryPerson(PeopleClass secondaryPerson) {
		this.secondaryPerson = secondaryPerson;
	}

	public PeopleClass getPrimaryPerson() {
		return primaryPerson;
	}

	public void setPrimaryPerson(PeopleClass primaryPerson) {
		this.primaryPerson = primaryPerson;
	}

	public RelationType getRelationType() {
		return relationType;
	}

	public void setRelationType(RelationType relationType) {
		this.relationType = relationType;
	}
        
        public int getId()
        {
            return id;
        }
	
}
