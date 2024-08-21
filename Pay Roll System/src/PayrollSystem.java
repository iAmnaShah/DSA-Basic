public class PayrollSystem {

    static class Employee {
        //declaring variables
        String Name;
        String Dept;
        double MonthlySalary;
        //constructors
        public Employee(String Name, String Dept, double MonthlySalary) {
            this.Name = Name;
            this.Dept = Dept;
            this.MonthlySalary = MonthlySalary;
        }
    }

    public static void main(String[] args) {
        // Sample array
        Employee[] employees = {
                new Employee("Amna Shah", "IT", 500000),
                new Employee("Ruby Salim", "HR", 60000),
                new Employee("Alia", "Accounts", 85000),
                new Employee("Shahrukh", "Advertisement", 55000)

        };

        // Sorting employees based on monthly salary in descending order
        quickSort(employees, 0, employees.length - 1);

        // Display the sorted records
        displaySortedEmployees(employees);
    }

    // Implementation Of Quick Sort
    private static void quickSort(Employee[] arr, int Low, int High) {
        if (Low < High) {
            int partitionIndex = partition(arr, Low, High);

            quickSort(arr, Low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, High);
        }
    }
    // Partition function
    private static int partition(Employee[] arr, int Low, int High) {
        double pivot = arr[High].MonthlySalary;
        int i = Low - 1;

        for (int j = Low; j < High; j++) {
            if (arr[j].MonthlySalary >= pivot) {
                i++;
                // Swaping
                Employee temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //Swapping
        Employee temp = arr[i + 1];
        arr[i + 1] = arr[High];
        arr[High] = temp;

        return i + 1;
    }

    // Display sorted records
    private static void displaySortedEmployees(Employee[] employees) {
        System.out.println("Sorted Employee Records (Descending Order by Monthly Salary):");
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.Name +
                    ", Department: " + employee.Dept +
                    ", Monthly Salary: " + employee.MonthlySalary);
        }
    }
}



















