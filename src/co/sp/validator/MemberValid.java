package co.sp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import co.sp.beans.Pet_member;

//발리드(유효성 검사) 객체 가져오는 클래스
public class MemberValid implements Validator{
	//유효성 검사할 정보를 담은 객체를 가져오는 메소드
		@Override
		public boolean supports(Class<?> clazz) {
			// TODO Auto-generated method stub
			return Pet_member.class.isAssignableFrom(clazz);
		}
		//코더가 조건을 만드는 발리데이터 작성
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
