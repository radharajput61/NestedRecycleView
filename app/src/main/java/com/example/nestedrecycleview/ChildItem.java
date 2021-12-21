package com.example.nestedrecycleview;
public class ChildItem {

    // Declaration of the variable
    private String ChildItemTitle;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String image;

    // Constructor of the class
    // to initialize the variable*
    public ChildItem(String childItemTitle,String image)
    {
        this.ChildItemTitle = childItemTitle;
        this.image = image;
    }

    // Getter and Setter method
    // for the parameter
    public String getChildItemTitle()
    {
        return ChildItemTitle;
    }

    public void setChildItemTitle(
            String childItemTitle)
    {
        ChildItemTitle = childItemTitle;
    }
}

