package pl.pjwstk.build;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppControl {
    Option option;
    private Scanner sc = new Scanner(System.in);
    ContainerManagement containerManagement = new ContainerManagement();
    boolean listContainersClicked = false;

    public void setListContainersClicked(boolean listContainersClicked) {
        this.listContainersClicked = listContainersClicked;
    }

    public boolean isListContainersClicked() {
        return listContainersClicked;
    }

    public void controlLoop() {
        do {
            printOptions();
            option = getOption();
            switch (option) {
                case EXIT:
                    exit();
                    break;
                case LIST_CONTAINERS:
                    containerManagement.listAllContainers();
                    break;
                case SORTED_CONTAINERS:
                    containerManagement.getAndSortContainers();
                    break;
                default:
                    System.out.println("Wybrano błędną opcję");
            }
        } while (option != Option.EXIT);
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono wartosc ktora nie jest liczbą podaj ponownie");
            }
        }
        return option;
    }

    private int getInt() {
        try {
            return sc.nextInt();
        } finally {
            sc.nextLine();
        }
    }


    private void printOptions() {
        System.out.println("Wybierz opcję:");
        for (Option element : Option.values()) {
            System.out.println(element.toString());
        }
    }

    public void exit() {
        System.out.println("Koniec programu");
        sc.close();
    }

    private enum Option {
        EXIT(0, "wyjście z programu"),
        LIST_CONTAINERS(1, "wygeneruj liste wszystkich kontenerów (containerList.txt) i ją wyświetl"),
        SORTED_CONTAINERS(2, "generuj plik manifest (kolejność załadunku)");

        private final int value;
        private final String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("Brak opcji o ID: " + option);
            }
        }
    }
}
