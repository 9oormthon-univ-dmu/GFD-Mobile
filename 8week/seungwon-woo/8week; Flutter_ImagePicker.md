# Flutter ImagePicker
- Flutter에서 이미지 및 동영상을 갤러리에서 선택하거나 카메라를 이용해 촬영하여 앱에 사용할 수 있도록 하는 플러그인이다.
- 프로필 사진, 게시물 이미지 업로드 등등에 사용된다.

## ImagePicker 패키지
- [ImagePicker 패키지](https://pub.dev/packages/image_picker)
- 추가 방법 : `pubspec.yaml` 파일에 추가. 기타 설정은 줄이겠음.

```
dependencies:
  image_picker: ^0.8.7+3
```

## 사용 설명
### 갤러리에서 이미지 선택
```
Future<void> pickImageFromGallery() async {
  final ImagePicker _picker = ImagePicker();
  final XFile? image = await _picker.pickImage(source: ImageSource.gallery);

  if (image != null) {
    print("Selected image path: ${image.path}");
  }
}
```
- `_picker.pickImage` : 갤러리나 카메라를 호출하고, 선택된 이미지를 `XFile` 객체로 반환한다.
- `ImageSource.gallery` : 갤러리에서 이미지를 선택한다.
> XFile?   
image_picker 패키지에서 사용되는 파일 객체를 나타내는 클래스이다. 이 클래스는 Flutter의 dart:io 패키지의 File 클래스와 비슷하지만, 웹 및 모바일 플랫폼 모두에서 사용될 수 있다.   
XFile 객체는 이미지, 동영상 등 파일의 경로를 포함하며, 해당 파일에 접근하거나 읽고 쓸 수 있는 다양한 메서드를 제공한다. 

### 카메라로 이미지 촬영
```
Future<void> captureImageFromCamera() async {
  final ImagePicker _picker = ImagePicker();
  final XFile? photo = await _picker.pickImage(source: ImageSource.camera);

  if (photo != null) {
    print("Captured image path: ${photo.path}");
  }
}
```
- `_picker.pickImage` : 갤러리나 카메라를 호출하고, 선택된 이미지를 `XFile` 객체로 반환한다.
- `ImageSource.camera` : 카메라로 이미지를 촬영한다.

### 이미지 파일 정보
- `image.path` or `photo.path` : XFile 객체를 반환한다. 파일의 경로를 가져오며 로컬에서 파일을 처리하는 것에 유용하다.

### 사진 업로드 or 서버 전송
```
Future<void> uploadImage(String filePath) async {
  var request = http.MultipartRequest(
    'POST',
    Uri.parse('경로'),
  );
  request.files.add(await http.MultipartFile.fromPath('image', filePath));
  var response = await request.send();
  
  if (response.statusCode == 200) {
    print("Image uploaded successfully");
  } else {
    print("Image upload failed");
  }
}
```
- 파일의 경로를 사용하여 `multipart` 요청을 보낼 수 있다.

## 코드
### 프로필 사진 업데이트 - 이미지 선택
```
onTap: () async {
    pickedFile = await picker.pickImage(
        source: ImageSource.gallery,
        imageQuality: 30,
    );
    if (pickedFile != null && mounted) {
        setState(() {
            updateValue = 1;
            // 서버에 보낼 이미지 경로 XFile? image;
            logger.d("image path : pickedFile!.path");
            sendData = pickedFile!.path;
        });
    }
},
```
- `ImageSource.gallery` : 갤러리에서 선택
- 선택한 이미지가 있다면 sendData에 경로를 담음

### 프로필 사진 업데이트 - 서버 전송
```
Future<String?> userPicUploadAPI(BuildContext context, dynamic pic) async {
    // secure storage token read
    final accessToken = await storage.read(key: 'accessToken');

    var dio = Dio();

    var formData =
        FormData.fromMap({'image': await MultipartFile.fromFile(pic)});

    const url = serverUrl + '/api/file-upload';

    try {
      dio.options.contentType = 'multipart/form-data';
      dio.options.headers = {'Authorization': 'Bearer $accessToken'};

      final response = await dio.post(url, data: formData);
      if (response.statusCode == 200) {
        Map<String, dynamic> jsonData = response.data;

        List<dynamic> dataList = jsonData['data'];
        String imageUrl = dataList[0]['imageUrl'];

        return imageUrl;
      } else if(response.statusCode == 401) {
        logger.d("status code : ${response.statusCode}");
        await reissue(context);
        return userPicUploadAPI(context, pic);
      } else {
        // 실패
        logger.d("Fail to upload $formData. status code : ${response.statusCode}");
        throw UserProfileException(
            "Fail to load. status code: ${response.statusCode}");
      }
    } catch (e) {
      logger.d("error : $e");
      throw UserProfileException("Error occurred: $e");
    }
  }
```
- `contentType = 'multipart/form-data'`으로 사용
> multipart?   
HTTP 프로토콜에서 파일과 데이터를 함께 전송할 때 사용하는 방식이다. 일반적으로 텍스트 데이터와 바이너리 데이터를 하나의 요청으로 서버에 보낼 때 활용된다.