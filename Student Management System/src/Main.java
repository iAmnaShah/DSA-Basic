class StudentNode {
    //declaring variables
    public int RollNo;
    public String Name;
    public double CGPA;
    public StudentNode left;
    public StudentNode right;
        //constructors
    public StudentNode(int RollNo, String Name, double CGPA) {
        this.RollNo = RollNo;
        this.Name = Name;
        this.CGPA = CGPA ;
        this.left = null;
        this.right = null;
    }
}

class StudentBST {
    private StudentNode root;

    public StudentBST() {
        this.root = null;
    }
    //inserting the nodes(student's details)

    public void insert(int RollNo, String Name, double CGPA) {
        if (search(RollNo)) {
            // Roll no already exists
            System.out.println("Student with roll number " + RollNo + " already exists.");
            return;
        }

        root = insertRec(root, RollNo, Name, CGPA);
    }

    //recursive function for insert
    private StudentNode insertRec(StudentNode root, int RollNo, String Name, double CGPA) {
        if (root == null) {
            return new StudentNode(RollNo, Name, CGPA);
        }

        if (RollNo < root.RollNo) {
            root.left = insertRec(root.left, RollNo, Name, CGPA);
        } else if (RollNo > root.RollNo) {
            root.right = insertRec(root.right, RollNo, Name, CGPA);
        }

        return root;
    }

    //searching for a student's record

    public boolean search(int rollNo) {
        StudentNode result = searchRec(root, rollNo);
        if (result != null) {
            System.out.println("Student Details - Roll No: " + result.RollNo +
                    ", Name: " + result.Name +
                    ", CGPA: " + result.CGPA);
            return true;
        } else {
            System.out.println("Student with roll number " + rollNo + " not found.");
            return false;
        }
    }

    // recursive search function

    private StudentNode searchRec(StudentNode root, int rollNo) {
        if (root == null || root.RollNo == rollNo) {
            return root;
        }

        if (rollNo < root.RollNo) {
            return searchRec(root.left, rollNo);
        } else {
            return searchRec(root.right, rollNo);
        }
    }
    // display student's records

    public void displayInRange(double cgpaStart, double cgpaEnd) {
        displayInRangeRec(root, cgpaStart, cgpaEnd);
    }

    //recursive display function

    private void displayInRangeRec(StudentNode root, double cgpaStart, double cgpaEnd) {
        if (root != null) {
            if (root.CGPA >= cgpaStart && root.CGPA <= cgpaEnd) {
                displayInRangeRec(root.left, cgpaStart, cgpaEnd);
                System.out.println("Student Details - Roll No: " + root.RollNo +
                        ", Name: " + root.Name +
                        ", CGPA: " + root.CGPA);
                displayInRangeRec(root.right, cgpaStart, cgpaEnd);
            } else if (root.CGPA < cgpaStart) {
                displayInRangeRec(root.right, cgpaStart, cgpaEnd);
            } else {
                displayInRangeRec(root.left, cgpaStart, cgpaEnd);
            }
        }
    }

    public static class Main {
        public static void main(String[] args) {
            // Creating object of class StudentBST
            StudentBST studentBST = new StudentBST();

            // Implementing insert function
            studentBST.insert(130, "Amna Shah", 3.8);
            studentBST.insert(2, "Babar", 3.4);
            studentBST.insert(120, "Ali", 3.2);
            studentBST.insert(289, "Aila", 2.8);
            studentBST.insert(212, "Samia", 2.5);
            studentBST.insert(56, "Laiba", 2.9);
            studentBST.insert(150, "Jan Mariot", 2.8);
            studentBST.insert(204, "Ayza", 3.3);
            //display

            System.out.println();
            // Implementing display in range function
            System.out.println("Students with CGPA between 3.2 and 4.0:");
            studentBST.displayInRange(3.2, 4.0);
            System.out.println();

            System.out.println("Already Existing Student");
            // Implementing search for already existing student
            studentBST.search(150); // Existing student
            studentBST.search(56);
            System.out.println();
            System.out.println("Checking For DUplicate");
            // Implementing function to check for duplicate roll no
            studentBST.insert(204, "Zayn", 3.7);
            System.out.println();
            System.out.println("Non-Existing Student");
            // Implementing function to search for a non-existing student
            studentBST.search(210);
            studentBST.search(256);
        }
    }
}
