import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int[] nums = {2,5,6,4};
        Arrays.stream(r(nums)).forEach(i->System.out.println(i));
    }
    static int[] r(int[] nums)
    {
        return Arrays.stream(nums).map(n->{
            int[] product = new int[nums.length];
            for(int i=0;i<nums.length;i++){ if(nums[i] != n) { product[i] = nums[i]; } }
            return Arrays.stream(product).filter(i->i != 0).reduce(1,(a,b)->a*b);
        }).toArray();
    }
}
