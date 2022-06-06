package day11.abstraction;

public class InterfaceDemo {
	public static void main(String[] args) {
		OnClickListener listener = new Button("Register");
		listener.onClick();
		listener.onDoubleClick();
	}
}
