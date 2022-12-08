package com.example.petShop1.kakao;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data //기본적인 getter, setter 생성
public class KakaoPayReadyVO {
	//결제요청 클라스
    //response : 카카오한테서 데이터를 받는다(결제요청)
    private String tid, next_redirect_pc_url;
    //결제고유번호, 요청한 클라이언트가 pc일때 결제메시지를 보냄
    private Date created_at;
    //결제준비 요청 시간
    
    /*
    private List<KakaoPayReadyVO> readyVOList;
    
    public List<KakaoPayReadyVO> getReadyVOList(){
    	return readyVOList;
    }
    public void setReadyVOList(List<KakaoPayReadyVO> readyVOList) {
    	this.readyVOList = readyVOList;
    }
    */
}
