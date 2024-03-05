package songs;

import java.util.Scanner;

        class Song {

            String title;
            String artist;
            Song next;

            public Song(String title, String artist) {
                this.title = title;
                this.artist = artist;
                this.next = null;
            }
        }

        class Playlist {

            Song head;

            public Playlist() {
                this.head = null;
            }

            public void addSong(String title, String artist) {
                Song newSong = new Song(title, artist);
                if (head == null) {
                    head = newSong;
                } else {
                    Song current = head;
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = newSong;
                }
            }

            public void insertAtBeginning(String title, String artist) {
                Song newSong = new Song(title, artist);
                newSong.next = head;
                head = newSong;
            }

            public void insertAtEnd(String title, String artist) {
                addSong(title, artist);
            }

            public void insertAfterTitle(String titleAfter, String title, String artist) {
                Song current = head;
                while (current != null && !current.title.equals(titleAfter)) {
                    current = current.next;
                }
                if (current != null) {
                    Song newSong = new Song(title, artist);
                    newSong.next = current.next;
                    current.next = newSong;
                } else {
                    System.out.println("Song with title " + titleAfter + " not found.");
                }
            }

            public void removeFirstSong() {
                if (head != null) {
                    head = head.next;
                } else {
                    System.out.println("Playlist is empty.");
                }
            }

            public void removeLastSong() {
                if (head == null) {
                    System.out.println("Playlist is empty.");
                    return;
                }
                if (head.next == null) {
                    head = null;
                    return;
                }
                Song current = head;
                while (current.next.next != null) {
                    current = current.next;
                }
                current.next = null;
            }

            public void removeSongByTitle(String title) {
                if (head == null) {
                    System.out.println("Playlist is empty.");
                    return;
                }
                if (head.title.equals(title)) {
                    head = head.next;
                    return;
                }
                Song current = head;
                while (current.next != null && !current.next.title.equals(title)) {
                    current = current.next;
                }
                if (current.next != null) {
                    current.next = current.next.next;
                } else {
                    System.out.println("Song with title " + title + " not found.");
                }
            }

            public void displayPlaylist() {
                Song current = head;
                while (current != null) {
                    System.out.println("Title: " + current.title + ", Artist: " + current.artist);
                    current = current.next;
                }
            }
        }
    

    public class Songs {

        public static void Main (String[] args) {

            Playlist playlist = new Playlist();
            Scanner sr = new Scanner(System.in);

            while (true) {
                System.out.println("Choose an operation:");
                System.out.println("1. Add a song");
                System.out.println("2. Insert a song at the beginning");
                System.out.println("3. Insert a song at the end");
                System.out.println("4. Insert a song after a title");
                System.out.println("5. Remove a song from the beginning");
                System.out.println("6. Remove a song from the end");
                System.out.println("7. Remove a song by title");
                System.out.println("8. Play songs (display playlist)");
                System.out.println("9. End the Program");
                int choice = sr.nextInt();
                sr.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Enter song title:");
                        String title = sr.nextLine();
                        System.out.println("Enter artist name:");
                        String artist = sr.nextLine();
                        playlist.addSong(title, artist);
                        break;
                    case 2:
                        System.out.println("Enter song title:");
                        String titleBegin = sr.nextLine();
                        System.out.println("Enter artist name:");
                        String artistBegin = sr.nextLine();
                        playlist.insertAtBeginning(titleBegin, artistBegin);
                        break;
                    case 3:
                        System.out.println("Enter song title:");
                        String titleEnd = sr.nextLine();
                        System.out.println("Enter artist name:");
                        String artistEnd = sr.nextLine();
                        playlist.insertAtEnd(titleEnd, artistEnd);
                        break;
                    case 4:
                        System.out.println("Enter title of the song after which you want to insert:");
                        String titleAfter = sr.nextLine();
                        System.out.println("Enter song title:");
                        String newTitle = sr.nextLine();
                        System.out.println("Enter artist name:");
                        String newArtist = sr.nextLine();
                        playlist.insertAfterTitle(titleAfter, newTitle, newArtist);
                        break;
                    case 5:
                        playlist.removeFirstSong();
                        break;
                    case 6:
                        playlist.removeLastSong();
                        break;
                    case 7:
                        System.out.println("Enter the title of the song you want to remove:");
                        String removeTitle = sr.nextLine();
                        playlist.removeSongByTitle(removeTitle);
                        break;
                    case 8:
                        System.out.println("Playlist:");
                        playlist.displayPlaylist();
                        break;
                    case 9:
                        System.out.println("End");
                        System.exit(choice);
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }

