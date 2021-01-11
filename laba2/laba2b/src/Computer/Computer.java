package Computer;

public abstract class Computer implements PrintInfo
{
   protected String maker, model;
   protected int price;

   public Computer()
   {
       maker = " ";
       model = " ";
       price = 0;
   }
   public Computer(String maker, String model, int price)
   {
       this.maker = maker;
       this.model = model;
       this.price = price;
   }

    public int getPrice() {
        return price;
    }
    public String getMaker() {
        return maker;
    }
    public String getModel() {
        return model;
    }
}
