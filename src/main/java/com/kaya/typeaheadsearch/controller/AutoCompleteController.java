package com.kaya.typeaheadsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.typeaheadsearch.intf.IAutoCompleteService;

@RestController()
@RequestMapping("/autocomplete")
public class AutoCompleteController {
	
	@Autowired
	IAutoCompleteService autoCompleteService;
	
	@GetMapping("/texts")
	public List<String> getAutoCompleteTexts(@RequestParam("text") String text) {
		return autoCompleteService.getAutoCompleteTextForEnteredText(text);
	}
}
