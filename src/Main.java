
public class Main {
    private static final String VALIDATE_PATTERN = "\\w{4,20}";


    public static void main(String[] args) {

        check("ffft", "224yfjg", "224yfjg");
        check("ffft,", "224yfjg", "224yfjg");
        check("sfingiw000000000000000000000", "ggggg", "ggggg");
        check("hhkkkd", "!wrerg", "!wrerg");
        check("ggggoo", "fgsgg", "yudhh");


    }

    private static boolean check(String login, String password, String confirmPassword) {
        boolean checkValid = true;
        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка в ведении логина " + e.getMessage());
            checkValid = false;
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка в ведении пароля " + e.getMessage());
            checkValid = false;
        }
        if (checkValid) {
            System.out.println("Логин и пароль введены корректно");

        }
        return checkValid;
    }

    private static void checkLogin(String login) throws WrongLoginException {
        if (!login.matches(VALIDATE_PATTERN)) {
            throw new WrongLoginException("Логин должен быть не длиннее 20 символов и содержать в себе только латинские буквы,цифры," +
                    "знак подчеркивания.");
        }

    }

    private static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.matches(VALIDATE_PATTERN)) {
            throw new WrongPasswordException("Пароль олжен быть не длиннее 20 символов и содержать в себе только латинские буквы,цифры," +
                    "                \"знак подчеркивания.");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

}