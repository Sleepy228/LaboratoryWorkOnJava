package Clothes;

public class Cardigan extends Clothes
{
    protected int sleeveLength, percentWool;

    public Cardigan()
    {
        super();
        sleeveLength = 0;
        percentWool = 0;
    }

    public Cardigan(String maker, String style, int price, int sleeveLength, int percentWool)
    {
        super(maker, style, price);
        this.sleeveLength = sleeveLength;
        this.percentWool = percentWool;
    }

    public Cardigan(String maker, String style, int price, int sleeveLength)
    {
        super(maker, style, price);
        this.sleeveLength = sleeveLength;
        percentWool = 0;
    }

    @Override
    public void Brand()
    {
        System.out.println("Кофта");
    }
    @Override
    public void Print()
    {
        System.out.println("Производитель: " + maker +";\nСтиль: "
                + style + ";\nЦена: " + price + ";\nДлинна рукава: " + sleeveLength
                + ";\nПроцент шерсти: " + percentWool + "%\n");
    }
}
