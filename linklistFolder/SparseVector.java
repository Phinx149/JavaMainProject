public class SparseVector {

	private Node head;
	private int length;

	public SparseVector(int len){
		head = null;
		length = len;
	}

	// Prints out a sparse vector (including zeros)
	public String toString(){

		String result = "";
		Node currNode = head;
		int currIndex = 0;
		while( currNode != null ){
			int idx = currNode.getIndex();

			// Pad the space between nodes with zero
			while( currIndex < idx ){
				result += "0, ";
				currIndex++;
			}
			result += currNode;
			currNode = currNode.getNext();
			currIndex++;

			// Only add a comma if this isn't the last element
			if( currNode != null ){ result += ", "; }
		}
		return result;
	}

	// TODO: Implement me for milestone 1
	
	
	public void addElement(int index, double value){
		if (this.head==null){
			head=new Node(index, value);
		}
		if (index<0|| index < head.getIndex()){
			System.out.print("invalid index");
		}else{
				
		Node nextNode=new Node(index, value);
		Node currNode=head;
		int currIndex=0;
		while (currNode.getNext()!=null&&index > currNode.getNext().getIndex() ){
			currNode=currNode.getNext();
			currIndex=currNode.getIndex();
		}
		nextNode.setNext(currNode.getNext());
		currNode.setNext(nextNode);
		
		
	}
}
		



	// TODO: Implement me for milestone 3
	public static double dot( SparseVector x, SparseVector y ){
		
		double result=0;
		if (x.length==y.length){
			Node currNodeX = x.head;
			Node currNodeY = y.head;
		    while (currNodeX != null&& currNodeY!=null) {
				
				System.out.println("x: " + currNodeX.getIndex() + ", y: " + currNodeY.getIndex());
				if (currNodeX.getIndex() == currNodeY.getIndex()) {
					
					result += currNodeX.getValue() * currNodeY.getValue();
					currNodeX = currNodeX.getNext();
					currNodeY = currNodeY.getNext();
					
				}else if (currNodeX.getIndex() < currNodeY.getIndex()) {
					currNodeX = currNodeX.getNext();
				} else {
					currNodeY = currNodeY.getNext();
				}
				
				
				
		
	
		
		}
		return result;
	}else{
		System.out.print("Cannot caluclate vector");
		return 0;
	}
}

	
	public void removeElement(int index) {
			if (head == null) {
				System.out.println(" The vector is empty. Unable to delete.");
				return;
			}
		
			
			if (head.getIndex() == index) {
				head = head.getNext();
				return;
			}
		
			Node prevNode = null;
			Node currNode = head;
		
			
			while (currNode != null && currNode.getIndex() != index) {
				prevNode = currNode;
				currNode = currNode.getNext();
			}
			if (currNode == null) {
				System.out.println("Index not found");
				return;
			}
		
			
			prevNode.setNext(currNode.getNext());
		}

	

	// TODO: Test out your code here!
	public static void main(String[] args) {
		SparseVector vec = new SparseVector(6);
		vec.addElement(0, 10.0);
		vec.addElement(3, -1.1);
		vec.addElement(5, 32.0); 
		System.out.println(vec);

		SparseVector x = new SparseVector(100000000);
		x.addElement(0, 1.0);
		x. addElement(10000000, 3.0);
		x.addElement(10000001, -2.0);
		SparseVector y = new SparseVector(100000000);
		y.addElement(0, 2.0);
		y.addElement(10000001, -4.0); y.removeElement(0);
		double result = dot(x, y);
		System.out.println(result);
	}
}


