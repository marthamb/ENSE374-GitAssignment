/**
 * 
 */

/**
 * @author ADMIN
 *
 */
public class ListElement 
{
	private ListElement next;
	private ListElement previous;
	private int data;

	public ListElement()
	{
		this.data=0;
		this.next=null;
		this.previous=null;
	}
	
	/**
	 * @param data
	 *   an integer to be stored in the node
	 *@return none
	 */
	public void setData(int data)
	{
		this.data=data;
	}
	
	public int getData()
	{
		return this.data;
	}

}
