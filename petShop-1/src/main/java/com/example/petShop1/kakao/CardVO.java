package com.example.petShop1.kakao;

import lombok.Data;

@Data
public class CardVO {
	//카드 클라스
    private String purchase_corp, purchase_corp_code;
    //매입카드사 한글명, 매입카드사 코드
    private String issuer_corp, issuer_corp_code;
    //카드 발급사 한글명, 카드 발급사 코드
    private String bin, card_type, install_month, approved_id, card_mid;
    //카드BIN, 카드타입, 할부개월수, 카드사 승인번호, 카드사 가맹점 번호
    private String interest_free_install, card_item_code;
    //무이자할부 여부(Y/N), 카드상품코드
}
