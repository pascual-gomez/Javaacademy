package com.gomezpascual;

//concrete reusable
public class Bitmap implements Image {

    private Integer location;

    private String name;

    public Bitmap(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Drawing "+name+" @ "+location);
    }

    @Override
    public Integer getLocation() {
        return location;
    }

    @Override
    public void setLocation(Integer location) {
        this.location = location;
    }

	@Override
	public void reset() {
		location = null;
		System.out.println("Bitmap is reset");
	}

    
}
