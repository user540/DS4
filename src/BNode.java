import java.util.ArrayList;

//SUBMIT
class BNode implements BNodeInterface
{
	// ///////////////////BEGIN DO NOT CHANGE ///////////////////
	// ///////////////////BEGIN DO NOT CHANGE ///////////////////
	// ///////////////////BEGIN DO NOT CHANGE ///////////////////
	private final int t;
	private int numOfBlocks;
	private boolean isLeaf;
	private ArrayList<Block> blocksList;
	private ArrayList<BNode> childrenList;
	
	/**
	 * Constructor for creating a node with a single child.<br>
	 * Useful for creating a new root.
	 */
	public BNode(int t, BNode firstChild)
	{
		this(t, false, 0);
		childrenList.add(firstChild);
	}
	
	/**
	 * Constructor for creating a <b>leaf</b> node with a single block.
	 */
	public BNode(int t, Block firstBlock)
	{
		this(t, true, 1);
		blocksList.add(firstBlock);
	}
	
	public BNode(int t, boolean isLeaf, int numOfBlocks)
	{
		this.t=t;
		this.isLeaf=isLeaf;
		this.numOfBlocks=numOfBlocks;
		blocksList=new ArrayList<>();
		childrenList=new ArrayList<>();
	}
	
	// For testing purposes.
	public BNode(int t, int numOfBlocks, boolean isLeaf,
	             ArrayList<Block> blocksList, ArrayList<BNode> childrenList)
	{
		this.t=t;
		this.numOfBlocks=numOfBlocks;
		this.isLeaf=isLeaf;
		this.blocksList=blocksList;
		this.childrenList=childrenList;
	}
	
	@Override
	public int getT()
	{
		return t;
	}
	
	@Override
	public int getNumOfBlocks()
	{
		return numOfBlocks;
	}
	
	@Override
	public boolean isLeaf()
	{
		return isLeaf;
	}
	
	@Override
	public ArrayList<Block> getBlocksList()
	{
		return blocksList;
	}
	
	@Override
	public ArrayList<BNode> getChildrenList()
	{
		return childrenList;
	}
	
	@Override
	public boolean isFull()
	{
		return numOfBlocks==2*t-1;
	}
	
	@Override
	public boolean isMinSize()
	{
		return numOfBlocks==t-1;
	}
	
	@Override
	public boolean isEmpty()
	{
		return numOfBlocks==0;
	}
	
	@Override
	public int getBlockKeyAt(int indx)
	{
		return blocksList.get(indx).getKey();
	}
	
	@Override
	public Block getBlockAt(int indx)
	{
		return blocksList.get(indx);
	}
	
	@Override
	public BNode getChildAt(int indx)
	{
		return childrenList.get(indx);
	}
	
