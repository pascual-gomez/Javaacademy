package com.gomezpascual;

//Proxy class.
public class ImageProxy implements Image {

    private String name;
    private Integer location;
    private BitmapImage image;

    public ImageProxy(String name) {
        this.name = name;
    }

    @Override
    public void setLocation(Integer location) {
        if (image != null) {
            image.setLocation(location);
        } else {
            this.location = location;
        }
    }

    @Override
    public Integer getLocation() {
        if (image != null) {
            return image.getLocation();
        } else {
            return location;
        }
    }

    @Override
    public void render() {
        if (this.image == null) {
            this.image = new BitmapImage(this.name);
            if (location != null) {
                this.image.setLocation(this.location);
            }
        }
        image.render();
    }
}
