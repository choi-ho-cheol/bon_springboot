package kr.smhrd.lunch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.smhrd.lunch.entity.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Integer>{

	List<Goods> findAll();

}
