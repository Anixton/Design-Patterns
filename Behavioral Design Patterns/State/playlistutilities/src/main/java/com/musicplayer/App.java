package com.musicplayer;
import java.util.Scanner;

/**
 * Create UML Diagram For given program
 *
 */
public class App 
{ 
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        Music music1 = new Music("Blinding Lights", "The Weeknd", 201);
        Music music2 = new Music("Starboy", "The Weeknd", 230);
        Music music3 = new Music("Save Your Tears", "The Weeknd", 215);
        Music music4 = new Music("In Your Eyes", "The Weeknd", 237);
        Music music5 = new Music("The Hills", "The Weeknd", 242);
        Music music6 = new Music("Can't Feel My Face", "The Weeknd", 213);
        Music music7 = new Music("Call Out My Name", "The Weeknd", 228);
        Music music8 = new Music("Earned It", "The Weeknd", 242);
        Music music9 = new Music("I Feel It Coming", "The Weeknd", 269);
        Music music10 = new Music("Pray For Me", "The Weeknd", 211);
        Music music11 = new Music("Heartless", "The Weeknd", 200);
        Music music12 = new Music("Often", "The Weeknd", 240);
        Music music13 = new Music("Escape From LA", "The Weeknd", 350);
        Music music14 = new Music("After Hours", "The Weeknd", 360);
        Music music15 = new Music("Too Late", "The Weeknd", 216);
        Music music16 = new Music("Die For You", "The Weeknd", 276);
        Music music17 = new Music("Out Of Time", "The Weeknd", 201);

        player.addMusic(music1);
        player.addMusic(music2);
        player.addMusic(music3);
        player.addMusic(music4);
        player.addMusic(music5);
        player.addMusic(music6);
        player.addMusic(music7);
        player.addMusic(music8);
        player.addMusic(music9);
        player.addMusic(music10);
        player.addMusic(music11);
        player.addMusic(music12);
        player.addMusic(music13);
        player.addMusic(music14);
        player.addMusic(music15);
        player.addMusic(music16);
        player.addMusic(music17);

        player.play();

        Scanner scanner = new Scanner(System.in);

        while (player.isMusicPlayerOn()) {
            System.out.println("\033[32m\nPlaying: " + player.getCurrentMusic() + "\n\033[0m");
            System.out.println("Press 1 to play,\n" +
            "2 to pause,\n" +
            "3 to play previous song,\n" +
            "4 to play next song,\n" +
            "5 to turn off music player.");
        
            int input = scanner.nextInt();
            
            switch (input) {
                case 1:
                    player.play();
                    break;
                case 2:
                    player.pause();
                    break;
                case 3:
                    player.previousTrack();
                    break;
                case 4:
                    player.nextTrack();
                    break;
                case 5:
                    player.stop();
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
        
        scanner.close();
    }
}
