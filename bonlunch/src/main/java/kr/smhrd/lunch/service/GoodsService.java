package kr.smhrd.lunch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.smhrd.lunch.dto.GoodsDto;
import kr.smhrd.lunch.entity.Goods;
import kr.smhrd.lunch.entity.GoodsDetail;
import kr.smhrd.lunch.repository.GoodsDetailRepository;
import kr.smhrd.lunch.repository.GoodsRepository;

@Service
public class GoodsService {
	
	@Autowired
	GoodsRepository goodsRepository;
	
	@Autowired
	GoodsDetailRepository goodsDetailRepository;
	
	// 특정 컴포넌트를 찾지 못한다
	// 내가 만들었나?
	// Autowired -> 작성이 되었는가?
	// 어노테이션 작성 되었는가?
	

	public List<GoodsDto> getGoodsList() {
		
		// 1. 데이터 처리
		// 2. repository 호출
		// 3. Controller 돌려줄 데이터 처리
        List<Goods> goodsList = goodsRepository.findAll();

        List<GoodsDto> returnList = new  ArrayList<GoodsDto>();
		
		for(Goods goods : goodsList) {
			GoodsDto goodsDto = new GoodsDto();
			goodsDto.setId(goods.getId());
			goodsDto.setIsBest(goods.getIsBest());
			goodsDto.setIsNew(goods.getIsNew());
			goodsDto.setMain_thumb(goods.getMain_thumb());
			goodsDto.setName(goods.getName());
			goodsDto.setPrice(goods.getPrice());
			returnList.add(goodsDto);
		}
        // Entity → DTO 변환
        return returnList;
    }

	public GoodsDto getGoodsDetail(int id) {
		// id값을 가지고 제품 정보 굿즈 가지고 오기
		Goods goods = goodsRepository.findById(id).orElse(null);
		GoodsDetail detail = goodsDetailRepository.findById(id).orElse(null);
		
		if(goods == null || detail == null) {
			
			return null;
		}
		
		GoodsDto dto = new GoodsDto();
		dto.setId(goods.getId());
		dto.setPrice(goods.getPrice());
		dto.setName(goods.getName());
		dto.setIsNew(goods.getIsNew());
		dto.setIsBest(goods.getIsBest());
		dto.setMain_thumb(goods.getMain_thumb());
		dto.setDetail(detail);
		
		return dto;
	}

	
		

}
