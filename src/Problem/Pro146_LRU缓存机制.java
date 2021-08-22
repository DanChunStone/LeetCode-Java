package Problem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pro146_LRU缓存机制 {

    public static void main(String[] args) {

    }

    /**
     * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
     * <p>
     * 实现 LRUCache 类：
     * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     * <p>
     * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
     */
    class LRUCache {

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode pre;
            DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private int capacity = 1;
        private int size = 0;
        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            } else {
                moveNodeToHead(node);
                return node.value;
            }
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node != null) {
                node.value = value;
                moveNodeToHead(node);
            } else {
                DLinkedNode newNode = new DLinkedNode(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
                size++;
                if (size > capacity) {
                    DLinkedNode deleteNode = deleteNode(tail.pre);
                    if (deleteNode != null) {
                        cache.remove(deleteNode.key);
                    }
                }
            }
        }

        private void addToHead(DLinkedNode node) {
            if (node == null) {
                return;
            }
            node.pre = head;
            node.next = head.next;
            node.next.pre = node;
            head.next = node;
        }

        void moveNodeToHead(DLinkedNode node) {
            if (node == null) {
                return;
            }
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
        }

        DLinkedNode deleteNode(DLinkedNode node) {
            if (node == null) {
                return null;
            }
            node.pre.next = node.next;
            node.next.pre = node.pre;
            return node;
        }
    }
}
