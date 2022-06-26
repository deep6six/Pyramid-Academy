package program;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            new GameFrame();
        } catch(Exception e) { System.out.println(e); System.exit(0); }
    }
}
