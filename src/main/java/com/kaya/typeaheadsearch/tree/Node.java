package com.kaya.typeaheadsearch.tree;

import java.util.HashMap;
import java.util.Map;

public class Node {

	private Character character;
	private String text;
	private int count;
	private boolean isMeaningfulText = false;
	//
	private Map<Character, Node> childNodeMap;
	
	public Node(Character character) {
		this.character = character;
	}
	
	public Node addChildNode(Character c) {
		if(childNodeMap == null) {
			childNodeMap = new HashMap<Character, Node>();
		}
		Node node;
		if(!childNodeMap.containsKey(c)) {
			node = new Node(c);
			childNodeMap.put(c, node);
		} else {
			node = childNodeMap.get(c);
		}
		return node;
	}
	
	public Node getChildNode(Character c) {
		Node childNode = null;
		if(childNodeMap != null && childNodeMap.containsKey(c)) {
			childNode = childNodeMap.get(c);
		}
		return childNode;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isMeaningfulText() {
		return isMeaningfulText;
	}

	public void setMeaningfulText(boolean isMeaningfulText) {
		this.isMeaningfulText = isMeaningfulText;
	}

	public Map<Character, Node> getChildNodeMap() {
		return childNodeMap;
	}

	public void setChildNodeMap(Map<Character, Node> childNodeMap) {
		this.childNodeMap = childNodeMap;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
