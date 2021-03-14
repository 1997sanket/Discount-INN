package com.discountinn.demo.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.discountinn.demo.repositories.StateRepository;
import com.discountinn.demo.models.State;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	StateRepository stateRepo;
	
	@Override
	public List<State> getStates() {
		return (List<State>)this.stateRepo.findAll();
	}

}
