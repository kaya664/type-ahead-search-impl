package com.kaya.typeaheadsearch.tree;

import java.util.HashMap;
import java.util.Map;

public class Node {

	private String character;
	private boolean isMeaningfulText = false;
	private Map<String, Node> nodeMap = new HashMap<String, Node>();
	
	public Node(String character) {
		this.character = character;
	}
	
	public void addChildNode(Node childNode) {
		nodeMap.put(childNode.character, childNode);
	}
	
	public Node getChildNode(String node) {
		Node childNode;
		if(nodeMap.containsKey(node)) {
			childNode = nodeMap.get(node);
		} else {
			childNode = new Node(node);
			nodeMap.put(node, childNode);
		}
		return childNode;
	}
	
	public Map<String, Node> getNodeMap() {
		return nodeMap;
	}
	
	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public boolean isMeaningfulText() {
		return isMeaningfulText;
	}

	public void setMeaningfulText(boolean isMeaningfulText) {
		this.isMeaningfulText = isMeaningfulText;
	}

}
