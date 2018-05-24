package promcheg.outliner.contoller.desc;

import org.eclipse.swt.SWT;

public enum ActionTypeDesc {
	NONE(0),
	OPEN_FILE(SWT.CTRL | KeyMapDesc.KEY_O.intValue),
	SAVE_FILE(SWT.CTRL | KeyMapDesc.KEY_S.intValue),
	EXIT_APPLICATION(SWT.CTRL | SWT.ALT | KeyMapDesc.KEY_E.intValue);

	int mask;
	
	ActionTypeDesc(int mask) {
		this.mask = mask;
	}
	
	/**
	 * 
	 * @param key 
	 * @param alt 
	 * @param ctrl 
	 * @param shift 
	 * @return
	 */
	public static ActionTypeDesc getActionForKey(boolean shift, boolean ctrl, boolean alt, int key) {
		for (ActionTypeDesc entry : ActionTypeDesc.values()) {
			int check = key | (shift ? SWT.SHIFT : 0) | (alt ? SWT.ALT : 0) | (ctrl ? SWT.CTRL : 0);
			if(check == entry.mask) {
				return entry;
			}
		};
		
		return NONE;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean onCtrl() {
		return (this.mask & SWT.CTRL) == SWT.CTRL;
	}
	
	public boolean onAlt() {
		return (this.mask & SWT.ALT) == SWT.ALT;
	}
	
	public boolean onShift() {
		return (this.mask & SWT.SHIFT) == SWT.SHIFT;	
	}
	
	
}
