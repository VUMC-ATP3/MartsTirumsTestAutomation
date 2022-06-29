package classroomSix;

import com.github.javafaker.Faker;

public class Example {
    public static void main(String[] args) {
        System.out.println("This is maven project");
        Employee employeeOne = new Employee("Janis", "Programētājs", 1000.32);
        System.out.println(employeeOne.toString());

        Faker faker = new Faker();

        Employee employeeTwo = new Employee(faker.name().firstName(),faker.company().profession(),
                faker.number().randomDouble(2,100,2000));
        System.out.println(employeeTwo.toString());

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.company().profession());
        //Izvadi 3 lietas uz ekrana
        System.out.println(faker.beer().yeast());
        System.out.println(faker.crypto().hashCode());
        System.out.println(faker.music().instrument());

        Employee employeeThree = new Employee();
        System.out.println(employeeThree);

        // uztaisit ciklu kas uztaisis 100 jaunus emploees un katru izvadis uz ekranu
//        for (int i = 0; i < 100; i++) {
//            Employee employee = new Employee();
//            System.out.println(employee);
//        }






    }
}
