public class TableData {
    private int id;
    private String inputSong;
    private String inputSongArtist;
    private int inputSongTime;

    public TableData(){}
    public TableData(String inputSong, String inputSongArtist){
        this.inputSong = inputSong;
        this.inputSongArtist = inputSongArtist;
    }

    public TableData(int id, String inputSong, String inputSongArtist){
        this.inputSong = inputSong;
        this.inputSongArtist = inputSongArtist;
        this.id = id;
    }

    public int getId(){return id;}
    public void getId(int id){this.id = id;}

    public String inputSong(){return inputSong;}
    public void setinputSong(String inputSong){this.inputSong = inputSong;}

    public String inputSongArtist(){return inputSongArtist;}
    public void setinputSongArtist(String inputSongArtist){this.inputSongArtist = inputSongArtist;}

}
