package kr.smhrd.lunch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.smhrd.lunch.BonlunchApplication;
import kr.smhrd.lunch.dto.GoodsDto;
import kr.smhrd.lunch.service.GoodsService;

@CrossOrigin(origins = "http://3.35.176.191:5173")
@RestController
@RequestMapping("/api")
public class GoodsController {

    private final BonlunchApplication bonlunchApplication;
	
	@Autowired
	GoodsService goodsService;

    GoodsController(BonlunchApplication bonlunchApplication) {
        this.bonlunchApplication = bonlunchApplication;
    }
	
		@GetMapping("/goods_list")
		public List<GoodsDto> getGoodsList() {
			System.out.println("[list 출력 컨트롤러]");
			
			
			
			// Step 2 : Service -> Repository 
			return goodsService.getGoodsList();
		}
		
		@GetMapping("/goods_list/{id}")
		public GoodsDto GoodsId(@PathVariable("id") int id) {
			System.out.println("받아온 id값 : " + id);
			GoodsDto goodsDetail = goodsService.getGoodsDetail(id);
			
			
			
			return goodsDetail;
		}
		
	
}
