/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import java.util.Scanner;

/**
 *
 * @author Windows 8
 */
public class Sorting {

    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(+a[i] + " ");
        }
        System.out.println("");
    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
        show(a);
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void selectionSort(int[] a) {
        int x = 0;
        if (a == null || a.length < 2) {
            return;
        }
        int n = a.length;

        for (int i = n - 1; i > 0; i--) {

            int k = i;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[k]) {
                    k = j;
                }
                x++;
            }
            swap(a, k, i);
        }
        show(a);
    }

    public static void insertionSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        int n = a.length;

        for (int i = 1; i < n; i++) {
            int target = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > target) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = target;
        }
        show(a);
    }
}

class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] angka;
        
        System.out.print("Masukkan Jumlah Data : ");
        int i = input.nextInt();
        angka = new int[i];
        for (int a = 0; a < i; a++) {
            System.out.print("Masukkan Angka Yang Akan Di Masukkan : ");
            angka[a] = input.nextInt();
        }

        System.out.println("SORTING ANGKA");
        System.out.println("-------------");
        System.out.println("1. Selection Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Bubble Sort");
        System.out.print("Masukkan Pilihan : ");
        int pilih = input.nextInt();
        System.out.println("\nHasil Sorting");
        System.out.println("-------------");
        switch (pilih) {
            case 1:
                Sorting.selectionSort(angka);
                break;
            case 2:
                Sorting.insertionSort(angka);
                break;
            case 3:
                Sorting.bubbleSort(angka);
                break;
            default:
                break;
        }
    }
}
