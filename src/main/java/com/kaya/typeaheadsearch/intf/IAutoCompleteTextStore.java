package com.kaya.typeaheadsearch.intf;

import java.util.List;

public interface IAutoCompleteTextStore {

	List<String> getAutoCompleteTextList(String text);

	void addTextToStore(String text);
}
