package org.example.model;

public class Car {
    private Integer id;
    private String name;
    private Integer anulFabricatiei;

    public Car() {
    }

    public Car(Integer id, String name, Integer anulFabricatiei) {
        this.id = id;
        this.name = name;
        this.anulFabricatiei = anulFabricatiei;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAnulFabricatiei() {
        return anulFabricatiei;
    }

    public void setAnulFabricatiei(Integer anulFabricatiei) {
        this.anulFabricatiei = anulFabricatiei;
    }
}