	@Override
	public int hashCode()
	{
		final int prime=31;
		int result=1;
		result=prime*result+(blocksList==null ? 0 : blocksList.hashCode());
		result=prime*result+(childrenList==null ? 0 : childrenList.hashCode());
		result=prime*result+(isLeaf ? 1231 : 1237);
		result=prime*result+numOfBlocks;
		result=prime*result+t;
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this==obj)
			return true;
		if (obj==null)
			return false;
		if (getClass()!=obj.getClass())
			return false;
		BNode other=(BNode)obj;
		if (blocksList==null)
		{
			if (other.blocksList!=null)
				return false;
		}
		else
			if (!blocksList.equals(other.blocksList))
				return false;
		if (childrenList==null)
		{
			if (other.childrenList!=null)
				return false;
		}
		else
			if (!childrenList.equals(other.childrenList))
				return false;
		return isLeaf==other.isLeaf && numOfBlocks==other.numOfBlocks && t==other.t;
	}
	
	@Override
	public String toString()
	{
		return "BNode [t="+t+", numOfBlocks="+numOfBlocks+", isLeaf="
		       +isLeaf+", blocksList="+blocksList+", childrenList="
		       +childrenList+"]";
	}
	// ///////////////////DO NOT CHANGE END///////////////////
	// ///////////////////DO NOT CHANGE END///////////////////
	// ///////////////////DO NOT CHANGE END///////////////////
	
	
	@Override
	public Block search(int key)
	{
		int i = 1;
		while(i<=getNumOfBlocks() && key>getBlockKeyAt(i))
			i++;
		if(i<=getNumOfBlocks() && key==getBlockKeyAt(i))
			return getBlockAt(i);
		else if(isLeaf())
			return null;
		else
			return getChildAt(i).search(key);
	}
	
	@Override
	public void insertNonFull(Block d)
	{
		// TODO Auto-generated method stub
		
		
	}
	
	@Override
	public void delete(int key)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public MerkleBNode createHashNode()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Splits the child node at childIndex into 2 nodes.
	 * @param childIndex
	 */
	public void splitChild(int childIndex)
	{
		//TODO splitChild
		BNode y = getChildAt(childIndex);
		BNode z = new BNode(getT(),y.isLeaf(),getT()-1);
		for (int i=0;i<getT()-1;i++)
			z.moveBlockAt(i)=y.getBlockAt(i+t);
		if (!y.isLeaf()){
			for (int i=0;i<getT();i++)
				z.moveChildAt(i)=y.getChildAt(i+t);
		for (int i=getNumOfBlocks()+1;i>childIndex+1;i--)
		
		
	}
	
	/**
	 * True iff the child node at childIndx-1 exists and has more than t-1 blocks.
	 * @param childIndx
	 * @return
	 */
	private boolean childHasNonMinimalLeftSibling(int childIndx)
	{
		//TODO childHasNonMinimalLeftSibling
		return false;
	}
	
	/**
	 * True iff the child node at childIndx+1 exists and has more than t-1 blocks.
	 * @param childIndx
	 * @return
	 */
	private boolean childHasNonMinimalRightSibling(int childIndx)
	{
		//TODO childHasNonMinimalRightSibling
		return false;
	}
	
	/**
	 * Verifies the child node at childIndx has at least t blocks.<br>
	 * If necessary a shift or merge is performed.
	 * @param childIndx
	 */
	private void shiftOrMergeChildIfNeeded(int childIndx)
	{
		//TODO shiftOrMergeChildIfNeeded
	}
	
	/**
	 * Add additional block to the child node at childIndx, by shifting from left sibling.
	 * @param childIndx
	 */
	private void shiftFromLeftSibling(int childIndx)
	{
		//TODO shiftFromLeftSibling
	}
	
	/**
	 * Add additional block to the child node at childIndx, by shifting from right sibling.
	 * @param childIndx
	 */
	private void shiftFromRightSibling(int childIndx)
	{
		//TODO shiftFromRightSibling
	}
	
	/**
	 * Merges the child node at childIndx with its left or right sibling.
	 * @param childIndx
	 */
	private void mergeChildWithSibling(int childIndx)
	{
		//TODO mergeChildWithSibling
	}
	
	/**
	 * Merges the child node at childIndx with its left sibling.<br>
	 * The left sibling node is removed.
	 * @param childIndx
	 */
	private void mergeWithLeftSibling(int childIndx)
	{
		//TODO mergeWithLeftSibling
	}
	
	/**
	 * Merges the child node at childIndx with its right sibling.<br>
	 * The right sibling node is removed.
	 * @param childIndx
	 */
	private void mergeWithRightSibling(int childIndx)
	{
		//TODO mergeWithRightSibling
	}
	
	/**
	 * Finds and returns the block with the min key in the subtree.
	 * @return min key block
	 */
	private Block getMinKeyBlock()
	{
		//TODO getMinKeyBlock
		return null;
	}
	
	/**
	 * Finds and returns the block with the max key in the subtree.
	 * @return max key block
	 */
	private Block getMaxKeyBlock()
	{
		//TODO getMaxKeyBlock
		return null;
	}
}