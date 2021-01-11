package Product;

public class Product
{
    protected String name;
    protected  int price;
    protected boolean availability;

    public Product()
    {
        this.name = "apple";
        this.price = 300;
        this.availability = true;
    }

    public Product(String name)
    {
        this.name = name;
        this.price = 500;
        this.availability = true;
    }

    public Product(String name, int price)
    {
        this.name = name;
        this.price = price;
        this.availability = true;
    }

    public Product(String name, int price, boolean availability)
    {
        this.name = name;
        this.price = price;
        this.availability = availability;
    }

    public String getName()
    {
        return this.name;
    }
    public int getPrice()
    {
        return this.price;
    }
    public boolean getAvail()
    {
        return this.availability;
    }

    public static int TotalCost(Product [] products)
    {
        int totalCost = 0;

        for (int i = 0; i < products.length; i++)
            totalCost += products[i].price;

        return  totalCost;
    }

    public static int Quantity(Product [] products)
    {
        int counter = 0;

        for (int i = 0; i < products.length; i++)
            if(products[i].availability == true)
                counter ++;

        return counter;
    }

    public void Print()
    {
        System.out.println("Название: " + this.name + "; \nЦена: "
                + this.price + "; \nНаличие: " + this.availability + ";\n");
    }

}

