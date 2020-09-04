package com.xbl.ecommerce.sign;

public class SignService {
    private int DEFAULT_POINT = 1;
    private int MAX_POINT = 7;
    private int HOLIDAY_INCREMENT = 1;
    SignRepository signRepository;

    public SignService(SignRepository signRepository) {
        this.signRepository = signRepository;
    }

    public SignVo sign() {
        Sign lastSign = signRepository.getLastSign();
        int totalPoint = signRepository.getTotalPoint();
        boolean isHoliday = signRepository.getIsHoliday();
        boolean repeat = lastSign.getRepeat();
        if (repeat) {
            return getRepeatSignVo(lastSign, totalPoint);
        }
        int point = DEFAULT_POINT;
        if (isHoliday) {
            point += HOLIDAY_INCREMENT;
        }
        SignVo signVo = null;
        boolean continues = lastSign.getContinues();
        if (!continues) {
            signVo = getNotContinuesSignVo(totalPoint, point);
        }

        if (continues) {
            int signCount = signRepository.getSignCount();
            signVo = getContinuesSignVo(totalPoint, signCount, isHoliday);
        }
        signRepository.save(signVo);
        return signVo;
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
        return signRepository.getIsHoliday();
    }

    public int getSignCount() {
        return signRepository.getSignCount();
    }

    public int getTotalPoint() {
        return signRepository.getTotalPoint();
    }

    public Sign getLastSign() {
        return signRepository.getLastSign();
    }
}
