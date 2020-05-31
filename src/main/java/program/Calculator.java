package program;

public class Calculator {
    public boolean isFirst(int a) {
        boolean isFirst = false;
            int counter = 0;
            if(a > 1){
        for(int i = 1; i < a;i++){
            if(a % i == 0 && counter < 2){
                isFirst = true;
                counter ++;
            }
        }
            }
    return  isFirst;
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.isFirst(6));
    }
}
