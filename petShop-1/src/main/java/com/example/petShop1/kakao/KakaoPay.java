package com.example.petShop1.kakao;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.petShop1.log.UserInfo;
import com.example.petShop1.shopping.Basket;
import com.example.petShop1.shopping.BasketRepository;
import com.example.petShop1.table.Customer;
import com.example.petShop1.table.CustomerRepository;
import com.example.petShop1.table.Sale;
import com.example.petShop1.table.SaleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@RequiredArgsConstructor
@Service
@Log
public class KakaoPay {

    private static final String HOST = "https://kapi.kakao.com";
    
    private KakaoPayReadyVO kakaoPayReadyVO;
    private KakaoPayApprovalVO kakaoPayApprovalVO;
    
	private final BasketRepository basketRepository;
    private final CustomerRepository customerRepository;
    private final SaleRepository saleRepository;
    private final HttpSession session;
    
    
    public String kakaoPayReady() {
 
        RestTemplate restTemplate = new RestTemplate();
 
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "6a5e2f5fd7261e18d6f085fef9f53e70");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        
		UserInfo users = (UserInfo)session.getAttribute("userInfo");
		String uid = users.getId();
		Optional<Customer> c = customerRepository.findById(uid);
		List<Basket> bList = basketRepository.findByCustomer(c.get());

		params.add("partner_order_id", String.valueOf(1)); //가맹점 주문번호
		
		params.add("cid", "TC0ONETIME"); //가맹점코드
		params.add("partner_user_id", c.get().getId()); //가맹점 회원

