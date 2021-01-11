package Clothes;

public class Windbreaker extends Jacket
{
    protected boolean shortened;

    public Windbreaker()
    {
        super();
        shortened = true;
    }

    public Windbreaker(String maker, String style, int price, String season)
    {
        super(maker, style, price, season);
        shortened = false;
    }

    public Windbreaker(String maker, String style, int price, String season, boolean availHood, boolean shortened)
    {
        super(maker, style, price, season, availHood);
        this.shortened = shortened;
    }

    @Override
    public void Brand()
    {
        System.out.println("Ветровка");
    }
    @Override
    public void Print()
    {
        System.out.println("Производитель: " + maker +";\nСтиль: "
                + style + ";\nЦена: " + price + ";\nСезонность: " + season
                + ";\nНаличие капюшона: " + availHood + "\nУкороченная: " + shortened + "\n");
    }
}
