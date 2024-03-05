package song;

import javax.swing.JOptionPane;

public class SongDancel{

    class Song {

        String title;
        String artist;
        Song next;

        Song(String title, String artist) {
            this.title = title;
            this.artist = artist;
            this.next = null;
        }
    }

    class Musicplayer {

        Song head;

        Musicplayer() {
            head = null;
        }

        void addSong(String title, String artist) {
            Song newMusic = new Song(title, artist);
            if (head == null) {
                head = newMusic;
            } else {
                Song current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newMusic;
            }
        }

        void insertAtBeginning(String title, String artist) {
            Song newMusic = new Song(title, artist);
            newMusic.next = head;
            head = newMusic;
        }

        void insertAfterTitle(String currentTitle, String title, String artist) {
            Song newMusic = new Song(title, artist);
            if (head == null) {
                JOptionPane.showMessageDialog(null, "Playlist is empty.");
                return;
            }
            Song current = head;
            if (current.title.equals(currentTitle)) {
                newMusic.next = head.next;
                head = newMusic;
                return;
            }
            while (current.next != null) {
                if (current.next.title.equals(currentTitle)) {
                    newMusic.next = current.next.next;
                    current.next = newMusic;
                    return;
                }
                current = current.next;
            }
            JOptionPane.showMessageDialog(null, "Song not found.");
        }

        void removeAtBeginning() {
            if (head == null) {
                JOptionPane.showMessageDialog(null, "Playlist is empty.");
                return;
            }
            head = head.next;
        }

        void removeAtEnd() {
            if (head == null) {
                JOptionPane.showMessageDialog(null, "Playlist is empty.");
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

        void removeWithTitle(String title) {
            if (head == null) {
                JOptionPane.showMessageDialog(null, "Playlist is empty.");
                return;
            }
            if (head.title.equals(title)) {
                head = head.next;
                return;
            }
            Song current = head;
            while (current.next != null) {
                if (current.next.title.equals(title)) {
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
            JOptionPane.showMessageDialog(null, "Song not found.");
        }

        void displayPlaylist() {
            if (head == null) {
                JOptionPane.showMessageDialog(null, "Playlist is empty.");
                return;
            }
            Song current = head;
            StringBuilder playlist = new StringBuilder();
            while (current != null) {
                playlist.append(current.title).append(" by ").append(current.artist).append("\n");
                current = current.next;
            }
            JOptionPane.showMessageDialog(null, playlist.toString());
        }
    }

    public static void main(String[] args) {

        Main music = new Main();
        Main.Musicplayer player = music.new Musicplayer();
        
        JOptionPane.showMessageDialog(null, "Pax!" + "\n" + "MUSICIAN");
        JOptionPane.showMessageDialog(null, "BRING YOUR LIFE INTO A WORLD OF MUSIC.");
        JOptionPane.showMessageDialog(null, "In...");
        JOptionPane.showMessageDialog(null, "3");
        JOptionPane.showMessageDialog(null, "2");
        JOptionPane.showMessageDialog(null, "1.");
        JOptionPane.showMessageDialog(null, "toooooooooooooooooooooooot");


        while (true) {
            String choice = JOptionPane.showInputDialog(
                    "Choose an option:" + "\n" + "1. Add a song" + "\n" + "2. Insert a song at the beginning" + "\n" + "3. Insert a song at the end" + "\n"
                    + "4. Insert a song after a specific title" + "\n" + "5. Remove a song at the beginning" + "\n" + "6. Remove a song at the end" + "\n"
                    + "7. Remove a song by title" + "\n" + "8. Play songs" + "\n" + "9. Exit");

            if (choice == null) {
                return;
            }
            if (choice.equals("1")) {
                String title = JOptionPane.showInputDialog("Enter the title of the song:");
                String artist = JOptionPane.showInputDialog("Enter the artist of the song:");
                player.addSong(title, artist);
            } else if (choice.equals("2")) {
                String titleBeginning = JOptionPane.showInputDialog("Enter the title of the song:");
                String artistBeginning = JOptionPane.showInputDialog("Enter the artist of the song:");
                player.insertAtBeginning(titleBeginning, artistBeginning);
            } else if (choice.equals("3")) {
                String titleEnd = JOptionPane.showInputDialog("Enter the title of the song:");
                String artistEnd = JOptionPane.showInputDialog("Enter the artist of the song:");
                player.addSong(titleEnd, artistEnd);
            } else if (choice.equals("4")) {
                String currentTitle = JOptionPane.showInputDialog("Enter the title of the song after which you want to insert:");
                String insertTitle = JOptionPane.showInputDialog("Enter the title of the song you want to insert:");
                String insertArtist = JOptionPane.showInputDialog("Enter the artist of the song you want to insert:");
                player.insertAfterTitle(currentTitle, insertTitle, insertArtist);
            } else if (choice.equals("5")) {
                player.removeAtBeginning();
            } else if (choice.equals("6")) {
                player.removeAtEnd();
            } else if (choice.equals("7")) {
                String removeTitle = JOptionPane.showInputDialog("Enter the title of the song you want to remove:");
                player.removeWithTitle(removeTitle);
            } else if (choice.equals("8")) {
                player.displayPlaylist();
            } else if (choice.equals("9")) {
                JOptionPane.showMessageDialog(null, "Exiting...");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a number between 1 and 9.");
            }
        }
    }
}
