package Computer;

public class Monitor extends Computer
{
    private String typeMatrix;
    private int lengthDiagonal,fps;

    public Monitor()
    {
        super();
        lengthDiagonal = 0;
        typeMatrix = " ";
        fps = 0;
    }

    public Monitor(String maker, String model, int price, int lengthDiagonal, String typeMatrix, int fps)
    {
    super(maker, model, price);
    this.lengthDiagonal = lengthDiagonal;
    this.typeMatrix = typeMatrix;
    this.fps = fps;
    }

    @Override
    public void Print()
    {
    System.out.println("Монитор\nМарка: " + maker + "\nМодель: " + model + "\nДлинна диагонали: "
            + lengthDiagonal + "\nТип матрицы: " + typeMatrix + "\nFPS: " + fps + "\n");
    }
}
