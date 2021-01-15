import java.util.Scanner;

/**
 * @description:
 * @author: liujingxiang
 * @time: 2020/12/15 21:24
 */
public class sap02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String z1=scanner.nextLine();
        String z2=scanner.nextLine();
        String[] s1 = z1.split(" ");
        String[] s2 = z2.split(" ");


        float x,y;
        if(Float.parseFloat(s1[0])<Float.parseFloat(s2[0])){
            x=Math.abs((Float.parseFloat(s2[0])-Float.parseFloat(s2[2])/2)-(Float.parseFloat(s1[0])+Float.parseFloat(s1[2])/2));
            if(Float.parseFloat(s1[1])<Float.parseFloat(s2[1])){
                y=Math.abs((Float.parseFloat(s2[1])-Float.parseFloat(s2[2])/2)-(Float.parseFloat(s1[1])+Float.parseFloat(s1[2])/2));
            }else {
                y=Math.abs((Float.parseFloat(s1[1])-Float.parseFloat(s1[2])/2)-(Float.parseFloat(s2[1])+Float.parseFloat(s2[2])/2));
            }
        }else{
            x=Math.abs((Float.parseFloat(s1[0])-Float.parseFloat(s1[2])/2)-(Float.parseFloat(s2[0])+Float.parseFloat(s2[2])/2));
            if(Float.parseFloat(s1[1])<Float.parseFloat(s2[1])){
                y=Math.abs((Float.parseFloat(s2[1])-Float.parseFloat(s2[2])/2)-(Float.parseFloat(s1[1])+Float.parseFloat(s1[2])/2));
            }else {
                y=Math.abs((Float.parseFloat(s1[1])-Float.parseFloat(s1[2])/2)-(Float.parseFloat(s2[1])+Float.parseFloat(s2[2])/2));
            }
        }

        double s=x*y;
        System.out.println(String.format("%.2f",s));

    }
}
