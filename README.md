# COMP2601 Final Project MusicMedia Library Management
## Description
This Java project is for the COMP2601 course at BCIT, focusing on enhancing the MusicMedia library application from Assignment 1. It incorporates advanced features such as sorting, searching, and updating entries in the library, alongside file I/O operations for data persistence. The assignment was completed by implementing all three suggested options, showcasing a diverse range of Java programming skills and techniques.
## Features
### User Interface
- **JFrame**, **JDialog**, and **JOptionPane** for main application windows and dialogs.
- Assorted UI components for interactive user experience.
### Sorting
MusicMedia items can be sorted and displayed in various orders:
- By type
- By artist
- By title
- By year
### Update Data
Users can modify the music library by:
- Adding new entries
- Updating existing entries
- Deleting entries
### File I/O
- The application reads from `music_data.txt` at startup to populate the MusicLibrary.
- Changes to the library are persisted back to this file.
- Users can manually trigger data saving via a menu option.
### Data Handling
- The library uses a `HashMap` to manage MusicMedia items, ensuring efficient lookups, insertions, and deletions.

## Options
1. **GUI Version**: Implements a graphical user interface using Swing components. This version supports enhanced user interaction and provides bonus marks.
2. **Console Version**: Utilizes console-based interaction with System.out.println, menus, and Scanner for input handling.
3. **Creative Option**: An alternative implementation that could include features like unit tests, GUI enhancements, use of collections, streams/filters, a design pattern, and some concurrency aspects. This version allowed for creative freedom and collaboration, as it could be completed with a partner.

## Achievements
Achieved a grade of 130% for exemplary implementation and exceeding project requirements by successfully completing all three options.

## Setup and Execution
1. Clone the repository:
```sh 
git clone https://github.com/SAMi-Rn/COMP2601-Final-Project-MusicMedia-Library-Management.git
```
2. Navigate to the project directory:
```sh 
cd to the options directory
```
3. Compile the Java files:
```sh 
javac src/*.java
```
4. Run the application
