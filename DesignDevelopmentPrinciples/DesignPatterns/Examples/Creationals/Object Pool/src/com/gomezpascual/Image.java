package com.gomezpascual;

//Represents our abstract reusable
public interface Image extends Poolable {

    void draw();

    Integer getLocation();

    void setLocation(Integer location);
}
