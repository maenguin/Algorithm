package kakao.Intern2021;

import java.util.ArrayDeque;


//문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/81303
//노션 링크 : https://delirious-sock-4dc.notion.site/c3c2df37f3c94245bef14620bcbcfef9
//문제 유형 : 자료구조
public class 표편집 {

    public String solution(int n, int k, String[] cmd) {
        final Node head = new Node(null, 0, null);
        Node prevNode = head;
        for (int i = 1; i < n; i++) {
            Node newNode = new Node(prevNode, i, null);
            prevNode = prevNode.next = newNode;
        }

        Node selectedRow = head;
        for (int i = 0; i < k; i++) {
            selectedRow = selectedRow.next;
        }
        ArrayDeque<Node> deletedRows = new ArrayDeque<>();
        boolean[] deleted = new boolean[n];
        for (String command : cmd) {
            switch (command.charAt(0)) {
                case 'U':
                    int x = Integer.parseInt(command.substring(2));
                    for (int i = 0; i < x; i++) {
                        selectedRow = selectedRow.prev;
                    }
                    break;
                case 'D':
                    int y = Integer.parseInt(command.substring(2));
                    for (int i = 0; i < y; i++) {
                        selectedRow = selectedRow.next;
                    }
                    break;
                case 'C':
                    deleted[selectedRow.item] = true;
                    if (selectedRow.prev != null) {
                        selectedRow.prev.next = selectedRow.next;
                    }
                    if (selectedRow.next != null) {
                        selectedRow.next.prev = selectedRow.prev;
                    }
                    deletedRows.push(selectedRow);
                    selectedRow = selectedRow.next == null ? selectedRow.prev : selectedRow.next;
                    break;
                case 'Z':
                    Node retrievedNode = deletedRows.pop();
                    deleted[retrievedNode.item] = false;
                    if (retrievedNode.prev != null) {
                        retrievedNode.prev.next = retrievedNode;
                    }
                    if (retrievedNode.next != null) {
                        retrievedNode.next.prev = retrievedNode;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (boolean b : deleted) {
            sb.append(b ? "X" : "O");
        }
        return sb.toString();
    }


    private static class Node {
        Node prev;
        int item;
        Node next;

        Node(Node prev, int item, Node next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

}