		if(bList.size() == 9) {
			params.add("item_name", bList.get(0).getDog().getDogBreed()+" 외 "+String.valueOf((bList.get(0).getNum() - 1) + (bList.get(1).getNum()) + (bList.get(2).getNum()) + (bList.get(3).getNum()) + (bList.get(4).getNum())
					+ (bList.get(5).getNum()) + (bList.get(6).getNum()) + (bList.get(7).getNum()) + (bList.get(8).getNum()))+"마리"); //상품이름
			
	        params.add("quantity",String.valueOf(bList.get(0).getNum() + bList.get(1).getNum() + bList.get(2).getNum() + bList.get(3).getNum() + bList.get(4).getNum() + bList.get(5).getNum() + bList.get(6).getNum() 
	        		+ bList.get(7).getNum() + bList.get(8).getNum())); //상품수량
	        
	        params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice() + bList.get(1).getNum() * bList.get(1).getDog().getPrice() + bList.get(2).getNum() * bList.get(2).getDog().getPrice()
	        		 + bList.get(3).getNum() * bList.get(3).getDog().getPrice() + bList.get(4).getNum() * bList.get(4).getDog().getPrice() + bList.get(5).getNum() * bList.get(5).getDog().getPrice() + bList.get(6).getNum() * bList.get(6).getDog().getPrice()
	        		 + bList.get(7).getNum() * bList.get(7).getDog().getPrice() + bList.get(8).getNum() * bList.get(8).getDog().getPrice())); //상품 총 금액
		}else if(bList.size() == 8) {
			params.add("item_name", bList.get(0).getDog().getDogBreed()+" 외 "+String.valueOf((bList.get(0).getNum() - 1) + (bList.get(1).getNum()) + (bList.get(2).getNum()) + (bList.get(3).getNum()) + (bList.get(4).getNum())
					+ (bList.get(5).getNum()) + (bList.get(6).getNum()) + (bList.get(7).getNum()))+"마리"); //상품이름
			
	        params.add("quantity",String.valueOf(bList.get(0).getNum() + bList.get(1).getNum() + bList.get(2).getNum() + bList.get(3).getNum() + bList.get(4).getNum() + bList.get(5).getNum() + bList.get(6).getNum() 
	        		+ bList.get(7).getNum())); //상품수량
	        
	        params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice() + bList.get(1).getNum() * bList.get(1).getDog().getPrice() + bList.get(2).getNum() * bList.get(2).getDog().getPrice()
	        		 + bList.get(3).getNum() * bList.get(3).getDog().getPrice() + bList.get(4).getNum() * bList.get(4).getDog().getPrice() + bList.get(5).getNum() * bList.get(5).getDog().getPrice() + bList.get(6).getNum() * bList.get(6).getDog().getPrice()
	        		 + bList.get(7).getNum() * bList.get(7).getDog().getPrice())); //상품 총 금액
		}else if(bList.size() == 7) {
			params.add("item_name", bList.get(0).getDog().getDogBreed()+" 외 "+String.valueOf((bList.get(0).getNum() - 1) + (bList.get(1).getNum()) + (bList.get(2).getNum()) + (bList.get(3).getNum()) + (bList.get(4).getNum())
					+ (bList.get(5).getNum()) + (bList.get(6).getNum()))+"마리"); //상품이름
			
	        params.add("quantity",String.valueOf(bList.get(0).getNum() + bList.get(1).getNum() + bList.get(2).getNum() + bList.get(3).getNum() + bList.get(4).getNum() + bList.get(5).getNum() + bList.get(6).getNum())); //상품수량
	        
	        params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice() + bList.get(1).getNum() * bList.get(1).getDog().getPrice() + bList.get(2).getNum() * bList.get(2).getDog().getPrice()
	        		 + bList.get(3).getNum() * bList.get(3).getDog().getPrice() + bList.get(4).getNum() * bList.get(4).getDog().getPrice() + bList.get(5).getNum() * bList.get(5).getDog().getPrice() + bList.get(6).getNum() * bList.get(6).getDog().getPrice())); //상품 총 금액
		}else if(bList.size() == 6) {
			params.add("item_name", bList.get(0).getDog().getDogBreed()+" 외 "+String.valueOf((bList.get(0).getNum() - 1) + (bList.get(1).getNum()) + (bList.get(2).getNum()) + (bList.get(3).getNum()) + (bList.get(4).getNum())
					+ (bList.get(5).getNum()))+"마리"); //상품이름
			
			params.add("quantity",String.valueOf(bList.get(0).getNum() + bList.get(1).getNum() + bList.get(2).getNum() + bList.get(3).getNum() + bList.get(4).getNum() + bList.get(5).getNum())); //상품수량
	        
	        params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice() + bList.get(1).getNum() * bList.get(1).getDog().getPrice() + bList.get(2).getNum() * bList.get(2).getDog().getPrice()
	        		 + bList.get(3).getNum() * bList.get(3).getDog().getPrice() + bList.get(4).getNum() * bList.get(4).getDog().getPrice() + bList.get(5).getNum() * bList.get(5).getDog().getPrice())); //상품 총 금액
		}else if(bList.size() == 5) {
			params.add("item_name", bList.get(0).getDog().getDogBreed()+" 외 "+String.valueOf((bList.get(0).getNum() - 1) + (bList.get(1).getNum()) + (bList.get(2).getNum()) + (bList.get(3).getNum()) + (bList.get(4).getNum()))+"마리"); //상품이름
			
			params.add("quantity",String.valueOf(bList.get(0).getNum() + bList.get(1).getNum() + bList.get(2).getNum() + bList.get(3).getNum() + bList.get(4).getNum())); //상품수량
	        
	        params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice() + bList.get(1).getNum() * bList.get(1).getDog().getPrice() + bList.get(2).getNum() * bList.get(2).getDog().getPrice()
	        		 + bList.get(3).getNum() * bList.get(3).getDog().getPrice() + bList.get(4).getNum() * bList.get(4).getDog().getPrice())); //상품 총 금액
		}else if(bList.size() == 4) {
			params.add("item_name", bList.get(0).getDog().getDogBreed()+" 외 "+String.valueOf((bList.get(0).getNum() - 1) + (bList.get(1).getNum()) + (bList.get(2).getNum()) + (bList.get(3).getNum()))+"마리"); //상품이름
			
			params.add("quantity",String.valueOf(bList.get(0).getNum() + bList.get(1).getNum() + bList.get(2).getNum() + bList.get(3).getNum())); //상품수량
	        
	        params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice() + bList.get(1).getNum() * bList.get(1).getDog().getPrice() + bList.get(2).getNum() * bList.get(2).getDog().getPrice()
	        		 + bList.get(3).getNum() * bList.get(3).getDog().getPrice())); //상품 총 금액
		}else if(bList.size() == 3) {
			params.add("item_name", bList.get(0).getDog().getDogBreed()+" 외 "+String.valueOf((bList.get(0).getNum() - 1) + (bList.get(1).getNum()) + (bList.get(2).getNum()))+"마리"); //상품이름
			
			params.add("quantity",String.valueOf(bList.get(0).getNum() + bList.get(1).getNum() + bList.get(2).getNum())); //상품수량
	        
	        params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice() + bList.get(1).getNum() * bList.get(1).getDog().getPrice() + bList.get(2).getNum() * bList.get(2).getDog().getPrice())); //상품 총 금액
		}else if(bList.size() == 2) {
			params.add("item_name", bList.get(0).getDog().getDogBreed()+" 외 "+String.valueOf((bList.get(0).getNum() - 1) + (bList.get(1).getNum()))+"마리"); //상품이름
			
	        params.add("quantity",String.valueOf(bList.get(0).getNum()+bList.get(1).getNum())); //상품수량
	        
	        params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice() + bList.get(1).getNum() * bList.get(1).getDog().getPrice())); //상품 총 금액
		}else if(bList.size() == 1) {
			params.add("item_name", bList.get(0).getDog().getDogBreed()+" 외 "+String.valueOf((bList.get(0).getNum() - 1))+"마리"); //상품이름
			
	        params.add("quantity",String.valueOf(bList.get(0).getNum())); //상품수량
	        
	        params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice())); //상품 총 금액
		}
        
		
		params.add("tax_free_amount", "100");//부과세금액
        params.add("approval_url", "http://localhost/kakaoPaySuccess"); //결제성공시 페이지 사이트
        params.add("cancel_url", "http://localhost/kakaoPayCancel"); //결제취소시 페이지 사이트
        params.add("fail_url", "http://localhost/kakaoPaySuccessFail"); //결제실패시 페이지 사이트
 
         HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
 
        try {
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
            return kakaoPayReadyVO.getNext_redirect_pc_url(); // PC로 결제요청 했을때 실행
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "/pay";
    }
    
    public KakaoPayApprovalVO kakaoPayInfo(String pg_token) {
    	//결제승인
        
        RestTemplate restTemplate = new RestTemplate();
 
        // 서버에서 응답하는 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "6a5e2f5fd7261e18d6f085fef9f53e70");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
 
        // 서버에서 응답하는 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        
		UserInfo users = (UserInfo)session.getAttribute("userInfo");
		String uid = users.getId();
		Optional<Customer> c = customerRepository.findById(uid);
		List<Basket> bList = basketRepository.findByCustomer(c.get());

		
		params.add("partner_order_id", String.valueOf(1)); //가맹점 주문번호
		
        params.add("cid", "TC0ONETIME"); //가맹점코드
        params.add("tid", kakaoPayReadyVO.getTid()); //결제고유번호
        params.add("partner_user_id", c.get().getId()); //가맹점 회원ID

        if(bList.size() == 9) {
	        params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice() + bList.get(1).getNum() * bList.get(1).getDog().getPrice() + bList.get(2).getNum() * bList.get(2).getDog().getPrice()
	        		 + bList.get(3).getNum() * bList.get(3).getDog().getPrice() + bList.get(4).getNum() * bList.get(4).getDog().getPrice() + bList.get(5).getNum() * bList.get(5).getDog().getPrice() + bList.get(6).getNum() * bList.get(6).getDog().getPrice()
	        		 + bList.get(7).getNum() * bList.get(7).getDog().getPrice() + bList.get(8).getNum() * bList.get(8).getDog().getPrice())); //상품 총 금액
        }else if(bList.size() == 8) {
	        params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice() + bList.get(1).getNum() * bList.get(1).getDog().getPrice() + bList.get(2).getNum() * bList.get(2).getDog().getPrice()
	        		 + bList.get(3).getNum() * bList.get(3).getDog().getPrice() + bList.get(4).getNum() * bList.get(4).getDog().getPrice() + bList.get(5).getNum() * bList.get(5).getDog().getPrice() + bList.get(6).getNum() * bList.get(6).getDog().getPrice()
	        		 + bList.get(7).getNum() * bList.get(7).getDog().getPrice())); //상품 총 금액
        }else if(bList.size() == 7) {
	        params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice() + bList.get(1).getNum() * bList.get(1).getDog().getPrice() + bList.get(2).getNum() * bList.get(2).getDog().getPrice()
	        		 + bList.get(3).getNum() * bList.get(3).getDog().getPrice() + bList.get(4).getNum() * bList.get(4).getDog().getPrice() + bList.get(5).getNum() * bList.get(5).getDog().getPrice() + bList.get(6).getNum() * bList.get(6).getDog().getPrice())); //상품 총 금액
        }else if(bList.size() == 6) {
	        params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice() + bList.get(1).getNum() * bList.get(1).getDog().getPrice() + bList.get(2).getNum() * bList.get(2).getDog().getPrice()
	        		 + bList.get(3).getNum() * bList.get(3).getDog().getPrice() + bList.get(4).getNum() * bList.get(4).getDog().getPrice() + bList.get(5).getNum() * bList.get(5).getDog().getPrice())); //상품 총 금액
        }else if(bList.size() == 5) {
	        params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice() + bList.get(1).getNum() * bList.get(1).getDog().getPrice() + bList.get(2).getNum() * bList.get(2).getDog().getPrice()
	        		 + bList.get(3).getNum() * bList.get(3).getDog().getPrice() + bList.get(4).getNum() * bList.get(4).getDog().getPrice())); //상품 총 금액
        }else if(bList.size() == 4) {
	        params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice() + bList.get(1).getNum() * bList.get(1).getDog().getPrice() + bList.get(2).getNum() * bList.get(2).getDog().getPrice()
	        		 + bList.get(3).getNum() * bList.get(3).getDog().getPrice())); //상품 총 금액
        }else if(bList.size() == 3) {
	        params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice() + bList.get(1).getNum() * bList.get(1).getDog().getPrice() + bList.get(2).getNum() * bList.get(2).getDog().getPrice())); //상품 총 금액
        }else if(bList.size() == 2) {
        	params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice() + bList.get(1).getNum() * bList.get(1).getDog().getPrice())); //상품 총 금액
        }else if(bList.size() == 1) {
        	params.add("total_amount", String.valueOf(bList.get(0).getNum() * bList.get(0).getDog().getPrice())); //상품 총 금액
        }

        params.add("pg_token", pg_token); //결제승인 정보들?
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        
        try {
            kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
            return kakaoPayApprovalVO;
        
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}