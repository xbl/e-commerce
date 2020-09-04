package com.xbl.ecommerce.sign;

public class SignService {
    private int DEFAULT_POINT = 1;
    private int MAX_POINT = 7;
    private int HOLIDAY_INCREMENT = 1;
    public SignVo sign() {
        SignVo signVo = null;
        Sign lastSign = getLastSign();
        boolean continues = lastSign.getContinues();
        int totalPoint = getTotalPoint();
        boolean isHoliday = getIsHoliday();
        boolean repeat = lastSign.getRepeat();
        if (repeat) {
            return getRepeatSignVo(lastSign, totalPoint);
        }
        int point = DEFAULT_POINT;
        if (isHoliday) {
            point += HOLIDAY_INCREMENT;
        }
        if (!continues) {
            return getNotContinuesSignVo(totalPoint, point);
        }

        if (continues) {
            int signCount = getSignCount();
            return getContinuesSignVo(totalPoint, signCount, isHoliday);
        }
        return null;
    }

    private SignVo getContinuesSignVo(int totalPoint, int signCount, boolean isHoliday) {
        int point;
        SignVo signVo;
        signVo = new SignVo();
        point = signCount;
        if (isHoliday) {
            point += HOLIDAY_INCREMENT;
        }
        point = Math.min(point, MAX_POINT);

        signVo.setPoint(point);
        signVo.setTotalPoint(totalPoint + point);
        return signVo;
    }

    private SignVo getNotContinuesSignVo(int totalPoint, int point) {
        SignVo signVo;
        signVo = new SignVo();
        signVo.setPoint(point);
        signVo.setTotalPoint(totalPoint + point);
        return signVo;
    }

    private SignVo getRepeatSignVo(Sign lastSign, int totalPoint) {
        SignVo signVo;
        signVo = new SignVo();
        signVo.setPoint(lastSign.getPoint());
        signVo.setTotalPoint(totalPoint);
        signVo.setRepeat(true);
        return signVo;
    }

    public boolean getIsHoliday() {
        return false;
    }

    public int getSignCount() {
        return 0;
    }

    public int getTotalPoint() {
        return 0;
    }

    public Sign getLastSign() {
        return new Sign();
    }
}
