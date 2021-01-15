package leetcode;

import java.util.*;

/**
 * @description:
 * @author: liujingxiang
 * @time: 2020/12/20 10:15
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        int value=nums[0];
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                value = nums[i];
                break;
            }
        }
        return value;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        boolean b=false;

        for(int i=0;i<col;i++){
            if(matrix[0][i]==target){
                b=true;
                break;
            }else if(matrix[0][i] >target){
                break;
            }else{
                for (int j=0;j<row;j++){
                    if(matrix[j][i]==target){
                        b=true;
                        break;
                    }
                }
            }
        }
        return b;
    }

    public String replaceSpace(String s) {
        String replace = s.replace(" ", "%20");
        return replace;
    }


    /*public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }*/
    public int[] reversePrint(ListNode head) {
        List<Integer> arr=new ArrayList<Integer>();
        while (head.next!=null){
            arr.add(0,head.val);
            head=head.next;
        }
        int[] a=new int[arr.size()];
        for (int i=0;i<arr.size();i++){
            a[i]=arr.get(i);
        }
        return a;
    }

    public int fib(int n) {
        int a=0,b=1,sum=0;
        for(int i=1;i<=n;i++){
            if(i==1){
                sum=b;
            }else{
                sum=(a+b)%1000000007;
                a=b;
                b=sum;
            }
        }
        return sum;
    }


    public int minArray(int[] numbers) {
        int value=numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]<numbers[i-1]){
                value=numbers[i];
            }
        }
        return value;
    }


    public int hammingWeight(int n) {
        int count=0;
        while (n!=0){
            if(n%2==1){
                count+=1;
            }
            n=n/2;
        }
        return count;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        int root=preorder[0];
        int index=0;
        for(int i=0;i<inorder.length;i++){
            if(root==inorder[i]){
                index=i;
            }
        }
        TreeNode tree=new TreeNode(preorder[0]);

        tree.left=buildTree(Arrays.copyOfRange(preorder,1,preorder.length),Arrays.copyOfRange(inorder,0,index));
        tree.right=buildTree(Arrays.copyOfRange(preorder,1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return tree;
    }


    public boolean exist(char[][] board, String word) {
        boolean b=false;
        if(board.length==0){
            if(word==null){
                return true;
            }else{
                return false;
            }
        }
        int rows=board.length;
        int cols=board[0].length;

        char[] chars = word.toCharArray();

        char[][] temp=board;

        for(int j=0;j<rows;j++){
            for(int k=0;k<cols;k++){
                board=temp;
                if(board[j][k]==chars[0]&&chars.length==1){
                    b=true;
                }
                if(board[j][k]==chars[0]&&chars.length>1){
                    board[j][k]='\0';

                    for(int i=1;i<chars.length;i++){
                        if((j>=1&&board[j-1][k]==chars[i])){
                            board[j-1][k]='\0';
                            j=j-1;
                        }else if(j<rows-1&&board[j+1][k]==chars[i]){
                            board[j+1][k]='\0';
                            j=j+1;
                        }else if(k>=1&&board[j][k-1]==chars[i]){
                            board[j][k-1]='\0';
                            k=k-1;
                        }else if(k<cols-1&&board[j][k+1]==chars[i]){
                            board[j][k+1]='\0';
                            k=k+1;
                        }else{
                            break;
                        }
                        if(i==chars.length-1){
                            b=true;
                        }
                    }
                }
                if(b){
                    break;
                }
            }
            if(b){
                break;
            }
        }
        return b;
    }

    public int[] printNumbers(int n) {
        /*int b=(int)(Math.pow(10,n));
        int[] a=new int[b-1];

        for(int i=0;i<Math.pow(10,n)-1;i++){
            a[i]=i+1;
        }*/
        List<Integer> a=new ArrayList<>();
        for(int i=1;i<Math.pow(10,n);i++){
            a.add(i);
        }

        return a.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[0];
        }
        int rows=matrix.length;//最大行
        int cols=matrix[0].length;//最大列
        int count=rows*cols;
        int[] p=new int[count];

        int row=0,col=0,k=0;
        int minrows=0,mincols=0;//最小行、列

        int f=0;//0:右,1:下,2:左;3:上.
        while(k<count){
            if(f==0){
                for(col=mincols;col<cols;col++){
                    p[k]=matrix[row][col];
                    k++;
                }
                col-=1;
                minrows+=1;
                f=1;
            }else if(f==1){
                for(row=minrows;row<rows;row++){
                    p[k]=matrix[row][col];
                    k++;
                }
                row-=1;
                cols-=1;
                f=2;
            }else if(f==2){
                for(col=cols-1;col>=mincols;col--){
                    p[k]=matrix[row][col];
                    k++;
                }
                col+=1;
                rows-=1;
                f=3;
            }else if(f==3){
                for(row=rows-1;row>=minrows;row--){
                    p[k]=matrix[row][col];
                    k++;
                }
                row+=1;
                mincols+=1;
                f=0;
            }
        }
        return p;
    }

    public int maxSubArray(int[] nums) {
        int sum=-100,max=-100;
        for(int i=0;i<nums.length;i++){
            for(int j=nums.length;j>=i;j--){
                sum=0;
                for(int k=i;k<j;k++){
                    sum+=nums[k];
                }
                if(sum>=max){
                    max=sum;
                }
            }
        }
        return max;
    }

    public char firstUniqChar(String s) {
        if("".equals(s) || s==null){
            return ' ';
        }else{
            char[] cs = s.toCharArray();
            int i,j;
            for(i=0;i<cs.length;i++){
                for(j=i+1;j<cs.length;j++){
                    if(cs[i]==cs[j]){
                        break;
                    }
                }
                if(j==cs.length){
                    break;
                }
            }
            return cs[i];
        }
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        /*if(headA==null || headB==null){
            return null;
        }else{
            ListNode flootA=getFloot(headA);
            ListNode flootB=getFloot(headB);

            ListNode floot=new ListNode(0);

            while(flootA!=null&&flootB!=null){
                if(flootA.val!=flootB.val){
                    break;
                }

                ListNode t=floot.next;
                floot.next=new ListNode(flootA.val);
                floot.next.next=t;

                flootA=flootA.next;
                flootB=flootB.next;
            }
            return floot.next;
        }*/

        if (headA == null || headB == null) {
            return null;
        } else {
            ListNode floot = new ListNode(0);

            while (headA != null) {
                ListNode tempA = headA;
                ListNode tempB = headB;

                while (headA != null && headB != null) {
                    if (headA.val == headB.val) {
                        ListNode t = new ListNode(headA.val);
                        floot.next = t;
                        floot = floot.next;

                        headA = headA.next;
                        headB = headB.next;
                    } else {
                        headB = headB.next;
                    }
                }
                if (headA == null && headB == null) {
                    break;
                } else {
                    floot = new ListNode(0);
                }
                headB = tempB;
                headA = tempA.next;
            }
            return floot.next;
        }
    }

    public String reverseWords(String s) {

        String[] strings = s.split(" ");

        StringBuilder sb=new StringBuilder();

        for(int i=strings.length-1;i>=0;i--){
            if(!"".equals(strings[i])) {
                sb.append(strings[i]);
                sb.append(" ");
            }
        }
        if(sb.length()==0){
            return "";
        }else{
            sb.deleteCharAt(sb.length()-1);
            return sb.toString();
        }
    }

    public String reverseLeftWords(String s, int n) {
        String s1=s.substring(0,n-1);
        String s2=s.substring(n);
        String s3=s2.concat(s1);
        return s3;
    }

    public int lastRemaining(int n, int m) {
        List<Integer> list=new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(i);
        }

        int count=0;
        int step=1;
        while(list.size()!=1){
            if(step%m==0){
                Integer integer = list.remove(count);
                //System.out.println(integer);
                step=1;
            }else{
                count++;
                if(count>=list.size()){
                    count=count%list.size();
                }
                step++;
            }
        }
        System.out.println(list.get(0));
        return list.get(0);
    }


    public int add(int a, int b) {
        //先转成字符串

        char[] A = String.valueOf(a).toCharArray();
        char[] B = String.valueOf(b).toCharArray();
        System.out.println(Arrays.toString(A) +":"+ Arrays.toString(B));
        char[] result=A;
        if(a>=0 && b>=0){
            if(A.length>=B.length){
                int count=0;
                while(count<B.length){
                    int value=(int)B[count];
                    int t=(int)A[A.length-B.length+count];
                    while(value>0){
                        t++;
                        value--;
                    }
                    A[A.length-B.length+count]=(char)t;
                    count++;
                }
                result=A;
            }else{
                int count=0;
                while(count<A.length){
                    int value=(int)A[count]-48;
                    int t=(int)B[B.length-A.length+count]-48;
                    while(value>0){
                        t++;
                        value--;
                    }
                    A[A.length-B.length+count]=(char)(t+48);
                    count++;
                }
                result=B;
            }
        }
        if(a>=0 && b<0){
            if(A.length>=B.length-1){
                int count=1;
                while(count<B.length){
                    int value=(int)B[count];
                    int t=(int)A[A.length-B.length+count];
                    while(value>0){
                        t--;
                        value--;
                    }
                    A[A.length-B.length+count]=(char)t;
                    count++;
                }
                result=A;
            }else{
                int count=0;
                while(count<A.length){
                    int value=(int)A[count]-48;
                    int t=(int)B[B.length-A.length+count]-48;
                    while(value>0){
                        t--;
                        value--;
                    }
                    A[A.length-B.length+count]=(char)(t+48);
                    count++;
                }
                result=B;
            }
        }
        if(a<0 && b>=0){
            if(A.length-1>=B.length){
                int count=0;
                while(count<B.length){
                    int value=(int)B[count]-48;
                    int t=(int)A[A.length-B.length+count]-48;
                    while(value>0){
                        t--;
                        value--;
                    }
                    A[A.length-B.length+count]=(char)(t+48);
                    System.out.println("t:"+A[A.length-B.length+count]);
                    count++;
                }
                result=A;
            }else{
                int count=1;
                while(count<A.length){
                    int value=(int)A[count]-48;
                    int t=(int)B[B.length-A.length+count]-48;
                    while(value>0){
                        t--;
                        value--;
                    }
                    A[A.length-B.length+count]=(char)(t+48);
                    count++;
                }
                result=B;
            }
        }
        if(a<0 && b<0) {
            if (A.length >= B.length) {
                int count = 1;
                while (count < B.length) {
                    int value = (int) B[count]-48;
                    int t = (int) A[A.length - B.length + count]-48;
                    while (value > 0) {
                        t++;
                        value--;
                    }
                    A[A.length-B.length+count]=(char)(t+48);
                    count++;
                }
                result = A;
            } else {
                int count = 1;
                while (count < A.length) {
                    int value = (int) A[count]-48;
                    int t = (int) B[B.length - A.length + count]-48;
                    while (value > 0) {
                        t++;
                        value--;
                    }
                    A[A.length-B.length+count]=(char)(t+48);
                    count++;
                }
                result = B;
            }
        }

        System.out.println(result);
        return Integer.parseInt(String.valueOf(result));
    }


    public static void main(String[] args) {
        Solution s=new Solution();
        char[][] c={{'c','a','a'},{'a','a','a'},{'b','c','d'}};
        //boolean b=s.exist(c,"aab");

        int[] nums=new int[]{-1};
        //int b=s.maxSubArray(nums);

        //s.reverseWords("  hello world!  ");

        //s.lastRemaining(10,17);

        s.add(-123,123);
        //System.out.println(b);
    }
}
