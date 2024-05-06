package org.example.console;

import org.example.shared.domain.User;
import org.example.shared.exception.EppTecException;
import org.example.shared.service.UserExtractor;
import org.example.shared.service.UserService;
import org.example.shared.service.impl.UserExtractorImpl;
import org.example.shared.service.impl.UserRepositoryMockImpl;
import org.example.shared.service.impl.UserServiceImpl;
import org.example.shared.service.validation.UserValidationImpl;
import org.example.shared.service.validation.rules.BirthNumberValidationRule;
import org.example.shared.service.validation.rules.UserBirthNumberValidationRule;
import org.example.shared.service.validation.rules.UserNameValidationRule;
import org.example.shared.service.validation.rules.UserSurnameValidationRule;

import java.util.Scanner;
import java.util.Set;

/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) {
        new UserConsoleApp().start();
    }


}

class UserConsoleApp {

    private final BirthNumberValidationRule birthNumberValidationRule = new BirthNumberValidationRule();
    private final UserExtractor userExtractor = new UserExtractorImpl();
    private final UserService userService = new UserServiceImpl(
            new UserValidationImpl(
                    Set.of(
                            new UserBirthNumberValidationRule(birthNumberValidationRule),
                            new UserNameValidationRule(),
                            new UserSurnameValidationRule()
                    ),
                    birthNumberValidationRule),
            new UserRepositoryMockImpl(),
            userExtractor
    );

    public void start() {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Vyberte možnost:");
            System.out.println("1. Přidat osobu");
            System.out.println("2. Odebrat osobu");
            System.out.println("3. Vyhledat osobu podle rodného čísla");
            System.out.println("4. Konec programu");
            System.out.print("Vaše volba: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPerson(scanner);
                    break;
                case 2:
                    removePerson(scanner);
                    break;
                case 3:
                    searchPerson(scanner);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Konec programu.");
                    break;
                default:
                    System.out.println("Neplatná volba. Zvolte prosím 1, 2, 3 nebo 4.");
            }

            if (!exit) {
                System.out.print("Chcete pokračovat (ano/ne)? ");
                String continueChoice = scanner.nextLine();
                if (!continueChoice.equalsIgnoreCase("ano")) {
                    exit = true;
                    System.out.println("Konec programu.");
                }
            }
        }

        scanner.close();
    }

    private void searchPerson(Scanner scanner) {
        System.out.print("Zadejte rodne cislo: ");
        String birthNumber = scanner.nextLine();
        try {
            User user = userService.getUser(birthNumber);

            System.out.println("Jmeno: " + user.getName());
            System.out.println("Prijmeni: " + user.getSurname());
            System.out.println("Rodne cislo: " + user.getBirthNumber());
            System.out.println("Vek: " + userExtractor.getUserAge(user));
            System.out.println();
        } catch (EppTecException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private void removePerson(Scanner scanner) {
        System.out.print("Zadejte rodne cislo: ");
        String birthNumber = scanner.nextLine();
        try {
            userService.deleteUser(birthNumber);
            System.out.println("Osoba odebrana");
        } catch (EppTecException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private void addPerson(Scanner scanner) {
        System.out.print("Zadejte Jmeno: ");
        String name = scanner.nextLine();

        System.out.print("Zadejte Prijmeni: ");
        String surname = scanner.nextLine();

        System.out.print("Zadejte rodne cislo: ");
        String birthNumber = scanner.nextLine();

        try {
            userService.addUser(new User(name, surname, birthNumber));
            System.out.println("Osoba zadana");
        } catch (EppTecException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}