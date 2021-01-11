package MainClass;

import Сlothes.*;

public class WriterInfo
{
    public static void main(String[] args)
    {
        Clothes clothes1 = new Blouse("Гучи", "Спортивный", 300, 30, 66);
        Clothes clothes2 = new Jacket("Адидас","Классика", 328, "Демисезон");
        Clothes clothes3 = new Trousers("Найк", "Гранж", 300, true);

        System.out.println("Гетт методы:\n1)" + clothes1.getMaker() + "\n2)"
                + clothes2.getMaker() + "\n3)" + clothes3.getMaker() + "\n");

        clothes1.Print();
        clothes2.Print();
        clothes3.Print();
    }
}
