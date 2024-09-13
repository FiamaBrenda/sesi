package com.senai.sesi.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.senai.sesi.dto.ProdutoDto;
import com.senai.sesi.model.ProdutoModel;
import com.senai.sesi.repository.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;

	@PostMapping("/produtos")
	public ResponseEntity<ProdutoModel> salvarProduto(@RequestBody @Valid ProdutoDto produtoDto) {
		ProdutoModel produtoModel = new ProdutoModel();
		BeanUtils.copyProperties(produtoDto, produtoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produtoModel));
	}

	@GetMapping("/produtos")
	public ResponseEntity<List<ProdutoModel>> mostrarProdutos() {
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.findAll());
	}
}
