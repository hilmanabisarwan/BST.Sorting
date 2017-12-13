/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

import java.util.*;

/**
 *
 * @author Windows 10
 */
class Node {

    Node left, right;
    int data;

    public Node(int n) {
        left = null;
        right = null;
        data = n;
    }

    public void setLeft(Node n) {
        left = n;
    }

    public void setRight(Node n) {
        right = n;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setData(int d) {

        data = d;
    }

    public int getData() {
        return data;
    }
}

public class BinarySearchTree {

    private Node root;
    private int[] items;
    public int size;

    public BinarySearchTree() {
        root = null;
        items = new int[1];
        size = 0;

    }

    public boolean isEmpty() {
        return root == null;
    }

    public Object root() {
        return root;
    }

    public void countArray() {
        System.out.println(size);
    }

    public void tampilArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
    }

    private boolean contains(final int[] array, final int key) {
        for (final int i : array) {
            if (i == key) {
                return true;
            }
        }
        return false;
    }

    public void searchPaths(int x) {
        searchgetPaths(root, x);
    }

    private void searchgetPaths(Node root, int x) {
        if (contains(items, x) == true) {
            if (root.getData() < x) {
                System.out.print(root.getData() + " ");
                searchgetPaths(root.getRight(), x);
            } else if (root.getData() > x) {
                System.out.print(root.getData() + " ");
                searchgetPaths(root.getLeft(), x);
            } else if (root.getData() == x) {
                System.out.print(root.getData() + " ");
            }
        } else {
            System.out.println("data kosong");
        }
    }

    public int getLeafCount() {
        return getLeafCount(root);
    }

    private int getLeafCount(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            return getLeafCount(node.left) + getLeafCount(node.right);
        }
    }

    private void push(int item) {
        if (root == null) {
            items[size] = item;
            size++;
        } else {
            items = Arrays.copyOf(items, items.length + 1);
            items[size] = item;
            size++;
        }
    }

    public void insert(int data) {
        push(data);
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }

        return node;
    }

    public void printPath() {
        printPaths(root);
    }

    private void printPaths(Node node) {
        int path[] = new int[1000];
        printPathsRecur(node, path, 0);
    }

    private void printPathsRecur(Node node, int path[], int pathLen) {
        if (node == null) {
            return;
        }

        path[pathLen] = node.data;
        pathLen++;

        if (node.left == null && node.right == null) {
            printArray(path, pathLen);
        } else {
            printPathsRecur(node.left, path, pathLen);
            printPathsRecur(node.right, path, pathLen);
        }
    }

    private void printArray(int ints[], int len) {
        int i;
        for (i = 0; i < len; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }

    private void deleteArray(int k) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == k) {
                for (int j = i; j < (items.length - 1); j++) {
                    items[j] = items[j + 1];
                }
                size--;
                break;
            }
        }
    }

    public void delete(int k) {
        if (isEmpty()) {
            System.out.println("Tree kosong");
        } else if (search(k) == false) {
            System.out.println("Maaf " + k + " tidak ada");
        } else {
            deleteArray(k);
            root = delete(root, k);
            System.out.println(k + " Dihapus Dari Tree");
        }
    }

    private Node delete(Node root, int k) {
        Node p, p2, n;
        if (root.getData() == k) {
            Node lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null) {
                return null;
            } else if (lt == null) {
                p = rt;
                return p;
            } else if (rt == null) {
                p = lt;
                return p;
            } else {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null) {
                    p = p.getLeft();
                }
                p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData()) {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        } else {
            n = delete(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }

    public boolean search(int val) {
        return search(root, val);
    }

    private boolean search(Node r, int val) {
        boolean found = false;
        while ((r != null) && !found) {
            int rval = r.getData();
            if (val < rval) {
                r = r.getLeft();
            } else if (val > rval) {
                r = r.getRight();
            } else {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node r) {
        if (r != null) {
            inorder(r.left);
            System.out.print(r.data + " ");
            inorder(r.right);
        }
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(Node r) {
        if (r != null) {
            System.out.print(r.data + " ");
            preorder(r.left);
            preorder(r.right);
        }
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(Node r) {
        if (r != null) {
            postorder(r.left);
            postorder(r.right);
            System.out.print(r.data + " ");
        }
    }
}

class main {

    public static void main(String[] args) {
        char ch;
        Scanner input = new Scanner(System.in);
        Scanner chr = new Scanner(System.in);
        BinarySearchTree bt = new BinarySearchTree();
        do {
            System.out.println("Program Binary Tree");
            System.out.println("1. Masukkan Data ");
            System.out.println("2. Hitung Leaf");
            System.out.println("3. Cari Data dan Tampilkan Rute");
            System.out.println("4. Tampilkan Data");
            System.out.println("5. Hapus Data");

            System.out.print("Masukkan Pilihan : ");
            int menu = input.nextInt();
            switch (menu) {
                case 1: 
                    System.out.print("\n");
                    System.out.print("Masukkan Jumlah Data : ");
                    int i = input.nextInt();
                    System.out.println("Masukkan Angka Yang Akan Di Masukkan");
                    for (int a = 0; a < i; a++) {
                        bt.insert(input.nextInt());
                    }
                    break;
                case 2: //Source ke 127-140
                    System.out.print("\n");
                    System.out.print("Banyak Leaf : " + bt.getLeafCount());
                    break;
                case 3: //Source ke 111-125
                    System.out.print("\n");
                    System.out.print("Masukkan Angka Yang Akan Dicari : ");
                    int a = input.nextInt();
                    System.out.print("Hasil pencarian : ");
                    bt.searchPaths(a);
                    break;
                case 4:
                    System.out.print("\n");
                    bt.printPath(); //Source ke 172-179
                    System.out.print("\nPost order\t: ");
                    bt.postorder(); //Source ke 308-318
                    System.out.print("\nPre order\t: ");
                    bt.preorder(); //Source ke 296-306
                    System.out.print("\nIn order\t: ");
                    bt.inorder(); //Source ke 284-294
                    break;
                case 5: //Source ke 217-261
                    System.out.print("\n");
                    System.out.print("Masukkan Angka Yang Akan Dihapus : ");
                    bt.delete(input.nextInt());
                    break;
                    
                default:
                    System.out.println("Masukkan Angka 1-5 \n");
                    break;
            }
            System.out.print("\n");
            System.out.print("\nApakah mau lanjut? (Y untuk Iya & N untuk Tidak) : ");
            ch = chr.next().toLowerCase().charAt(0);
            System.out.print("\n");
        } while (ch == 'y' || ch == 'Y');
    }
}
