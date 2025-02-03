package edu.java.inner08;

class FinishListener implements Button.OnClickListener{
	@Override
	public void onClick() {
		System.out.println("<<< Finish >>>");
		System.out.println();
	}	
}

class CancelListener implements Button.OnClickListener{
	@Override
	public void onClick() {
		System.out.println("<<< Cancel >>>");
		System.out.println();
	}
}

public class InnerMain08 {

	public static void main(String[] args) {
Button btnFinish = new Button();
		
		Button.OnClickListener finListener = new FinishListener();
		btnFinish.setOnClickListener(finListener);
		btnFinish.click();
		
		Button btnCancel = new Button();
//		Button.OnClickListener cancel = new CancelListener();
		btnCancel.setOnClickListener(new CancelListener());
		btnCancel.click();
		
		/*
		 *  1. btn 객체 생성
		 *  2. 익명 클래스를 사용해 listener 객체 생성(onClick 메소드 오버라이드)
		 *  3. btn 객체에 listener 적용(setOnClickListener())
		 *  4. btn click() 메소드 호출
		 */
		Button btn = new Button();
		Button.OnClickListener l = new Button.OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("Anonymous Class");
			}
		};
		btn.setOnClickListener(l);
		btn.click();
		
		btn.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("Shorten Anonymous Class");
			}
		});
		btn.click();

	}

}
