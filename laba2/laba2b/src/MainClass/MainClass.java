package MainClass;
import Computer.*;

import java.util.ArrayList;
import java.util.List;

public class MainClass
{
    public static void main(String[] args)
    {
    Computer monitor = new Monitor("Samsung", "np22", 300, 32, "TCP", 500);
    Computer videocard = new VideoСard("Nvidia", "2080TI", 500, 6, 12);
    Computer motherboard = new Motherboard("Asus", "ped2134", 222, "DDR4", true);

        List<Computer> computer = new ArrayList<Computer>();

        computer.add(monitor);
        computer.add(videocard);
        computer.add(motherboard);

        for (int i=0; i<computer.size(); i++)
            computer.get(i).Print();

        System.out.println(videocard.equals(monitor));
        System.out.println(videocard.hashCode());
        System.out.println(videocard.toString());
    }
}
