import java.util.Set;
public class Trie{
	public Node root;
	
	public Trie() {
		this.root = new Node();
	}
	
	public void insertWord(String word) {
		// gets the root node;
		Node currentNode = this.root;
		
		// iterates over every character in the word
		for(int i=0; i<word.length(); i++) {
			// current letter is just the character/letter at the iteration
			Character currentLetter = word.charAt(i);
			// ask if the current letter is in the map of the current node
			Node child = currentNode.children.get(currentLetter);
			if(child == null) {
				child = new Node();
				currentNode.children.put(currentLetter, child);
			}
			
			currentNode = child;
		}
		currentNode.isCompleteWord = true;
	}
	
	public boolean isPrefixValid(String prefix) {
		Node rootNode = this.root;
	    for(int i=0; i<prefix.length(); i++){
	        if(rootNode.children.get(prefix.charAt(i)) == null) {
	        	return false;
	        }
	        else rootNode = rootNode.children.get(prefix.charAt(i));
	    }
	    return (rootNode.children.isEmpty()) ? false : true;
	}
	
	public boolean isWordValid(String word) {
		Node currentNode = this.root;
		Node child = new Node();
		for(int i=0; i<word.length(); i++) {
			Character currentLetter = word.charAt(i);
			child = currentNode.children.get(currentLetter);
			currentNode = child;
		}
		return child.isCompleteWord;
	}
	
	public void printAllKeys() {
		Node currentNode = this.root;
		Set<Character> keys = root.children.keySet();
		for(Character key : keys) {
			System.out.println("Root key: " + key);
			Set<Character> subKeys = root.children.get(key).children.keySet();
				for(Character subKey : subKeys) {
					System.out.println("Child of " + key + ": " + subKey);
					Node child = currentNode.children.get(subKey);
					if(child != null) {
						Node subNode = child.children.get(subKey);
						Set<Character>subNextKeys = subNode.children.keySet();
						for(Character subNextKey : subNextKeys) {
							System.out.println("Child of " + subKey + ": " + subNextKey);
							
							
						}
							
							
					}
				}
		}
	}
}




