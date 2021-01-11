package Computer;

import java.util.Objects;

public class VideoСard extends Computer
{
    private int gpu, amountVdeoMemory;

    public VideoСard()
    {
        super();
        gpu = 0;
        amountVdeoMemory = 0;
    }

    public VideoСard(String maker, String model, int price, int gpu, int amountVdeoMemory)
    {
        super(maker, model, price);
        this.amountVdeoMemory = amountVdeoMemory;
        this.gpu = gpu;
    }

    @Override
    public void Print()
    {
        System.out.println("Видеокарта\nМарка: " + maker + "\nМодель: " + model + "\nЧастота: "
                + gpu + " Мгц\nОбъем видеопамяти : " + amountVdeoMemory + " Гб\n");
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoСard temp = (VideoСard) o;
        return gpu == temp.gpu && amountVdeoMemory == temp.amountVdeoMemory
                && maker == temp.maker && model == temp.model && price == temp.price;
    }

    @Override
    public int hashCode()
    {
        int result = 7;
        result = 31 * result + gpu;
        result = 31 * result + amountVdeoMemory;
        return result;
    }

    @Override
    public String toString() {
        return "Данные связанные только с видеокартой:" +
                "\nЧастота=" + gpu +
                ", Объем видеопамяти=" + amountVdeoMemory;
    }
}
