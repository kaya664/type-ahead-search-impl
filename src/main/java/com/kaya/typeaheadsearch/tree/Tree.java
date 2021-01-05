package com.kaya.typeaheadsearch.tree;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Tree {
	
	Node baseNode = new Node(null);
	
	public Tree() {
		buildTree();
		traverseTree(baseNode);
	}
	
	public void buildTree() {
		Node tempNode = baseNode;
		String searchText = "SearchText";
		if(searchText != null && searchText.trim().length() > 0) {
			for(char c: searchText.toCharArray()) {
				tempNode = tempNode.getChildNode(c + "");
			}
			tempNode.setMeaningfulText(true);
		}
		searchText = "Searchhie";
		if(searchText != null && searchText.trim().length() > 0) {
			for(char c: searchText.toCharArray()) {
				tempNode = tempNode.getChildNode(c + "");
			}
		}
		System.out.println("Tree builded");
	}
	
	public void traverseTree(Node node) {
		if(node != null) {
			System.out.println(node.getCharacter());
			if(node.getNodeMap().size() > 0) {
				List<Node> nodeList = new ArrayList<Node>(node.getNodeMap().values());
				for(Node tempNode: nodeList) {
					traverseTree(tempNode);
				}
			}
		}
	}
	
}
