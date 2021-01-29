package test;

public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abc");
        sb.delete(2,3);
        System.out.println(sb);
    }
}
