package models;

import java.util.ArrayList;

public class Project {
    private String name;
    private String description;
    private ArrayList <String> domains;

    public Project(String name, String description, ArrayList<String> domains) {
        this.name = name;
        this.description = description;
        this.domains = domains;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getDomains() {
        return domains;
    }

    public void setDomains(ArrayList<String> domains) {
        this.domains = domains;
    }
}
