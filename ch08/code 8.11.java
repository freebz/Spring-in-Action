// 코드 8.11  PaymentType 열거형: 결제를 위한 고객의 선택을 정의한다.

package com.springinaction.pizza.domain;
import static org.apache.commons.lang.WordUtils.*;
import java.util.Arrays;
import java.util.List;
public enum PaymentType {
    CASH, CHECK, CREDIT_CARD;
    public static List<PaymentType> asList() {
	PaymentType[] all = PaymentType.values();
	return Arrays.asList(all);
    }
    @Override
    public String toString() {
	return capitalizeFully(name().replace('_', ' '));
    }
}
