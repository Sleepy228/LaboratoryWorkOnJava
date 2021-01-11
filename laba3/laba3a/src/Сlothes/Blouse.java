package Сlothes;

public class Blouse extends  Clothes
{
    protected int sleeveLength, percentWool;

   public Blouse()
    {
        super();
        sleeveLength = 0;
        percentWool = 0;
    }

   public Blouse(String maker, String style, int price, int sleeveLength, int percentWool)
    {
     super(maker, style, price);
     this.sleeveLength = sleeveLength;
     this.percentWool = percentWool;
    }

   public Blouse(String maker, String style, int price, int sleeveLength)
    {
        super(maker, style, price);
        this.sleeveLength = sleeveLength;
        percentWool = 0;
    }

    public void Print()
    {
        System.out.println("Производитель: " + maker +";\nСтиль: "
                + style + ";\nЦена: " + price + ";\nДлинна рукава: " + sleeveLength
                + ";\nПроцент шерсти: " + percentWool + "%\n");
    }
}
