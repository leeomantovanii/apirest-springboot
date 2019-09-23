package com.contatos.apirest.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.contatos.apirest.enums.TelefoneType;
import com.contatos.apirest.models.Contato;
import com.contatos.apirest.models.Email;
import com.contatos.apirest.models.Telefone;
import com.contatos.apirest.repository.ContatoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Contatos")
@CrossOrigin(origins="*")
public class ContatoResource {
	
	@Autowired
	ContatoRepository contatoRepository;
	
	@GetMapping("/contatos")
	@ApiOperation(value="Retorna uma lista de contatos")
	public List<Contato> listaContatos(){
		return contatoRepository.findAll();
	}
		
	@GetMapping("/contato/{id}")
	@ApiOperation(value="Retorna um contato específico")
	public ResponseEntity<Contato> listaContato(@PathVariable(value="id")long id){
		Contato c = contatoRepository.findById(id);
		
		if (c == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(c);
	}
		
	@PutMapping("/contato")
	@ApiOperation(value="Atualiza contato")
	public ResponseEntity<Contato> atualizarContato(@Valid @RequestBody Contato contato){
		Contato contatoExistente = contatoRepository.findById(contato.getId());
		
		if (contatoExistente == null) {
			return ResponseEntity.notFound().build();
		}
		
		contatoRepository.save(contato);
		return ResponseEntity.ok(contato);
	}
	
	@DeleteMapping("/contato/{id}")
	@ApiOperation(value="Remove um contato")
	public ResponseEntity<Void> removerContato(@PathVariable(value="id")long id){
		Contato contatoExistente = contatoRepository.findById(id);
		
		if (contatoExistente == null) {
			return ResponseEntity.notFound().build();
		}
		
		contatoRepository.delete(contatoExistente);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/contato")
	@ApiOperation(value="Adiciona um contato")
	public Contato adicionarContato(@Valid @RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
	
	@PutMapping("/contato/{id}/{favorito}")
	@ApiOperation(value="Marcar/Desmarcar contato como favorito")
	public ResponseEntity<Contato> atualizarFavorito(@PathVariable(value="id")long id, @PathVariable(value="favorito")boolean favorito){
		Contato contatoExistente = contatoRepository.findById(id);
		
		if (contatoExistente == null) {
			return ResponseEntity.notFound().build();
		}
		contatoExistente.setFavorito(favorito);
		
		contatoRepository.save(contatoExistente);
		return ResponseEntity.ok(contatoExistente);
	}
	
	
	@GetMapping("/inserir")
	public void insereDadosTeste() {
		Telefone t = new Telefone(TelefoneType.CELULAR, 43996448899L);
		ArrayList<Telefone> listTel= new ArrayList<Telefone>();
		listTel.add(t);
		
		Email e = new Email("leonardo@email.com");
		ArrayList<Email> listEmail = new ArrayList<Email>();
		listEmail.add(e);
		
		Contato c = new Contato();
		c.setDtNascimento(new Date());
		c.setFavorito(false);
		c.setNome("Teste");
		c.setTelefones(listTel);
		c.setEmails(listEmail);
		
		contatoRepository.save(c);
	}
	
	
	
	
}
