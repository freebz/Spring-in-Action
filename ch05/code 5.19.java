// 코드 5.19  processRegistration(): 제출된 데이터의 적합성 확인

@Requestmapping(value="/register", method=POST)
public String processRegistration(
				  @Valid Spitter spitter,  // Spitter 입력 검증
				  Errors errors) {

    if (errors.hasErrors()) {  // 검증 오류 발생 시 폼으로 되돌아감
	return "registerForm";
    }

    spitterRepository.save(spitter);
    return "redirect:/spitter/" + spitter.getUsername();
}
