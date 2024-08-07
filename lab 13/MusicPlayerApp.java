import java.util.Scanner;

class Song {
    String title;
    Song prev;
    Song next;

    Song(String title) {
        this.title = title;
        this.prev = null;
        this.next = null;
    }
}

class Playlist {
    Song head;
    Song tail;
    Song current;

    Playlist() {
        this.head = null;
        this.tail = null;
        this.current = null;
    }

    
    void addSong(String title) {
        Song newSong = new Song(title);
        if (head == null) {
            head = newSong;
            tail = newSong;
            current = newSong;
        } else {
            tail.next = newSong;
            newSong.prev = tail;
            tail = newSong;
        }
        tail.next = head;
        head.prev = tail;
    }

    
    void removeSong(String title) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        Song temp = head;
        do {
            if (temp.title.equals(title)) {
                if (temp == head && temp == tail) {
                    head = null;
                    tail = null;
                    current = null;
                } else {
                    if (temp == head) {
                        head = head.next;
                        head.prev = tail;
                        tail.next = head;
                    } else if (temp == tail) {
                        tail = tail.prev;
                        tail.next = head;
                        head.prev = tail;
                    } else {
                        temp.prev.next = temp.next;
                        temp.next.prev = temp.prev;
                    }
                }
                System.out.println("Removed: " + title);
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Song not found.");
    }

    
    void playCurrentSong() {
        if (current != null) {
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println("No song to play.");
        }
    }

    
    void nextSong() {
        if (current != null) {
            current = current.next;
            playCurrentSong();
        } else {
            System.out.println("No songs in the playlist.");
        }
    }

    
    void previousSong() {
        if (current != null) {
            current = current.prev;
            playCurrentSong();
        } else {
            System.out.println("No songs in the playlist.");
        }
    }

    
    void printPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        Song temp = head;
        do {
            System.out.print(temp.title + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}

public class MusicPlayerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();
        String command;

        while (true) {
            System.out.println("Commands: [add <title>, remove <title>, play, next, previous, print, exit]");
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            if (command.startsWith("add ")) {
                playlist.addSong(command.substring(4));
            } else if (command.startsWith("remove ")) {
                playlist.removeSong(command.substring(7));
            } else if (command.equals("play")) {
                playlist.playCurrentSong();
            } else if (command.equals("next")) {
                playlist.nextSong();
            } else if (command.equals("previous")) {
                playlist.previousSong();
            } else if (command.equals("print")) {
                playlist.printPlaylist();
            } else if (command.equals("exit")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }

        scanner.close();
    }
}
