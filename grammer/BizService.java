package javaStudy_01;

public class BizService {
	public void bizMethod(int i) throws BizException {
		System.out.println("�����Ͻ� �޼ҵ� ����");
		
		if(i < 0) {
			throw new BizException("�Ű����� i�� 0 �̻��̾�� �մϴ�.");
		}
		
		System.out.println("�����Ͻ� �޼ҵ� ����");
	}
}
