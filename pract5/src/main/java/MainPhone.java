import java.util.Scanner;

/*
Создать базовый класс Мобильный телефон (название, вес, диагональ экрана, количество встроенной памяти, наличие камеры).
Производный класс – Смартфон (частота процессора, количество ядер, объем ОП).
 */

public class MainPhone {
    public static void main(String[] args) {
        try {
            String name;
            double weight;
            double diagonal;
            int memory;
            boolean isCamera;
            double frequency;
            int number_of_cores;
            int amount_of_ram;
            Scanner in = new Scanner(System.in);
            System.out.print("Enter name of device: ");
            name = in.nextLine();
            System.out.print("Enter weight of device: ");
            weight = in.nextDouble();
            System.out.print("Enter diagonal of device: ");
            diagonal = in.nextDouble();
            System.out.print("Enter a volume of memory: ");
            memory = in.nextInt();
            System.out.print("whether the device has a camera: ");
            isCamera = in.nextBoolean();
            System.out.print("Enter frequency of device: ");
            frequency = in.nextDouble();
            System.out.print("Enter a number of cores: ");
            number_of_cores = in.nextInt();
            System.out.print("Enter amount of RAM: ");
            amount_of_ram = in.nextInt();

            SmartPhone s = new SmartPhone(frequency, number_of_cores, amount_of_ram, name, weight, diagonal, memory, isCamera);
            System.out.println(s.toString());
            System.out.println(s.hashCode());
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
