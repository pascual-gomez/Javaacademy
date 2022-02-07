package com.gomezpascual;

//Interface implemented by proxy and concrete objects
public interface Image {

	void setLocation(Integer location);
	
	Integer getLocation();
	
	void render();
	
}
