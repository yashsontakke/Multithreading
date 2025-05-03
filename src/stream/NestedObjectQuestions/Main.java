package stream.NestedObjectQuestions;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = EmployeeDataBase.getAllEmployees();

        //Collectors is meant to be a utility class — like Collections or Arrays
        //The collect() method needs a Collector.
        //Collectors methods build and return those Collector objects.

        List<Employee> employeesWithDD = employees.stream().filter(e->e.getDept().equals("Development")).collect(Collectors.toList());

        List<String> uniqueDepartments = employees.stream().map(emp->emp.getDept()).distinct().collect(Collectors.toList());

        List<List<Project>> projects =  employees.stream().map(e->e.getProjects()).collect(Collectors.toList());

        List<Stream<String>> streamList = employees.stream().map(e->e.getProjects().stream().map(p->p.getName())).collect(Collectors.toList());

        List<List<String>> listoflist = streamList.stream().map(a->a.collect(Collectors.toList())).collect(Collectors.toList());

        List<List<String>> streamList2 = employees.stream().map(e->e.getProjects().stream().map(p->p.getName()).collect(Collectors.toList())).collect(Collectors.toList());

        // [Alpha, Beta, Gamma, Delta, Epsilon, Zeta, Eta, Theta, Iota, Kappa]
        List<String> projectsList = employees.stream().flatMap(e->e.getProjects().stream().map(p->p.getName())).distinct().collect(Collectors.toList());

        List<Employee> employeesSortedBySalary = employees.stream().sorted(Comparator.comparingDouble(e->e.getSalary())).collect(Collectors.toList());
        System.out.println(employeesSortedBySalary);

        // If you're using comparingInt returns an IntComparator , comparingLong, or comparingDouble, you cannot call .reversed() directly.
        List<Employee> employeesSortedBySalaryInReverseOrder = employees.stream().sorted(Comparator.comparing(e->e.getSalary(),Comparator.reverseOrder())).collect(Collectors.toList());

        System.out.println(employeesSortedBySalaryInReverseOrder);
    }

}
