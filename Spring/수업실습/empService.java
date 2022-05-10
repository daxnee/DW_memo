package com.example.first_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.first_spring.mapper.EmpMapper;
import com.example.first_spring.vo.EmpVO;

@Service
public class EmpService {
	
	@Autowired
	private EmpMapper empMapper;
	
	
	public List<EmpVO> getAllempList(){
		return empMapper.getEmpList();	
	}
	
	public List<EmpVO> getEmpName() {
		return empMapper.getEmpName();
	}
	
	public List<EmpVO> getEmpComm(){
		return empMapper.getEmpComm();
	}
	
	public List<EmpVO> getEmpHireDate(){
		return empMapper.getEmpHireDate();
	}
	
	public List<EmpVO> selectEmpMaxSal(String hiredate){
		return empMapper.selectEmpMaxSal(hiredate);
	}
	
	public EmpVO getEmp(int empno) {
		return empMapper.getEmp(empno);
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public List<EmpVO> selectEmpWhereJobAndSal(String job, int sal) {
		if(job.equals("SALESMAN")) {// 만약 job이 salesman이라면 return null;  
			return null;
		}
		List<EmpVO> list = empMapper.selectEmpWhereJobAndSal(job, sal);
		int comm = 500; //커미션
		int rows = 0;
		
		for(int i=0; i<list.size(); i++) {
			// 만약 기존에 있던 포인트에 합산을 원하는 로직을 구현한다면
//			int empComm = list.get(i).getComm();
//			int sum = empComm + comm;
//			list.get(i).setComm(sum);
			
			list.get(i).setComm(comm);
			EmpVO vo = list.get(i);
			vo.setComm(comm);
			rows += empMapper.updateEmp(vo);
		}
		if(rows>0) {
			return empMapper.selectEmpWhereJobAndSal(job, sal);
		}
		
		return null;
	}
	
	public List<EmpVO> selectEmpHowSal(int sal){
		return empMapper.selectEmpHowSal(sal);
	}
	
	public List<EmpVO> selectEmpMgr(){
		return empMapper.selectEmpMgr();
	}
	
	public List<EmpVO> selectEmpHiredate(String hiredate){
		List<EmpVO> list = empMapper.selectEmpHiredate(hiredate);
		int size = list.size();
		if(size <= 3) {
			String year = "1981";
			list = empMapper.selectEmpHiredate(year);
		}
		
		return list;
	} 
	
	//rollbackFor: 이전 commit으로 돌아감
	//Exception : 모든에러를 잡아준다.
	
	//insert
	@Transactional(rollbackFor = {Exception.class})
	public int setEmpInfo(EmpVO empVO) {
		int rows = empMapper.insertEmp(empVO); // 몇 행 insert 되었는지 리턴 
		return rows;
	}
	
	//delete
	@Transactional(rollbackFor = {Exception.class})
	public int getEmpRemoveCount(int empno) {
		int rows = empMapper.deleteEmp(empno);
		return rows; // 몇 행 delete 되었는지 리턴
	}
	
	//update
	@Transactional(rollbackFor = {Exception.class})
	public int getEmpUpdateCount(EmpVO empVO) {
		int rows = empMapper.updateEmp(empVO); // 몇 행 update 되었는지 리턴
		return rows; 
		//return empMapper.updateEmp(vo); //이것도 가능
	}
	
	//0509 문제1


	
	
		
}
