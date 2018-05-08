package promcheg.outliner;

import org.eclipse.swt.events.SelectionListener;

abstract class ProjectTreeSelectionAdapter<T> implements SelectionListener {
	
	private final T uObject;

	/**
	 * 
	 * @param uObject
	 */
	public ProjectTreeSelectionAdapter(T uObject) {
		this.uObject = uObject;
	}

	public T getuObject() {
		return uObject;
	}
}
