# Flutter bottomNavigationBar 및 showModalBottomSheet 
## Flutter bottomNavigationBar
- Flutter에서 화면 하단에 고정된 네비게이션 바를 만드는 데 사용되는 위젯. 
- 주로 앱의 주요 섹션 간에 이동할 수 있는 탭을 제공할 때 사용된다.
- 이 위젯은 Scaffold의 속성 중 하나로, 앱의 구조에서 일관된 하단 네비게이션을 만들기 쉽도록 도와준다.
### 기본 사용법
```
Scaffold(
  body: _pages[_selectedIndex],
  bottomNavigationBar: BottomNavigationBar(
    currentIndex: _selectedIndex,
    onTap: (index) {
      setState(() {
        _selectedIndex = index; 
      });
    },
    items: [
      BottomNavigationBarItem(
        icon: Icon(Icons.home),
        label: 'Home',
      ),
      BottomNavigationBarItem(
        icon: Icon(Icons.search),
        label: 'Search',
      ),
      BottomNavigationBarItem(
        icon: Icon(Icons.person),
        label: 'Profile',
      ),
    ],
  ),
);

```
- Scaffold 위젯에 bottomNavigationBar 속성을 추가하면 된다. 
- 일반적으로 BottomNavigationBar 위젯을 사용한다.
- 여러 개의 BottomNavigationBarItem을 추가하여 탭을 구성한다.
- `_pages[_selectedIndex]` : 선택된 페이지 표시
- `_selectedIndex = index;` : 탭 변경 시 상태 업데이트
#### 주요 속성
- `items`: 각 탭의 아이템 리스트를 정의. 각 BottomNavigationBarItem은 icon과 label을 설정할 수 있다.
- `currentIndex`: 현재 선택된 탭의 인덱스를 나타낸다.
- `onTap`: 탭이 선택될 때 호출되는 콜백. 탭이 변경되면 이 함수로 인덱스를 받아 상태를 업데이트할 수 있다.
- `selectedItemColor`: 선택된 아이템의 색상을 설정한다.
- `unselectedItemColor`: 선택되지 않은 아이템의 색상을 설정한다.
- `backgroundColor`: 네비게이션 바의 배경색을 설정한다.

### 코드
```
class MyAppPage extends StatefulWidget {
  final int initialIndex;
  const MyAppPage({super.key, this.initialIndex = 0});

  @override
  State<MyAppPage> createState() => MyAppPageState();
}

class MyAppPageState extends State<MyAppPage> {
  late int selectedIndex;

  final List<Widget> screens = [
    const MainPage(),
    const AddPage(),
    const CommunityPage(),
    const MyPage(),
  ];

  @override
  void initState() {
    super.initState();
    selectedIndex = widget.initialIndex;
  }

  void onItemTapped(int index) {
    // 콜백 함수
    setState(() {
      Navigator.of(context).maybePop();
      selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: IndexedStack(
        index: selectedIndex,
        children: screens,
      ),
      bottomNavigationBar: SizedBox(
        child: BottomNavigationBar(
          items: const <BottomNavigationBarItem>[
            BottomNavigationBarItem(
              icon: Icon(Icons.home),
              label: '',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.create),
              label: '',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.description),
              label: '',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.supervisor_account),
              label: '',
            ),
          ],
          iconSize: 24,
          currentIndex: selectedIndex,
          selectedItemColor: const Color(0xffF15A2B), // 클릭 시 변경할 색상
          unselectedItemColor: const Color(0xff767676), // 클릭되지 않은 아이콘 색상
          onTap: onItemTapped,
          backgroundColor: Colors.white,
          type: BottomNavigationBarType.fixed, // 메뉴 아이템 고정 크기
          showSelectedLabels: false, // 라벨 감추기
          showUnselectedLabels: false, // 라벨 감추기
          enableFeedback: false, // 선택 시 효과음 X
        ),
      ),
    );
  }
}
```
- `initialIndex` : 탭 초기 위치를 설정하는 매개변수. 타 페이지에서 원하는 바텀시트로 넘어갈 수 있게 한다.
- `screens` : 각 탭에 해당하는 페이지 목록을 저장한 리스트. 탭이 선택될 때마다 해당 인덱스의 페이지를 보여준다.
- `onItemTapped` : BottomNavigationBar에서 아이템을 클릭할 때 호출되는 함수.
- `Navigator.of(context).maybePop();`: 현재 네비게이션 스택에서 페이지를 닫을 수 있으면 닫음. 
- `setState`: selectedIndex를 업데이트하여 화면을 새로 렌더링하도록 함.

## Flutter showModalBottomSheet
- 화면의 하단에서 슬라이드되어 올라오는 모달 시트를 만드는 데 사용되는 함수. 
- 주로 사용자에게 추가 정보를 제공하거나, 선택할 수 있는 옵션을 표시할 때 사용됨.
- `showModalBottomSheet`는 모달로 표시되기 때문에 사용자가 화면의 다른 부분과 상호작용하지 못하게 차단함.

### 기본 사용법
```
showModalBottomSheet(
  context: context,
  builder: (BuildContext context) {
    return Container(
      height: 200,
      color: Colors.white,
      child: Center(
        child: Text('This is a modal bottom sheet'),
      ),
    );
  },
);
```
#### 주요 속성
- `context`: 현재 위젯의 BuildContext를 사용한다.
- `builder`: 모달 시트의 내용을 구성하는 위젯을 반환하는 콜백.
- `isScrollControlled`: 기본적으로 모달 시트는 화면의 일부만 차지하지만, 값을 true로 설정하면 전체 화면을 차지할 수 있다.
- `backgroundColor`: 모달 시트의 배경색을 설정한다.
- `shape`: 모달 시트의 모양을 커스텀할 수 있다. (둥근 모서리의 컨테이너를 만들 수 있다.)
- `isDismissible`: 모달 바깥을 터치하여 모달을 닫을 수 있는지 여부를 설정한다.
- `enableDrag`: 드래그하여 모달을 아래로 내릴 수 있는지 여부를 설정한다.

### `showModalBottomSheet` vs `showBottomSheet`
- `showModalBottomSheet` : 모달 시트를 화면에 띄우면 다른 부분과의 상호작용이 차단되며, 사용자가 반드시 모달을 닫아야만 다른 부분을 조작할 수 있다. 일반적으로 사용된다.
- `showBottomSheet` : Scaffold 메서드로, 모달이 아닌 단순 바텀 시트를 띄우는 용도로 사용한다. 다른 화면과 상호작용이 가능하다.