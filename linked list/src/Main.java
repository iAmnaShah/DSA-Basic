public class Main {
    public static void main(String[] args) {
        LL newnode = new LL();
        newnode.addfirst(5);
        newnode.addfirst(9);
        newnode.addfirst(1);
        newnode.addfirst(12);

        System.out.println("ADD FIRST");
        newnode.print();
        System.out.println();
        System.out.println("ADD LAST");
        newnode.addlast(30);
        newnode.addlast(33);
        newnode.print();
        System.out.println();
        newnode.addatloc(3, 12);
        System.out.println("ADD AT LOCATION:");
        newnode.print();
        System.out.println();
        System.out.println("REMOVING SMALL NODES");
        newnode.print();
        System.out.println("DELETING FIRST:");
        newnode.deletefrst();
        newnode.print();
        System.out.println();
        System.out.println("DELETING LAST:");
        newnode.deletelast();
        newnode.print();
        System.out.println();
        newnode.delatlocation(3);
        System.out.println("DELETE AT LOCATION:");
        newnode.print();
        System.out.println();
        System.out.println("Size Of List is: "+newnode.getSize());
        System.out.println();
        newnode.findpos(12);

    }
}