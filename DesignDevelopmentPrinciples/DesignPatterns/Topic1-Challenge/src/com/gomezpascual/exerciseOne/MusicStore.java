package com.gomezpascual.exerciseOne;

//MusicStore class would work as a Facade
public class MusicStore {
    public PortableMusicPlayer createPortableMusicPlayer(String storage, String battery, String color) {
        return new PortableMusicPlayer(storage, battery, color);
    }
}
