import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: liujingxiang
 * @time: 2020/12/15 20:58
 */
public class sap01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        List<String> strings=new ArrayList<String>();
        do {
            String s = scanner.nextLine();
            strings.add(s);

            n--;
        }while (n>=0);

        for (int i= 1; i<strings.size(); i++){
            boolean b = strings.get(i).contains("Did Li Hua go to university");
            if (b){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }

    }
}
