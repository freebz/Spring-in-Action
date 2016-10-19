// 리터럴 값을 생성자에 주입하기

package soundsystem;

public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;

    public BlankDisc(String title, String artist) {
	this.title = title;
	this.artist = artist;
    }

    public void play() {
	System.out.println("Playing " + title + " by " + artist);
    }

}
