package com.bank.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.BankDto;
import com.bank.entities.Bank;
import com.bank.repo.BankRepo;
import com.bank.serviceinterface.BranchServiceIf;

@Transactional
@Service
public class BankImpl implements BranchServiceIf {

	@Autowired
	private ModelMapper mapper;

	public BankImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("In Bank Impl of Branches");
	}

	@Autowired
	private BankRepo br;

	@Override
	public List<Bank> getAllBrances() {
		// TODO Auto-generated method stub
		List<Bank> list = br.findAll();
		return list;
	}

	@Override
	public String addBranch(Bank e) {
		br.save(e);
		return "Branch Added";
	}

	@Override
	public String updateBank(Bank e) {
		br.save(e);
		return "Branch updated";
	}

	@Override
	public String deleteBranch(Long id) {
		br.deleteById(id);
		return "Branch deleted";
	}

	@Override
	public Bank getByid(Long id) {
		Bank b = br.findByBranchCode(id);
		return b;
	}

	@Override
	public String addBranchDto(BankDto e) {
		// TODO Auto-generated method stub

//		BeanUtils.copyProperties(e, b);
		Bank d = mapper.map(e, Bank.class);
		br.save(d);
		return "Branch added";
	}

}
