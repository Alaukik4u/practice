package wrapper.recursion.IBH;

public class TowerOFHanoi {
    public static void main(String[] args) {
        int n=3;

        solve(n, 'S','D', 'H');
    }

    private static void solve(int n, char s, char h, char d) {
        if(n == 1){
            System.out.println("moving plate "+n+ " from "+s +"to"+ d);
            return;
        }

        solve(n-1, s, d, h);
        System.out.println("moving plate "+n+ " from "+s +"to"+ d);
        solve(n-1, h, s, d);
    }
}