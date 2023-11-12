package christmas.Model;

import java.util.HashMap;

public class Consumer {
    private int date=0;
    private HashMap<String,Integer> menuAndNum = new HashMap<>();
    private HashMap<String,Integer> discountDetail = new HashMap<>();


    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public HashMap<String, Integer> getMenuAndNum() {
        return menuAndNum;
    }

    public void setMenuAndNum(HashMap<String, Integer> menuAndNum) {
        this.menuAndNum = menuAndNum;
    }

    public HashMap<String, Integer> getDiscountDetail() {
        return discountDetail;
    }

    public void setDiscountDetail(HashMap<String, Integer> discountDetail) {
        this.discountDetail = discountDetail;
    }

}
