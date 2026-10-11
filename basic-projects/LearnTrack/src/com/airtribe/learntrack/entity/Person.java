package com.airtribe.learntrack.entity;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

     public Person(int id, String firstName, String lastName, String email){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public int getId(){                 //Getter 1
         return id;
    }
    public String getFirstName(){       //Getter 2
         return firstName;
    }
    public String getLastName(){        //Getter 3
         return lastName;
    }
    public String getEmail(){           //Getter 4
         return email;
    }

    public void setId(int id){                                 //Setter 1
         this.id = id;
    }
    public void setFirstName(String firstName){                //Setter 2
         this.firstName = firstName;
    }
    public void setLastName(String lastName){                  //Setter 3
         this.lastName = lastName;
    }
    public void setEmail(String email){                        //Setter 4
         this.email = email;
    }


    public String getDisplayName(){
         return firstName + " - " + lastName;
    }
}



