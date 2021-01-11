package Clothes;

public abstract class Clothes implements IndividTask, Object
{
    protected String maker, style;
    protected int price;

    Clothes()
    {
        maker = " ";
        style = " ";
        price = 0;
    }

    Clothes (String maker, String style)
    {
        this.maker = maker;
        this.style = style;
    }

    Clothes (String maker, String style, int price)
    {
        this(maker, style);
        this.price = price;
    }

    public int getPrice()
    {
        return price;
    }

    public String getMaker()
    {
        return maker;
    }

    public String getStyle()
    {
        return style;
    }
}
