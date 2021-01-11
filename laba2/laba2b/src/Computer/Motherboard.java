package Computer;

public class Motherboard extends Computer
{
    private String typeram;
    private boolean overclocking;

    public Motherboard()
    {
    super();
    typeram = " ";
    overclocking = false;
    }

    public Motherboard(String maker, String model, int price, String typeram, boolean overclocking)
    {
        super(maker, model, price);
        this.typeram = typeram;
        this.overclocking = overclocking;
    }

    @Override
    public void Print()
    {
        System.out.println("Материнская плата\nМарка: " + maker + "\nМодель: " + model + "\nОперативная память: "
                + typeram + "\nРазгон : " + overclocking + "\n");
    }
}
