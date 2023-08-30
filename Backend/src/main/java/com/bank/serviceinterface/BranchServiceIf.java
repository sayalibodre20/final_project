package com.bank.serviceinterface;

import java.util.List;

import com.bank.dto.BankDto;
import com.bank.entities.Bank;

public interface BranchServiceIf {

	List<Bank> getAllBrances();
	String addBranch (Bank e);
	String updateBank(Bank e);
	String deleteBranch(Long id);
	Bank getByid(Long id);
	String addBranchDto (BankDto e);
}
