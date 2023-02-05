public class Ladder
{
    private int bottom; //Initial Position of the Ladder
    private int top; //Final Position of the Ladder
    Ladder(int bottom, int top)
    {
        this.bottom = bottom;
        this.top = top;
    }

    public int getBottom()
    {
        return bottom;
    }

    public int getTop()
    {
        return top;
    }
}
