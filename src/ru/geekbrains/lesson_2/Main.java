package ru.geekbrains.lesson_2;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		// Задание 1: Задать целочисленный массив, состоящий из элементов 0 и 1.
		// Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
		int[] firstArray = {1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1};
		for (int i = 0; i < firstArray.length; i++) {
			if (firstArray[i] == 0)
				firstArray[i] = 1;
			else
				firstArray[i] = 0;
			System.out.print(firstArray[i] + " ");
		}
		System.out.print("\n");

		// Задание 2: Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
		int[] secondArray = new int[8];
		for (int i = 0; i < secondArray.length; i++) {
			if (i == secondArray[0])
				System.out.print(secondArray[i] + " ");
			else {
				secondArray[i] = secondArray[i - 1] + 3;
				System.out.print(secondArray[i] + " ");
			}
		}
		System.out.print("\n");

		// Задание 3: Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
		int[] thirdArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
		for (int i = 0; i < thirdArray.length; i++) {
			if (thirdArray[i] < 6)
				thirdArray[i] = thirdArray[i] * 2;
			System.out.print(thirdArray[i] + " ");
		}
		System.out.print("\n" + "\n");

		// Задание 4: Создать квадратный двумерный целочисленный массив
		// (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
		int[][] fourthArray = new int[7][7];

		for (int i = 0; i < fourthArray.length; i++) {
			for (int j = 0; j < fourthArray[i].length; j++) {
				fourthArray[i][i] = 1;
				fourthArray[i][i + (fourthArray.length - (1 + i * 2))] = 1;
				System.out.print(fourthArray[i][j] + " ");
			}
			System.out.println();
		}

		System.out.print("\n" + "\n");

		// Задание 5: Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)
		int[] minMaxArray = {7, 13, 4, 18, 78, 2, 54, 9, 43, 88, 91, 10};
		int minElem = 0;
		int maxElem = 0;
		for (int i = 0; i < minMaxArray.length; i++) {
			if (i == 0) {
				minElem = minMaxArray[i];
			} else if (minElem > minMaxArray[i]) {
				minElem = minMaxArray[i];
			} else if (maxElem < minMaxArray[i]) {
				maxElem = minMaxArray[i];
			}
		}
		System.out.println("Минимальное значение: " + minElem + "\n" + "Максимальное значение: " + maxElem);

		// Проверека задания 6
		int[] luckyTicket = {3, 2, 4, 1, 5, 6, 5, 4};
		System.out.println(calcArray(luckyTicket));

		// Проверка задания 7
		int[] arrayToMove = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int shiftLength = 2;
		moveArray(arrayToMove, shiftLength);


	}

	// Задание 6. Написать метод, в который передается не пустой одномерный целочисленный массив,
	// метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
	static boolean calcArray(int[] array) {
		int leftSum = 0;
		int rightSum = 0;
		int result = 0;

		for (int k = 0; k < array.length; k++) {
			rightSum = rightSum + array[k];
		}

		for (int i = 0; i < array.length; i++) {
			leftSum = leftSum + array[i];
			rightSum = rightSum - array[i];
			if (rightSum == leftSum) {
				result = 1;
			}
		}
		if (result == 1) {
			return true;
		}
		return false;
	}

	// Задание 7. Написать метод, которому на вход подается одномерный массив и число n,
	// при этом метод должен сместить все элементы массива на n позиций.

	static void moveArray(int[] array, int n) {
		if (n > 0) {
			for (int i = 0; i < n; i++) {
				int storage = array[0];
				array[0] = array[array.length - 1];

				for (int j = array.length - 1; j >= 1; j--) {
					array[j] = array[j - 1];
				}
				array[1] = storage;
			}

		} else if (n < 0) {
			for (int i = 0; i > n; i--) {
				int storage = array[array.length - 1];
				array[array.length - 1] = array[0];

				for (int j = 1; j < array.length - 1; j++) {
					array[j - 1] = array[j];
				}
				array[array.length - 2] = storage;
			}
		}
		System.out.println(Arrays.toString(array));
	}
}