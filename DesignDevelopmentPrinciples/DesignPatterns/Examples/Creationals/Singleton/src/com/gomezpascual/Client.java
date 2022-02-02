package com.gomezpascual;

public class Client {

	public static void main(String[] args) {

		//Eager Singleton
		EagerRegistry registry = EagerRegistry.getInstance();
		EagerRegistry registry1 = EagerRegistry.getInstance();
		System.out.println(registry == registry1);

		//Lazy Singleton with double check lock
		LazyRegistryWithDCL lazySingleton = LazyRegistryWithDCL.getInstance();
		LazyRegistryWithDCL lazySingleton1 = LazyRegistryWithDCL.getInstance();
		System.out.println(lazySingleton1 == lazySingleton);

		//Lazy Singleton with holder
		System.out.println("Before get instance: ");
		LazyRegistryIODH singleton;
		System.out.println("After get instance: ");
		singleton = LazyRegistryIODH.getInstance();
	}

}
