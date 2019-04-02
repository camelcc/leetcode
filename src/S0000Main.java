import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0855ExamRoom.ExamRoom room = new S0855ExamRoom.ExamRoom(10);
        room.seat();
        room.seat();
        room.seat();
        room.seat();
        room.leave(4);
        room.seat();
    }
}
