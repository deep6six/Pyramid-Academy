import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main
{
    static ArrayList<Integer> array = new ArrayList<>();
    public static void main(String[] args)
    {
        IntStream.range(0,11).forEach(i->array.add(i));
        removeRange(array,3,7);
        array.forEach(i->System.out.print(i));
    }
    static void removeRange(ArrayList<Integer> nums, int from, int to)
    {
        nums.removeIf(i->(nums.get(i)>=from && nums.get(i) <= to));
    }
}
