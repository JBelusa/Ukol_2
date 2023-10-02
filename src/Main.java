import com.engeto.rooms.Room;

public class Main {
    public static void main(String[] args) {

        //region Room
        Room room1 = new Room(
                1,
                1,
                true,
                true,
                1000
        );

        Room room2 = new Room(
                2,
                1,
                true,
                true,
                1000
        );

        Room room3 = new Room(
                3,
                3,
                false,
                true,
                2400
        );

//        System.out.println("místnost 3 má" + room3.getPricePerNight()+"ano");
        //endregion


    }
}