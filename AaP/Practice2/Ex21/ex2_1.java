package Ex21;

public class ex2_1 {
    public static void m (int x){
        System.out.println("x ="+x);
        if ((2*x+1)<20){
            m(2*x+1);
        }
        System.out.println("x = " +x);
    }
    private static int step=0;
    public static void p(int x) {
        space();
        System.out.println(""+x+"-> ");
        step++;
        if ((2*x+1) <20) {
            p(2*x+1);
        }
        step--;
        space();
        System.out.println(""+x+ " <-");
    }
    public static void space() {
        for (int i = 0; i < step; i++) {
            System.out.println(" ");
        }
    }
    public static int fact(int n){
        int result;
        if (n==1)
            return 1;
        else{
            result=fact(n-1)*n;
            return result;
        }
    }
    public static int f(int n){
        if (n==0){
            return 0;
        }else
        if (n==1){
            return 1;
        } else {
            return f(n-2)+f(n-1);
        }
    }
    public static void main(String[] args){
        m(1);
        p(1);
        System.out.println("факториал = " + fact(4));
        System.out.println(f(3));
    }
}
