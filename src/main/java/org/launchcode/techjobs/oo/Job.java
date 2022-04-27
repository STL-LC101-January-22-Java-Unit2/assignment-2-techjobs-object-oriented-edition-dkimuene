package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private Integer id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Job)) return false;
        Job job = (Job) obj;
        return getId() == job.getId();
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        Character firstLine = '\n';
        Character lastLine = '\n';
        String idInfo;
        String nameInfo;
        String employerInfo;
        String locationInfo;
        String positionTypeInfo;
        String coreCompetencyInfo = "Core Competency: "+getCoreCompetency().getValue()+"\n";

        if(this.id == null){
            idInfo = "ID: "+"Data not available\n";
        }else{
            idInfo = "ID: "+getId()+"\n";
        }

        if(this.name.isEmpty() || name==null){
            nameInfo = "Name: "+getName()+"Data not available\n";
        }else{
            nameInfo = "Name: "+getName()+"\n";
        }

        if(this.employer.getValue().isEmpty() || employer==null){
            employerInfo = "Employer: "+"Data not available\n";
        }else{
            employerInfo = "Employer: "+getEmployer().getValue()+"\n";
        }

        if(this.location.getValue().isEmpty() || location==null){
            locationInfo = "Location: "+"Data not available\n";
        }else{
            locationInfo = "Location: "+getLocation().getValue()+"\n";
        }

        if(this.positionType.getValue().isEmpty() || positionType==null){
            positionTypeInfo = "Position Type: "+"Data not available\n";
        }else{
            positionTypeInfo = "Position Type: "+getPositionType().getValue()+"\n";
        }

        if(this.coreCompetency.getValue().isEmpty() || coreCompetency==null){
            coreCompetencyInfo = "Core Competency: "+"Data not available";
        }else{
            coreCompetencyInfo = "Core Competency: "+getCoreCompetency().getValue();
        }
        return "\n"+idInfo+nameInfo+employerInfo+locationInfo+positionTypeInfo+coreCompetencyInfo+"\n";
    }
}
