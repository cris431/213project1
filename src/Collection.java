import java.util.Arrays; 
//are we even allowed to use this?

public class Collection {
	private Album[] albums; //how to initialize it to size 4 if we can't change instance variables?
	private int numAlbums;
	
	/**
	Finds the index where the album is located in the albums array
	@param album the album being looked for
	@return the index of the album if found, -1 otherwise
	@author Cristofer Gomez-Martinez
	*/
	private int find(Album album) {
	for (int i = 0; i< numAlbums; i++) {
			if (album.equals(albums[i])) {
				return i;
			} else {
				continue;
			}
		}
		return -1;
	}
	
	/**
	Returns the array of albums
        @return albums array
	@author Emily Nelson 
	*/
	public Album[] getAlbums() {
		  return albums;
	  }
	  
	  /**
	  Sets the albusm array to a new albums array
	  @param newAlbum the new albums array to set
	  @author Emily Nelson
	  */
	  public void setAlbums(Album[] newAlbum) {
		  this.albums = newAlbum;
	  }
	
	/**
	Increases the capacity of the albums array by 4
	Grown whenever array is full
	@author Emily Nelson
	*/
	private void grow() {
		Album[] grownCollection = new Album[albums.length + 4];
			
		for (int i = 0; i < albums.length; i++) {
			grownCollection[i] = albums[i];
		}
		
		for (int i = albums.length; i < grownCollection.length; i++) {
			grownCollection[i] = null;
		}
		
		//trying to call grown collection albums instead
		albums = grownCollection;
		
		//albums = new Album[grownCollection.length];
			
		//for (int i = 0; i < grownCollection.length; i++) {
			//albums[i] = grownCollection[i];
		//}
				
	}
	
	/**
	Checks if an album can be added to the albums array
	Adds album to albums array if album is not found in array
	Does nothing if the album is alrady in the albums array
	@param album the album that is to be added
	@return true if album is not in albums array, false otherwise
	@author Cristofer Gomez-Martinez, Emily Nelson
	*/
	public boolean add(Album album) {
		//use find to check if already in collection
		//put attributes of album in the array
		
		if (find(album) == -1) {
			return false;
		}
		
		
		int emptySpot = find(album) + 1;
		
		albums[emptySpot].setIsAvailable(true);
		albums[emptySpot].setTitle(album.getTitle());
		albums[emptySpot].setArtist(album.getArtist());
		albums[emptySpot].setGenre(album.getGenre());
		
		numAlbums++;
		return true;
	}
	
	/**
	Checks if an album can be removed from the albums array
	Removes album from albums array if album is found
	Does nothing if the album is not in albums array
	@param album the album that is to be removed
	@return true if album is in albums array, false otherwise
	@author Emily Nelson
	*/
	public boolean remove(Album album) {
		if (find(album) == -1) {
			return false;
		}
		
		albums[find(album)].setIsAvailable(false);
		albums[find(album)].setTitle(null);
		albums[find(album)].setArtist(null);
		albums[find(album)].setGenre(null);
		albums[find(album)] = null;
		numAlbums--;
		return true;
	}
	
	/**
	Checks if the album can be lended out
	Lends out the album if the album is found in the albums array
	Does nothing if the albums is not in the albums arrays
	@param album the album that is to be lended out
	@return true if album is in albums array, false otherwise
	@author Emily Nelson
	*/
	public boolean lendingOut(Album album) {
		if (find(album) == -1) {
			return false;
		}
		
		albums[find(album)].setIsAvailable(false);
		return true;
	}
	
	/**
	Checks if the album can be returned
	Returns the album if the album is found in the albums array
	Does nothing if the albums is not in the albums arrays
	@param album the album that is to be returned
	@return true if album is in albums array, false otherwise
	@author Emily Nelson
	*/
	public boolean returnAlbum(Album album) {
		if (find(album) == -1) {
			return false;
		}
		
		albums[find(album)].setIsAvailable(true);
		return true;
	}
	
	/**
	Displays the list of albums in the albums array without specifying the order
	@author Cristofer Gomez-Martinez
	*/
	public void print() {
		String placeHolder = "";
		for(int i = 0; i < albums.length; i++) {
			placeHolder = albums[i].toString();
			System.out.println(placeHolder);
		}
	}
	
	/**
	Displays the list of albums in the albums array by release date
	@author Cristofer Gomez-Martinez
	*/
	public void printByReleaseDate() {
		Album[] sortedCollection = new Album[albums.length];
		//sortedCollection will be a copy of the albums array that we will modify so to not change the original
		for(int i = 0; i < albums.length; i++) {
			sortedCollection[i] = albums[i];
		}
		
		int olderDate = 0;
		//sorting array
		for(int i = 0; i < sortedCollection.length; i++) {
			olderDate = i;
			for(int j = i + 1; j < sortedCollection.length; j++) {
				if(sortedCollection[olderDate].getReleaseDate().compareTo(sortedCollection[j].getReleaseDate()) == 1) {
					olderDate = j;
				}
			}
			if(olderDate != i) {
				Album holder = new Album();
				holder = sortedCollection[i];
				sortedCollection[i] = sortedCollection[olderDate];
				sortedCollection[olderDate] = holder;
			}
		}
		
		String placeHolder = "";
		for(int i = 0; i < sortedCollection.length; i++) {
			placeHolder = sortedCollection[i].toString();
			System.out.println(placeHolder);
		}
	}
	
	public void printByGenre() {}
	
}
