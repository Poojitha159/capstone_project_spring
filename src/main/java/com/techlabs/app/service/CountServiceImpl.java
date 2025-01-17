package com.techlabs.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.app.dto.ReportsDto;
import com.techlabs.app.repository.AgentRepository;
import com.techlabs.app.repository.CustomerRepository;
import com.techlabs.app.repository.EmployeeRepository;
import com.techlabs.app.repository.InsurancePolicyRepository;

@Service
public class CountServiceImpl {
	 @Autowired
	    private CustomerRepository customerRepository;

	    @Autowired
	    private AgentRepository agentRepository;

	    @Autowired
	    private EmployeeRepository employeeRepository;

	    @Autowired
	    private InsurancePolicyRepository policyRepository;

	 
	    public ReportsDto getAllReportCount() {
	        ReportsDto reportsDto = new ReportsDto();
	        reportsDto.setAgentCount(agentRepository.count());
	        reportsDto.setCustomerCount(customerRepository.count());
	        reportsDto.setEmployeeCount(employeeRepository.count());
	        reportsDto.setPolicyCount(policyRepository.count());
	        if (reportsDto.getCustomerCount() != 0) {
	            reportsDto.setCustomerPolicyRatio((double) (reportsDto.getPolicyCount() / reportsDto.getCustomerCount()));
	        } else {
	            reportsDto.setCustomerPolicyRatio(0D);
	        }
	        return reportsDto;
	    }

}
