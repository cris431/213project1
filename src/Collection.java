import java.util.Arrays 
//are we even allowed to use this?

public class Collection {
	private Album[] albums; //how to initialize it to size 4 if we can't change instance variables?
	private int numAlbums;
	private int find(Album album) {
		for (int i = 0; i< numAlbums; i++) {
			if (album.equals(albums[i])) {
				return i;
			} else {
				return -1;
			}
		}
	}
	private void grow() {
		Album[] grownCollection = new Album[albums.length + 4]
			
		for (int i = 0; i < albums.length; i++) {
			grownCollection[i] = albums[i];
		}
		
		for (int i = albums.length; i < grownCollection.length; i++) {
			grownCollection[i] = NULL;
		}
		
		//trying to call grown collcetion album instead
		albums = new Album[grownCollection.length];
			
		for (int i = 0; i < grownCollection.length; i++) {
			albums[i] = grownCollection[i];
		}
				
	}
	public boolean add(Album album) {
		//use find to check if already in collection
		//use string tokenizer to assign title, artist, genre, date
		
		int emptySpot = firstEmptySpace();
		
		//how to make sure the tokens from run can be used in add???
		
		//emptySpot.artist = input.nextToken;
		//emptySpot.title = input.nextToken;
		//emptySpot.genre = input.nextToken;
		//emptySpot.releaseDate = input.nextToken
		emptySpot.isAvailable = TRUE;
		
		numAblums++;
	}
	public boolean lendingOut(Album album) {}
	public boolean returnAlbum(Album album)
	public void print() {}
	public void printByReleaseDate() {}
	public void printByGenre() {}
	
	public int firstEmptySpace(){
		int i = 0;
		 while (albums[i] != NULL) {
			 i++;
		 }
		
		return i;
	}
}
