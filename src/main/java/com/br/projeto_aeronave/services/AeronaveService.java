package com.br.projeto_aeronave.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.projeto_aeronave.domian.Aeronave;
import com.br.projeto_aeronave.dtos.AeronaveDTO;
import com.br.projeto_aeronave.repositories.AeronaveRepository;
import com.br.projeto_aeronave.services.exceptions.ObjectNotFoundException;

@Service
public class AeronaveService implements Comparable<Aeronave> {

	@Autowired
	private AeronaveRepository repository;

	public List<Aeronave> findAll() {
		return repository.findAll();
	}

	public Aeronave findById(Long id) {
		Optional<Aeronave> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não encontrado! ID: " + id));

	}

	public Aeronave create(AeronaveDTO objDTO) {
		objDTO.setId(null);
		Aeronave newObj = new Aeronave(objDTO);

		if (this.compareTo(newObj) == 0) {
			return repository.save(newObj);
			}
	
		return null;
	}

	public Aeronave update(Long id, AeronaveDTO objDTO) {
		Aeronave oldObj = findById(id);

		oldObj.setNome(objDTO.getNome());
		oldObj.setMarca(objDTO.getMarca());
		oldObj.setAno(objDTO.getAno());
		oldObj.setDescricao(objDTO.getDescricao());
		oldObj.setVendido(objDTO.getVendido());
		oldObj.setUpdate(objDTO.getUpdate());

		if (this.compareTo(oldObj) == 0) {
			return repository.save(oldObj);
		}

		return null;
	}

	public void delete(Long id) {
		Aeronave obj = findById(id);
		repository.delete(obj);
	}

	@Override
	public int compareTo(Aeronave o) {

		String[] marcaValidas = { "Airbus", "Boeing", "Bombardier", "Embraer" };

		for (String string : marcaValidas) {
			if (o.getMarca().compareToIgnoreCase(string) == 0) {
				return 0;
			}
		}

		this.verificarOrtografiaMarca(-1);
		return -1;
	}

	private void verificarOrtografiaMarca(int num) {
		if (num != 0)
			throw new ObjectNotFoundException("Marca digitada Não encontrado");
	}

}
