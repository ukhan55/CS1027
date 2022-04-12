//This class implements the user interface

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
//author: Usman Khan
public class TextInterface {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("No file passed.");
            return;
        }

        OrderedDictionary dict = new OrderedDictionary();
        try {
            Scanner inFile = new Scanner(Paths.get(args[0]));
            while (inFile.hasNextLine()) {
                String dataLine = inFile.nextLine();

                String name;
                String kind;
                String content;

                name = dataLine;
                System.out.println(dataLine);
                if(!inFile.hasNextLine())
                	break;
                dataLine = inFile.nextLine();
                System.out.println(dataLine);
                content = dataLine;
                kind = getKind(content);

                Key key = new Key(name, kind);
                DataItem dataItem = new DataItem(key, content);

                try {
                    dict.put(dataItem);
                } catch (DictionaryException ex) {
                    System.out.println("Key already exists.");
                }
            }
        } catch (IOException ex) {
            System.out.println("Couldn't find file.");
            return;
        }

        // Menu
        StringReader keyboard = new StringReader();

        boolean userQuit = false;
        while (!userQuit) {
            String line = keyboard.read("Enter next command: ").toLowerCase();
            String[] splitLine = line.split(" ");
            String command = splitLine[0];

            if (command.equals("get")) {
                String name = splitLine[1];

                if (splitLine.length != 2)
                    System.out.println("Need to pass in a word");
                else {
                    handleGet(name, dict);
                }
            } else if (command.equals("remove")) {
                if (splitLine.length != 3) {
                    System.out.println("Need to pass in word and key");
                } else {
                    String name = splitLine[1];
                    String kind = splitLine[2];

                    Key key = new Key(name, kind);
                    DataItem item = dict.get(key);

                    // item not found
                    if (item == null) {
                        System.out.println("No record in the ordered dictionary has key ("
                        + name + "," + kind + ").");
                    } else {
                        try {
                            dict.remove(key);
                        } catch (DictionaryException ex) {
                            System.out.println(ex);
                        }
                    }
                }
            } else if (command.equals("add")) {
                if (splitLine.length != 4) {
                    System.out.println("Need to pass in word, key, and content");
                } else {
                    String name = splitLine[1];
                    String kind = splitLine[2];
                    String content = splitLine[3];

                    Key key = new Key(name, kind);
                    DataItem item = dict.get(key);

                    if (item != null) {
                        // duplicate
                        System.out.println(
                            "A record with the given key (" +
                            name + "," + kind +
                            ") is already in the ordered dictionary."
                        );
                    } else {
                        try {
                            DataItem newItem = new DataItem(key, content);
                            dict.put(newItem);
                        } catch (DictionaryException ex) {
                            System.out.println(ex);
                        }
                    }
                }
            } else if (command.equals("list")) {
                if (splitLine.length != 2) {
                    System.out.println("Need to pass in prefix");
                } else {
                    String prefix = splitLine[1];
                    if (prefix.isEmpty())
                        System.out.println("Prefix must not be empty");
                }
            } else if (command.equals("first")) {
                DataItem smallestItem = dict.smallest();
                System.out.println(smallestItem);
            } else if (command.equals("last")) {
                DataItem largestItem = dict.largest();
                System.out.println(largestItem);
            } else if (command.equals("end")) {
                userQuit = true;
            } else {
                System.out.println("Command not recognized");
            }
        }
    }

    private static void handleGet(String name, OrderedDictionary dict) {
        Key definitionKey = new Key(name, "definition");
        DataItem definitionItem = dict.get(definitionKey);
        if (definitionItem != null)
            System.out.println(definitionItem.content);

        Key soundKey = new Key(name, "sound");
        DataItem soundItem = dict.get(soundKey);
        if (soundItem != null) {
            SoundPlayer soundPlayer = new SoundPlayer();

            try {
                soundPlayer.play(soundItem.getContent());
            } catch (MultimediaException ex) {
                System.out.println("Could not play sound");
            }
        }

        Key pictureKey = new Key(name, "picture");
        DataItem pictureItem = dict.get(pictureKey);
        if (pictureItem != null) {
            PictureViewer pictureViewer = new PictureViewer();
            try {
                pictureViewer.show(pictureItem.getContent());
            } catch (MultimediaException ex) {
                System.out.println("Could not show image");
            }
        }

        Key urlKey = new Key(name, "url");
        DataItem urlItem = dict.get(urlKey);
        if (urlItem != null) {
            ShowHTML showHtml = new ShowHTML();
            System.out.println(urlItem.getContent());
            showHtml.show(urlItem.getContent());
        }

        Key programKey = new Key(name, "program");
        DataItem programItem = dict.get(programKey);
        if (programItem != null) {
            RunCommand runCommand = new RunCommand();
            runCommand.run(programItem.getContent());
        }
    }

    private static String getKind(String content) {
        String contentLowercase = content.toLowerCase();
        if (contentLowercase.contains(".wav") || contentLowercase.contains(".mid"))
            return "sound";

        if (contentLowercase.contains(".jpg") || contentLowercase.contains(".gif"))
            return "picture";

        if (contentLowercase.contains(".exe"))
            return "program";

        if (contentLowercase.contains(".html"))
            return "url";

        return "definition";
    }
}