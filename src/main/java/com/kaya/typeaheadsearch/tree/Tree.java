package com.kaya.typeaheadsearch.tree;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;

import com.kaya.typeaheadsearch.intf.IAutoCompleteTextStore;

@Component
public class Tree implements IAutoCompleteTextStore{
	
	Node root = new Node(null);
	
	private Tree() {
		buildTree();
	}
	
	private void buildTree() {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		File[] fileArray = getFileNames();
		int index = 0;
		while(index < fileArray.length) {
			addText(root, fileArray[index].getName().substring(0, fileArray[index].getName().indexOf(".txt")));
			index++;
		}
		stopWatch.stop();
		System.out.println(stopWatch.getTotalTimeMillis());
	}
	
	private File[] getFileNames() {
		File folder = new File("./words/");
		return folder.listFiles();
	}
	
	@Override
	public List<String> getAutoCompleteTextList(String text) {
		return getAutoCompleteTextListForEnteredText(root, text);
	}
	
	private void addText(Node root, String text) {
		Node temp = root;
		if(StringUtils.hasText(text)) {
			for(Character c: text.toCharArray()) {
				temp = temp.addChildNode(c);
			}
			temp.setMeaningfulText(true);
			temp.setText(text);
		}
	}
	
	private void traverseTree(Node node, List<String> textList) {
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
	
	private List<String> getAutoCompleteTextListForEnteredText(Node root, String enteredText) {
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
