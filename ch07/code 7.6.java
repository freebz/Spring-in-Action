// 코드 7.6  Amazon S3에 MultipartFile 저장하기

private void saveImage(MultipartFile image)
      throws ImageUploadException {
    try {
	AWSCredentials awsCredentials =
	    new AWSCredentials(s3AccessKey, s2SecretKey);
	S3Service s3 = new RestS3Service(awsCredentials);  // S3 서비스 시작

	S3Bucket bucket = s3.getBucket("spittrImages");  // S3 버킷 및 객체 생성
	S3Object imageObject =
	    new S3Object(image.getOriginalFilename());

	imageObject.setDataInputStream(  // 이미지 데이터 설정
				       image.getInputStream());
	imageObject.setContentLength(image.getSize());
	imageObject.setContentType(image.getContentType());

	AccessControlList acl = new AccessControlList();  // 권한 설정
	acl.setOwner(bucket.getOwner());
	acl.grantPermission(GroupGrantee.ALL_USERS,
			    Permission.PERMISSION_READ);
	imageObject.setAcl(acl);

	s3.putObject(bucket, imageObject);  // 이미지 저장
    } catch (Exception e) {
	throw new ImageUploadException("Unable to save image", e);
    }

}
