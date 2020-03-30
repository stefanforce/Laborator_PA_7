import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Game {
    Board board;
    List<Player>players;
    Game(int size,int nrPlayers,List<String>names)
    {
        players=new ArrayList<Player>();

        board=new Board(size);
        for(String name:names) {
            Runnable newPlayer = new Player(name, board);
            players.add((Player)newPlayer);
        }
    for(int i=0;i< players.size();i++)
    {
        new Thread(players.get(i)).start();
    }
    int max=0;
    int maxP=1;

        for(Player p :players){
            System.out.print("Jucatorul " + p.getName() + " a strans tokenurile: ");
            for(Token t : p.usedTokens){
                System.out.print(t.getNumber() + " ");
            }
            System.out.print("\n");
            int len=lenghtOfLongestAP(p.usedNumbers,p.usedNumbers.size());
            if(max<len) {
                max = len;
            }
        }
        System.out.print("A castigat jucatorul cu "+max+" puncte");
    }


    /**checks the length of the longest arithmetic progression
     * taken from https://www.geeksforgeeks.org/longest-arithmetic-progression-dp-35/ **/

    static int lenghtOfLongestAP(List<Integer> set, int n)
    {
        if (n <= 2) return n;

        int L[][] = new int[n][n];

        int llap = 2;

        for (int i = 0; i < n; i++)
            L[i][n - 1] = 2;

        for (int j = n - 2; j >= 1; j--)
        {
            int i = j -1 , k = j + 1;
            while (i >= 0 && k <= n - 1)
            {
                if (set.get(i) + set.get(k) < 2 * set.get(j))
                    k++;

                else if (set.get(i) + set.get(k) > 2 * set.get(j))
                {
                    L[i][j] = 2; i--;

                }

                else
                {

                    L[i][j] = L[j][k] + 1;

                    llap = Math.max(llap, L[i][j]);

                    i--; k++;
                }
            }
            while (i >= 0)
            {
                L[i][j] = 2;
                i--;
            }
        }
        return llap;
    }
}
