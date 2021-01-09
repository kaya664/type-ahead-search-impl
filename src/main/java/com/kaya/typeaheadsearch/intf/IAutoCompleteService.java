package com.kaya.typeaheadsearch.intf;

import java.util.List;

public interface IAutoCompleteService {

	List<String> getAutoCompleteTextForEnteredText(String text);

}
