package edu.java.inner08;

public class Button {
	public interface OnClickListener{
		public abstract void onClick();
	}
	
	private OnClickListener listener;
	
	public void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	public void click() {
		listener.onClick();
	}
}
