package com.example.lab3duytruong;

public class Contributor {
    private String name;
    private String contributions;
    private int imageResource;

    public Contributor(String name, String contributions, int imageResource) {
        this.name = name;
        this.contributions = contributions;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContributions() {
        return contributions;
    }

    public void setContributions(String contributions) {
        this.contributions = contributions;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}

