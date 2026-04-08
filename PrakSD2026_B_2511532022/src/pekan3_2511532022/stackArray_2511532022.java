package pekan3_2511532022;

public class stackArray_2511532022{
    static final int MAX = 1000;
    int top;
    int a[] = new int[MAX];
    boolean isEmpty() {
        return (top < 0);
    }
    stackArray_2511532022() {
        top = -1;
    }
    boolean push(int x) {
        if (top >= (MAX - 1)) {
            System.out.println("Stack overflow");
            return false;
        } else {
            a[++top] = x;
            System.out.println(x + " masukkan ke dalam stack");
            return true;
        }
    }
    int pop() {
        if (top < 0) {
            System.out.println("Stack underflow");
            return 0;
        }
        else {
            int x = a[top--];
            return x;
        }   
    }
    int peek() {
        if (top < 0) {
            System.out.println("Stack underflow");
            return 0;
        }
        else {
            int x = a[top];
            return x;
        }
    }
    void print(){
        for (int i = top; i >= 1; i--) {
            System.out.println(" " + a[i]);
        }
    }
}

