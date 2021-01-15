package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: liujingxiang
 * @time: 2020/12/20 13:53
 */
class CQueue {
    private List<Integer> arr;
    public CQueue() {
        arr=new ArrayList<>();

    }

    public void appendTail(int value) {
        arr.add(value);
        arr.isEmpty();
    }

    public int deleteHead() {
        int re;
        if (arr.size()==0){
            re = -1;
        }
        re=arr.remove(0);
        return re;
    }
}
