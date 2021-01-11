package Сlothes;

public class Trousers extends Clothes
{
    boolean flared;

    public Trousers()
    {
        super();
        flared = false;
    }

    public Trousers(String maker, String style, int price, boolean flared)
    {
        super(maker, style, price);
        this.flared = flared;
    }

    public Trousers(String maker, String style, int price)
    {
        super(maker, style, price);
        flared = false;
    }

    public void Print()
    {
        System.out.println("Производитель: " + maker +";\nСтиль: "
                + style + ";\nЦена: " + price + ";\nИзношенные: " + flared + "\n");
    }
}
