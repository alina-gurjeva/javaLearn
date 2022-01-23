package lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    int FIELD_SIZE = 3;
    int VICTORY_ROW_SIZE = 3;
    char[][] GameField;
    char USER_SIGN = 'x';
    char AI_SIGN = 'o';
    Scanner SC = new Scanner(System.in);
    String USER_VICTORY, AI_VICTORY;
    String currentTurn;
    Random random = new Random();
    int x, y;

    public static void main(String[] args) {
        Game game = new Game();
        game.game();
    }

    void game(){

        System.out.println("Введите размер поля: ");
        int fieldSize = this.SC.nextInt();
        System.out.println("Введите размер победного ряда: ");
        int sizeVictory = this.SC.nextInt();
        System.out.println("Кто начинает первым? Введи 1 если ты, 0 - если я ");
        int setFirst = this.SC.nextInt();

        this.makeSettings(fieldSize, sizeVictory, setFirst);

        System.out.println("Да начнется битва!!1");
        boolean victory;

        while (!this.isGameFieldFull()){
            if (this.currentTurn.equals("user")){
                System.out.println("Твой ход!!1 ");
                this.userTurn();

            }
            else {
                System.out.println("Ход AI ");
                this.aiTurn();
            }
            this.printGameField();
            victory = this.isVictory();
            if (victory){
                System.out.println("GAME OVER");
                return;
            }

        }
        System.out.println("НИЧЬЯ");
        System.out.println("GAME OVER");

    }

    void aiTurn(){
        this.x = this.random.nextInt(this.FIELD_SIZE);
        this.y = this.random.nextInt(this.FIELD_SIZE);
        if (checkIsCoordinatesIncorrect(x, y)) {
            this.aiTurn();
        }
        this.GameField[x][y] = this.AI_SIGN;
        this.currentTurn = "user";
    }

    void userTurn(){
        System.out.println("введите координаты: ");
        this.x = this.SC.nextInt();
        this.y = this.SC.nextInt();
        if (checkIsCoordinatesIncorrect(this.x, this.y)) {
            System.out.println("Координаты не существуют или уже заняты! попробуй еще раз ");
            this.userTurn();
        }
        this.GameField[x][y] = this.USER_SIGN;
        this.currentTurn = "ai";
    }

    boolean checkIsCoordinatesIncorrect(int x, int y){
        return (x < 0 || x >= this.FIELD_SIZE) || (y < 0) || (y >= this.FIELD_SIZE)
                || (this.GameField[x][y] != '.');
    }

    boolean isVictory(){
        String[] checkVictory = this.getAllPossibleLines();
        for (String s: checkVictory){
            if (s.contains(this.USER_VICTORY)){
                System.out.println("Ты победил!");
                return true;

            }
            else if(s.contains(this.AI_VICTORY)){
                System.out.println("Победила матрица");
                return true;
            }
        }
        return false;
    }

    String[] getAllPossibleLines(){
        ArrayList<String> result = new ArrayList(Arrays.asList(this.getAllRows()));
        result.addAll(Arrays.asList(this.getAllCols()));
        result.addAll(Arrays.asList(this.getAllDiagonals()));
        String[] resultArray = new String[result.size()];
        return result.toArray(resultArray);
    }

    String[] getAllRows(){
        String[] result = new String[this.FIELD_SIZE];
        for (int i=0; i<this.FIELD_SIZE; i++){
            result[i] = String.valueOf(this.GameField[i]);
        }
        return result;
    }

    String[] getAllCols(){
        String[] result = new String[this.FIELD_SIZE];

        for (int i=0; i<this.FIELD_SIZE; i++){
            StringBuilder s = new StringBuilder();
            for (int j=0; j<this.FIELD_SIZE; j++){
                s.append(this.GameField[j][i]);
            }
            result[i] = s.toString();
        }
        return result;
    }

    String[] getAllDiagonals(){
        String[] result = new String[(this.FIELD_SIZE * 2 - 1) * 2];
        int ind = 0;
        for (int k=0; k<this.FIELD_SIZE; k++){
            StringBuilder s = new StringBuilder();
            for (int j=k, i=0; j>=0; j--, i++){
                s.append(this.GameField[i][j]);
            }
            result[ind] = s.toString();
            ind++;
        }
        for (int k=0; k<this.FIELD_SIZE; k++){
            StringBuilder s = new StringBuilder();
            for (int i=0, j=this.FIELD_SIZE-1-k; i<=k; i++, j++){
                s.append(this.GameField[i][j]);
            }
            result[ind] = s.toString();
            ind++;
        }
        for (int k=1; k<this.FIELD_SIZE; k++){
            StringBuilder s = new StringBuilder();
            for (int i=k, j=0; i<this.FIELD_SIZE; i++, j++){
                s.append(this.GameField[i][j]);
            }
            result[ind] = s.toString();
            ind++;
        }
        for (int k=1; k<this.FIELD_SIZE; k++){
            StringBuilder s = new StringBuilder();
            for (int i=k, j=this.FIELD_SIZE-1; i<this.FIELD_SIZE; i++, j--){
                s.append(this.GameField[i][j]);
            }
            result[ind] = s.toString();
            ind++;
        }

        return result;

    }

    void makeGameField(){
        this.GameField = new char[this.FIELD_SIZE][this.FIELD_SIZE];
        for (int i=0; i<this.FIELD_SIZE; i++){
            for (int j=0; j<this.FIELD_SIZE; j++)
                this.GameField[i][j] = '.';
        }
    }

    void makeSettings(int fieldSize, int victoryRowSize, int setFirst){
        if (fieldSize < 3){
            System.out.println("Некорректный размер поля: минимальный размер = 3");
            return;
        }
        if (victoryRowSize > fieldSize){
            System.out.println("Размер победного ряда не может быть больше размера поля");
            return;
        }
        this.FIELD_SIZE = fieldSize;
        this.VICTORY_ROW_SIZE = victoryRowSize;
        this.makeGameField();
        this.currentTurn = setFirst == 1 ? "user":"ai";
        this.USER_VICTORY = String.valueOf(USER_SIGN).repeat(VICTORY_ROW_SIZE);
        this.AI_VICTORY = String.valueOf(AI_SIGN).repeat(VICTORY_ROW_SIZE);
    }

    void printGameField(){
        for (int i=0; i<this.FIELD_SIZE; i++){
            for (int j=0; j<this.FIELD_SIZE; j++) {
                System.out.print(String.valueOf(this.GameField[i][j]) + " ");
            }
            System.out.println();
        }
    }

    boolean isGameFieldFull(){
        for (int i=0; i<this.FIELD_SIZE; i++){
            for (int j=0; j<this.FIELD_SIZE; j++){
                if(this.GameField[i][j] == '.') return false;
            }

        }
        return true;
    }
}
