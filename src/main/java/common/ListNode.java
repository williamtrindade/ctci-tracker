package common;

import java.util.ArrayList;
import java.util.List;

/**
 * Nó de lista ligada simples usado nas questões do capítulo 2 (e outras).
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /** Cria uma lista a partir dos valores: of(1, 2, 3) -> 1 -> 2 -> 3. Retorna null se vazio. */
    public static ListNode of(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int v : values) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }

    /** Converte a lista em java.util.List (falha se houver ciclo com mais de 100_000 nós). */
    public static List<Integer> toList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        int guard = 0;
        for (ListNode n = head; n != null; n = n.next) {
            if (++guard > 100_000) {
                throw new IllegalStateException("Lista parece ter um ciclo");
            }
            result.add(n.val);
        }
        return result;
    }

    /** Retorna o k-ésimo nó (0-based) da lista. */
    public static ListNode nodeAt(ListNode head, int index) {
        ListNode n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    /** Retorna o último nó da lista. */
    public static ListNode last(ListNode head) {
        ListNode n = head;
        while (n != null && n.next != null) {
            n = n.next;
        }
        return n;
    }

    @Override
    public String toString() {
        return "ListNode(" + val + ")";
    }
}
