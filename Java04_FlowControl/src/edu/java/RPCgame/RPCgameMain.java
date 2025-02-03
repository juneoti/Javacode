package edu.java.RPCgame;

import java.util.Random;
import java.util.Scanner;

public class RPCgameMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("게임을 몇판 하시겠습니까?");
        int rounds = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rounds; i++) {
        	playRockPaperScissors(scanner);
        }
    }

    static void playRockPaperScissors(Scanner scanner) {
        // 유저의 입력값(가위, 바위, 보)를 받기
        System.out.println("안내면 진거 가위 바위 보!!");
        String playerMove = scanner.nextLine();

        // 컴퓨터의 랜덤 입력값(가위, 바위, 보)를 받기 
        Random random = new Random();
        int randomNumber = random.nextInt(3);

        String computerMove;
        if (randomNumber == 0) {
            computerMove = "바위";
        } else if (randomNumber == 1) {
            computerMove = "보";
        } else {
            computerMove = "가위";
        }
        System.out.println("컴퓨터는: " + computerMove + "!");

        // 결과 출력
        if (playerMove.equals(computerMove)) {
            System.out.println("무승부!");
        } else if (playerWins(playerMove, computerMove)) {
            System.out.println("너가 이겼어!");
        } else {
            System.out.println("컴퓨터가 이겼어!");
        }
    }

    static boolean playerWins(String playerMove, String computerMove) {
        if (playerMove.equals("바위")) {
            return computerMove.equals("가위");
        } else if (playerMove.equals("보")) {
            return computerMove.equals("바위");
        } else {
            return computerMove.equals("보");
        }
    }
}