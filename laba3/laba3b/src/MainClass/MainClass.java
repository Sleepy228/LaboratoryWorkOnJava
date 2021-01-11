package MainClass;
import Clothes.*;

public class MainClass
{
    public static void main(String[] args)
    {
    Clothes clothes1 = new Cardigan("Гучи", "Спортивный", 119, 30, 66);
    Clothes clothes2 = new Trousers("Найк", "Гранж", 300, true);
    Clothes clothes3 = new DownJacket("Адидас","Классика", 328, "Демисезон", true, "Хлопок");
    Clothes clothes4 = new Windbreaker("Гучи", "Классика", 567, "Лето", false, true);

    System.out.println("Гетт методы:\n1)" + clothes1.getMaker() + "\n2)"
                + clothes2.getMaker() + "\n3)" + clothes3.getMaker() + "\n4)" + clothes4.getMaker() + "\n");

        clothes1.Brand();
        clothes1.Print();

        clothes2.Brand();
        clothes2.Print();

        clothes3.Brand();
        clothes3.Print();

        clothes4.Brand();
        clothes4.Print();
    }
}
