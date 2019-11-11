public class Board {
    private int[][] snakes = {{36, 6}, {32, 10}, {48, 26}, {88, 24}, {62, 18}, {95, 56}, {97, 78}};
    private int[][] ladders = {{4, 14}, {8, 10}, {1, 38}, {21, 42}, {28, 76}, {50, 67}, {71, 92}, {88, 99}};

    public void printBoard(int player1Position, int player2Position) {
        int counter = 100;
        for (int i = 0; i < 10; i++) {
            System.out.println("=========================================================================================================================");
            System.out.print("|");
            for (int j = 0; j < 10; j++) {
                String add = "   ";
                if (player1Position == counter) add = add.trim() + "[1]";
                if (player2Position == counter) add = add.trim() + "[2]";
                System.out.print("\t" + counter + add + "\t|");

                counter--;
            }
            System.out.println();
        }
        System.out.println("=========================================================================================================================");
    }

    public boolean isSnake(int position) {
        for (int i = 0; i < snakes.length; i++) {
            if (position == snakes[i][0]) return true;
        }
        return false;
    }

    public boolean isLadder(int position) {
        for (int i = 0; i < ladders.length; i++) {
            if (position == ladders[i][0]) return true;
        }
        return false;
    }

    public int dec(int position) {
        if (isSnake(position)) {
            for (int i = 0; i < snakes.length; i++) {
                if (position == snakes[i][0]) return snakes[i][1];
            }
        }
        return -1;
    }

    public int inc(int position) {
        if (isLadder(position)) {
            for (int i = 0; i < ladders.length; i++) {
                if (position == ladders[i][0]) return ladders[i][1];
            }
        }
        return -1;
    }

}
