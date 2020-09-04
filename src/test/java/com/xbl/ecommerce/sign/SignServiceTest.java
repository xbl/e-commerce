package com.xbl.ecommerce.sign;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SignServiceTest {
    private Sign getYesterdaySign() {
        Sign lastSign = new Sign();
        lastSign.setPoint(1);
        Date yesterday = getYesterday();
        lastSign.setDate(yesterday);
        return lastSign;
    }

    private Date getYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date yesterday = cal.getTime();
        return yesterday;
    }

    @Test
    @DisplayName("Given：签到第1天，When 签到，Then 积分为 1 And 总积分数 1")
    public void given_sign_one_day_when_called_sign_Then_point_was_1_and_total_point_1() {
        SignRepository signRepository = spy(SignRepository.class);
        SignService signService = new SignService(signRepository);
        when(signRepository.getSignCount()).thenReturn(1);
        when(signRepository.getTotalPoint()).thenReturn(0);
        when(signRepository.getLastSign()).thenReturn(new Sign());
        doNothing().when(signRepository).save(any());

        SignVo signVo = signService.sign();

        SignVo expectedSignVo = new SignVo();
        expectedSignVo.setPoint(1);
        expectedSignVo.setTotalPoint(1);

        assertEquals(expectedSignVo, signVo);
        verify(signRepository).save(signVo);
    }

    @Test
    @DisplayName("Given：签到第2天 And 连续签到，When 签到，Then 积分为 2 And 总积分数 3")
    public void given_sign_two_day_when_called_sign_Then_point_was_2_and_total_point_3() {
        SignRepository signRepository = spy(SignRepository.class);
        SignService signService = new SignService(signRepository);
        when(signRepository.getSignCount()).thenReturn(2);
        Sign lastSign = getYesterdaySign();
        when(signRepository.getLastSign()).thenReturn(lastSign);
        when(signRepository.getTotalPoint()).thenReturn(1);

        SignVo signVo = signService.sign();

        SignVo expectedSignVo = new SignVo();
        expectedSignVo.setPoint(2);
        expectedSignVo.setTotalPoint(3);

        assertEquals(expectedSignVo, signVo);
        verify(signRepository).save(signVo);
    }

    @Test
    @DisplayName("Given：未连续，When 签到，Then 积分为 1 And 总积分数 3")
    public void given_sign_two_day_not_continue_when_called_sign_Then_point_was_2_and_total_point_3() {
        SignRepository signRepository = spy(SignRepository.class);
        SignService signService = new SignService(signRepository);
        when(signRepository.getSignCount()).thenReturn(2);
        when(signRepository.getTotalPoint()).thenReturn(2);
        when(signRepository.getLastSign()).thenReturn(new Sign());
        SignVo signVo = signService.sign();

        SignVo expectedSignVo = new SignVo();
        expectedSignVo.setPoint(1);
        expectedSignVo.setTotalPoint(3);

        assertEquals(expectedSignVo, signVo);
        verify(signRepository).save(signVo);
    }

    @Test
    @DisplayName("Given：签到第7天 And 连续签到，When 签到，Then 积分为 7 And 总积分数 28")
    public void given_sign_seven_day_And_continue_when_called_sign_Then_point_was_7_and_total_point_28() {
        SignRepository signRepository = spy(SignRepository.class);
        SignService signService = new SignService(signRepository);
        when(signRepository.getSignCount()).thenReturn(7);
        when(signRepository.getTotalPoint()).thenReturn(21);
        Sign lastSign = getYesterdaySign();
        when(signRepository.getLastSign()).thenReturn(lastSign);
        SignVo signVo = signService.sign();

        SignVo expectedSignVo = new SignVo();
        expectedSignVo.setPoint(7);
        expectedSignVo.setTotalPoint(28);

        assertEquals(expectedSignVo, signVo);
        verify(signRepository).save(signVo);
    }


    @Test
    @DisplayName("Given：签到第8天 And 连续签到，When 签到，Then 积分为 7 And 总积分数 35")
    public void given_sign_8_day_And_continue_when_called_sign_Then_point_was_7_and_total_point_35() {
        SignRepository signRepository = spy(SignRepository.class);
        SignService signService = new SignService(signRepository);
        when(signRepository.getSignCount()).thenReturn(8);
        when(signRepository.getTotalPoint()).thenReturn(28);
        Sign lastSign = getYesterdaySign();
        when(signRepository.getLastSign()).thenReturn(lastSign);
        SignVo signVo = signService.sign();

        SignVo expectedSignVo = new SignVo();
        expectedSignVo.setPoint(7);
        expectedSignVo.setTotalPoint(35);

        assertEquals(expectedSignVo, signVo);
        verify(signRepository).save(signVo);
    }

    @Test
    @DisplayName("Given：签到第1天 And 是节假日，When 签到，Then 积分为 2 And 总积分数 2")
    public void given_sign_1_day_And_holiday_when_called_sign_Then_point_was_2_and_total_point_2() {
        SignRepository signRepository = spy(SignRepository.class);
        SignService signService = new SignService(signRepository);
        when(signRepository.getSignCount()).thenReturn(1);
        when(signRepository.getTotalPoint()).thenReturn(0);
        when(signRepository.getLastSign()).thenReturn(new Sign());
        when(signRepository.getIsHoliday()).thenReturn(true);
        SignVo signVo = signService.sign();

        SignVo expectedSignVo = new SignVo();
        expectedSignVo.setPoint(2);
        expectedSignVo.setTotalPoint(2);

        assertEquals(expectedSignVo, signVo);
        verify(signRepository).save(signVo);
    }

    @Test
    @DisplayName("Given：签到第7天 And 连续签到 And 是节假日，When 签到，Then 积分为 7 And 总积分数 28")
    public void given_sign_7_day_And_holiday_And_continue_when_called_sign_Then_point_was_7_and_total_point_28() {
        SignRepository signRepository = spy(SignRepository.class);
        SignService signService = new SignService(signRepository);
        when(signRepository.getSignCount()).thenReturn(7);
        when(signRepository.getTotalPoint()).thenReturn(21);
        when(signRepository.getIsHoliday()).thenReturn(true);
        Sign lastSign = getYesterdaySign();
        when(signRepository.getLastSign()).thenReturn(lastSign);
        SignVo signVo = signService.sign();

        SignVo expectedSignVo = new SignVo();
        expectedSignVo.setPoint(7);
        expectedSignVo.setTotalPoint(28);

        assertEquals(expectedSignVo, signVo);
        verify(signRepository).save(signVo);
    }

    @Test
    @DisplayName("Given：签到第2天 And 连续签到 And 是节假日，When 签到，Then 积分为 3 And 总积分数 4")
    public void given_sign_2_day_And_holiday_And_continue_when_called_sign_Then_point_was_3_and_total_point_4() {
        SignRepository signRepository = spy(SignRepository.class);
        SignService signService = new SignService(signRepository);
        when(signRepository.getSignCount()).thenReturn(2);
        when(signRepository.getTotalPoint()).thenReturn(1);
        when(signRepository.getIsHoliday()).thenReturn(true);
        Sign lastSign = getYesterdaySign();
        when(signRepository.getLastSign()).thenReturn(lastSign);
        SignVo signVo = signService.sign();

        SignVo expectedSignVo = new SignVo();
        expectedSignVo.setPoint(3);
        expectedSignVo.setTotalPoint(4);

        assertEquals(expectedSignVo, signVo);
        verify(signRepository).save(signVo);
    }

    @Test
    @DisplayName("Given：签到第1天 And 重复签到，When 签到，Then 积分为 1 And 总积分数 1，重复")
    public void given_sign_1_day_And_repeat_when_called_sign_Then_point_was_1_and_total_point_1_repeat_was_true() {
        SignRepository signRepository = mock(SignRepository.class);
        SignService signService = new SignService(signRepository);
        when(signRepository.getSignCount()).thenReturn(1);
        when(signRepository.getTotalPoint()).thenReturn(1);
        Sign lastSign = new Sign();
        lastSign.setPoint(1);
        lastSign.setDate(new Date());
        when(signRepository.getLastSign()).thenReturn(lastSign);

        SignVo signVo = signService.sign();

        SignVo expectedSignVo = new SignVo();
        expectedSignVo.setPoint(1);
        expectedSignVo.setTotalPoint(1);
        expectedSignVo.setRepeat(true);

        assertEquals(expectedSignVo, signVo);
    }
}
