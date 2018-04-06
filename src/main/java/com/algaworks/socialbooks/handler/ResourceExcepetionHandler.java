package com.algaworks.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.socialbooks.domain.DetalhesErro;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExcepetionHandler {
	
	@ExceptionHandler(LivroNaoEncontradoException.class)
	private ResponseEntity<DetalhesErro> handleLivroNaoEncontradoExcepetion(LivroNaoEncontradoException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Livro não foi encontrado");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks/404");
		erro.setTimestamp(System.currentTimeMillis());	 
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		 

	}

}
