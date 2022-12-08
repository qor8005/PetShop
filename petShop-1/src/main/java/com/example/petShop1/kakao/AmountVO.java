package com.example.petShop1.kakao;

import lombok.Data;

@Data
public class AmountVO {
	//금액 클라스
	 private Integer total, tax_free, vat, point, discount;
	 //전체결제 금액, 비과세 금액, 부과세 금액, 사용한 포인트 금액, 할인금액
}
