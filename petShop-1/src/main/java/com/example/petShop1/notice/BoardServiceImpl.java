package com.example.petShop1.notice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.petShop1.table.Customer;
import com.example.petShop1.table.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
	private final BoardRepository repository;
	private final CustomerRepository customerRepository;
	
	@Override
	public void register(Board board, String id) throws Exception{
		
		Optional<Customer> customer = customerRepository.findById(id);
		board.setCustomer(customer.get());
		board.setDat(LocalDateTime.now());
		repository.save(board);
	}
	
	@Override
	public List<Board> list() throws Exception{
		return repository.findAll(Sort.by(Direction.DESC, "bodid"));
	}
	
	@Override
	public Board read(Integer bodid) throws Exception{
		return repository.getOne(bodid);
	}
	
	@Override
	public void modify(Board board) throws Exception{
		Board boardEntity = repository.getOne(board.getBodid());
		
		boardEntity.setTitle(board.getTitle());
		boardEntity.setContents(board.getContents());
		repository.save(boardEntity);
	}
	
	@Override
	public void remove(Integer bodid) throws Exception{
		repository.deleteById(bodid);
	}
	

}