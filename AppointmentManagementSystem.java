import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Department {
    private String name;
    private List<String> doctors;

    public Department(String name) {
        this.name = name;
        doctors = new ArrayList<>();
    }

    public void addDoctor(String doctor) {
        doctors.add(doctor);
    }

    public List<String> getDoctors() {
        return doctors;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class AppointmentManagementSystem {
    public static void main(String[] args) {
        Map<Integer, Department> departments = createDepartments();
        displayGreetingMessage();
        showDepartments(departments);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the department number: ");
        int departmentNumber = scanner.nextInt();
        scanner.nextLine();

        Department department = departments.get(departmentNumber);
        if (department == null) {
            System.out.println("Invalid department number.");
            return;
        }

        showDoctors(department);

        System.out.print("Enter the doctor number: ");
        int doctorNumber = scanner.nextInt();
        scanner.nextLine();

        List<String> doctors = department.getDoctors();
        if (doctorNumber < 1 || doctorNumber > doctors.size()) {
            System.out.println("Invalid doctor number.");
            return;
        }

        String doctor = doctors.get(doctorNumber - 1);

        System.out.print("Enter the appointment date (YYYY-MM-DD): ");
        String appointmentDateStr = scanner.nextLine();

        LocalDate appointmentDate;
        try {
            appointmentDate = LocalDate.parse(appointmentDateStr);
        } catch (Exception e) {
            System.out.println("Invalid date format.");
            return;
        }

        bookAppointment(department, doctor, appointmentDate);
        displayThanksNote();
    }

    private static Map<Integer, Department> createDepartments() {
        Map<Integer, Department> departments = new HashMap<>();

        Department cardiology = new Department("Cardiology");
        cardiology.addDoctor("Dr. Rajesh");
        cardiology.addDoctor("Dr. Priya");
        cardiology.addDoctor("Dr. Suresh");
        departments.put(1, cardiology);

        Department neurology = new Department("Neurology");
        neurology.addDoctor("Dr. Sanjay");
        neurology.addDoctor("Dr. Nisha");
        neurology.addDoctor("Dr. Rahul");
        departments.put(2, neurology);

        Department dermatology = new Department("Dermatology");
        dermatology.addDoctor("Dr. Aishwarya");
        dermatology.addDoctor("Dr. Deepak");
        dermatology.addDoctor("Dr. Ravi");
        departments.put(3, dermatology);

        return departments;
    }

    private static void displayGreetingMessage() {
        System.out.println("Welcome to the Hospital Appointment Management System!");
        System.out.println("=============================================");
    }

    private static void displayThanksNote() {
        System.out.println("=============================================");
        System.out.println("Thank you for Choosing us! ");
        System.out.println("You will get a reminder on the day of your consultation!");
    }
        		
     
        		 private static void showDepartments(Map<Integer, Department> departments) {
        		System.out.println("Available Departments:");
        		 for (Map.Entry<Integer, Department> entry : departments.entrySet()) {
        		            int departmentNumber = entry.getKey();
        		            Department department = entry.getValue();
        		            System.out.println(departmentNumber + ". " + department);
        		        }
        		        System.out.println("=============================================");
        		 }
        		    
        		
        		 private static void showDoctors(Department department) {
        		     System.out.println("Available Doctors:");
        		        List<String> doctors = department.getDoctors();
        		        for (int i = 0; i < doctors.size(); i++) {
        		            System.out.println((i + 1) + ". " + doctors.get(i));
        	
        		       System.out.println("=============================================");
        		        }
        		 }
        		
        		
        		    private static void bookAppointment(Department department, String doctor, LocalDate appointmentDate) {
        		        System.out.println("=============================================");
        		       System.out.println("Appointment booked successfully!");
        		        System.out.println("Department: " + department);
        		       System.out.println("Doctor: " + doctor);
        		       System.out.println("Appointment Date: " + appointmentDate);
        		     System.out.println("=============================================");
        		        }
        		  }
   



