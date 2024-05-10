import java.util.ArrayList;

public class PrintVisilica {
    private String slovo;

    public PrintVisilica(String slovo) {
        this.slovo = slovo;
    }

    private ArrayList<String[]> arr = new ArrayList<>();

    ArrayList<String[]> printVisilica(int oshibka) {
        switch (oshibka) {
            case (1):
                arr.add(new String[]{"У вас осталось пять попыток",
                        "|",
                        "|",
                        "|",
                        "|",
                        "|",
                        "|"});
                break;
            case (2):
                arr.add(new String[]{
                        "У вас осталось четыре попытки",
                        "---------",
                        "|/",
                        "|",
                        "|",
                        "|",
                        "|",
                        "|",
                });
                break;
            case (3):
                arr.add(new String[]{
                        "У вас осталось три попытки",
                        "---------",
                        "|/       |",
                        "|",
                        "|",
                        "|",
                        "|",
                        "|",
                });
                break;
            case (4):
                arr.add(new String[]{
                        "У вас осталось две попытки",
                        "---------",
                        "|/       |",
                        "|        *",
                        "|",
                        "|",
                        "|",
                        "|",
                });
                break;
            case (5):
                arr.add(new String[]{
                        "У вас осталось одна попытка",
                        "---------",
                        "|/       |",
                        "|        *",
                        "|       /||",
                        "|",
                        "|",
                        "|",
                });
                break;
            case (6):
                arr.add(new String[]{
                        "Вы проиграли (((:",
                        "загаданное слово: " + slovo,
                        "---------",
                        "|/       |",
                        "|        *",
                        "|       /||",
                        "|        |",
                        "|",
                        "|",
                });
                break;

        }
        return arr;
    }
}


