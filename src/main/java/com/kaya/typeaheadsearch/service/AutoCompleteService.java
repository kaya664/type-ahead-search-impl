package com.kaya.typeaheadsearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.typeaheadsearch.tree.Tree;

@Service
public class AutoCompleteService {
	
	@Autowired
	Tree tree;
	
	public List<String> getAutoCompleteTextForEnteredText(String text) {
		return tree.getAutoCompleteTextList(text);
	}
	
}
