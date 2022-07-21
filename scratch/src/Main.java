public class Main
{
    public static void main(String[] args)
    {
        String s = "banana";
        System.out.println(s);
        System.out.println(iterativeRvs(s));
        System.out.println(functionalRvs("abcdefg"));
    }
    static String iterativeRvs(String str)
    {
        String rvs = "";
        for(int i = str.length()-1; i>=0; i--)
        {
            rvs += str.charAt(i);
        }
        return rvs;
    }
    static String functionalRvs(String str)
    {
        return str.chars().mapToObj(c->(char)c).reduce("",(s,c)->(c+s),(s1,s2)->s2+s1);
    }
}
