public class Main {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.addfirst(4);
        list.addfirst(3);
        list.addfirst(2);
        System.out.println("INSERT AT FIRST:");
        list.printnode();
        System.out.println();
        list.addlast(15);
        System.out.println("INSERT AT LAST");
        list.printnode();
        System.out.println();
        list.addatloc(3,12);
        System.out.println("INSERT AT LOCATION");
        list.printnode();
        System.out.println();
        System.out.println("REVERSE PRINT");
        list.reverseprint();


    }
}