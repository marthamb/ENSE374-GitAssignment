import java.util.Scanner;

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

	
	public static void main(String[] args)
	{
		LinkedList SingleLL=new LinkedList();
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("To Add a node enter: add");
		System.out.println("To Retrieve a node enter: retrieve");
		System.out.println("To Delete a node enter: delete");
		System.out.println("To Print the linked list from the tail enter: tail");
		System.out.println("To Print the linked list from the head enter: head");
		System.out.println("To exit the program enter: exit");
		
		String action="";
		while(!action.equals("extit"))
		{
			System.out.println("Enter action");
			action = entrada.nextLine();
			
			if (action.equals("add"))
			{
				System.out.println("Enter 1 value at time");
				int val = Integer.parseInt(entrada.nextLine());
				ListElement leNew= new ListElement();
				leNew.setData(val);
				SingleLL.addElement(leNew);
			}
			else if (action.equals("retrieve"))
			{
				System.out.println("Enter position of the value to see, strarting on 1");
				int index = Integer.parseInt(entrada.nextLine());
				System.out.println(SingleLL.getElement(index).getData());
			}
			else if (action.equals("delete"))
			{
				System.out.println("Enter position of the value to delete, strarting on 1");
				int index = Integer.parseInt(entrada.nextLine());
				SingleLL.deleteElement(index);
			}
			else if (action.equals("tail"))
			{
				SingleLL.printLinkedListTail();
			}
			else if (action.equals("head"))
			{
				SingleLL.printLinkedListHead();
			}
			else if (action.equals("exit"))
			{
				System.out.println("Bye");
				break;
			}
		}
		
		
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
			leAdd.setPrevious(leTail);
			leTail=leAdd;
		}
		elementCount++;
	}
	
	//Retrieve a node 
	public ListElement getElement(int index)
	{
		if (index>0)
		{
			le=leHead;
			int i=1;
			while ( le!=null && i<index)
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
				le=le.getNext();
				i++;
			}
			
			lePrev=le.getPrevious();
			if (lePrev==null)
			{
				if(leHead==leTail)
				{
					leTail=leTail.getNext();
				}
				leHead=leHead.getNext();
				if(leHead!=null)
				{
					leHead.setPrevious(null);
				}
				
				le=leHead;
				System.out.println("successful delete");
				return true;
			}
			else if (le!=null)
			{
				if (le.getNext()==null) 
				{
					lePrev.setNext(null);
					leTail=lePrev;
				} 
				else 
				{
					lePrev.setNext(le.getNext());
					lePrev.getNext().setPrevious(lePrev);
				}
				le=leHead;
				System.out.println("successful delete");
				return true;
			}
		}
		System.out.println("any element was deleted");
		return false;
	}
	
	// Print the linked list from the tail
	public void printLinkedListTail()
	{
		le=leTail;
		while (le!=null) 
		{
			System.out.println(le.getData());
			 le=le.getPrevious();
		}
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
