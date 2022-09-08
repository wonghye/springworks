	function checkForm() {
		let form = document.regForm;
		let id = form.userid.value;
		let pwd1 = form.userpw.value;
		let pwd2 = form.userpw_confirm.value;
		let name = form.username.value;
		let idChkVal = document.getElementById("idCheck");
		
		let regExpId = /^[a-zA-Z0-9]*$/ //영문자, 숫자만(^-시작, *-반복)
		let regExpPwd1 = /[a-zA-Z0-9]/  //영문자, 숫자
		let regExpPwd2 = /[~!@#$%^&*()_+/]/  //특수문자
		let regExpPwd3 = /[ㄱ-ㅎㅏ-ㅣ가-힣]/  //한글
	
			if(id.length < 4 || id.length > 12 || !regExpId.test(id)){
				alert("아이디는 영문자, 숫자 포함 4-12자 이하로 입력해주세요 ");
				form.userid.focus();
				form.userid.select();
				return false;
			}
			if(pwd1.length < 8 || pwd1.length > 12 ||
					!regExpPwd1.test(pwd1) || !regExpPwd2.test(pwd1) ||
					regExpPwd3.test(pwd1)){
				alert("비밀번호는 영문자, 숫자, 특수문자 포함 8-12자 이하로 입력해주세요 ");
				form.userpw.focus();
				form.userpw.select();
				return false;
			}
			if(pwd1 != pwd2){
				alert("비밀번호를 동일하게 입력해주세요");
				form.userpw_confirm.focus();
				form.userpw_confirm.select();
				return false;
			}
			if(name == ""){
				alert("이름을 입력해주세요");
				form.name.focus();
				return false;
			}
			if(idChkVal.value == "N"){
				alert("아이디 중복 확인을 해주세요!");
				return false;
			}
	}