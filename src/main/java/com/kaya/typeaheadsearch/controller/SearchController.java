package com.kaya.typeaheadsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.typeaheadsearch.intf.IAutoCompleteService;

@RestController
@RequestMapping("/search")
public class SearchController {
	@Autowired
	IAutoCompleteService autoCompleteService;
	
	@GetMapping("/text")
	public void addSearchedTextToStore(@RequestParam("text") String text) {
		autoCompleteService.addTextToStore(text);
	}
}
