import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Dictionary dict = new Dictionary();
    private String secretWord = dict.getRandomWord(dict.createDictionary());
    private PrintVisilica visilica = new PrintVisilica(secretWord);
    private String recordLetter = "";

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[N]ew game or [E]xit");
            String enter = scanner.nextLine();

            if (enter.equals("e".toLowerCase())) {
                System.out.println("Вы закончили");
                break;
            }
            if (enter.equals("n".toLowerCase())) {
                System.out.println(secretWord);
                ArrayList<String> zipLetter = getZipletter();
                for (String s : zipLetter) {
                    System.out.print(s);
                }
                System.out.println(" " + secretWord.length() + " букв в слове. \nРазгадайте слово по буквам, у вас 6 попыток. Введите первую букву:");
                game(zipLetter);
            }
        }
    }

    public ArrayList<String> getZipletter() {
        ArrayList<String> zipLetter = new ArrayList<>();
        for (int i = 0; i < secretWord.length(); i++) {
            zipLetter.add("*");
        }
        return zipLetter;
    }

    public void game(ArrayList<String> zipLetter) {
        Scanner scanner = new Scanner(System.in);
        boolean key = true;
        int i = 0;
        while (key) {
            String enterLetter = scanner.nextLine();// вводимая буква
            if (validateEnterLetter(enterLetter)) {
                System.out.println("Такая буква уже была, попробуйте другую");
                continue;
            }

            int x = secretWord.indexOf(enterLetter); //вход буквы в слово -1 не входит, оставальное входит
            if (x == -1) {
                i += 1; // счетчик попыток и номер виселицы и хода игры
                System.out.println("не верно");
                for (String s : visilica.printVisilica(i).get(i - 1)) {
                    System.out.println(s);
                }
                if (i == 6) {
                    key = false;
                    break;
                }
            } else {
                char[] charSecretWord = secretWord.toCharArray();

                for (int j = 0; j < charSecretWord.length; j++) {
                    if (charSecretWord[j] == enterLetter.charAt(0)) {
                        zipLetter.add(j, enterLetter);
                        zipLetter.remove(j + 1);
                    }
                }
                String q = "";
                for (String s : zipLetter) {
                    q = q.concat(s);
                    if (q.equals(secretWord)) {
                        System.out.println("You win!");
                        key = false;
                        break;
                    }
                }

            }

            for (String f : zipLetter) {
                System.out.print(f);
            }
            System.out.println();

        }

    }

    public boolean validateEnterLetter(String letter) {
        boolean key = true;
        recordLetter = recordLetter.concat(letter);
        if (recordLetter.length() == 1) {
            key = false;
            return key;
        }
        char[] ch = recordLetter.toCharArray();
        int i = 0;
        for (char c : ch) {
            if (c == letter.charAt(0)) {
                i += 1;
            }
            if (i > 1) {
                return true;
            }
        }

        return false;
    }


}
