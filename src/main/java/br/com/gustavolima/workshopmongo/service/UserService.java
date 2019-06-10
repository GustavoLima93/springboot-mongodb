package br.com.gustavolima.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.gustavolima.workshopmongo.domain.User;
import br.com.gustavolima.workshopmongo.repository.UserRepository;

@Repository
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> fildAll() {
		return repo.findAll();
	}
	
}
