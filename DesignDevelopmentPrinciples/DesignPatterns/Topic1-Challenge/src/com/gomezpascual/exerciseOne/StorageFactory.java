package com.gomezpascual.exerciseOne;

public class StorageFactory {
    public Storage createStorage(String capacity) {
        if (capacity == null || capacity.isEmpty())
            return null;
        if ("8GB".equals(capacity)) {
            return new EightGBStorage();
        } else if ("16GB".equals(capacity)) {
            return new SixteenGBStorage();
        }

        return null;
    }
}
