package pekan3_2511532022;
public class stackArrayDriver_2511532022 {
    public static void main(String args[]) {
        stackArray_2511532022 s = new stackArray_2511532022();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " dikeluarkan dari stack");
        System.out.println("Elemen teratas stack adalah: " + s.peek());
        System.out.println("Elemen pada stack:");
        s.print();
    }
}