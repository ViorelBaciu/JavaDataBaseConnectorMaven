package org.example.model;

public class ExAnimal {
    private Integer Id;
    private String name;
    private String species;

    public ExAnimal() {
    }

    public ExAnimal(Integer id, String name, String species) {
        Id = id;
        this.name = name;
        this.species = species;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
