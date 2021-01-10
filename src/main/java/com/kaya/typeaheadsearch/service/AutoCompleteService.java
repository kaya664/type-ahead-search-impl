package com.kaya.typeaheadsearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.typeaheadsearch.intf.IAutoCompleteService;
import com.kaya.typeaheadsearch.intf.IAutoCompleteTextStore;

@Service
public class AutoCompleteService implements IAutoCompleteService {
	
	@Autowired
	IAutoCompleteTextStore textStore;
	
	@Override
	public List<String> getAutoCompleteTextForEnteredText(String text) {
		return textStore.getAutoCompleteTextList(text);
	}
	
	@Override
	public void addTextToStore(String text) {
		textStore.addTextToStore(text);
	}
	
}
