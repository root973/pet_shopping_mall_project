package co.sp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import co.sp.beans.Pet_member;

//�߸���(��ȿ�� �˻�) ��ü �������� Ŭ����
public class MemberValid implements Validator{
	//��ȿ�� �˻��� ������ ���� ��ü�� �������� �޼ҵ�
		@Override
		public boolean supports(Class<?> clazz) {
			// TODO Auto-generated method stub
			return Pet_member.class.isAssignableFrom(clazz);
		}
		//�ڴ��� ������ ����� �߸������� �ۼ�
		@Override
		public void validate(Object target, Errors errors) {
			// TODO Auto-generated method stub
			Pet_member memberBean=(Pet_member)target;
			String beanName = errors.getObjectName();
			
			if(beanName.equals("joinUserBean") || beanName.equals("modifyUserBean")) {
				if(!memberBean.getPass().equals(memberBean.getPass2())) {
					errors.rejectValue("pass2", "NotEquals");
				}
			}
				
			if(beanName.equals("joinUserBean")) {
				
				if(memberBean.isIdExist() == false) {
					errors.rejectValue("member_id", "DontCheckUserIdExist");
				}
			}
			
		}
}
