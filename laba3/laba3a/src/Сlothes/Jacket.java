package Сlothes;

public class Jacket extends Clothes
{
   protected String season;
   protected boolean availHood;

    public Jacket()
    {
        super();
        season = " ";
        availHood = true;
    }

    public Jacket(String maker, String style, int price, String season)
    {
        super(maker, style, price);
        this.season = season;
        availHood = false;
    }

    public Jacket(String maker, String style, int price, String season, boolean availHood)
    {
        super(maker, style, price);
        this.season = season;
        this.availHood = availHood;
    }

    public void Print()
    {
        System.out.println("Производитель: " + maker +";\nСтиль: "
                + style + ";\nЦена: " + price + ";\nСезонность: " + season
                    + ";\nНаличие капюшона: " + availHood + "\n");
    }
}
