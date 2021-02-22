import java.util.Arrays;
import java.util.NoSuchElementException;

public class StackImpl<T> {
    private int size = 0;
    Object[] array = new Object[10];

    public StackImpl(String[] array) {
        this.array = array;
    }

    public StackImpl() {
    }

    public void push(T item) {
        if (this.size == this.array.length) {
            this.resize(this.array.length * 2);
        }

        this.array[this.size++] = item;
    }

    public T pop() {
        if (--this.size < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            T buff = (T) this.array[this.size];
            this.array[this.size] = null;
            if (this.size == this.array.length / 4 && this.size > 0) {
                this.resize(this.array.length / 2);
            }

            return buff;
        }
    }

    public Object peek() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        } else {
            return this.array[this.size];
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    private void resize(int newSize) {
        this.array = Arrays.copyOf(this.array, newSize);
    }

    public String toString() {
        return Arrays.toString(this.array);
    }
}
