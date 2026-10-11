package com.airtribe.learntrack.entity;

public class Student extends Person {         //Class Student inherits Person
    private String batch;            //Encapsulation
    private boolean active;

    public Student(int id, String firstName, String lastName, String email, String batch, boolean active){
        super(id,firstName,lastName,email);         //Calls Parent constructor
        this.batch = batch;
        this.active = active;
    }
    public String getBatch(){                       //Getter 1
        return batch;
    }
    public boolean isActive(){                     //Getter 2
        return active;
    }
    public void setBatch(String batch){             //Setter 1
        this.batch = batch;
    }
    public void setActive(boolean active){          //Setter 2
        this.active = active;
    }
    @Override
    public String getDisplayName(){
        return getFirstName() + " - " + getLastName() + " - " + getBatch();
    }
}
