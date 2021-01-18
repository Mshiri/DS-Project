package DSProject;

public class Call extends Edge
{
    String shomare;
    String time;
    int duration;
    public Call(Node from, Node to, String shomare, String time, int duration) {
        super(shomare, from, to);
        this.shomare = shomare;
        this.time = time;
        this.duration = duration;
    }
}
