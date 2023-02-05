public class Snake
{
    private int head; //Head Position of the Snake
    private int tail; // Tail Position of the Snake
    Snake(int head, int tail)
    {
        this.head = head;
        this.tail = tail;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }
}
