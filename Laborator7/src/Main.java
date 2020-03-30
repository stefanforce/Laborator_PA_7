import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main( String[] args )
    {
        List<String> nume= new ArrayList<>();
        nume.add("Player1");
        nume.add("Player2");
        nume.add("Player3");
        Game game= new Game(21,3,nume);


    }
}
