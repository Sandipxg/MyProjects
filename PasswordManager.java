import java.util.*;

class PasswordManager
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Password Manager!");
        while (true)
        {
            System.out.println("\nSelect a feature to use:");
            System.out.println("1. Generate Password");
            System.out.println("2. Analyze Password Strength");
            System.out.println("3. Estimate Hack Time");
            System.out.println("4. Encrypt/Decrypt Password ");
            System.out.println("5. Common Password Check ");
            System.out.println("6. Password Storage Suggestions");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice)
            {
                case 1:
                    generatePasswordFeature(scanner, random);
                    break;
                case 2:
                    analyzePasswordFeature(scanner);
                    break;
                case 3:
                    estimateHackTimeFeature(scanner);
                    break;
                case 4:
                    encryptDecryptPasswordFeature(scanner);
                    break;
                case 5:
                    commonPasswordCheckFeature(scanner);
                    break;
                case 6:
                    displayStorageSuggestions();
                    break;
                case 7:
                    System.out.println("Exiting Password Manager. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Feature 1: Generate Password
    static void generatePasswordFeature(Scanner scanner, Random random)
    {
        System.out.print("Enter the desired length of your password: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("What types of characters would you like to include?");
        System.out.print("Include Uppercase (y/n): ");
        boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("y");
        System.out.print("Include Lowercase (y/n): ");
        boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("y");
        System.out.print("Include Numbers (y/n): ");
        boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("y");
        System.out.print("Include Special Characters (y/n): ");
        boolean includeSpecial = scanner.nextLine().equalsIgnoreCase("y");

        String password = generatePassword(length, includeUppercase, includeLowercase, includeNumbers, includeSpecial, random);
        System.out.println("Generated Password: " + password);
    }

    static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecial, Random random)
    {
        String password = "";
        String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerChars = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        String charPool = "";
        if (includeUppercase) charPool += upperChars;
        if (includeLowercase) charPool += lowerChars;
        if (includeNumbers) charPool += digits;
        if (includeSpecial) charPool += specialChars;

        if (charPool.isEmpty()) {
            System.out.println("Error: No character types selected.");
            return "";
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * charPool.length());
            password = password + charPool.charAt(randomIndex);
        }

        return password;
    }

    // Feature 2: Analyze Password Strength
    static void analyzePasswordFeature(Scanner scanner)
    {
        System.out.print("Enter the password to analyze: ");
        String password = scanner.nextLine();
        analyzePasswordStrength(password);
    }

    static void analyzePasswordStrength(String password)
    {
        int score = 0;
        String reasons = "";
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (ch >= 'A' && ch <= 'Z') { hasUppercase = true; }
            else if (ch >= 'a' && ch <= 'z') { hasLowercase = true; }
            else if (ch >= '0' && ch <= '9') { hasDigit = true; }
            else { hasSpecial = true; }
        }

        if (password.length() >= 8) { score += 25; }
        else { reasons += "--> Password is too short.\n"; }

        if (hasUppercase) { score += 25; }
        else { reasons += "--> No uppercase letters.\n"; }

        if (hasLowercase) { score += 25; }
        else { reasons += "--> No lowercase letters.\n"; }

        if (hasDigit) { score += 15; }
        else { reasons += "--> No numbers.\n"; }

        if (hasSpecial) { score += 10; }
        else { reasons += "--> No special characters.\n"; }

        System.out.println("\nPassword Strength Analysis:");
        System.out.println("Strength Score: " + score + "%");

        if (score < 100) {
            System.out.println("Reasons for less strength:");
            System.out.println(reasons);
        }

        if (score < 50) {
            System.out.println("Your password is weak. Consider adding a mix of uppercase letters, lowercase letters, numbers, and special characters.");
        } else if (score < 80) {
            System.out.println("Your password is moderate. Try adding more variety in character types.");
        } else {
            System.out.println("Your password is strong!");
        }
    }

    // Feature 3: Estimate Hack Time
    static void estimateHackTimeFeature(Scanner scanner)
    {
        System.out.print("Enter the password to estimate hack time: ");
        String password = scanner.nextLine();
        estimateHackTime(password);
    }

    static void estimateHackTime(String password)
    {
        int length = password.length();
        int complexity = 0;

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);
            if (ch >= 'A' && ch <= 'Z') { hasUppercase = true; }
            else if (ch >= 'a' && ch <= 'z') { hasLowercase = true; }
            else if (ch >= '0' && ch <= '9') { hasDigit = true; }
            else { hasSpecial = true; }
        }

        if (hasUppercase) { complexity++; }
        if (hasLowercase) { complexity++; }
        if (hasDigit) { complexity++; }
        if (hasSpecial) { complexity++; }

        double timeToCrack = Math.pow(complexity * 10, length);
        System.out.println("\nEstimated Time to Crack: " + formatTime(timeToCrack));
    }

     static String formatTime(double seconds)
    {
        if (seconds < 60) { return seconds + " seconds"; }
        if (seconds < 3600) { return (seconds / 60) + " minutes"; }
        if (seconds < 86400) { return (seconds / 3600) + " hours"; }
        if (seconds < 31536000) { return (seconds / 86400) + " days"; }

        return (seconds / 31536000) + " years";
    }

    // Feature 5: Common Password Check
    static void commonPasswordCheckFeature(Scanner scanner)
    {
        System.out.print("Enter the password to check: ");
        String password = scanner.nextLine();

        String[] commonPasswords = {"123456", "password", "123456789", "qwerty", "abc123", "password1", "111111", "123123", "letmein", "monkey"};
        checkCommonPassword(password, commonPasswords);
    }

    static void checkCommonPassword(String password, String[] commonPasswords)
    {
        for (String commonPassword : commonPasswords) {
            if (password.equals(commonPassword)) {
                System.out.println("\nWarning: Your password is too common and easily guessable.");
                return;
            }
        }
        System.out.println("Your password is not on the common password list.");
    }

    // Feature 6: Password Storage Suggestions
     static void displayStorageSuggestions()
    {
        System.out.println("\nPassword Storage Suggestions:");
        System.out.println("--> Use a password manager.");
        System.out.println("--> Avoid reusing passwords across sites.");
        System.out.println("--> Change passwords periodically.");
    }

    // Feature 4: Encrypt/Decrypt Password
    static void encryptDecryptPasswordFeature(Scanner scanner)
    {
        System.out.println("\nSelect an encryption/decryption method:");
        System.out.println("1. Encrypt/Decrypt using Caesar Cipher");
        System.out.println("2. Encrypt/Decrypt using Alphabet to Symbol");
        System.out.println("3. Encrypt/Decrypt using reverse And Swap even-odd positions method");
        System.out.print("Enter your choice (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the password to encrypt/decrypt: ");
        String password = scanner.nextLine();
        System.out.print("Do you want to Encrypt or Decrypt? (E/D): ");
        char action = scanner.nextLine().charAt(0);

        String result = "";
        switch (choice) {
            case 1:
                System.out.print("Enter the Shift value: ");
                int shift = scanner.nextInt();
                result = caesarCipher(password, action,shift);
                break;
            case 2:
                result = alphabetToSymbol(password, action);
                break;
            case 3:
                result = reverseAndSwap(password, action);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        System.out.println("Result: " + result);
    }

    // M1 :- Caesar Cipher encryption/decryption
    static String caesarCipher(String input, char action,int shift)
    {
        String result = "";
        if (action == 'E' || action == 'e') {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (Character.isUpperCase(c)) {
                    result += (char) ((c + shift - 65) % 26 + 65);
                } else if (Character.isLowerCase(c)) {
                    result += (char) ((c + shift - 97) % 26 + 97);
                } else {
                    result += c;
                }
            }
        } else if (action == 'D' || action == 'd') {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (Character.isUpperCase(c)) {
                    result += (char) ((c - shift - 65 + 26) % 26 + 65);
                } else if (Character.isLowerCase(c)) {
                    result += (char) ((c - shift - 97 + 26) % 26 + 97);
                } else {
                    result += c;
                }
            }
        }
        return result;
    }

    // M2 :- Alphabet to Symbol encryption/decryption
    static String alphabetToSymbol(String input, char action)
    {
        String result = "";
        String symbols = "!@#$%^&*()_+[]{}|;:,.<>?/";
        if (action == 'E' || action == 'e') {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (Character.isLetter(c)) {
                    result += symbols.charAt((c - (Character.isLowerCase(c) ? 'a' : 'A')) % symbols.length());
                } else {
                    result += c;
                }
            }
        } else if (action == 'D' || action == 'd') {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (symbols.contains(String.valueOf(c))) {
                    result += (char) (symbols.indexOf(c) + (Character.isLowerCase(input.charAt(i)) ? 'a' : 'A'));
                } else {
                    result += c;
                }
            }
        }
        return result;
    }

    // M3 :- Reverse and swap even positions to odd positions and vice versa
    static String reverseAndSwap(String input, char action)
    {
        String result = "";
        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        // Swap characters at even and odd positions
        char[] charArray = reversed.toCharArray();
        for (int i = 0; i < charArray.length - 1; i += 2) {
            // Swap characters at positions i and i + 1
            char temp = charArray[i];
            charArray[i] = charArray[i + 1];
            charArray[i + 1] = temp;
        }

        // Convert char array back to string
        for (int i = 0; i < charArray.length; i++) {
            result += charArray[i];
        }
        return result;
    }

}
