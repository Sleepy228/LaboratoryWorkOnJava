package Clothes;

public class DownJacket extends Jacket
{
    protected String filler;

    public DownJacket()
    {
        super();
        filler = " ";
    }

    public DownJacket(String maker, String style, int price, String season)
    {
        super(maker, style, price, season);
        filler = "Пух";
    }

    public DownJacket(String maker, String style, int price, String season, boolean availHood, String filler)
    {
        super(maker, style, price, season, availHood);
        this.filler = filler;
    }

    @Override
    public void Brand()
    {
        System.out.println("Пуховик");
    }
    @Override
    public void Print()
    {
        System.out.println("Производитель: " + maker +";\nСтиль: "
                + style + ";\nЦена: " + price + ";\nСезонность: " + season
                + ";\nНаличие капюшона: " + availHood + ";\nНаполнитель: " + filler +"\n");
    }
}
