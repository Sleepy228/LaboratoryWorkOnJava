package MainClass;
import  Product.Product;

public class MainClass
{
    public static void main(String[] args)
    {
        Product [] products = new Product[4];

        products[0] = new Product();
        products[1] = new Product("orange");
        products[2] = new Product("chary", 600);
        products[3] = new Product("tomato", 100, false);

        products[1].Print();
        System.out.println("Общее колличество продуктов: " + Product.Quantity(products));
        System.out.println("Общая стоимость: " + Product.TotalCost(products) + "\n");
        System.out.println("Геттер: " + products[2].getName());

    }
}
