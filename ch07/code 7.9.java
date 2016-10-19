// 코드 7.9  요청-처리 메소드에서 직접 예외 처리하기

@RequestMapping(method=RequestMethod.POST)
public String saveSpittle(SpittleForm form, Model model) {
    try {
	spittleRepository.save(
			       new Spittle(null, form.getMessage(), new Date(),
					   form.getLongitude(), form.getLatitude()));
	return "redirect:/spittles";
    } catch (DuplicateSpittleException e) {  // 예외 잡기
	return "error/duplicate";
    }
}
