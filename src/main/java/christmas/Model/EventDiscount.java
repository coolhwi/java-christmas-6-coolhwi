package christmas.Model;

public class EventDiscount {
    private int christmasDDayDiscount=0;
    private int dailyDiscount = 0;
    private int weekendDiscount = 0;
    private int specialDiscount = 0;
    private boolean isGiftEvent = false;
    private String badge = "";
    private int totalMoney = 0;
    private int totalBenefitMoney = 0;

    public int getTotalBenefitMoney() {
        return totalBenefitMoney;
    }

    public void setTotalBenefitMoney() {
        totalBenefitMoney = christmasDDayDiscount + dailyDiscount + weekendDiscount + specialDiscount ;
        if(isGiftEvent){
            totalBenefitMoney += 25000;
        }
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }


    public int getChristmasDDayDiscount() {
        return christmasDDayDiscount;
    }

    public void setChristmasDDayDiscount(int christmasDDayDiscount) {
        this.christmasDDayDiscount = christmasDDayDiscount;
    }

    public int getDailyDiscount() {
        return dailyDiscount;
    }

    public void setDailyDiscount(int dailyDiscount) {
        this.dailyDiscount = dailyDiscount;
    }

    public int getWeekendDiscount() {
        return weekendDiscount;
    }

    public void setWeekendDiscount(int weekendDiscount) {
        this.weekendDiscount = weekendDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public void setSpecialDiscount(int specialDiscount) {
        this.specialDiscount = specialDiscount;
    }

    public boolean isGiftEvent() {
        return isGiftEvent;
    }

    public void setGiftEvent(boolean giftEvent) {
        isGiftEvent = giftEvent;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

}
