public class Player {
    private int position;
    private String name;

    public Player(String name) {
        this.position = 0;
        this.name = name;
    }

    public void changePosition(int inc) {
        this.position += inc;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }
}
