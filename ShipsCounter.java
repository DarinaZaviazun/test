class ShipsCounter{

    public static void main(String[] args) {

        int[][] ships = {
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 1}
        };
        System.out.println(countShips(ships));
    }

    static int countShips(int[][] ships) {
        int count = 0;
        int length = ships.length;
        int height = ships[0].length;

        for (int a = 0; a < length; a++) {
            for (int b = 0; b < height; b++) {
                if (ships[a][b] == 1) {
                    count++;

                    if (a + 1 < length && b + 1 < height && ships[a + 1][b + 1] == 1) {
                        ships[a + 1][b] = 0;
                        ships[a][b + 1] = 0;
                        ships[a + 1][b + 1] = 0;
                    }

                    if (a + 1 < length && ships[a + 1][b] == 1) {
                        for (int c = 1; c < 4; c++){
                            if (a + c == length || ships[a + c][b] == 0) break;
                            else ships[a + c][b] = 0;
                        }
                    }

                    if (b + 1 < height && ships[a][b + 1] == 1) {
                        for (int c = 1; c < 4; c++){
                            if (b + c == height || ships[a][b + c] == 0) break;
                            else ships[a][b + c] = 0;
                        }
                    }
                }
            }
        }
        return count;
    }
}

