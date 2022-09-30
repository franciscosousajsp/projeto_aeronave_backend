package com.br.projeto_aeronave.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.projeto_aeronave.domian.Aeronave;
import com.br.projeto_aeronave.dtos.AeronaveDTO;
import com.br.projeto_aeronave.services.AeronaveService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "aeronaves")
public class AeronaveResource {

	@Autowired
	private AeronaveService service;

	@GetMapping
	public ResponseEntity<List<AeronaveDTO>> findAll() {
		List<Aeronave> list = service.findAll();
		List<AeronaveDTO> listDTO = list.stream().map(obj -> new AeronaveDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AeronaveDTO> findById(@PathVariable Long id) {

		Aeronave obj = service.findById(id);
		return ResponseEntity.ok().body(new AeronaveDTO(obj));
	}

	@PostMapping
	public ResponseEntity<AeronaveDTO> create( @Valid  @RequestBody AeronaveDTO objDTO) {

		Aeronave newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AeronaveDTO> update( @Valid @PathVariable Long id, @RequestBody AeronaveDTO objDTO){
		
		Aeronave obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new AeronaveDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Aeronave> delete(@PathVariable Long id){
		
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	

}
