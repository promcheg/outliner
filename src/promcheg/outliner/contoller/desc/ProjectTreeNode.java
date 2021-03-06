package promcheg.outliner.contoller.desc;

/**
 * 
 * @author waldemar
 *
 */
public interface ProjectTreeNode {
	/**
	 * 
	 * @return
	 */
	ProjectTreeNodeType getType();
	String getCaption();
	String getTooltip();
	void checkPopupMenuAvailability();
}
