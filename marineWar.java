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

        System.out.println("Отлично, в этой битве схлестнутся " + nameFirst + " и " + nameSecond);

        while(true) {
            int countFirst;
            int countSecond;
            String text;

            // Принимаем координаты ячейки от первого пользователя
            System.out.println(nameFirst + " указывает точку для нанесения удара:");
            int a = Integer.parseInt(reader.readLine()) - 1;
            int b = Integer.parseInt(reader.readLine()) - 1;

            // Если по указанным координатам ячейка содержит в себе 1, то игрок попал и может ввести новые координаты
            if(secondPlayerField[b][a] == 1) {
                secondPlayerField[b][a] = 0;
                countFirst = 0;

                // Считаем сколько осталось заполненных ячеек
                for (int i = 0; i < secondPlayerField.length - 1; i++) {
                    for(int j = 0; j < secondPlayerField.length - 1; j++) {
                        if(secondPlayerField[i][j] == 1) {
                            countFirst++;
                        }
                    }
                }

                // Если в массиве не осталось заполненных ячеек, то игрок победил (НУЖНО ОСТАНОВИТЬ ИСПОЛНЕНИЕ ПРОГРАММЫ)
                if(countFirst == 0) {
                    System.out.println("Победил " + nameFirst + ". Поздравляем!");
                    break;
                }

                // Поправляем склонение
                if (countFirst % 10 == 1) {
                    text = " удар.";
                } else if (countFirst % 10 == 2 || countFirst % 10 == 3 || countFirst % 10 == 4) {
                    text = " удара.";
                } else if(countFirst == 11){
                    text = " ударов.";
                }
                else {
                    text = " ударов.";
                }

                System.out.println("Попадание. Для победы вам осталось нанести" + " " + countFirst + text);

            }
            else {
                System.out.println("По указанным координатам попадание не зафиксировано.");
                while(true) {
                    System.out.println(nameSecond + " указывает точку для нанесения удара:");
                    a = Integer.parseInt(reader.readLine()) - 1;
                    b = Integer.parseInt(reader.readLine()) - 1;
                    if(firstPlayerField[b][a] == 1) {
                        firstPlayerField[b][a] = 0;
                        countSecond = 0;

                        // Считаем сколько осталось заполненных ячеек
                        for (int i = 0; i < firstPlayerField.length - 1; i++) {
                            for(int j = 0; j < firstPlayerField.length - 1; j++) {
                                if(firstPlayerField[i][j] == 1) {
                                    countSecond++;
                                }
                            }
                        }

                        // Если в массиве не осталось заполненных ячеек, то игрок победил (НУЖНО ОСТАНОВИТЬ ИСПОЛНЕНИЕ ПРОГРАММЫ)
                        if(countSecond == 0) {
                            System.out.println("Победил " + nameSecond + ". Поздравляем!");
                            System.exit(0);
                        }
                        // Поправляем склонение
                        if (countSecond % 10 == 1) {
                            text = " удар.";
                        } else if (countSecond % 10 == 2 || countSecond % 10 == 3 || countSecond % 10 == 4) {
                            text = " удара.";
                        } else if(countSecond == 11){
                            text = " ударов.";
                        }
                        else {
                            text = " ударов.";
                        }

                        System.out.println("Попадание. Для победы вам осталось нанести" + " " + countSecond + text);

                    }
                    else {
                        System.out.println("По указанным координатам попадание не зафиксировано.");
                        break;
                    }
                }

            }
        }
    }
}
