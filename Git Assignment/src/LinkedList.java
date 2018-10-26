
public class LinkedList
{
	 /**
     * Head
     */
	private ListElement leHead;
	
	 /**
     * Tail
     */
	private ListElement leTail;
	
	 /**
     * pointer
     */
	private ListElement le;
	
	/**
     * Number of element
     */
	int elementCount;

	
	public static void main()//String[] args)
	{
		LinkedList SingleLL=new LinkedList();
		ListElement leNew= new ListElement();
		SingleLL.addElement(leNew);
	}
	
	//Add a node
	public void addElement(ListElement leAdd)
	{
		//is this the first element
		if (leHead==null)
		{
			leHead=leAdd;
			leTail=leAdd;
		} 
		else 
		{
			leTail.setNext(leAdd);
			leTail=leAdd;
		}
	}
	
	//Retrieve a node 
	public ListElement getElement(int index)
	{
		if (index>0)
		{
			le=leHead;
			int i=1;
			while ( le!=null && i<=index)
			{
				le=le.getNext();
				i++;
			}
			return le;
		}
		else
		{
			return null;
		}
		
	}

	// Delete a node 
	public boolean deleteElement(int index)
	{
		ListElement lePrev= new ListElement();
		if (index>0 && leHead!=null)
		{
			le=leHead;
			
			int i=1;
			while ( le!=null && i<index)
			{
				lePrev=le;
				le=le.getNext();
				i++;
			}
			
			if (lePrev==null)
			{
				leHead=leHead.getNext();
				le=leHead;
				return true;
			}
			else if (le!=null)
			{
				if (le.getNext()==null) 
				{
					lePrev.setNext(null);
				} 
				else 
				{
					lePrev.setNext(le.getNext());
				}
				le=leHead;
				return true;
			}
		}
		return false;
	}
	
	// Print the linked list from the tail
	public void printLinkedListTail()
	{
		if(leHead!=null)
		{
			printTail(leHead);
		}
	}
	public void printTail(ListElement element)
	{
		if(element.getNext()!=null)
		{
			printTail(element.getNext());
		}
		System.out.println(element.getData());
	}
	
	// Print the linked list from the head
	 public void printLinkedListHead()
	 {
		 le=leHead;
		 while (le!=null) 
		 {
			 System.out.println(le.getData());
			 le=le.getNext();
		}
	 }


}
