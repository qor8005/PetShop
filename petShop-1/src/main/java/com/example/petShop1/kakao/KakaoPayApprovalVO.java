package com.example.petShop1.kakao;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class KakaoPayApprovalVO {
	//결제승인 클라스
    //response : 카카오한테서 데이터를 받는다(결제승인)
    private String aid, tid, cid, sid;
    //요청고유번호, 결제고유번호, 가맹점코드, 정기결제ID(정기결제 -> 단건결제할때 사용)
    private String partner_order_id, partner_user_id, payment_method_type;
    //가맹점 주문번호, 가맹점 회원 ID, 결제수단
    private AmountVO amount;
    //결제금액정보
    private CardVO card_info;
    //결제수단이 카드일때만 결제상세정보 보기가능
    private String item_name, item_code, payload;
    //상품이름, 상품코드, 결제승인 요청시 저장한값(요청시 전달내용)
    private Integer quantity, tax_free_amount, vat_amount;
    //상품수량, 상품 비과세금액, 상품 부과세 금액
    private Date created_at, approved_at;
    //결제준비 요청 시간, 결제승인 시각
    
    /*
    private List<KakaoPayApprovalVO> kakaoVOList;
    
    public List<KakaoPayApprovalVO> getKakaoVOList(){
    	return kakaoVOList;
    }
    public void setKakaoVOList(List<KakaoPayApprovalVO> kakaoVOList) {
    	this.kakaoVOList = kakaoVOList;
    }
    */
}