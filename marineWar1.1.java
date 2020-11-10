import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class marineWar {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] firstPlayerField = {
                {1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        int[][] secondPlayerField = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        // Начало игры
        System.out.println("Нажмите Enter для начала игры.");
        try {
            while(true) {
                String start = reader.readLine();
                if (!start.equals("\n")) {
                    System.out.println("Игра началась.");
                    break;
                }
            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Пожалуйста, введите имя первого игрока: ");
        String nameFirst = reader.readLine();
        System.out.println("Теперь введите имя второго игрока");
        String nameSecond = reader.readLine();

        System.out.println("Отлично, в этой битве схлестнутся " + nameFirst + " и " + nameSecond + ".");

        while(true) {

            // Принимаем координаты ячейки от первого пользователя
            System.out.println(nameFirst + " указывает точку для нанесения удара:");
            int a = Integer.parseInt(reader.readLine()) - 1;
            int b = Integer.parseInt(reader.readLine()) - 1;

            // Если по указанным координатам ячейка содержит в себе 1, то игрок попал и может ввести новые координаты
            if(secondPlayerField[b][a] == 1) {
                secondPlayerField[b][a] = 0;

                // Если в массиве не осталось заполненных ячеек, то игрок победил (НУЖНО ОСТАНОВИТЬ ИСПОЛНЕНИЕ ПРОГРАММЫ)
                if(count(secondPlayerField) == 0) {
                    System.out.println("Победил " + nameFirst + ". Поздравляем!");
                    break;
                }
                System.out.println("Попадание. Для победы вам осталось нанести" + " " + count(secondPlayerField) + declination(count(secondPlayerField)));
            }
            else {
                System.out.println("По указанным координатам попадание не зафиксировано.");
                while(true) {
                    System.out.println(nameSecond + " указывает точку для нанесения удара:");
                    a = Integer.parseInt(reader.readLine()) - 1;
                    b = Integer.parseInt(reader.readLine()) - 1;
                    if(firstPlayerField[b][a] == 1) {
                        firstPlayerField[b][a] = 0;

                        // Если в массиве не осталось заполненных ячеек, то игрок победил (НУЖНО ОСТАНОВИТЬ ИСПОЛНЕНИЕ ПРОГРАММЫ)
                        if(count(firstPlayerField) == 0) {
                            System.out.println("Победил " + nameSecond + ". Поздравляем!");
                            System.exit(0);
                        }
                        System.out.println("Попадание. Для победы вам осталось нанести" + " " + count(firstPlayerField) + declination(count(firstPlayerField)));
                    }
                    else {
                        System.out.println("По указанным координатам попадание не зафиксировано.");
                        break;
                    }
                }
            }
        }
    }

    // Метод правильного склонения
    public static String declination(int count) {
        String text;
        if (count % 10 == 1) {
            text = " удар.";
        } else if (count % 10 == 2 || count % 10 == 3 || count % 10 == 4) {
            text = " удара.";
        } else if(count == 11){
            text = " ударов.";
        }
        else {
            text = " ударов.";
        }
        return text;
    }

    // Метод подсчета заполненных ячеек на поле
    public static int count(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for(int j = 0; j < matrix.length - 1; j++) {
                if(matrix[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
