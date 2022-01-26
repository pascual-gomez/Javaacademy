package com;

public class EJ3 {
    /*
    Clases: Automóvil Estándar, Cabriolet (Descapotable), Campero 4x4, Bus de pasajeros
    Comportamiento: Pitar, Acelerar, Frenar, Doble Tracción, Remover Techo, Poner Techo
     */

    public class Car {
        public void honk() {
            System.out.println("Honk! honk!");
        }

        public void speedUp() {
            System.out.println("Vrooom!");
        }

        public void slowDown() {
            System.out.println("Screech!");
        }
    }

    public class Cabriolet extends Car {
        public void openRoof() {
            System.out.println("Roof opened.");
        }

        public void closeRoof() {
            System.out.println("Roof closed.");
        }
    }

    public class Camper extends Car {
        public void starFourWheelDrive() {
            System.out.println("4x4 on.");
        }

        public void turnOffFourWheelDrive() {
            System.out.println("4x4 off.");
        }
    }

    public class Bus extends Car {
        
    }
}
