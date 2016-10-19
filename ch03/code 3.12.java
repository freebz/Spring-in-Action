// 3.5.2 스프링 표현식 와이어링

// SpEL 예제

#{1}

#{T(System).currentTimeMillis()}

#{sgtPeppers.artist}

#{systemProperties['disc.title']}

public BlankDisc(
		 @Value("#{systemProperties['disc.title']}") String title,
		 @Value("#{systemProperties['disc.artist']}") String artist) {
    this.title = title;
    this.artist = artist;
}

<bean id="sgtPeppers"
    class="soundsystem.BlankDisc"
    c:_title="#{systemProperties['disc.title']}"
    c:_artist="#{systemProperties['disc.artist']}" />



// 리터럴 값 표시하기

#{3.14159}

#{9.87E4}    // 98,700

#{'Hello'}

#{false}



// 빈, 프로퍼티, 메소드 참조

#{sgtPeppers}

#{sgtPeppers.artist}

#{artistSelector.selectArtist()}

#{artistSelector.selectArtist().toUpperCase()}

// 타입세이프 연산자(type-safe operator)
#{artistSelector.selectArtist()?.toUpperCase()}



// 표현식에서 타입 사용하기

T(java.lang.Math)

T(java.lang.Math).PI

T(java.lang.Math).random()



// SpEl 연산자

#{2 * T(java.lang.Math).PI * circle.radius}

#{T(java.lang.Math).PI * circle.radius ^ 2}

#{disc.title + ' by ' + disc.artist}

#{counter.total == 100}

#{counter.total eq 100}

#{scoreboard.score > 1000 ? "Winner!" : "Loser"}

// 엘비스 연산자(Elvis operator)
#{disc.title ?: 'Rattle and Hum'}



// 정규 표현식 사용하기

#{admin.email matches '[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com'}



// 컬렉션 사용하기

#{jukebox.songs[4].title}

#{jukebox.songs[T(java.lang.Math).random() * jukebox.songs.size()].title}

#{'This is a test'[3]}

#{jukebox.songs.?[artist eq 'Aerosmith']}   // 일치 항목
#{jukebox.songs.^[artist eq 'Aerosmith']}   // 첫번째
#{jukebox.songs.$[artist eq 'Aerosmith']}   // 마지막

#{jukebox.songs.![title]}                   // 타이틀 목록

#{jukebox.songs.?[artist eq 'Aerosmith'].![title]}
