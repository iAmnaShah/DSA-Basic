public class Main {
    public static void main(String[] args) {
        CLL list = new CLL();
        list.addfirst(23);
        list.addfirst(12);
        list.addfirst(32);
        System.out.println("ADD FISRT");
        list.display();
        System.out.println();
        System.out.println("ADD LAST");
        list.addlast(22);
        list.display();
        System.out.println();
        System.out.println("ADD AT LOCATION");
        list.addatloc(3,33);
        list.display();
        System.out.println();
        System.out.println("DELETE AT FIRST");
        list.delfirst();
        list.display();
        System.out.println();
        System.out.println("DELETE AT LAST");
        list.dellast();
        list.display();
        System.out.println();
        System.out.println("DELETE AT LOCATION");
        list.delatloc(2);
        list.display();


    }
}