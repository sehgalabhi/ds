package com.enums;

public class StrategyEnumPattern {
    public static void main(String[] args) {
        PayRollDay payRollDay = PayRollDay.Monday;
        System.out.println(payRollDay.pay());
        PayRollDay payRollDay1 = PayRollDay.Sunday;
        System.out.println(payRollDay1.pay());


    }
}


enum PayRollDay{
    Monday(PayType.WEEKDAY), Tuesday(PayType.WEEKDAY), Wednesday(PayType.WEEKDAY), Thursday(PayType.WEEKDAY), Friday(PayType.WEEKDAY), Saturday(PayType.WEEKEND), Sunday(PayType.WEEKEND);


    private final PayType payType;
    PayRollDay(PayType payType) {
        this.payType = payType;
    }

    double pay(){
        return  payType.overtimePay();
    }

    private enum PayType{
        WEEKDAY {double overtimePay(){
            return 1;
        }},
        WEEKEND {double overtimePay(){
            return 2;
        }};

        abstract double overtimePay();
    }
}
