import java.util.ArrayList;
import java.util.List;

public class Board {
    public List<Token> tokenList=new ArrayList<Token>();
    int size;
    Board(int size)
    {
        this.size=size;
        for(int i=0;i<size;i++)
            tokenList.add(new Token(i+1));
    }
    synchronized Token takeToken(int number)
    {
        if(tokenList.isEmpty())
            return null;
        for(Token t:tokenList)
            if(t.getNumber()==number)
            {
                tokenList.remove(t);
                return t;
            }
        return null;
    }

    public int getSize() {
        return size;
    }
}
