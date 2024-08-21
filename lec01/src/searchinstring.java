public class searchinstring {
    public static void main(String[] args){
        String string = "Amna Shah";
        char target = 'S';
        System.out.println(search(string,target));
    }
    static boolean search(String string, char target)
    {
        if(string.length()==0)
            return false;

        for(char ch:string.toCharArray())
        {
            if(ch==target)
                return true;
        }
        return false;

    }
}
