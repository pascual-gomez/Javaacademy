package com.gomezpascual;

public class Ej1 {


        private final int[] wall = new int[] {3,4,2,4,2};

        public static void main(String[] args) {
            Ej1 ej1 = new Ej1();
            /**
            System.out.println(ej1.blocksAmount());

            int blockAmount = ej1.blocksAmount();
            int avg = ej1.getAvg(blockAmount);

            System.out.println(avg);
            System.out.println(ej1.wallSize(avg));

             **/

            int wallHeight = ej1.getWallSize();
            System.out.println("La altura es de " + wallHeight + " bloques.");

            int blocksToAdd = ej1.countBlocksToAdd(wallHeight);
            System.out.println("Faltan " + blocksToAdd + " bloques por agregar.");
        }

        public int blocksAmount() {
            int blockAmount = 0;
            for (int i = 0; i < wall.length; i++){
                blockAmount += wall[i];
            }
            return blockAmount;
        }

        public int getAvg(int blockAmount) {
            return blockAmount / wall.length;
        }

        public int wallSize(int blockAvg) {
            int blocksToMove = 0;
            for (int i = 0 ; i < wall.length; i++) {
                if (wall[i] > blockAvg) {
                    blocksToMove = blocksToMove + (wall[i] - blockAvg);
                }
            }
            return blocksToMove;
        }

        public int getWallSize() {
            int wallHeight = 0;

            for (int i = 0; i < wall.length; i++) {
                if (wall[i] > wallHeight) {
                    wallHeight = wall[i];
                }
            }

            return wallHeight;
        }

        public int countBlocksToAdd(int wallHeight) {
            int blocksToAdd = 0;

            for (int i = 0; i < wall.length; i++) {
                if (wall[i] < wallHeight) {
                    blocksToAdd += (wallHeight - wall[i]);
                }
            }

            return blocksToAdd;
        }

}
