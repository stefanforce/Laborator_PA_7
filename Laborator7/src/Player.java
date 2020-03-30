import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    private String name;
    List<Integer> usedNumbers = new ArrayList<>();
    List<Token> usedTokens = new ArrayList<>();
    Board board;
    Player(String name, Board board){
        this.name=name;
        this.board=board;
    }

    public String getName(){
        return name;
    }
    /**making a method for picking a random token**/
    void pickRandomToken(int size)
    {
        int number;
        Token token;
        do {
            number = 1 + (int) (Math.random() * size);
            token = board.takeToken(number);
        }while(token==null);
        usedNumbers.add(token.getNumber());
        usedTokens.add(token);
    }

@Override
    public void run(){
        while(!board.tokenList.isEmpty())
        {
            pickRandomToken(board.getSize());
           
        }
}

}
