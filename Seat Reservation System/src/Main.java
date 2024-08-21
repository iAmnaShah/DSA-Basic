import java.util.Scanner;
class Seat {
    int row;
    int column;
    boolean isReserved;
    Seat next;
    Seat prev;
    public Seat(int Row, int Column){
        this.row = Row;
        this.column = Column;
        this.isReserved = false;
        this.next = null;
        this.prev = null;
    }
}
class Airplane {
    Seat first;
    int nRows;
    int nColumns;
    //declaring seat layouts by rows and columns
    public Airplane(int numRows, int numColumns) {
        this.nRows = numRows;
        this.nColumns = numColumns;
        initializeSeats();
    }
    //method for initializing seats
    private void initializeSeats() {
        for (int row = 1; row <= nRows; row++) {
            for (int column = 1; column <= nColumns; column++) {
                Seat newSeat = new Seat(row, column);
                if (first == null) {
                    first = newSeat;
                } else {
                    Seat current = first;
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = newSeat;
                    newSeat.prev = current;
                }
            }
        }
    }
// displaying current seat availability
    public void displayAvailability() {
        Seat current = first;
        while (current != null) {
            System.out.print("[" + current.row + "-" + current.column + ":");
            if (current.isReserved) {
                System.out.print("X] ");
            } else {
                System.out.print("O] ");
            }
            current = current.next;
        }
        System.out.println();
    }
//indicating reserved seats
    public void reserveSeat(int row, int column) {
        Seat current = first;
        while (current != null) {
            if (current.row == row && current.column == column && !current.isReserved) {
                current.isReserved = true;
                System.out.println("Seat " + row + "-" + column + " reserved.");
                return;
            }
            current = current.next;
        }
        System.out.println("Seat " + row + "-" + column + " is already reserved or does not exist.");
    }
//cancel reservations
    public void cancelReservation(int row, int column) {
        Seat current = first;
        while (current != null) {
            if (current.row == row && current.column == column && current.isReserved) {
                current.isReserved = false;
                System.out.println("Reservation for seat " + row + "-" + column + " canceled.");
                return;
            }
            current = current.next;
        }
        System.out.println("No reservation found for seat " + row + "-" + column + ".");
    }
// specific rows seating information for monitoring
    public void displayRowInfo(int row) {
        Seat current = first;
        while (current != null) {
            if (current.row == row) {
                System.out.print("[" + current.row + "-" + current.column + ":");
                if (current.isReserved) {
                    System.out.print("X] ");
                }
                else {
                    System.out.print("O] ");
                }
            }
            current = current.next;
        }
        System.out.println();
    }
}
//main class
class SeatReservationSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Airline Seat Reservation System!");
        System.out.print("Enter the number of rows: ");
        int numRows = scan.nextInt();
        System.out.print("Enter the number of columns: ");
        int numColumns = scan.nextInt();
        Airplane plane = new Airplane(numRows, numColumns);

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. DISPLAY SEAT AVILABILTY");
            System.out.println("2. RESERVE A SEAT");
            System.out.println("3. CANCEL RESERVATION");
            System.out.println("4. DISPLAY ROW INFROMATION");
            System.out.println("5. EXIT");
            System.out.print("ENTER YOUR CHOICE: ");
            int ch = scan.nextInt();

            switch (ch) {
                case 1 -> plane.displayAvailability();
                case 2 -> {
                    System.out.print("Enter the number of row and column you to reserve: ");
                    int row = scan.nextInt();
                    int column = scan.nextInt();
                    plane.reserveSeat(row, column);
                }
                case 3 -> {
                    System.out.print("Enter the number of row and column to cancel the reservation");
                    int rowtocancel = scan.nextInt();
                    int columntocancel = scan.nextInt();
                    plane.cancelReservation(rowtocancel, columntocancel);
                }
                case 4 -> {
                    System.out.print("Enter the number of row to display information: ");
                    int rowtodisplay = scan.nextInt();
                    plane.displayRowInfo(rowtodisplay);
                }
                case 5 -> {
                    System.out.println("Thank you for using the Airline Seat Reservation System.");
                    scan.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
