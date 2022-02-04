package com.gomezpascual.exerciseOne;

public class Client {
    public static void main(String[] args) {
        MusicStore store = new MusicStore();
        PortableMusicPlayer walkman = store
                .createPortableMusicPlayer("16GB", "8HOUR", "BLUE");
        walkman.playMusic();
    }
}
