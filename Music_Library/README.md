# Music Library 🎵

A CLI-based Java application to manage your personal music collection — add songs, create playlists, and search your library from the terminal.

---

## Features

- Add and remove songs from your library
- Create and manage playlists
- Search and filter songs by title, artist, or genre
- Runs fully in the terminal (no GUI)
- Docker support for easy setup

---

## Project Structure

```
.
├── Dockerfile
├── README.md
├── runDocker.sh
├── run.sh
└── src
    ├── Artist.java
    ├── Comparator.java
    ├── LibraryUtils.java
    ├── Main.java
    ├── Media.java
    ├── out
    │   ├── Artist.class
    │   ├── LibraryUtils.class
    │   ├── Main.class
    │   ├── Media.class
    │   ├── Playable.class
    │   ├── Playlist.class
    │   ├── PodcastEp.class
    │   ├── Song.class
    │   ├── sortByduration.class
    │   └── sortByreleaseYear.class
    ├── Playable.java
    ├── Playlist.java
    ├── PodcastEp.java
    └── Song.java

```

---

## Getting Started

### Requirements

- Java 17+
- Docker *(optional)*

### Run Locally

```bash
git clone https://github.com/your-username/music-library.git
cd music-library
javac -d out src/*.java
java -cp out Tester
```
### Script for run code
```
# PWD(must): Music_Library
bash run.sh
```


### Run with Docker 🐳

```bash
docker build -t music-library . #run from directory
docker run -it music-library
```
### Debuuging from bash in container

```bash
 docker run -it music-library /bin/bash
```
### Script to run in container 
```
# PWD(must): Music_Library
bash rundocker.sh
```
---

## Sample Output:
```
 ________________________________________________________
|                  MENU MUSIC-LIBRARY                    |
|________________________________________________________|

 1)  Show Artists
 2)  Show All Media (Heterogeneous List)
 3)  Play Playlist
 4)  Sort by Title & Year  (Natural Order)
 5)  Sort by Duration      (Ascending)
 6)  Sort by Release Year  (Descending)
 7)  Artist Comparisons    (equals)
 8)  Library Utilities     (songsInGenre etc)
 9)  Playall playlist
 10) Total duration of all media
 0)  Exit

 ________________________________________________________
  Enter your choice: 1

 ________________________________________________________
|   Artist Created                                       |
|________________________________________________________|

 Name                      Country         Followers
 --------------------------------------------------------
 Atif Aslam                Pakistan        230.32M
 Arijit Singh              India           73.00M
 Atif Aslam                Pakistan        1.34M
 Steave                    Unknown         953.34M
 Rahat Fateh Ali Khan      Pakistan        45.08M


 ________________________________________________________
|                  MENU MUSIC-LIBRARY                    |
|________________________________________________________|

 1)  Show Artists
 2)  Show All Media (Heterogeneous List)
 3)  Play Playlist
 4)  Sort by Title & Year  (Natural Order)
 5)  Sort by Duration      (Ascending)
 6)  Sort by Release Year  (Descending)
 7)  Artist Comparisons    (equals)
 8)  Library Utilities     (songsInGenre etc)
 9)  Playall playlist
 10) Total duration of all media
 0)  Exit

 ________________________________________________________
  Enter your choice: 2

________________________________________________________
| 9.2  ||  Building heterogeneous ArrayList<Media>       |
|________________________________________________________|


  Songs created:
  #   | Title                                    Artist                                   Genre      Year
 --------------------------------------------------------------------------------------------------------------------------------------------
  1   | Dil Lagi                                 Artist: Rahat Fateh Ali Khan             Sad        2019
  2   | Dil Lagi (Romantic Version)              Artist: Arijit Singh                     Romantic   2020
  3   | Dil Lagi (Romantic Version)              Artist: Arijit Singh                     Romantic   2020
  4   | The End of Beginning                     Artist: Steave                           Emotional  2018
  5   | Tum Hi Ho                                Artist: Atif Aslam                       Romantic   2013
  6   | Tera Hona                                Artist: Atif Aslam                       Romantic   2022
  7   | Shape of You                             Artist: Steave                           Pop        2017
  8   | Bohemian Rhapsody                        Artist: Steave                           Rock       1975
  9   | Kun Faya Kun                             Artist: Arijit Singh                     Sufi       2011

  Podcast created:
  #   | Title                                         Show                                          Ep No
 --------------------------------------------------------------------------------------------------------------------------------------------
  1   | Tech Talk: Future of CyberSecurity            Tech Talk                                     7   
  2   | Mind Matters: Sleep Science                   Mind Matters                                  12  
  3   | Podcast No. 1: Intro to Python                Podcast                                       3
```

## Contributing

1. Fork the repo
2. Create a branch (`git checkout -b feature/your-feature`)
3. Commit your changes
4. Open a Pull Request

---
Student: 'Hanan Qaisar' <br>
Status:  'Actively learning' <br>

## License

MIT License
---
> Every song tells a story — listen closely
---
