package com.kaya.typeaheadsearch.tree;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class Tree {
	
	Node baseNode = new Node(null);
	
	public Tree() {
		buildTree();
		getAutoCompleteTextListForEnteredText(baseNode, "Alf");
		getAutoCompleteTextListForEnteredText(baseNode, "Charcoa");
	}
	
	public void buildTree() {
		addText(baseNode, "Alfa");
		addText(baseNode, "Bravo");
		addText(baseNode, "Charlie");
		addText(baseNode, "Delta");
		addText(baseNode, "Alfred");
		addText(baseNode, "Brain");
		addText(baseNode, "Charcoal");
		addText(baseNode, "Delivery");
	}
	
	public void addText(Node root, String text) {
		Node temp = root;
		if(StringUtils.hasText(text)) {
			for(Character c: text.toCharArray()) {
				temp = temp.addChildNode(c);
			}
			temp.setMeaningfulText(true);
			temp.setText(text);
		}
	}
	
	public void traverseTree(Node node, List<String> textList) {
		if(node != null) {
			if(node.isMeaningfulText()) {
				textList.add(node.getText());
			}
			if(node.getChildNodeMap() != null && node.getChildNodeMap().size() > 0) {
				List<Node> nodeList = new ArrayList<Node>(node.getChildNodeMap().values());
				for(Node tempNode: nodeList) {
					traverseTree(tempNode, textList);
				}
			}
		}
	}
	
	public List<String> getAutoCompleteTextListForEnteredText(Node root, String enteredText) {
		if(!StringUtils.hasText(enteredText)) {
			return null;
		}
		
		Node respectiveRoot = findRootNodeForAutoCompleteSearch(root, enteredText);
		if(respectiveRoot == null) {
			return null;
		}
		
		List<String> autoCompleteTextList = new ArrayList<>();
		traverseTree(respectiveRoot, autoCompleteTextList);
		for(String text: autoCompleteTextList) {
			System.out.println(text);
		}
		
		return autoCompleteTextList;
	}
	
	private Node findRootNodeForAutoCompleteSearch(Node root, String enteredText) {
		Node respectiveRoot = root;
		for(Character c: enteredText.toCharArray()) {
			if(respectiveRoot != null) 
				respectiveRoot = respectiveRoot.getChildNode(c);
		}
		return respectiveRoot;
	}
	
}
