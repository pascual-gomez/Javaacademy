package com.gomezpascual.exerciseOne;

public class PortableMusicPlayer {
    Storage storage;
    Battery battery;
    Color color;

    PortableMusicPlayer(String storage, String battery, String color) {
        BatteryFactory batteryFactory = new BatteryFactory();
        this.battery = batteryFactory.createBattery(battery);
        this.battery.provideBattery();

        StorageFactory storageFactory = new StorageFactory();
        this.storage = storageFactory.createStorage(storage);
        this.storage.provideStorage();

        ColorFactory colorFactory = new ColorFactory();
        this.color = colorFactory.createColor(color);
        this.color.paint();
    }

    public void playMusic() {
        System.out.println("Playing music!");
    }
}
