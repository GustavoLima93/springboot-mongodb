package br.com.gustavolima.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.gustavolima.workshopmongo.domain.User;
import br.com.gustavolima.workshopmongo.dto.UserDTO;
import br.com.gustavolima.workshopmongo.repository.UserRepository;
import br.com.gustavolima.workshopmongo.service.exception.ObjectNotFoundException;

@Repository
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> fildAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objtDto) {
		return new User(objtDto.getId() ,objtDto.getName(), objtDto.getEmail());
	}
	
	
	
}
